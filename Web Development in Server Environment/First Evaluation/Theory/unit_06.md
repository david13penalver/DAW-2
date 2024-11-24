UNIT 06 - PERSISTENCE LAYER

# Table of Contents

- [Table of Contents](#table-of-contents)
- [DAO (Data Access Object)](#dao-data-access-object)
- [Generic Classes](#generic-classes)
- [Cache System](#cache-system)
- [Repository](#repository)

# DAO (Data Access Object)
[Up](#table-of-contents)

The DAO (Data Access Object) pattern is used to separate and encapsulate data access, providing an abstraction layer that isolates the data access logic from the rest of the application. This allows the rest of the application, and in particular the domain layer, to interact with the data without worrying about the specifics of persistence. DAOs facilitate the delegation of data access operations so that repositories can focus solely on working with domain models.

We will start by creating two generic interfaces that will serve as the basis for our DAOs: `GenericDaoDb` and `GenericDaoCache`. These interfaces define the basic methods to interact with a database and a cache system, respectively.

We will create both interfaces inside the package *persitence.dao.db* and *persitence.dao.cache+*, respectively. 

# Generic Classes
[Up](#table-of-contents)

In Java, generic classes allow us to write flexible and reusable code. Defining a generic class or interface means that we can work with different types of data without having to write duplicate code for each type of entity. In the case of DAOs, this is useful because many operations, such as get all records or search by ID, are common to all entities.

For example, consider the `getAll` method in the `GenericDaoDb` interface. This method returns a list of entities, but since it is generic, we cannot know, a priori, what type. Instead of defining a method that only works with, for example, *books* (`List<Book>`), we use a generic parameter (`T`) so that it can be adapted to any type of entity, whether it is *Book*, *Author*, *Genre*...:

```java
public interface GenericDaoDb<T> {
 
    List<T> getAll();
    List<T> getAll(int page, int size);
    Optional<T> findById(long id);
    long insert(T t);
    void update(T t);
    void delete(long id);
    int count();
    T save(T t);
 
}
```

By using `T`, we are telling the compiler that the type of the entity to be used will be determined when we implement or instantiate the interface. This makes the interface flexible and reusable for any entity.

When we need specific operations for certain entities, we can create interfaces that extend `GenericDaoDb` and add additional methods that correspond to those entities. For example, `PublisherDaoDb` can extend `GenericDaoDb<Publisher>`, without the need to add additional methods if we only need the common operations.

```java
public interface PublisherDaoDb extends GenericDaoDb<Publisher> {
}
```

> **Note**: When we extend `GenericDaoDb`, we must specify the type of entity that the DAO will work with. In this case, `Publisher`.

However, if we need specific functionalities, such as searching by ISBN or handling relationships with authors and genres in the case of books, we can add those methods to, in this case, BookDaoDb: 

```java
public interface BookDaoDb extends GenericDaoDb<Book> {
 
    Optional<Book> findByIsbn(String isbn);
    void deleteAuthors(long id);
    void insertAuthors(long id, List<Author> authors);
    void deleteGenres(long id);
    void insertGenres(long id, List<Genre> genres);
}
```

Lastly, we create the implementatios in *persistence.dao.db.impl* package. For example, `BookDaoDbImpl`:

```java
@Component
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDaoDb {
    private final JdbcTemplate jdbcTemplate;
 
    @Override
    public List<Book> getAll() {
        String sql = """
                        SELECT * FROM books
                     """;
        return jdbcTemplate.query(sql, new BookRowMapper());
    }
 
    @Override
    public List<Book> getAll(int page, int size) {
        String sql = """
                        SELECT * FROM books
                        LIMIT ? OFFSET ?
                     """;
        return jdbcTemplate.query(sql, new BookRowMapper(), size, page * size);
    }
 
    @Override
    public int count() {
        String sql = """
                        SELECT COUNT(*) FROM books
                     """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
 
    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                WHERE books.isbn = ?
           """;
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
            return Optional.of(book);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
// Rest of the code
```

# Cache System
[Up](#table-of-contents)

In this case, we are going to implement a very basic system (obviously, it would not represent a suitable solution for a production environment) as an example. 

To do this, we will create, as we did with the database, an interface with the common methods, which in this case will be to save items in the cache and delete it: 

```java
public interface GenericDaoCache<T> {
    void save(T t);
    void clearCache();
}
```

For now, we are going to create only `BookDaoCache` with a method for searching books by ISBN:

```java
public interface BookDaoCache extends GenericDaoCache<Book>{
 
    Optional<Book> findByIsbn(String isbn);
}
```

The implementation will be very simple. We create two `Maps`, one to cache books and one to manage expiration times. 
 
The first method, `findByIsbn(String isbn)`, searches for a book in the cache using its ISBN. It compares the expiration time with the current time, and if the book is still valid, it returns it from the cache. If it has expired or is not found, it removes it from both maps and returns an `Optional.empty()`. 
 
The `save(Book book)` method saves a book in the cache with its ISBN as the key and sets its expiration time by adding the TTL (10 minutes) to the current time. 
 
Finally, the `clearCache()` method clears both `Maps`, removing all books and expiration times stored in the cache.

We will use `ConcurrentHashMap` instead of `HashMap` because it is designed to handle multiple threads accessing and modifying the cache at the same time. This is important in a concurrent environment, where multiple threads can read or write data to the cache simultaneously: 

```java
@Component
public class BookDaoCacheImpl implements BookDaoCache {
 
    private final Map<String, Book> cache = new ConcurrentHashMap<>();
    private final Map<String, Long> expiration = new ConcurrentHashMap<>();
    private static final long TTL = 600_000L; // 10 minutos en milisegundos
 
    @Override
    public Optional<Book> findByIsbn(String isbn) {
        Long expirationTime = expiration.get(isbn);
        if(expirationTime != null && expirationTime >= System.currentTimeMillis()) {
            System.out.println("Retrieved from cache: " + isbn);
            return Optional.ofNullable(cache.get(isbn));
        }
        cache.remove(isbn);
        expiration.remove(isbn);
        return Optional.empty();
    }
 
    @Override
    public void save(Book book) {
        cache.put(book.getIsbn(), book);
        expiration.put(book.getIsbn(), System.currentTimeMillis() + TTL);
    }
 
    @Override
    public void clearCache() {
        cache.clear();
        expiration.clear();
    }
}
```

Once we have created our DAOs, we can use them in the repository to delegate data access responsibilities. 

In the case of the `findByIsbn` method, we first try to get the book from the cache using `bookDaoCache.findByIsbn(isbn)`. If it is not found, the repository takes care of querying the database with `bookDaoJdbc.findByIsbn(isbn)`. As soon as we get the book from the database, we save it in the cache through `bookDaoCache.save(book)` to optimize future queries: 

```java
Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
 
    private final BookDaoDb bookDaoDb;
    private final BookDaoCache bookDaoCache;
 
    ...
 
    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookDaoCache.findByIsbn(isbn).or(
                () -> {
                    System.out.println("Retrieved from db: " + isbn);
                    Optional<Book> book = bookDaoDb.findByIsbn(isbn);
                    book.ifPresent(bookDaoCache::save);
                    return book;
                }
        );
    }
     
    // Rest of the code
```

# Repository
[Up](#table-of-contents)

https://github.com/cesguiro/dws-spring/tree/develop/dws-persistence

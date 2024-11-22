UNIT 04 - LAYERED ARCHITECTURE

# Table of Contents
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Layers](#layers)
- [Data Models](#data-models)
- [Presentation Layer](#presentation-layer)
- [Domain Layer](#domain-layer)
- [Persistence Layer](#persistence-layer)
  - [Mapping](#mapping)
  - [N-M Relationships](#n-m-relationships)
- [Cesar's Repository](#cesars-repository)

# Introduction
[Up](#table-of-contents)

The Layered Architecture is a software architecture pattern that divides the software into different layers. 

Each layer has a specific responsibility and uses the services offered by the superior layer. 

The below layers do not depend on the superior layers.

The main idea is to separate the concerns of the software, making it easier to maintain and test.

# Layers
[Up](#table-of-contents)

The most common layers are:
- Presentation Layer.
- Domain Layer.
- Persistence Layer.

The Presentation Layer is the layer that interacts with the user. It is responsible for receiving the user's input and showing the output. Here, we implement the controllers that manage the logic of the interface and coordinate the interaction between the user and the system.

The Domain Layer is the layer that contains the business logic of the application. Here, we implement the services that manage the business rules and the entities that represent the data of the application.

The Persistence Layer is the layer that manages the data of the application. Here, we implement the repositories that manage the data access and the entities that represent the data of the database.

# Data Models
[Up](#table-of-contents)

The data models are the classes that represent the data of the application.

Each model must encapsulate the properties and behavior of the data.

It is important to differenciate between the models of the domain layer and the models of the persistence layer. The models of the domain layer represent the business data, while the models of the persistence layer represent the data of the database.

We are going to use Lombok to generate the getters, setters, and constructors of the models. The annotations we are going to use are:
- `@Data`: Generates the getters, setters, `toString`, `equals()` and `hashCode()`. It also includes `@RequiredArgsConstructor`.
  - `@RequiredArgsConstructor`: Generates a constructor with the required or final arguments.
- `@NoArgsConstructor`: Generates a constructor without arguments.
- `@AllArgsConstructor`: Generates a constructor with all the arguments.

# Presentation Layer
[Up](#table-of-contents)

The Presentation Layer is the layer that interacts with the user. 

It is responsible for receiving the user's input and showing the output. 

It is common to use Spring annotations like:
- `@RestController`: Indicates that the class is a controller and that the response is serialized as JSON or XML.
- `@RequestMapping`: Maps the HTTP requests to the methods of the controller.
```java
@RestController
@RequestMapping("/api")
public class MyController {
    // Code
}
```
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Maps the HTTP requests to the methods of the controller.

Our BookController would be like this:
```java
@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {
 
    public static final String URL = "/books";
 
    private final BookService bookService;
 
    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
 
    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }
}
```

# Domain Layer
[Up](#table-of-contents)

The Domain Layer is the layer that contains the business logic of the application.

To our example, we will create an interface BookService and the implementation BookServiceImpl.

```java
public interface BookService {
    List<Book> getAll();
 
    Book findByIsbn(String isbn);
}
```

```java
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
 
    private final BookRepository bookRepository;
 
    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }
 
    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
```

Advantages of using interfaces:
- Abstraction: We can change the implementation without changing the interface.
- Flexibility: We can have multiple implementations of the same interface. Useful for testing.
- Maintainability: We can change the implementation without affecting the interface.

The annotations we are going to use are:
- `@Service`: Indicates that the class is a service and that it is a candidate for Spring beans for the dependency injection.
- - `@RequiredArgsConstructor`: Generates a constructor with the required or final arguments.
- `@Autowired`: Injects the dependencies of the class.

# Persistence Layer
[Up](#table-of-contents)

The Persistence Layer is the layer that manages the data of the application.

We are going to use `spring-boot-starter-jdbc` to manage the data access, taht includes [JdbcTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html).

To add Spring Boot JDBC, we need to add the dependency in the `pom.xml` file:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
    <version>3.3.2</version>
</dependency>
```

It is mandatory to configure the database connection in the `application.properties` file:
```java
spring.datasource.url = jdbc:mariadb://localhost:3306/bookstore
spring.datasource.username = root
spring.datasource.password = root
```

Now we can create the interface BookRepository and the implementation BookRepositoryImpl.

## Mapping
[Up](#table-of-contents)

To implement the interface, we must map the columns of the database (`ResultSet`) to the properties of the model. We can use the `RowMapper` interface to map the columns of the database to the properties of the model.

Example mapping from ResultSet to Author using AuthorRowMapper:
```java
public class AuthorRowMapper implements RowMapper<Author> {
 
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setName(rs.getString("name"));
        author.setNationality(rs.getString("nationality_es"));
        author.setBiography(rs.getString("biography_es"));
        author.setBirthYear(rs.getInt("birth_year"));
        author.setDeathYear(rs.getInt("death_year"));
        return author;
    }
}
```

- `RowMapper<T>`: Maps the columns of the database to the properties of the model.
- `mapRow(ResultSet rs, int rowNum)`: Maps the columns of the database to the properties of the model.

When mapping the entity Book, we have 1-N and N-N relationships. To solve this, we are going to use our own interface `CustomRowMapper` that extends `RowMapper<T>` and implements the method `mapRow(ResultSet rs, int rowNum)`.

```java
public interface CustomRowMapper<T> extends RowMapper<T> {
 
    default boolean existsColumn(ResultSet rs, String columnName) {
        try {
            rs.findColumn(columnName);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
```

Then, in the Books mapper, we can use that interface to check the existence of the fields Publisher and Category before trying to map them.

```java
public class BookRowMapper implements CustomRowMapper<Book>{
 
    private final CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
    private final PublisherRowMapper publisherRowMapper = new PublisherRowMapper();
 
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setIsbn(rs.getString("books.isbn"));
        book.setTitle(rs.getString("books.title_es"));
        book.setSynopsis(rs.getString("books.synopsis_es"));
        book.setPrice(new BigDecimal(rs.getString("books.price")));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));
        if(this.existsColumn(rs, "publishers.id")) {
            book.setPublisher(publisherRowMapper.mapRow(rs, rowNum));
        }
        if(this.existsColumn(rs, "categories.id")) {
            book.setCategory(categoryRowMapper.mapRow(rs, rowNum));
        }
        return book;
    }
}
```

Our Book repository would be like this:
```java
@Repository
@RequiredArgsConstructor
public class BookRepositoryJdbc implements BookRepository {
 
    private final JdbcTemplate jdbcTemplate;
 
    @Override
    public List<Book> getAll() {
        String sql = """
                        SELECT * FROM books
                     """;
        return jdbcTemplate.query(sql, new BookRowMapper());
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
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
```

We are using JDBC to manage the data access:
- `query`: This method is used when we expect to receive several rows of results from the SQL query. 
  - The function takes the SQL query and a RowMapper, which is responsible for converting each row of the ResultSet into an instance of our domain class (in this case, Book). 
  - The method executes the query and returns a list of mapped objects.
- `queryForObject`: This method is used when we expect the query to return a single result. 
  - If the query returns more than one row or none, an exception is thrown. 
  - It also requires a RowMapper to transform the resulting single row into a domain object. 
  - This method is useful, for example, when searching for a specific record, such as a book by its ISBN.

## N-M Relationships
[Up](#table-of-contents)

To handle N-M relationships, such as those between books and authors or books and genres, it is necessary to make additional queries to the intermediate tables. 

Each book can have multiple authors and genres, so we will use separate repositories to manage these relationships.

We will create two additional repositories: one for authors and one for genres.

Author interface and implementation:
```java
public interface AuthorRepository {
 
    List<Author> getByIsbnBook(String isbn);
}
```

```java
@Repository
@RequiredArgsConstructor
public class AuthorRepositoryJdbc implements AuthorRepository {
 
    private final JdbcTemplate jdbcTemplate;
 
    @Override
    public List<Author> getByIsbnBook(String isbn) {
        String sql = """
                SELECT authors.* FROM authors
                JOIN books_authors ON authors.id = books_authors.author_id
                JOIN books ON books_authors.book_id = books.id
                AND books.isbn = ?
           """;
        return jdbcTemplate.query(sql, new AuthorRowMapper(), isbn);
    }
}
```

Genre interface and implementation:
```java
public interface GenreRepository {
 
    List<Genre> getByIsbnBook(String isbn);
}
```

```java
@Repository
@RequiredArgsConstructor
public class GenreRepositoryJdbc implements GenreRepository {
 
    private final JdbcTemplate jdbcTemplate;
 
    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        String sql = """
                SELECT genres.* FROM genres
                JOIN books_genres ON genres.id = books_genres.genre_id
                JOIN books ON books_genres.book_id = books.id
                AND books.isbn = ?
           """;
        return jdbcTemplate.query(sql, new GenreRowMapper(),isbn);
    }
}
```

Now we have to add the authors and genres queries:

```java
@Repository
@RequiredArgsConstructor
public class BookRepositoryJdbc implements BookRepository {
 
    private final JdbcTemplate jdbcTemplate;
 
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
 
    @Override
    public List<Book> getAll()
    {
        String sql = """
                        SELECT * FROM books
                     """;
        return jdbcTemplate.query(sql, new BookRowMapper());
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
            book.setAuthors(authorRepository.getByIsbnBook(isbn));
            book.setGenres(genreRepository.getByIsbnBook(isbn));
            return Optional.of(book);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
```

# Cesar's Repository
[Up](#table-of-contents)

Repository: https://github.com/cesguiro/dws-spring/tree/develop/dws-layers

Database: https://cesguiro.es/lib/exe/fetch.php/clase/daw/arquitectura/bookstore.zip
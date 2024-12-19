UNIT 07 - JPA

# Table of Contents
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Adding the Dependency and Configuring the Connection](#adding-the-dependency-and-configuring-the-connection)
- [Structure](#structure)
- [Entities](#entities)
  - [Relationships Between Entities](#relationships-between-entities)
- [JPA Repositories](#jpa-repositories)
- [Choosing the Corresponding DAO](#choosing-the-corresponding-dao)
- [Related Data Loading](#related-data-loading)
- [Pagination](#pagination)
- [Updates, Deletions and Updates](#updates-deletions-and-updates)
- [Repository](#repository)

# Introduction
[Up](#table-of-contents)

Java Persistence API (JPA) has emerged as a standard Object Relational Mapping (ORM) framework for Java applications.

It offers an efficient and coherent way to manage the database connection and the data persistence.

There are different implementations of JPA:
- Hibernate: One of the most popular JPA implementations. By default, Spring Boot uses Hibernate as the JPA provider.
- EclipseLink.
- Apache OpenJPA.

# Adding the Dependency and Configuring the Connection
[Up](#table-of-contents)

We are going to use Spring Data JPA.

As always, the first step is to add the dependency to the `pom.xml` file.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

In our file `application.properties`, we need to configure the connection to the database if we do not have it, and adding a couple of useful options:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/movies
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=none
# Habilitar logs de consultas SQL
spring.jpa.show-sql=true
```

- `spring.jpa.hibernate.ddl-auto`: This property is used to automatically create the database schema based on the JPA entities. The possible values are:
  - `create`: Creates the schema, destroying the previous data.
  - `create-drop`: Creates the schema and drops it when the application is closed.
  - `update`: Updates the schema.
  - `validate`: Validates the schema.
  - `none`: Does nothing.
- `spring.jpa.show-sql`: This property is used to show the SQL queries in the console.
  - `true`: Shows the SQL queries.
  - `false`: Does not show the SQL queries.

# Structure
[Up](#table-of-contents)

We are going to add a new package: `dao.db.jpa` with the JPA implementation of our DAOs.

Inside, we will have another 3 packages:
- `dao.db.jpa.entity`: Contains the JPA entities.
- `dao.db.jpa.mapper`: Contains the mappers to convert the JPA entities to the domain entities.
- `dao.db.jpa.repository`: Contains the JPA repositories.

# Entities
[Up](#table-of-contents)

JPA uses its own entities that map the database tables.

For that, we only need to add the annotation `@Entity` to the class and `@Id` to the primary key.

If we put another name to the entity (for example, BookEntity), we need the annotation `@Table(name = "books")` to map the entity to the table `books` in the database.

`@GeneratedValue(strategy = GenerationType.IDENTITY)` is used to generate the primary key automatically.

When a column has a different name, we use the annotation `@Column(name = "name")`.

Our BookEntity would be like this:

```java
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class BookEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    @Column(name = "title_es")
    private String titleEs;
    @Column(name = "title_en")
    private String titleEn;
    @Column(name = "synopsis_es")
    private String synopsisEs;
    @Column(name = "synopsis_en")
    private String synopsisEn;
    private BigDecimal price;
    private float discount;
    private String cover;
 
    private PublisherEntity publisher;
    private CategoryEntity category;
    private List<AuthorEntity> authors;
    private List<GenreEntity> genres;
}
```

## Relationships Between Entities
[Up](#table-of-contents)

- `@OneToOne`: relationship 1-1 between two entities.
- `@OneToMany`: relationship 1-n between two entities.
- `@ManyToOne`: relationship n-1 between two entities.
- `@ManyToMany`: relationship n-n between two entities.

In general, we do not want bidirectional relationships because it can lead to infinite loops.

With the `@ManyToMany` relationship, we need to add the annotation `@JoinTable` to specify the table that will store the relationship.

```java
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class BookEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ...
     
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<AuthorEntity> authors;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genres;
}
```

# JPA Repositories
[Up](#table-of-contents)

JPA repositories are interfaces that extend the `JpaRepository` interface.

We have to specify the entity and the type of the primary key.

```java
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
 
}
```

When you extend this interface to create your repository, you get methods like save, findById, findAll, delete, count, etc.

Additionally, you can create your own methods using the specific conventions of Spring Data JPA.

For example with the ISBN (`find` methods return an `Optional` object):

```java
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
 
    Optional<BookEntity> findByIsbn(String isbn);
}
```

The complete list of the conventions can be found in the [Spring Data JPA documentation](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html).

The next step is to create the DAO implementation, but before we need the mappers:

```java
@Mapper(uses = {PublisherJpaMapper.class, AuthorJpaMapper.class, GenreJpaMapper.class, CategoryJpaMapper.class})
public interface BookJpaMapper {
 
    BookJpaMapper INSTANCE = Mappers.getMapper(BookJpaMapper.class);
 
    Book toBookWithDetails(BookEntity bookEntity);
 
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "category", ignore = true)
    Book toBook(BookEntity bookEntity);
 
    BookEntity toBookEntity(Book book);
 
}
```

And, then, we create the DAO implementation:

```java
@Component
@RequiredArgsConstructor
public class BookDaoJpa implements BookDaoDb {
 
    private final BookJpaRepository bookJpaRepository;
 
    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(bookJpaRepository.findByIsbn(isbn))
                .map(BookJpaMapper.INSTANCE::toBookWithDetails);
    }
    ...
    @Override
    public List<Book> getAll() {
        return bookJpaRepository
                .findAll()
                .stream()
                .map(BookJpaMapper.INSTANCE::toBook)
                .toList();
    }
    ...
}
```

# Choosing the Corresponding DAO
[Up](#table-of-contents)

Right now we have two implementations of the DAOs: the JDBC and the JPA. Spring does not know which one to use.

To solve that, we use the annotation `@Primary` in the JPA implementation.

```java
@Component
@Primary
@RequiredArgsConstructor
public class BookDaoJpa implements BookDaoDb {
   ...
}
```

# Related Data Loading
[Up](#table-of-contents)

- LAZY: The related data is loaded when it is needed. This can improve the performance, but needs additional queries when needed.
- EAGER: The related data is loaded when the entity is loaded. This can decrease the performance, but does not need additional queries.

Which one is by default?

- `@ManyToOne` and `@OneToOne` are EAGER by default.
- `@OneToMany` and `@ManyToMany` are LAZY by default.

JPA does not guarantee doing the query with JOIN, which can be important when choosing one option or the other.

We can avoid that using LAZY and adding the annotation that returns the entities with their related data:

```java
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
 
    @EntityGraph(attributePaths = {"publisher", "category"})
    BookEntity findByIsbn(String isbn);
  ...
}
```

The other option is using the `@Query` annotation:

```java
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
 
    @Query("SELECT b FROM BookEntity b " +
            "JOIN FETCH b.publisher p " +
            "JOIN FETCH b.category c " +
            "WHERE b.isbn = :isbn")
    BookEntity findByIsbn(String isbn);
    ...
}
```

# Pagination
[Up](#table-of-contents)

Pagination is as simple as adding the `Pageable` parameter to the method.

*Notes here*

# Updates, Deletions and Updates
[Up](#table-of-contents)

*Notes here*

# Repository
[Up](#table-of-contents)

https://github.com/cesguiro/dws-spring/tree/develop/dws-jpa
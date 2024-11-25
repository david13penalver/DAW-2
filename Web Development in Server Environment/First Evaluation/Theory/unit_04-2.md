UNIT 04.2 - PRESENTATION LAYER: LANGUAGE, PAGINATION AND ROLES

# Table of Contents
- [Table of Contents](#table-of-contents)
- [Language](#language)
  - [LanguageUtils](#languageutils)
  - [Interceptors in Java](#interceptors-in-java)
  - [LocaleConfig](#localeconfig)
- [Pagination](#pagination)
- [Roles](#roles)
  - [Admin](#admin)
    - [Domain Models](#domain-models)
    - [Presentation Layer](#presentation-layer)
    - [Domain \& Persistence Layers](#domain--persistence-layers)
- [Repository](#repository)

# Language
[Up](#table-of-contents)

We are going to create the configuration that allows our application to support multiple languages dinamycally sung the HTTP header *Accept-Language*.

With the interceptors and a language manager we can apply it in the whole application.

To store the language, we are going to use the `Locale` class. It represents a set of specific configurations for a particular language and region.

Firs of all, we will create the package `locale` in the *common* package.

## LanguageUtils
[Up](#table-of-contents)

We will create the class `LanguageUtils` in the package `locale` in the *common* package.

It will have the following methods:`setCurrentLocale()` to establish the proporcionate Locale, and `getCurrentLocale()`, that will return the corresponding language or the default one.

The class uses a `ThreadLocal` object to storage the current *Locale*.

```java
public class LanguageUtils {
 
    private static final ThreadLocal<Locale> currentLocale = new ThreadLocal<>();
 
    public static void setCurrentLocale(Locale locale) {
        currentLocale.set(locale);
    }
 
    public static String getCurrentLanguage() {
        Locale locale = currentLocale.get();
        return locale != null ? locale.getLanguage() : Locale.getDefault().getLanguage();
    }
}
```

## Interceptors in Java
[Up](#table-of-contents)

Java interceptors are components that allow intercepting and modifying the behavior of requests and responses in a web application. 

They act as filters that can perform various actions before and after a request is processed, allowing the implementation of functionalities such as authentication, authorization, logging and language management. 

In the Spring context, interceptors are mainly used to execute pre-processing and post-processing logic on HTTP requests. 

This is useful for tasks such as validating access permissions, logging information about the request or, in our case, managing the application language according to user preferences. 

To adapt our application to different languages, we have created a custom interceptor that extends `LocaleChangeInterceptor`. 

This interceptor will take care of reading the *Accept-Language* header of incoming requests and set the current Locale using the LanguageUtils class.

```java
public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
 
    private final String defaultLanguage;
 
    public CustomLocaleChangeInterceptor(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        String lang = request.getHeader("Accept-Language");
        Locale locale = lang != null ? Locale.forLanguageTag(lang) : Locale.of(defaultLanguage);
 
        LanguageUtils.setCurrentLocale(locale);
 
        return super.preHandle(request, response, handler);
    }
}
```

The class will have the `defaultLanguage`, which we will inject in the constructor.

The method `preHandle()` will read the *Accept-Language* header of the request and set the current *Locale* using the `LanguageUtils` class.

The `HttpServletRequest` interface is part of the Java servlet API and represents the HTTP request that a client sends to a server. 

It provides methods to access information about the request, such as parameters, headers and attributes. 

In the context of the interceptor, it is used to obtain the *Accept-Language* header that specifies the client's preferred language. 

The `HttpServletResponse` interface is also part of the servlet API and represents the HTTP response that a server sends back to the client. 

It allows the developer to modify the response, such as setting status codes, adding headers and sending data to the client. 

In the interceptor, although not directly modified, it is passed as an argument to allow the response to be interacted with if necessary. 

The *handler* parameter is an object representing the controller that will process the request. In the Spring context, it can be a controller (a method on a controller annotated with `@RequestMapping`) or other components that handle application logic. This parameter is used to determine what action to take after interceptor processing is complete. 

The *preHandle* method is executed before the request is processed by the controller. In this method, the value of the *Accept-Language* header of the request is first obtained. If a value is found, it is converted to a *Locale* object using the `forLanguageTag()` method. In case there is no value, the default language is used. 

The `Locale.forLanguageTag(String languageTag)` method is a static method of the Locale class that converts a language identifier (tag) into a Locale object. This method allows you to easily create instances of Locale using a standard language representation, such as “es-ES” for Spanish from Spain or “en-US” for English from the United States. 

Then, the current Locale is set in the thread context through the LanguageUtils class, ensuring that the selected language is used throughout the application. 

Finally, the `preHandle` method of the parent class is called to continue normal processing of the request. This is important because the parent class may contain logic that also needs to be executed to ensure that the interceptor functions correctly. By calling this method, you allow the base logic of the parent class to be executed before continuing with the processing of the request.

## LocaleConfig
[Up](#table-of-contents)

The LocaleConfig class is a configuration class that will be responsible for defining how the language is handled in the application.

This class is annotated with `@Configuration`, indicating that it contains bean definitions that will be used in the Spring context. 

To define the default language, we are going to use the file `application.properties`:

```properties
app.language.default=es
```

Spring allows us injecting the values of that file. We use the Spring annotation `@Value` putting inside {} the key of the property.

```java
@Configuration
public class LocaleConfig implements WebMvcConfigurer {
 
    @Value("${app.language.default}")
    private String defaultLanguage;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomLocaleChangeInterceptor(defaultLanguage));
    }
}
```

The method `addInterceptors()` is part of the `WebMvcConfigurer` interface, which is used to configure Spring MVC.

In this case, our custom interceptor CustomLocaleChangeInterceptor is added. Adding this interceptor ensures that every time a request is processed, the logic of our custom interceptor will be executed before it reaches the controllers, thus allowing the application to correctly handle the language according to the user's preferences. 

Now, we can know the user language in our mappers:

```java
@RequiredArgsConstructor
public class CategoryRowMapper implements CustomRowMapper<Category> {
 
    @Override
    public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Category category = new Category();
        category.setName(resultSet.getString("categories.name_" + language));
        category.setSlug(resultSet.getString("categories.slug"));
        return category;
    }
}
```

> **Note**: It is important to note that if the user requests a language that is not available in the database, this may cause an error. 
> 
> Therefore, it would be advisable to implement a check to ensure that the requested language has a corresponding field in the database before attempting to access it. This can help avoid exceptions and ensure a more robust user experience. 

If the user provides *es-** or nothing in the *Accept-Language* header, the response will be:

```json
{
          "isbn": "9780142424179",
          "title": "El principito",
          "price": 15.99,
          "discount": 10.0,
          "cover": "http://images.cesguiro.es/books/9780142424179.webp"
}
```

If the user provides *es-GB* in the *Accept-Language* header, the response will be:

```json
{
          "isbn": "9780142424179",
          "title": "The Little Prince",
          "price": 15.99,
          "discount": 10.0,
          "cover": "http://images.cesguiro.es/books/9780142424179.webp"
}
```

# Pagination
[Up](#table-of-contents)

Pagination is an essential aspect when managing great volumes of data.

To implement our pagination, we are going to create the class `PaginatedResponse` in the package *webmodel*, that will be responsible of escapsulating the paginated response.

```java
@Data
@AllArgsConstructor
public class PaginatedResponse<T> {
    private List<T> data;
    private int total;
    private int currentPage;
    private int pageSize;
    private String next;
    private String previous;
 
    public PaginatedResponse(List<T> data, int total, int currentPage, int pageSize, String baseUrl) {
        this.data = data;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.next = createNextLink(baseUrl);
        this.previous = createPreviousLink(baseUrl);
    }
 
    private String createNextLink(String baseUrl) {
        if(currentPage * pageSize < total) {
            return baseUrl + "?page=" + (currentPage + 1) + "&size=" + pageSize;
        }
        return null;
    }
 
    private String createPreviousLink(String baseUrl) {
        if(currentPage > 1) {
            return baseUrl + "?page=" + (currentPage - 1) + "&size=" + pageSize;
        }
        return null;
    }
}
```

As with the default language, we are going to define the default page size in the `application.properties` file:

```properties
app.base.url=http://localhost:8080
app.pageSize.default=10
```

Next, we will inject those values in our controllers and will modify the method `getAll()` to use the pagination:

```java
@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.URL)
public class BookController {
 
    public static final String URL = "/api/books";
    @Value("${app.base.url}")
    private String baseUrl;
 
    @Value("${app.pageSize.default}")
    private String defaultPageSize;
 
    private final BookService bookService;
 
    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<BookCollection> books = bookService
                .getAll(page - 1, pageSize)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
 
        int total = bookService.count();
 
        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
// Rest of the code...
}
```

To obtain the total number of records, we will use a method in the service that will count the number of books available in the database. This will allow us to provide information on how many items there are in total, which is crucial for pagination. In this way, we can calculate whether there is a next or previous page and manage the navigation between the different result pages. 

The `@RequestParam` annotation is used to extract query parameters from the URL of the HTTP request. In this case, it will be used to receive the page and size values from the request. 

Page will have a default value of 1, in case the user does not specify this parameter. 

We make the size parameter not mandatory (with required = false) and see if it has been passed to us. If not, we read the default value. 

In the `BookService` class, we add two methods to manage the business logic of pagination:

```java
List<Book> getAll(int page, int size);
int count();
```

The implementation of both methods in the class `BookServiceImpl` is as follows:

```java
@Override
public List<Book> getAll(int page, int size) {
    return bookRepository.getAll(page, size);
}
 
@Override
public int count() {
    return bookRepository.count();
}
```

In `bookRepository`, we will add the methods `getAll()` and `count()`:

```java
List<Book> getAll(int page, int size);
int count();
```

And will be implemented in `BookRepositoryImpl`:

```java
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
```

# Roles
[Up](#table-of-contents)

In this section, we are going to implement the roles in our application.

To handle the differentiation between users and administrators in our application, we implemented a clear separation of components by roles. 

This separation translates into the creation of specific packages within each layer of our architecture: user and admin. 

This structure not only helps to keep the code organized, but also allows us to scale and maintain the application more effectively.

To implement the separation of functionality by roles, we will start by renaming all our controllers, services and repositories. For example, the book controller will become `BookUserController`, the service will become `BookUserService` and the repository will become `BookRepository`. This naming convention will help us clearly identify which components are intended for user logic. 

## Admin
[Up](#table-of-contents)

### Domain Models
[Up](#table-of-contents)

The first thing to do is to create the administrator domain templates, including all the fields with the languages: 

Author class:
```java
public class Author {
 
    private long id;
    private String name;
    private String nationality;
    private String biographyEs;
    private String biographyEn;
    private int birthYear;
    private int deathYear;
}
```

Category class:
```java
public class Category {
 
    private long id;
    private String nameEs;
    private String nameEn;
    private String slug;
}
```

Genre class:
```java
public class Genre {
 
    private long id;
    private String nameEs;
    private String nameEn;
    private String slug;
}
```

Publisher class:
```java
public class Publisher {
 
    private long id;
    private String name;
    private String slug;
}
```

Book class:
```java
public class Book {
 
    private long id;
    private String isbn;
    private String titleEs;
    private String titleEn;
    private String synopsisEs;
    private String synopsisEn;
    private BigDecimal price;
    private float discount;
    private String cover;
    private Publisher publisher;
    private Category category;
    private List<Genre> genres;
    private List<Author> authors;
}

public String getTitle() {
    String language = LanguageUtils.getCurrentLanguage();
    if ("en".equals(language)) {
        return titleEn;
    }
    return titleEs;
}
```

The previous method `getTitle()` will return the title in the current language.

### Presentation Layer
[Up](#table-of-contents)

Then, we will createe the `BookCollection` model in the Presentation Layer:

```java
public record BookCollection( 
    String isbn, 
    String title 
) { } 
```

This template will be placed in the *admin* package, allowing it to be used specifically for the administrator's book management functionality. In this way, we ensure a clear separation of responsibilities and facilitate access to the information needed for library administration.

We will translate the *PaginatedResponse* to the common package, so it can be used by both user and admin roles.

Next, we will create the *BookMapper* for the admin to cast the *Book* to *BookCollection*:

```java
@Mapper
public interface BookMapper {
 
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
 
    @Mapping(target = "title", source = "book.title")
    BookCollection toBookCollection(Book book);
 
}
```

In this mapper, we use the `getTitle()` method that we have previously defined in the `Book` class. This method is responsible for returning the title of the book in the corresponding language, according to the administrator's preference. In this way, we ensure that the presentation model correctly reflects the localized information that the administrator needs to manage the books.

Then, we continue with the next layers.

### Domain & Persistence Layers
[Up](#table-of-contents)

In the service, it will be almost identical to the user service, but with the admin domain models and the calling to the admin repositories.

```java
@Service
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {
 
    private final BookAdminRepository bookAdminRepository;
 
    @Override
    public List<Book> getAll() {
        return bookAdminRepository.getAll();
    }
 
    @Override
    public List<Book> getAll(int page, int size) {
        return bookAdminRepository.getAll(page, size);
    }
 
    @Override
    public int count() {
        return bookAdminRepository.count();
    }
 
    @Override
    public Book findByIsbn(String isbn) {
        return bookAdminRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book isbn " + isbn + " not found"));
    }
}
```

In the Persistence Layer, we will also create a common package where we will place our `CustomRowMapper`, which will serve to reuse the mapping logic between the results of the queries and the domain models in both user and administrator controllers. 

The administrator's mappers will contain all the database information. For example, the Book mapper will be defined as follows: 

```java
    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setTitleEs(resultSet.getString("title_es"));
        book.setTitleEn(resultSet.getString("title_en"));
        book.setSynopsisEs(resultSet.getString("synopsis_es"));
        book.setSynopsisEn(resultSet.getString("synopsis_en"));
        book.setPrice(new BigDecimal(resultSet.getString("books.price")));
        book.setDiscount(resultSet.getFloat("books.discount"));
        book.setCover(resultSet.getString("books.cover"));
        if(this.existsColumn(resultSet, "publishers.id")) {
            book.setPublisher(publisherRowMapper.mapRow(resultSet, rowNum));
        }
        if(this.existsColumn(resultSet, "categories.id")) {
            book.setCategory(categoryRowMapper.mapRow(resultSet, rowNum));
        }
        return book;
    }
```

The administrator's repositories will be very similar to the user's, with the only difference being that we will use the corresponding mappers to convert the ResultSets into models of the administrator's domain layer. 

```java
@Repository
@RequiredArgsConstructor
public class BookAdminRepositoryImpl implements BookAdminRepository {
 
    private final JdbcTemplate jdbcTemplate;
 
    private final AuthorAdminRepository authorAdminRepository;
    private final GenreAdminRepository genreAdminRepository;
 
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
            book.setAuthors(authorAdminRepository.getByIsbnBook(isbn));
            book.setGenres(genreAdminRepository.getByIsbnBook(isbn));
            return Optional.of(book);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
```

> **Note**: This code duplication will be solved when we add the DAOs.

# Repository
[Up](#table-of-contents)

Repository: https://github.com/cesguiro/dws-spring/tree/develop/dws-presentation

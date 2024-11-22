UNIT 04-1 - PRESENTATION LAYER

# Table of Contents

- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Endpoints](#endpoints)
- [Models of the Presentation Layer](#models-of-the-presentation-layer)
- [Mappers](#mappers)
  - [MapStruct](#mapstruct)
- [Response](#response)
- [ResponseEntity](#responseentity)
- [Exception Handling](#exception-handling)
  - [ErrorMessage](#errormessage)
  - [ApiExceptionHandler](#apiexceptionhandler)
- [Repository](#repository)

# Introduction
[Up](#Table-of-Contents)

The Presentation Layer is the layer that interacts with the user. 

It is responsible for receiving the user's request, processing it, and returning the response.

This layer must be the most independent of the other layers, and is communicated with the Domain Layer.

# Endpoints
[Up](#Table-of-Contents)

The endpoints are the URLs that the user accesses to interact with the application.

Developing APIs, it is a good practice to add a prefix to the endpoints, such as `/api` (`localgost:8080/api/books`).

It is also common to the version of the API in the URL, such as `/api/v1` (`localgost:8080/api/v1/books`).

```java
@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {
 
    public static final String URL = "/api/books";

    // Rest of the code
}
```

# Models of the Presentation Layer
[Up](#Table-of-Contents)

Sometimes, the models of the Presentation Layer are different from the models of the Domain Layer to addapt to the user's and interface's needs.

In our example, we are going to divide the modes in *Collection* (for a list of resources) and *Detail* (for an individual resource).

We can use `Record` to create simple classes with only attributes and no methods.

***AuthorCollection:**
```java
public record AuthorCollection(
        long id,
        String name
) {
}
```

**PublisherCollection:**
```java
public record PublisherCollection(
        long id,
        String name
) {
}
```

**BookCollection:**
```java
public record BookCollection (
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String cover
) { }
```

**BookDetail:**
```java
public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String synopsis,
        String cover,
        List<String> genres,
        String category,
        @JsonProperty("publisher") PublisherCollection publisherCollection,
        @JsonProperty("authors") List<AuthorCollection> authorsCollection
) {
}
```

- `@JsonProperty("publisher")`: This annotation is used to change the name of the attribute in the JSON response. In this case, the name in the JSON response will be `publisher` instead of `publisherCollection`.

# Mappers
[Up](#Table-of-Contents)

MapStruct is a library that helps to map objects from one class to another.

We have to add the dependency in the `pom.xml` file.

```xml
...
<properties>
    ...
    <org.mapstruct.version>1.6.2</org.mapstruct.version>
</properties>
...
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
</dependencies>
...
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source> <!-- depending on your project -->
                <target>1.8</target> <!-- depending on your project -->
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                    <!-- other annotation processors -->
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
```

When we are using Lombok and MapStruct together, we have to add the `lombok-mapstruct-binding` dependency.

```xml
<properties>
    ...
    <org.mapstruct.version>1.6.2</org.mapstruct.version>
    <org.mapstruct.version>1.6.2</org.mapstruct.version>
    <lombok-mapstruck-bindings.version>0.2.0</lombok-mapstruck-bindings.version>    
</properties>
...
 
<annotationProcessorPaths>
    <path>
       <groupId>org.mapstruct</groupId>
           <artifactId>mapstruct-processor</artifactId>
           <version>${org.mapstruct.version}</version>
    </path>
    <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
    </path>
    <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok-mapstruct-binding</artifactId>
        <version>${lombok-mapstruck-bindings.version}</version>
    </path>
</annotationProcessorPaths>
```

## MapStruct
[Up](#Table-of-Contents)

To create a mapper, we have to create an interface with the `@Mapper` annotation.

```java
@Mapper
public interface AuthorMapper {
 
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
 
    AuthorCollection toAuthorCollection(Author author);
}
```
- `@Mapper`: This annotation is used to indicate that this interface is a mapper.
- `INSTANCE`: This is a Singleton instance that MapStruct generates automatically.
- `toAuthorCollection(Author author)`: Defines the method that MapStruct will use to map an `Author` object to an `AuthorCollection` object.

For MapStruct to work correctly, it is necessary that the classes participating in the mapping, both in the domain layer and in the presentation layer, have an empty constructor, as well as getters and setters methods for all attributes.

The names of the attributes must be the same in both classes. If the names are different, we can use the `@Mapping` annotation to indicate which attribute of the source class corresponds.

For example, if the attribute in the class *Author* is *fullName* and in the class *AuthorCollection* is *name*, we can use the `@Mapping` annotation to indicate the correspondence.

```java
@Mapper
public interface AuthorMapper {
 
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
 
    @Mapping(source = "fullName", target = "name")
    AuthorCollection toAuthorCollection(Author author);
}
```

In the case of *GenreMapper*, the objetive is to convert a list of *Genre* objects into a *List<String>*, where each string represents the name of the genre. To achieve this, we can use either direct mapping methods or a custom conversion method: 

```java
@Mapper
public interface GenreMapper {
 
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
 
    List<String> toGenreNameList(List<Genre> genres);
 
    default String toGenreName(Genre genre) {
        return genre.getName();
    }
}
```
- `toGenreNameList(List<Genre> genres)`: This method receives a list of *Genre* objects and returns a list of *String* objects. MapStruct will generate the needed code to convert each element of the list using the casting methods availables (in this case: `toGenreName(Genre genre)`).
- `default String toGenreName(Genre genre)`: This casting personalized method receives a *Genre* object and returns a *String* object. This method is used by the previous method to convert each element of the list.

Building *BookMapper*:

```java
@Mapper(uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class})
public interface BookMapper {
 
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
 
    BookCollection toBookCollection(Book book);
 
    @Mapping(target ="publisherCollection", source = "publisher")
    @Mapping(target="authorsCollection", source = "authors")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "genres", source = "genres")
    BookDetail toBookDetail(Book book);
 
}
```
- `@Mapper(uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class})`: This annotation indicates that this mapper uses other mappers to convert the attributes of the *Book* object. Useful to avoid code duplication.
- `BookCollection toBookCollection(Book book)`: This method converts a *Book* object into a *BookCollection* object.
- `@Mapping(target =“publisherCollection”, source = “publisher”)`: This annotation indicates that the attribute *publisherCollection* of the *BookCollection* object corresponds to the attribute *publisher* of the *Book* object.
- `@Mapping(target=“authorsCollection”, source = “authors”)`: Similar to the previous one, this mapping takes the mission of converting the list of authors from the Book object in authorsCollection to BookDetail, using the AuthorMapper.
- `@Mapping(target = “category”, source = “category.name”)`: This mapping converts the category attribute to Book, extracting its name to assign it to category in BookDetail.
- `@Mapping(target = “genres”, source = “genres”)`: Here a direct mapping from genre to genre is performed, where GenreMapper is expected to be used to convert each Genre into its corresponding representation.

# Response
[Up](#Table-of-Contents)

To use the new models in the controller responses, we must make changes to the methods that handle the requests. 

Specifically, we will change the return type of the `getAll()` method to return a *BookCollection* list and the `findByIsbn()` method to return a *BookDetail* object:

```java
@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {
 
    public static final String URL = "/api/books";
 
    private final BookService bookService;
 
    @GetMapping
    public List<BookCollection> getAll() {
        return bookService.getAll()
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
    }
 
    @GetMapping("/{isbn}")
    public BookDetail findByIsbn(@PathVariable String isbn) {
        return BookMapper.INSTANCE.toBookDetail(bookService.findByIsbn(isbn));
    }
}
```

# ResponseEntity
[Up](#Table-of-Contents)

To improve the handling of responses in the controller, we are going to change the response type to ResponseEntity. 

The ResponseEntity class is a fundamental part of Spring that allows us to represent an HTTP response, including the body, headers, and status of the response. 

This provides greater control over how responses are sent to the client: 
    
```java
@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {
 
    public static final String URL = "/api/books";
 
    private final BookService bookService;
 
    @GetMapping
    public ResponseEntity<List<BookCollection>> getAll() {
        List<BookCollection> bookCollections = bookService
                .getAll()
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
        return new ResponseEntity<>(bookCollections, HttpStatus.OK);
    }
 
 
    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn) {
        BookDetail bookDetail = BookMapper.INSTANCE.toBookDetail(bookService.findByIsbn(isbn));
        return new ResponseEntity<>(bookDetail, HttpStatus.OK);
    }
 
}
```

Advantages of using *ResponseEntity*:
- Control of the status of the response: We can define the status of the response, such as 200 (OK) (`HttpStatus.OK`), 404 (Not Found) (`HttpStatus.NOT_FOUND`), 500 (Internal Server Error) (`HttpStatus.INTERNAL_SERVER_ERROR`), etc.
- Personalized headers: We can add headers to the response, such as `Content-Type`, `Location`, etc.
- Flexibility in the body of the answer: It allows any type of object to be sent as the body of the response, maintaining the ability to send complex data without losing the structure of the HTTP response.

# Exception Handling
[Up](#Table-of-Contents)

When it comes to creating custom exceptions in an application, there is the option of organizing them in a common package or in the corresponding layers of the application. 

Although both strategies have their advantages, in this case we will choose to create the exceptions in a common package, since we will use them in different places. 

In our case, we will create the exception *ResourceNotFoundException* :

```java
public class ResourceNotFoundException extends RuntimeException {
 
    private static final String DESCRIPTION = "Resource not found";
 
    public ResourceNotFoundException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}
```

In this way, when a resource is not found (like a book), we can throw this exception:

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
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book isbn " + isbn + " not found"));
    }
}
```

Spring offers a way to centralize exception handling through the `@ControllerAdvice` annotation. 

Using `@ControllerAdvice` allows you to define a single place to handle all exceptions that may occur in the application's controllers. 

This not only simplifies error handling by avoiding duplication of logic in each controller, but also ensures that all error responses have a consistent structure and format.

It gives the possibiity to handle  different type of exceptions in a specific way, allowing customized responses to be returned according to the situation, with appropriate HTTP status codes and descriptive error messages.

To handle exceptions in the application effectively, we will create two classes in the common package: *ErrorMessage* and *ApiExceptionHandler*.

## ErrorMessage
[Up](#Table-of-Contents)

The class *ErrorMessage* contains two properties (*error* and *message*) that will be used to represent the error in the response.

```java
@Getter
@ToString
public class ErrorMessage {
 
    private final String error;
    private final String message;
 
    public ErrorMessage(Exception exception) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
    }
}
```

## ApiExceptionHandler
[Up](#Table-of-Contents)


The *ApiExceptionHandler* class uses the `@ControllerAdvice` annotation to handle exceptions globally. 

Here, it handles the ResourceNotFoundException exception by returning an ErrorMessage with a 404 status code (NO FOUND).

To catch the rest of the exceptions more securely and avoid exposing sensitive details about the internal error, we can create a method in the ApiExceptionHandler class to return a generic message such as “Internal error”. 

This ensures that any exceptions not specifically handled are also handled appropriately, providing a consistent response to the client. 

```java
@ControllerAdvice
public class ApiExceptionHandler {
 
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceNotFoundException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(ResourceNotFoundException exception) {
        return new ErrorMessage(exception);
    }
     
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleGeneralException(Exception exception) {
        return new ErrorMessage(exception);
    }    
}
```

# Repository
[Up](#Table-of-Contents)

Repository: https://github.com/cesguiro/dws-spring/tree/develop/dws-presentation
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

*Continue here.*

# Response
[Up](#Table-of-Contents)

# ResponseEntity
[Up](#Table-of-Contents)

# Exception Handling
[Up](#Table-of-Contents)

# Repository
[Up](#Table-of-Contents)

Repository: https://github.com/cesguiro/dws-spring/tree/develop/dws-presentation
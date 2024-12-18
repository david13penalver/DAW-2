UNIT 06 - JPA

# Table of Contents
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Adding the Dependency and Configuring the Connection](#adding-the-dependency-and-configuring-the-connection)
- [Structure](#structure)
- [Entities](#entities)
- [JPA Repositories](#jpa-repositories)
- [Choosing the Corresponding DAO](#choosing-the-corresponding-dao)
- [Related Data Loading](#related-data-loading)
- [Pagination](#pagination)

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

# JPA Repositories
[Up](#table-of-contents)

# Choosing the Corresponding DAO
[Up](#table-of-contents)

# Related Data Loading
[Up](#table-of-contents)

# Pagination
[Up](#table-of-contents)
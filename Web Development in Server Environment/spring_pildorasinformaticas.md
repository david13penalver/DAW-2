# Spring Advantages

- Dependencies Injection
- Easy development with POJOs (Plain Old Java Objects)
- Reduces the repetition of code (boilerplate code)
- Simplifies the access to the database
- Aspect Oriented Programming (AOP): allows to separate the business logic from the cross-cutting concerns

# Structure of Spring core

- Core container: provides the basic functionalities of the framework
  - Context: provides the configuration of the application
  - Beans: manages the objects of the application
  - Spring Expression Language: allows to access the objects of the application
- Infrastructure: provides the functionalities to the core container
  - AOP
  - Instrumentation
  - Messaging
  - DAO
  - ORM
- Data Access/Integration: provides the functionalities to access the data
  - JDBC (Java Database Connectivity)
  - ORM (Object Relational Mapping)
    - Object Oriented Programming with relational databases
    - High integration with Hibernate
  - Transactions
    - JMS (Java Messaging Service)
    - OXM (Object XML Mapping)
  - JCA (Java Connector Architecture)
- Web/VCM (View Controller Model): provides the functionalities to develop web applications
  - Servlets
  - Struts
  - JSF (Java Server Faces)
  - Portlet
  - Web Services
  - Web Sockets
  - Web Flow
  - Web MVC
- Test: provides the functionalities to test the application
  - JUnit
  - Mockito
  - Integration

# Istall Spring JAR Files

If I use Maven, I can add the following dependencies to the `pom.xml` file:

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-core</artifactId>
  <version>5.2.6.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.2.6.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-beans</artifactId>
  <version>5.2.6.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-expression</artifactId>
  <version>5.2.6.RELEASE</version>
</dependency>
```
Is is automatically downloaded from the Maven repository or with Spring Initializr.

# Inversion of Control (IoC)

- It is a design principle that allows to invert the control of the objects to the framework
- It allows modularity
- It allows to reduce the coupling between the objects (dependency between the objects)
- It allows to increase the functionality of our apps withou changing the code
- It flexibilizes the code making them more configurable

We make it with:
- XML (disused)
- Java Annotations
- Java Source Code

## With XML

- Name the file `applicationontext.xml`
- Put that file in the src folder
- Paste the next code:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
    http://www.springframework.org/schema/beans   
    http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context-3.1.xsd
">

<bean id="nameObject" class="es.pildoras.IoC.ClassName">

</beans>

</beans>
```

Then we create a context en the `es.pildoras.IoC.ClassName`:
```java
ClassPathXMLApplicationContext context = new ClassPathXMLApplicationContext("nameObject");
// Import the package
ClassName className = context.getBean("nameObject, InterfaceOfTheClasses.class")

System.out.println(className.getMethod());
```

With that, modifiyng the XML file we can change the type of the classes that implement the interface.

# Inyection of Dependencies

- It is a design pattern that allows to inject the dependencies of the objects
- It allows modularity
- *It is like a PC, where there are independent components that are connected working as a unit*
- **3:50**

*Continue here: [Video 9](https://www.youtube.com/watch?v=BghyeYN34a4&list=PLU8oAlHdN5Blq85GIxtKjIXdfHPksV_Hm&index=9)*

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
- It allows to reduce the coupling between the objects

Forms of injection:
- Constructor
  - Create the class and interface of the object
  - Create a constructor in the class that receives the interface
```java
public class ClassName {

// Interface object 
  private InterfaceName interfaceName;

// Constructor with the interface as parameter
  public ClassName(InterfaceName interfaceName) {
    this.interfaceName = interfaceName;
  }
}
```
  - Create the object in the XML file (`ApplicationContext.xml`)
```xml
<bean id="miInforme" class="es.pildoras.IoC.Informe">
  <constructor-arg ref="nameObject"/>

</bean>

<bean id="miEmpleado" class="es.pildoras.IoC.DirectorEmpleado">
  <constructor-arg href="miInforme" value="value"/>

</bean>
```
  - Configurate the XML file with the constructor-arg (`ApplicationContext.xml`)
```xml

```
- Setter
  - Create the class and interface of the object
  - Create a setter in the class that receives the interface
  - Create the object in the XML file (`ApplicationContext.xml`)
- Auto-wired (with annotations)

# Design Patterns

## Singleton

- It is a design pattern that allows to create a single instance of a class
- Examples: Runtime, Logger, Spring Beans
- Advantages:
  - It allows to reduce the memory usage
  - It allows to reduce the time of execution
  - Better hierarchical control
  - Stronger control of the objects
- Spring uses the Singleton pattern by default

```java
public class Singleton {
  private static Singleton instance = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return instance;
  }
}
```

## Prototype

- It is a design pattern that allows to create multiple instances of a class
- They are created by cloning the object
- It is better to clone the object than to create a new one
- The cloned object is independent of the original object and can be modified thanks to setters
- Advantages:
  - An app can create and delete objects in runtime
  - It allows creating new objects modifying the original object, reducing time and resources
  - Cloning is faster than creating a new object
- Spring can use it when needed

```java
public class Prototype implements Cloneable {
  private String name;

  public Prototype clone() {
    Prototype clone = new Prototype();
    clone.setName(this.name);
    return clone;
  }
}
```

*Continue here: [Video 14](https://www.youtube.com/watch?v=J6Mae6LLpLI&list=PLU8oAlHdN5Blq85GIxtKjIXdfHPksV_Hm&index=14)*
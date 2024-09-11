// table of contents
- [Introduction](#introduction)
- [Fundamental Principles](#fundamental-principles)
- [Lambda Functions](#lambda-functions)
  - [Syntax](#syntax)
- [Functional Interfaces](#functional-interfaces)
  - [Common Functional Interfaces](#common-functional-interfaces)
- [Streams](#streams)
  - [Creation and Collection](#creation-and-collection)
  - [Common methods](#common-methods)
    - [Intermediate Operations](#intermediate-operations)
    - [Terminal Operations](#terminal-operations)
- [Optional](#optional)
  - [Creation](#creation)
  - [Most Common Methods](#most-common-methods)

# Introduction

Functional programming is a programming paradigm where functions are treated as first-class citizens. It is a declarative programming paradigm where the logic of the program is expressed without explicitly describing the flow control.

Functions can be treated as variables, passed as arguments, and returned as values.

Advantages of functional programming:
- Easier to understand and debug
- Easier to test
- Easier to maintain
- Easier to scale
- Encourages code reusability
- Encourages modularity

# Fundamental Principles

- Functions as First Class Citizens: can be treated like any other type of data.
- Immutability: once an object (such as a variable or a data structure) has been created, its state cannot be changed
- Purity of functions: always produce the same results and have no observable side effects outside of the function. A pure function neither modifies the state of external variables nor performs operations that depend on mutable external data
- Recursion and Higher Order Funcionts: encourages the use of recursion and higher-order functions. Recursion is used to perform iterations instead of loops, which can lead to clearer and more concise implementation of algorithms. Higher-order functions are those that can accept other functions as arguments or return functions as results, allowing function composition and the construction of more powerful abstractions.

# Lambda Functions

Lambda functions are anonymous functions. They do not have a name, return type, or access modifier. They are used to provide the implementation of functional interfaces.

These functions can be passed as arguments to other functions, returned as results of other functions and stored in variables. Their concise syntax and flexibility make them especially useful for high-level operations, such as manipulating collections of data and implementing functional design patterns.

## Syntax

```java
(parameters) -> expression
```

- Parameters are enclosed in parentheses and separated by commas.
- The arrow separates the parameters from the body of the lamba function.
- The expression after the arrow is the body of the lambda function. Represents the impleementation.
- If the type of parameters can be inferred by the compiler, you can omit them. For example, `(int a, int b)` can be abbreviated as `(a, b)`.
- If the lambda function has only one expression, you can omit the braces `{}` and the `return` keyword.
- The expression will be automatically the return value of the lambda function.

Example to add two numbers using lambda function:

```java
//Without Lambda
AddOperation addOperation = new AddOperation() {
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
};

// With Lambda
AddOperation addOperationFunctional = (a, b) -> a + b;
```

Lambda functions are commonly used in combination with functional interfaces, which are interfaces containing a single abstract method.

# Functional Interfaces

Functional interfaces are interfaces that have only one abstract method. These interfaces are the basis of functional programming in Java and are mainly used to define the type of a lambda function.

Example of a functional interface:

```java
@FunctionalInterface
interface AddOperation {
    Integer add(Integer a, Integer b);
}
```
The annotation `@FunctionalInterface` is optional, but it is recommended to use it to indicate that the interface is intended to be used as a functional interface and avoid adding more abstract methods in the future.

Utilities:
- Declaration of variables: you can declare functional interface type variables and assign references to them to lambda functions that implement the abstract method of the interface:
```java
public class LambdaFunctions {
 
   // Without functional programming
   AddOperation addOperation = new AddOperation() {
      @Override
      public Integer add(Integer a, Integer b) {
         return a + b;
      }
   };
 
   // With functional programming
   AddOperation addOperationFunctional = (a, b) -> a + b;
}
```

- Parameters of methods: you can pass lambda functions as arguments to methods that take parameters of the corresponding functional interface type:
```java
public Integer add(Integer a, Integer b, AddOperation addOperation) {
   return addOperation.add(a, b);
}

@Test
void testAdd() {
    LambdaFunctions lambdaFunctions = new LambdaFunctions();
    assertEquals(3, lambdaFunctions.add(1, 2, lambdaFunctions.addOperation));
}
```

## Common Functional Interfaces

Since Java 8, the JDK has included a package called `java.util.function` that contains several functional interfaces that can be used to define lambda functions for common operations.

Four main groups of functional interfaces:
- `Consumer<T> accept(T)`: accepts one argument and returns no result. Mainly for operations with side effects.
```java
Consumer<String> print = s -> System.out.println(s);
print.accept("Hello, World!"); // Imprime: Hello, World!
```
- `Predicate <T> test(T): Boolean`: accepts one argument and returns a boolean result. Mainly for evaluating conditions.
 ```java
 Predicate<Integer> isPositive = i -> i > 0;
System.out.println(isPositive.test(1)); // Prints: true
 ```
- `Function<T, R> apply(T): R`: accepts one argument and returns a result. Mainly for transforming data.
```java
Function<Integer, Integer> square = i -> i * i;
System.out.println(square.apply(3)); // Prints: 9
```
- `Supplier<T> get(): T`: does not accept arguments and returns a result. Mainly for providing data when they are required.
```java
Supplier<String> hello = () -> "Hello, World!";
System.out.println(hello.get()); //Prints: "Hello, World!"
```

The `java.util.function` library defines many more interfaces to cover different needs. 

Among them are binary variants such as BiConsumer, BiPredicate and BiFunction, which accept two arguments. 

There are also specialized interfaces for primitive types, such as IntConsumer, DoublePredicate, LongSupplier..... 

These additional interfaces allow for greater flexibility and efficiency in functional programming in Java.

# Streams

A `Stream` is a sequence of elements that can be processed in a sequential or parallel manner. Streams are a key feature of functional programming in Java, as they allow for the manipulation of collections of data in a declarative and functional style.

Characteristics of Streams:
- Sequence of Operations: Streams allow you to perform a sequence of operations on a collection of data (filtering, mapping, and reducing). It facilitates a cleaner and more readible code.
- Intermediate and Terminal Operations: intermediate operations are used to transform the data in the stream, while terminal operations produce a result or side effect.
- Lazy Evaluation: which means that intermediate operations are not executed until a terminal operation is called. This allows for more efficient processing of data.

## Creation and Collection

They can be created from collections, arrays, or other sources. Streams can be used to perform operations such as filtering, mapping, reducing, and sorting on the elements of the stream.

- From collections: they can be created from collections using the `stream()` method of the `Collection` interface (or the `parallelStream()` method to obtain a parallel Stream):
```java
List<Integer> numberList = List.of(1, 2, 3, 4, 5);
Stream<Integer> numberStream = numberList.stream();
```
- Fron arrays: they can be created from arrays using the `Arrays.stream()` method:
```java
Integer[] numberArray = {1, 2, 3, 4, 5};
Stream<Integer> numberStream = Arrays.stream(numberArray);
```
- From individual values: they can be created from individual values using the `Stream.of()` method:
```java
Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
```

## Common methods

Streams provide a wide range of methods to perform operations on the elements of the stream. Some of the most common methods are:

### Intermediate Operations

- `filter`: filters the elements of a `Stream`using a `Predicate` function:
```java
List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
List<String> filteredNames = names.stream()
                                  .filter(name -> name.startsWith("J"))
                                  .toList();
```
- `map`: transforms the elements of a `Stream`:
```java
List<Integer> lengths = names.stream()
                             .map(String::length)
                             .toList();
```

*`String::length` is equivalent to the lambda function `s → s.length()`, but in a more concise and readable form. This optimization is possible in Java when the lambda function consists of invoking a single method on the function argument.*

- `sorted`: sorts the elements of a `Stream`:
```java
List<String> sortedNames = names.stream()
                                .sorted()
                                .toList();
```

*When the `sorted()` method is applied to a `Stream` of objects that implement the Comparable interface (such as String), the default order is the natural order, which in the case of text strings (String) is the lexicographical or alphabetical order.*

- `distinct`: removes duplicate elements from a `Stream`:
```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
List<Integer> distinctNumbers = numbers.stream()
                                       .distinct()
                                       .toList();
```

### Terminal Operations

- 'toList': collects the elements of a `Stream` into a `List`:
```java
List<String> collectedNames = names.stream()
                                   .toList();
```
- 'toArray': collects the elements of a `Stream` into an array:
```java
String[] namesArray = names.stream()
                           .toArray(String[]::new);
```

- 'reduce': combines the elements of a `Stream` into a single result:
```java
Integer sum = numbers.stream()
                     .reduce(0, Integer::sum);
```

It is also possible to calculate the sum of elements in an Integer Stream in a more concise way by using the reduce method together with a method reference. 

For example, instead of specifying an explicit initial value as in the previous example, you can use reduce without an initial value. This returns an `Optional<Integer>` containing the result of the sum operation:

```java
return integers
        .stream()
        .reduce(Integer::sum)
        .orElse(0);
```

- `forEach`: performs an action on each element of a `Stream`:
```java
names.stream()
     .forEach(System.out::println);
```
- `count`: returns the number of elements in a `Stream`:
```java
long count = names.stream()
                  .filter(name -> name.startsWith("J"))
                  .count();
```
- 'findFirst' and 'findAny': return the first or any element of a `Stream`:
```java
Optional<String> firstName = names.stream()
                                  .findFirst();
```
```java
Optional<String> anyName = names.stream()
                                .findAny();
```

# Optional

The `Optional` class is a container object that may or may not contain a non-null value. It is used to represent the absence of a value, instead of using `null`.

This class was introduced to address the problem of null references that can lead to NullPointerExceptions at runtime.

Its main usefulness lies in:
- Avoid `NullPointerExceptions`: by providing a way to handle the absence of a value.
- Clarity and Readability: by making it explicit that a value may be absent.
- Better Design: by encouraging the use of methods that return `Optional` instead of `null`.
- More expressive API: It provides useful methods for working with optional values, such as `orElse`, `orElseGet`, `orElseThrow`, `ifPresent`, etc.; which make it easier to handle cases of `null` values in a more elegant way.

## Creation

- `Optional.of(value)`: creates an `Optional` object that contains a non-null value. If the value is `null`, a `NullPointerException` is thrown.
```java
String name = "John";
Optional<String> optionalName = Optional.of(name);
```
- `Optional.ofNullable(value)`: creates an `Optional` object that contains a value, which may be `null`.
```java
String nullableName = null;
Optional<String> optionalNullableName = Optional.ofNullable(nullableName);
```
- `Optional.empty()`: creates an `Optional` object that contains no value.
```java
Optional<String> emptyOptional = Optional.empty();
```
While `null` indicates the total absence of value and may cause NullPointerExceptions if not handled correctly, `Optional.empty()` explicitly represents the absence of a value inside an Optional container, without the possibility of generating `NullPointerExceptions`.

It is good practice to use `Optional` only as a return type for methods that may or may not return a value, but it should not be used as an input parameter type for methods.

## Most Common Methods

- `isPresent()`: verifies if the `Optional` contains a value.
```java
Optional<String> optionalName = Optional.of("John");
if (optionalName.isPresent()) {
    System.out.println("El nombre es: " + optionalName.get());
}
```
- `orElse(T other)`: returns the value contained in the `Optional` object if it is present, or the specified default value if it is not.
```java
Optional<String> optionalName = Optional.empty();
String name = optionalName.orElse("Valor Predeterminado");
```
- `orElseGet(Supplier<? extends T> other)`: returns the value contained in the `Optional` object if it is present, or the result of the supplier function if it is not.
```java
Optional<String> optionalName = Optional.empty();
String name = optionalName.orElseGet(() -> "Valor Generado");
```
- `orElseThrow(Supplier<? extends X> exceptionSupplier)`: returns the value contained in the `Optional` object if it is present, or throws an exception generated by the supplier function if it is not.
```java
Optional<String> optionalName = Optional.empty();
String name = optionalName.orElseThrow(() -> new NoSuchElementException("No se encontró el nombre"));
```
- `get()`: returns the value contained in the `Optional` object if it is present, or throws a `NoSuchElementException` if it is not.
```java
Optional<String> optionalName = Optional.of("Jane");
String name = optionalName.get();
```
- `ifPresent(Consumer<? super T> consumer)`: performs an action on the value contained in the `Optional` object if it is present.
```java
Optional<String> optionalName = Optional.of("Jack");
optionalName.ifPresent(name -> System.out.println("El nombre es: " + name));
```
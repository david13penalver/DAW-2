# Fundamental Principles

- Functions as First Class Citizens
- Immutability
- Purity of functions
- Recursion and Higher-Order Funcionts

# Lambda Functions

Lambda functions are anonymous functions that are defined using the `lambda` keyword. They are used to create small, one-time and throwaway functions. They are also known as inline functions.

Example to add two numbers using lambda function:

```java
//Without Lambda
AddOperation addOperation = new AddOperation() {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
};

// With Lambda
AddOperation addOperationFunctional = (a, b) -> a + b;
System.out.println(addOperationFunctional.add(10, 20));
```

# Functional Interfaces

Functional interfaces are interfaces that have only one abstract method. They are used to provide the implementation of lambda expressions.

Example of a functional interface:

```java
@FunctionalInterface
interface AddOperation {
    int add(int a, int b);
}
```

Implementing the functional interface:
    
    ```java
    // Without functional programming
    AddOperation addOperation = new AddOperation() {
        @Override
        public int add(int a, int b) {
            return a + b;
        }
    };

    // With functional programming
    AddOperation addOperationFunctional = (a, b) -> a + b;
    ```

# Table of Contents

- [Table of Contents](#table-of-contents)
- [Functions](#functions)
  - [Parameters](#parameters)
  - [Function Expressions and Anonymous Functions](#function-expressions-and-anonymous-functions)
  - [Fat Arrows](#fat-arrows)
- [Iterables](#iterables)
  - [Arrays](#arrays)
    - [Declaration and access to the elements](#declaration-and-access-to-the-elements)
    - [Properties and methods](#properties-and-methods)
    - [Callbacks](#callbacks)
    - [Array Type](#array-type)
  - [Sets](#sets)
  - [Maps](#maps)
- [Objects](#objects)
  - [Object Creation](#object-creation)
  - [Access to the properties](#access-to-the-properties)
  - [Methods](#methods)
  - [JSON](#json)
- [Classes](#classes)

# Functions
[Up](#table-of-contents)

- JavaScript functions are reusable block codes that perform a specific task.
- They allow you to organize code, make it more modular and avoid repetition.
- They can receive parameters and return values.

Basic structure:

```javascript
function functionName(parameter1, parameter2, ...) {
    // Body
    // code block
    return value;
}
```

Parts of a function:
- `function`: keyword that indicates the beginning of a function.
- `functionName`: name of the function.
- `parameter1, parameter2, ...`: parameters that the function receives.
- {}: keys that delimit the code block or body.
- `return`: keyword that indicates the value that the function returns.

Function types:
- Named functions: functions that have a name.
- Expression functions: functions that are assigned to a variable.
- Anonymous functions: functions that do not have a name.
  - They are executed right after they are created.

## Parameters
[Up](#table-of-contents)

Parameters are data that are declared in the function declaration.

Alternatives:
- **Pass the same number of parameters** to the function as the number defined in the function header. This would be the traditional form of the other languages.
- **Use default values for the parameters**, this means that we can define in the function header default values, if the function call does not include that parameter, the value that the function will take will be the one we have defined as default.
```javascript
function muestraMensaje(msg = "No hay texto...") {
    alert(msg);
}
muestraMensaje(); // Llamamos a la funcion sin parametro
```
- **Use the arguments object**, an array-like object that is available inside all functions (except fat arrow) and contains the values of the arguments passed to that function. 
  - It can be used to access the arguments of the function inside the body of the function. 
  - It allows us to call the function with the parameters we want, without having to define parameters in the function. 
  - It is currently in disuse.

```javascript
function sumar() {
let total = 0;
    for (let i = 0; i < arguments.length; i++) {
        total += arguments[i];
    }
    return total;
}

const resultado = sumar(10, 5, 3, 2);
console.log('La suma es:', resultado); // Imprime: La suma es: 20
```

- **Rest parameters and Spread Operator** are features introduced in ECMAScript 6 (ES6).
  - The rest parameters allow functions to accept any number of arguments. 
  - These arguments are collected in an array inside the function body.
```javascript
function nombreFuncion(...parametroRest) {
// Cuerpo de la función
}
```
  - The rest parameters differ from the arguments object in that they are actually an array and we can apply all the methods of the array object.
- **The spread operator**, also known as spread syntax, allows us to expand iterable elements such as arrays and objects into individual arguments or elements of an array literal.
```javascript
function sumar(...numeros) {
// Cuerpo de la función
}
const numeros = [10, 5, 3, 2];
sumar(...numeros); // Equivalente a sumar(10, 5, 3, 2)
```
  - Also used to create arrays without modifying existing arrays, problem of treating arrays as references.
```javascript
const arrayCopia = [...arrayOriginal];
console.log(arrayCopia === arrayOriginal); // Imprime: false (son diferentes referencias)
```

## Function Expressions and Anonymous Functions
[Up](#table-of-contents)

- Declaration of a function:
```javascript
function sumar(a, b) {
    return a + b;
}
```
- Expression of a function:
  - Assigning a function to a variable or to a property of an object.
  - A case could be the assignment of event handlers.
  - It should finish with a semicolon because it is an assignment to a variable.
  - Widely used in the creation of callback functions.
```javascript
const sumar = function(a, b) {
    return a + b;
};
```

## Fat Arrows
[Up](#table-of-contents)

Basic structure:
```javascript
(parametro1, parametro2, ...) => {
// Cuerpo de la función
}
```
- Parameters: parameters that the function receives.
  - If there is only one parameter, the parentheses can be omitted.
  - If there are no parameters, the parentheses must be included empty.
- Arrow: fat arrow.
- Body: code block.
  - If the body is a single line, the braces can be omitted.
  - If the body is a single line and returns a value, the return keyword can be omitted.

```javascript
const sumar = (a, b) => a + b; // Función que suma dos números
const resultado = sumar(5, 3); // Se llama a la función
console.log('La suma es:', resultado); // Imprime: La suma es: 8
```

# Iterables
[Up](#table-of-contents)

## Arrays
[Up](#table-of-contents)

### Declaration and access to the elements
[Up](#table-of-contents)

### Properties and methods
[Up](#table-of-contents)

### Callbacks
[Up](#table-of-contents)

### Array Type
[Up](#table-of-contents)

## Sets
[Up](#table-of-contents)

## Maps
[Up](#table-of-contents)

# Objects
[Up](#table-of-contents)

## Object Creation
[Up](#table-of-contents)

## Access to the properties
[Up](#table-of-contents)

## Methods
[Up](#table-of-contents)

## JSON
[Up](#table-of-contents)

# Classes
[Up](#table-of-contents)
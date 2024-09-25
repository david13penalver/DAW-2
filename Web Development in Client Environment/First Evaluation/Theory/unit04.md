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
      - [Add, delite and extract elements:](#add-delite-and-extract-elements)
      - [Iterate each element](#iterate-each-element)
      - [Search elements](#search-elements)
      - [Transform an array](#transform-an-array)
    - [Declaration and access to the elements](#declaration-and-access-to-the-elements-1)
    - [Properties and methods](#properties-and-methods-1)
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

- Objects that can be iterated using a loop.
- They allow as access to their elements in a sequential way.

More important iterables:
- Arrays: ordered collection of elements.
  - More used iterable.
  - They allow us storage and access to a list of sort elements.
- Sets: collection of unique elements.
- Sets: collection of key-value pairs.
  - They allow us to store and access elements by a key.
  - They are used to store data in a structured way.
- Objects: collection of properties.
  - They allow us to store and access data in a structured way.

## Arrays
[Up](#table-of-contents)

- Arrays are a type of object that allows us to store multiple values in a single variable.
- They are a key tool in JavaScript.
- The index of the elements starts at 0.

### Declaration and access to the elements

- Literal notation: most common way to create an array.
```javascript
const array = [element1, element2, ...];
const numeros = [10, 5, 3, 2];
const mixto = ["valor1", 20, true, { nombre: "Objeto" }];
```
- Constructor notation: less common way to create an array.
```javascript
const array = new Array(element1, element2, ...);
const numeros = new Array(10, 5, 3, 2);
const mixto = new Array("valor1", 20, true, { nombre: "Objeto" });
```

### Properties and methods

- `length`: property that returns the number of elements in the array.
```javascript
const numeros = [10, 5, 3, 2];
console.log(numeros.length); // Imprime: 4
```
#### Add, delite and extract elements:
- `push()`: method that adds one or more elements to the end of an array and returns the new length of the array.
```javascript
const numeros = [10, 5, 3, 2];
numeros.push(7);
console.log(numeros); // Imprime: [10, 5, 3, 2, 7]
```
  - `pop()`: method that removes the last element from an array and returns that element.
```javascript
const numeros = [10, 5, 3, 2];
const ultimo = numeros.pop();
console.log(ultimo); // Imprime: 2
```
  - `shift()`: method that removes the first element from an array and returns that element.
```javascript
const numeros = [10, 5, 3, 2];
const primero = numeros.shift();
console.log(primero); // Imprime: 10
```
  - `unshift()`: method that adds one or more elements to the beginning of an array and returns the new length of the array.
```javascript
const numeros = [10, 5, 3, 2];
numeros.unshift(7);
console.log(numeros); // Imprime: [7, 10, 5, 3, 2]
```
  - `splice()`: method that changes the contents of an array by removing or replacing existing elements and/or adding new elements in place.
    - The first parameter is the index where the change will start.
    - The second parameter is the number of elements to remove.
    - The third and following parameters are the elements to add.
```javascript
const numeros = [10, 5, 3, 2];
numeros.splice(1, 2, 7, 8);
console.log(numeros); // Imprime: [10, 7, 8, 2]
```
- `slice()`: method that returns a shallow copy of a portion of an array into a new array object selected from begin to end (end not included).
```javascript
const numeros = [10, 5, 3, 2];
const subArray = numeros.slice(1, 3);
console.log(subArray); // Imprime: [5, 3]
```
- `concat()`: method that returns a new array comprised of this array joined with other array(s) and/or value(s).
```javascript
const numeros = [10, 5, 3, 2];
const numeros2 = [7, 8];
const resultado = numeros.concat(numeros2);
console.log(resultado); // Imprime: [10, 5, 3, 2, 7, 8]
```
#### Iterate each element
  - `forEach()`: method that executes a provided function once for each array element.
```javascript
const numeros = [10, 5, 3, 2];
numeros.forEach(function(elemento, indice) {
    console.log(`En la posición ${indice} hay el valor ${elemento}`);
});
```
#### Search elements
  - `indexOf()`: method that returns the first index at which a given element can be found in the array, or -1 if it is not present.
```javascript
const numeros = [10, 5, 3, 2];
const posicion = numeros.indexOf(5);
console.log(posicion); // Imprime: 1
```
  - `lastIndexOf()`: method that returns the last index at which a given element can be found in the array, or -1 if it is not present.
```javascript
const numeros = [10, 5, 3, 2, 5];
const posicion = numeros.lastIndexOf(5);
console.log(posicion); // Imprime: 4
```
  - `includes()`: method that determines whether an array includes a certain value among its entries, returning true or false as appropriate.
```javascript
const numeros = [10, 5, 3, 2];
const incluido = numeros.includes(5);
console.log(incluido); // Imprime: true
```
- `find()`: method that returns the value of the first element in the provided array that satisfies the provided testing function.
  - If the value does not exist, `undefined` is returned.
```javascript
const numeros = [10, 5, 3, 2];
const encontrado = numeros.find(function(elemento) {
    return elemento > 3;
});
console.log(encontrado); // Imprime: 10
```
- `findIndex()`: method that returns the index of the first element in the array that satisfies the provided testing function. Otherwise, it returns -1.
```javascript
const numeros = [10, 5, 3, 2];
const indice = numeros.findIndex(function(elemento) {
    return elemento > 3;
});
console.log(indice); // Imprime: 0
```
- `findLast()`: method that returns the value of the last element in the provided array that satisfies the provided testing function.
  - If the value does not exist, `undefined` is returned.
```javascript
const numeros = [10, 5, 3, 2];
const encontrado = numeros.findLast(function(elemento) {
    return elemento > 3;
});
console.log(encontrado); // Imprime: 5
```
- `filter()`: method that creates a new array with all elements that pass the test implemented by the provided function.
```javascript
const numeros = [10, 5, 3, 2];
const filtrados = numeros.filter(function(elemento) {
    return elemento > 3;
});
console.log(filtrados); // Imprime: [10, 5]
```

#### Transform an array

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
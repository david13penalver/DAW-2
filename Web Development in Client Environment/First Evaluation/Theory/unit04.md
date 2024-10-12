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
      - [String - Array](#string---array)
    - [Callbacks](#callbacks)
    - [Array Type](#array-type)
  - [Sets](#sets)
    - [Methods of a set](#methods-of-a-set)
  - [Maps](#maps)
    - [Methods](#methods)
- [Objects](#objects)
  - [Object Creation](#object-creation)
  - [Access to the properties](#access-to-the-properties)
    - [Loop "for...in"](#loop-forin)
    - [Object.keys(object)](#objectkeysobject)
  - [Methods](#methods-1)
    - [`this` keyword](#this-keyword)
  - [JSON](#json)
    - [Characteristics](#characteristics)
    - [Sintaxis](#sintaxis)
    - [Methods](#methods-2)
- [Classes](#classes)
  - [Basic concepts](#basic-concepts)
  - [Getters and Setters](#getters-and-setters)

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
[Up](#table-of-contents)

- `map()`: transforms the content of an array.
```javascript
const numeros = [10, 5, 3, 2];
const duplicados = numeros.map(function(elemento) {
    return elemento * 2;
});
console.log(duplicados); // Imprime: [20, 10, 6, 4]
```
- `revert()`: reverts the order of the elements in an array. 
```javascript
const numeros = [10, 5, 3, 2];
const revertido = numeros.reverse();
console.log(revertido); // Imprime: [2, 3, 5, 10]
``` 

#### String - Array

- `split()`: method that divides a string into an array of substrings.
```javascript
const texto = "Hola, soy un texto";
const palabras = texto.split(" ");
console.log(palabras); // Imprime: ["Hola,", "soy", "un", "texto"]
```
- `join()`: method that joins all elements of an array into a string.
```javascript
const palabras = ["Hola,", "soy", "un", "texto"];
const texto = palabras.join(" ");
console.log(texto); // Imprime: "Hola, soy un texto"
```

### Callbacks
[Up](#table-of-contents)

Simplifies the operations with arrays.

They allow us use functional programming.

Example showing the elements of an array:
- Traditional way:
```javascript
let lista=[1,2,3,4,5]
for(let i=0;i<lista.length;i++){
console.log(lista[i])
}
```
- Using a callback:
```javascript
lista.forEach(function(e){console.log(e)})
```

The most habitual is to use fat arrows:
```javascript
lista.forEach(e=>console.log(e))
```

### Array Type
[Up](#table-of-contents)

There is a specific method to check if a variable is an array:
```javascript
alert(Array.isArray({})); // false
alert(Array.isArray([])); // true
```
- `Array.from(object)`: method that creates a new, shallow-copied array instance from an array-like or iterable object.
```javascript
const array = Array.from("Hola");
console.log(array); // Imprime: ["H", "o", "l", "a"]
const array2 = Array.from({ length: 5 }, (v, i) => i);
console.log(array2); // Imprime: [0, 1, 2, 3, 4]
```

`NodeList` is an array-like object that is returned by methods like `document.querySelectorAll()`, `childNodes`.

It is possible operate it with `forEach()`.

```html
<div id="contenedor">
<p>Parrafo</p>
<button>Boton</button>
<h1>Encabezado</h1>
</div>
<script>
// NodeList
nodosHijos=document.getElementById("contenedor").childNodes
console.log(nodosHijos)
nodosHijos.forEach(n=>console.log(n))
// It will display:
// #text
//    <p>Parrafo</p>
// #text
//    <button>Boton</button>
// #text
//    <h1>Encabezado</h1>
// #text
</script>
```

`HTMLCollection` is another array-like object that is returned by methods like `document.getElementBy...`.

We can use for or convert it into an array: `Array.from(HTMLCollecionElement).forEach(method)`.

## Sets
[Up](#table-of-contents)

It is a collection of unique elements.

They keep the order of the elements as they were inserted.

Creation of a Set:
```javascript
// Solo se agregan "uva" y "pera" una vez
const frutas = new Set(["uva", "pera", "uva", "pera"]);
console.log(frutas); // Imprime: Set { "uva", "pera" }
``` 

### Methods of a set
[Up](#table-of-contents)

- `add()`: method that adds a new element to the end of a Set object.
```javascript
const frutas = new Set(["uva", "pera"]);
frutas.add("manzana");
console.log(frutas); // Imprime: Set { "uva", "pera", "manzana" }
```
- `delete()`: method that removes the specified element from a Set object.
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
frutas.delete("pera");
console.log(frutas); // Imprime: Set { "uva", "manzana" }
```
- `has()`: method that returns a boolean indicating whether an element with the specified value exists in a Set object or not.
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
const existe = frutas.has("pera");
console.log(existe); // Imprime: true
```
- `size`: property that returns the number of elements in a Set object.
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
console.log(frutas.size); // Imprime: 3
```
- `clear()`: method that removes all elements from a Set object.
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
frutas.clear();
console.log(frutas); // Imprime: Set {}
```
- `values()`: method that returns a new Iterator object that contains the values for each element in a Set object in insertion order.
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
const iterador = frutas.values();
console.log(iterador.next().value); // Imprime: uva
console.log(iterador.next().value); // Imprime: pera
console.log(iterador.next().value); // Imprime: manzana
```
- `forEach(callback)`: method that executes a provided function once for each value in the Set object, in insertion order.
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
frutas.forEach(function(valor) {
    console.log(valor);
});

// Imprime: uva pera manzana
```

## Maps
[Up](#table-of-contents)

It is a collection of key-value pairs.

Keys are unique. If we add a key that already exists, the value is replaced.

Keys can be any type of data.

Values can be any type of data.

Creation of a Map:
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.set(3, {nombre: "Carlos", ciudad: "Valencia", edad: 40});
```

### Methods
[Up](#table-of-contents)

- `has()`: method that returns a boolean indicating whether an element with the specified key exists in a Map object or not.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const existe = clientes.has(2);
console.log(existe); // Imprime: true
```
- `get()`: method that returns the value associated to the key, or undefined if there is none.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const cliente = clientes.get(2);
console.log(cliente); // Imprime: {nombre: "Ana", ciudad:" Barna", edad:25}
```
- `set()`: method that adds or updates an element with a specified key and a value to a Map object.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.set(3, {nombre: "Carlos", ciudad: "Valencia", edad: 40});
```
- `delete()`: method that removes the specified element from a Map object.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.delete(2);
```
- `keys()`: method that returns a new Iterator object that contains the keys for each element in a Map object in insertion order.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const iterador = clientes.keys();
console.log(iterador.next().value); // Imprime: 1
console.log(iterador.next().value); // Imprime: 2
```
- `values()`: method that returns a new Iterator object that contains the values for each element in a Map object in insertion order.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const iterador = clientes.values();
console.log(iterador.next().value); // Imprime: {nombre: "Juan", ciudad: "Madrid", edad: 30}
console.log(iterador.next().value); // Imprime: {nombre: "Ana", ciudad:" Barna", edad:25}
```
- `entries()`: method that returns a new Iterator object that contains an array of [key, value] for each element in a Map object in insertion order.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const iterador = clientes.entries();
console.log(iterador.next().value); // Imprime: [1, {nombre: "Juan", ciudad: "Madrid", edad: 30}]
console.log(iterador.next().value); // Imprime: [2, {nombre: "Ana", ciudad:" Barna", edad:25}]
```
- `forEach(callback)`: method that executes a provided function once for each key-value pair in the Map object, in insertion order.
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.forEach(function(valor, clave) {
    console.log(`Cliente ${clave}: ${valor.nombre}`);
});
``` 

# Objects
[Up](#table-of-contents)

Fundamental data structures that allow us to store, organize and access information in a flexible and efficient way.

They are used in virtually all areas of modern web development.

An object in JavaScript is a collection of key-value pairs. 

Each pair consists of a key (which identifies the value) and a value (which can be of any data type in JavaScript).

The objects themselves are associative arrays, i.e. they are arrays in which the information is not stored in positions accessible by numeric indexes, but is stored in positions accessible by names.  

## Object Creation
[Up](#table-of-contents)

- Literal notation: most common way to create an object.
```javascript
const persona = {
nombre: "Juan",
apellido: "Pérez",
edad: 30,
ciudad: "Valencia"
};
```
- Constructor notation: less common way to create an object.
```javascript
const persona = new Object();
persona.nombre = "Juan";
persona.apellido = "Pérez";
persona.edad = 30;
persona.ciudad = "Valencia";
```

## Access to the properties
[Up](#table-of-contents)

- Point notation: most common way to access the properties of an object.
```javascript
const nombrePersona = persona.nombre;
```
- Bracket notation: less common way to access the properties of an object.
  - Useful when the name of the property is dynamic or not known in advance
```javascript
const propiedad = "edad";
const edadPersona = persona[propiedad];
```

Reading a non-existing property only returns undefined. 

We can easily test if the property exists.

There is a special operator to check if a property exists in an object: `in`.
- We can differenciate if a property has the value `undefined` or if it does not exist.
```javascript
alert("nombre" in persona)
alert("cp" in persona)
```

### Loop "for...in"
[Up](#table-of-contents)

- It is used to iterate over the properties of an object.
- It is not recommended to use it with:
  - Arrays.
  - Objects that are not created by us.
  - Objects that have been modified.

```javascript
for (key in persona){
console.log(`${key}: ${persona[key]}`)
}
```

### Object.keys(object)
[Up](#table-of-contents)

It allows us to obtain an array with the keys of an object.

```javascript
let propiedades=Object.keys(persona)
console.log(propiedades)
```

In the objects, if you change the order of a property, it will return that the two objects are different.

When we want to work with object comparison, what we really want for two objects to be equal is that they have the same properties and the same values for each property.

## Methods
[Up](#table-of-contents)

The methods are defined using the function keyword and are called using the same syntax as the properties.

```javascript
const persona = {
nombre: "Juan",
apellido: "Pérez",
edad: 30,
ciudad: "Madrid",
// Método "obtenerNombreCompleto"
obtenerNombreCompleto: function() {
return this.nombre + " " + this.apellido;
}
};
const nombreCompleto = persona.obtenerNombreCompleto();
console.log(nombreCompleto); // Imprime: Juan Pérez
```

### `this` keyword

It can be used in any function.

It behaves differently from most other programming languages.

The value of this is evaluated during runtime, depending on the context. 

*For example, in JavaScript we can use a function to manage the click event of a series of buttons of our web, that is to say, we are not going to create a function for each button, but all will have the same function.*

*`this` inside that function will allow to know which is the button that has called it and according to that to carry out the necessary actions.*

## JSON
[Up](#table-of-contents)

Lightsweight data interchange format.

Used specially in APIs.

### Characteristics
[Up](#table-of-contents)

- Lightweight: easy to read and write.
- Independent of the programming language.
- Flexible structure.
- Easy use and generation.

### Sintaxis
[Up](#table-of-contents)

- Data is in name/value pairs.
- Non ordered list of values.
- {}: object.
- []: array.
- "": for the name of properties and strings.
- :: separates the name of the value.
- ,: separates the pairs.

Example:
```json
{
"nombre": "Juan",
"apellido": "Pérez",
"edad": 30,
"ciudad": "Madrid",
"casado": false,
"hijos": ["Ana", "Carlos"],
"coche": null,
"mascotas": {
  "tipo": "perro",
  "nombre": "Rex"
}
}
```

Ejemplo de array de objetos:
```json
let estudiantes = [
{
"nombre": "Juan",
"apellido": "Pérez",
"edad": 30
},
{
"nombre": "Ana",
"apellido": "Gómez",
"edad": 25
}
]
```

### Methods
[Up](#table-of-contents)

- `JSON.stringify(object)`: method that converts a JavaScript object or value to a JSON string.
```javascript
const persona = {
nombre: "Juan",
apellido: "Pérez",
edad: 30,
ciudad: "Madrid"
};
const json = JSON.stringify(persona);
console.log(json); // Imprime: {"nombre":"Juan","apellido":"Pérez","edad":30,"ciudad":"Madrid"}
```
  - Deleted properties:
    - Functions.
    - Undefined properties.
    - Symbol properties.
- `JSON.parse(string)`: method that parses a JSON string, constructing the JavaScript value or object described by the string.
```javascript
const json = '{"nombre":"Juan","apellido":"Pérez","edad":30,"ciudad":"Madrid"}';
const persona = JSON.parse(json);
console.log(persona); // Imprime: {nombre: "Juan", apellido: "Pérez", edad: 30, ciudad: "Madrid"}
```

# Classes
[Up](#table-of-contents)

Introduced in ECMAScript 6 (ES6).

## Basic concepts
[Up](#table-of-contents)
- Classes: templates that define the structure and behavior of objects.
- Objects: instances of classes.
- Properties: characteristics of the objects.
- Methods: functions that define the behavior of the objects.
- Heritance: mechanism that allows a class to inherit the properties and methods of another class.
- Encapsulation: mechanism that allows to restrict access to certain properties and methods of a class.
- Polymorphism: mechanism that allows to define methods with the same name but with different implementations.

Creation of a class:
```javascript
class Persona {
constructor(nombre, apellido, edad) {
this.nombre = nombre;
this.apellido = apellido;
this.edad = edad;
}
saludar() {
console.log(`Hola, soy ${this.nombre} ${this.apellido}`);
}
}
```

## Getters and Setters
[Up](#table-of-contents)

- Getters: methods that get the value of a property.
- Setters: methods that set the value of a property.
- Private properties: properties that are not accessible from outside the class.

```javascript
class Persona {
#nombre; // Propiedad privada
#ciudad; // Propiedad privada

constructor(nombre, ciudad) {
  this._nombre = nombre;
  this._ciudad=ciudad
}

get nombre(){
  return this._nombre
}

set nombre(nombre){
  this._nombre=nombre
}

unaPersona=new Persona('Juan','Valencia')
console.log(unaPersona.nombre) // Juan por el getter
unaPersona.nombre='Pepe' // Cambia nombre por el setter
console.log(unaPersona.nombre)

console.log(unaPersona.ciudad) // devuelve undefined por ser privada y no tener getter
unaPersona.ciudad='Alicante' // deberia generar error por no tener setter
console.log(unaPersona.ciudad) // devuelve undefined por ser privada y no tener getter
```
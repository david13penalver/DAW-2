# Table of Contents
- [Table of Contents](#table-of-contents)
- [Adding Scripts to a Web Page](#adding-scripts-to-a-web-page)
- [External Scripts](#external-scripts)
  - [Modules](#modules)
  - [Module usage](#module-usage)
  - [Module area](#module-area)
- [Project Structure](#project-structure)
  - [npm](#npm)
  - [Personalized scripts](#personalized-scripts)
- [Code Structure](#code-structure)
  - [Declarations](#declarations)
  - [Semi colons](#semi-colons)
  - [Comments](#comments)
  - [Strict](#strict)
- [Variables](#variables)
- [Data types](#data-types)
- [Casting](#casting)
- [Operators](#operators)
- [Conditionals](#conditionals)
  - [if-else statement](#if-else-statement)
  - [Ternary operator](#ternary-operator)
  - [Switch statement](#switch-statement)
- [Loops](#loops)
  - [for loop](#for-loop)
  - [while loop](#while-loop)
  - [do-while loop](#do-while-loop)
  - [for-in loop](#for-in-loop)
  - [for-of loop](#for-of-loop)

# Adding Scripts to a Web Page
[(Up)](#table-of-contents)

JavaScript code can be added to a web page with the `script`tag. 

The `src` attribute is used to specify the URL of the external script file. 

The `type` attribute is used to specify the type of the script.

```html
<!DOCTYPE HTML>
<html>
    <body>
        <p>Antes del script...</p>
        <script>
            alert( 'Hello, world!' );
        </script>
        <p>...Después del script.</p>
    </body>
</html>
```

# External Scripts
[(Up)](#table-of-contents)

HTML file:
```html
<!DOCTYPE HTML>
<html>
    <head>
        <script src="script.js"></script>
    </head>
    <body>
        <p>Antes del script...</p>
        <p>...Después del script.</p>
    </body>
</html>
```
JS file:
```javascript
alert( 'Hello, world!' );
```

We can also put an external URL.

As a general rule, only the simplest scripts are put directly into HTML. More complex ones are put into separate files.

The main benefit of a separated file is that the browser will download it and store it in its cache. If the same script is used in other pages, it won't be downloaded again.

It reduces traffic and makes pages faster.

## Modules
[(Up)](#table-of-contents)

Introduced in ES6, modules are a way to organize code. They are separate files that can be imported into other files.

The alloy to split the code into separate files, making it easier to manage.

Benefits:
- Modularity: the code is split into separate files.
- Reusability: modules can be reused in other parts of the code.
- Encapsulation: variables and functions are not visible outside the module.
- Asynchronous loading: modules are loaded asynchronously, only when needed.

## Module usage
[(Up)](#table-of-contents)

We use `import` in the main file to import a module.

We use `export` to export a module to the main file.

External file 1 (`datos.js`):
```javascript
export const articulos=[
    {id:1, nombre:"articulo1"},
    {id:2, nombre:"articulo2"},
    {id:3, nombre:"articulo3"}
]
```

External file 2 (`utilidades.js`):
```javascript
const mensaje="Bienvenido a mi Web"
export function verMensaje() {
alert(mensaje);
}
```

Main file (`main.js`):
```javascript
import {articulos} from "./datos.js"
import {verMensaje} from "./utilidades.js"

window.onload=function(){
    verMensaje()
    alert("Total articulos: " + articulos.length)
}
```

In the main file, we import the modules `datos.js` and `utilidades.js`. We use the `verMensaje` function from `utilidades.js` and the `articulos` array from `datos.js`.

In the HTML file, we only include the main file:
```html
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <script src="./js/main.js" type="module"></script>
    </head>
    <body>
        <h3>Demo de modulos</h3>
    </body>
</html>
```

Additionally, we have to use a web server to run the code. We can use the `live-server` from VSCode. 

## Module area
[(Up)](#table-of-contents)

We could have added a button to the web page to tell it in the event `onclick` event to execute the function `verMensaje`.

If we load the index.html page we will get an error when clicking on the button.

The problem is that importing a module has created a scope for its use that the HTML cannot reach, that the HTML cannot reach. The onclick event mapping in the button's of the button does not find the function `verMensaje`.

Two solutions:
- To make the `verMensaje` function visible to the HTML by incorporating it into the Window object. 
  - That's not desirable because we lose the advantages of encapsulation.
- To use the imports only on the code and avoid referencing the functions in the HTML.
```html
<button id="btn">Bienvenida DOM</button>
````

```javascript
document.getElementById("btn").addEventListener("click", verMensaje)
```

# Project Structure
[(Up)](#table-of-contents)

- assets
  - img
  - videos
  - etc.
- css
- js
- node_modules
- index.html

## npm
[(Up)](#table-of-contents)

Node Package Manager is a package manager for JavaScript. It is used to install and manage packages.

Characteristics:
- It is a command-line tool.
- Great dependencies repository.
- Easy installation and use.
- Automatic dependency management.
- Management of dependencies in the `package.json` file.
- Personalized scripts.

We need to install Node.js to use npm.

Example with Bootstrap:
```bash
npm install bootstrap
```

We can also install a specific version:
```bash
npm install bootstrap@4.5.0
```

```html
<link rel="stylesheet" href="./node_modules/bootstrap/dist/css/bootstrap.min.css">

------------------------------

<button class="btn btn-primary" id="btn">Bienvenida DOM</button>
```

## Personalized scripts
[(Up)](#table-of-contents)

If we want to execute our project outside of the IDE, we need to install 'live-server' globally:
```bash
npm install -g live-server
```

Personalized script:
```json
"scripts": {
    "serve": "live-server"
}
```

To run the script:
```bash
npm run serve
```

# Code Structure

## Declarations
[(Up)](#table-of-contents)

Declarations are syntax constructs and commands that perform actions. 

We can have as many statements in our code as we want. 

Statements can be separated with a semicolon. 

Declarations are usually written on separate lines to make the code more readable.

## Semi colons
[(Up)](#table-of-contents)

Semi colons are used to separate statements.

They are optional in JavaScript, but it is recommended to use them.

Example when it is necessary:
```javascript
alert("There will be an error")
[1, 2].forEach(alert)
```

The motor reads the array as a part of the previous statement.

Proper way:
```javascript
alert("There will be an error");
[1, 2].forEach(alert)
```

## Comments
[(Up)](#table-of-contents)

Comments are used to explain the code and make it more readable.

There are two types of comments:
- Single line comments: `//`
- Multi-line comments: `/* */`

```javascript
// Single line comment

/*
Multi-line 
comment
*/
```

## Strict
[(Up)](#table-of-contents)

The `"use strict"` directive is used to enable strict mode.

Strict mode is a way to make JavaScript more secure.

It catches common coding errors and makes it easier to write secure code.

It is recommended to use strict mode.

```javascript
"use strict";
```

The declaration is placed at the beginning of the script.

# Variables
[(Up)](#table-of-contents)

Variables are used to store data.

The declaration is not mandatory (except in strict mode).

Variables allow us to store data and manipulate it.

Types:
- `var`: variable that can be changed.
  - Old way to declare variables.
  - Global scope.
  - It is not recommended to use it.
- `let`: variable that can be changed.
  - Block scope.
- `const`: constant variable that cannot be changed.
  - Block scope.

# Data types
[(Up)](#table-of-contents)

JavaScript has several data types:
- Number: integer, float, etc.
- String: text.
- Boolean: true or false.
- Null: null value.
- Undefined: undefined value.
- Symbol: unique value.

Complex data types:
- Object: collection of data with properties and methods.
- Array: list of values.

Typeof operator is used to get the type of a variable.

It can return the following values:
- `number`
- `string`
- `boolean`
- `object`
- `function`
- `undefined`
- `symbol`

It is used mainly for verification purposes.

```javascript
let numero = "10";

if (typeof numero === "number") {
console.log("El valor es un número");
// Se puede realizar una operación matemática con numero
} else {
console.log("El valor no es un número");
// Se debe convertir el valor a un número
}
```

Typeof does not distinguish between different types of objects. For this, we use the `instanceof` operator.

# Casting
[(Up)](#table-of-contents)

Casting is the process of converting a variable from one type to another.

- Implicit casting: automatic conversion.
  - `let numero = 10;`
  - `let texto = "El número es " + numero;`
  - The number is converted to a string.
- Explicit casting: manual conversion.
  - String to number:
```javascript
let texto = "10";
let numero = Number(texto); // numero se convierte en 10 (número)
```
  - Also with `parseInt` and `parseFloat`.
- Number to string:
```javascript
let numero = 20;
let texto = String(numero); // texto se convierte en "20" (cadena)
```
- Boolean
  - `Boolean()`: converts a value to a boolean.
  - "Truthy" values:
    - Any number except 0.
    - Any string except an empty string.
    - Any object.
    - True.
  - "Falsy" values:
    - 0.
    - Empty string.
    - null.
    - undefined.
    - NaN.
    - False.

# Operators
[(Up)](#table-of-contents)

Arithmetic operators:
- `+`: addition.
- `-`: subtraction.
- `*`: multiplication.
- `/`: division.
- `%`: modulus.
- `++`: increment.
- `--`: decrement.

Relational operators:
- `==`: equal to.
- `===`: equal value and equal type.
- `!=`: not equal.
- `!==`: not equal value or not equal type.
- `>`: greater than.
- `<`: less than.
- `>=`: greater than or equal to.
- `<=`: less than or equal to.

Logical operators:
- `&&`: and.
- `||`: or.
- `!`: not.

Assignment operators:
- `=`: assigns a value.
- `+=`: adds a value.
- `-=`: subtracts a value.
- `*=`: multiplies a value.
- `/=`: divides a value.
- `%=`: assigns a modulus value.

Ternary operator:
- `condition ? value1 : value2`
  - If the condition is true, value1 is returned.
  - If the condition is false, value2 is returned.
```javascript
let edad = 18;
let mensaje = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";
```

# Conditionals
[(Up)](#table-of-contents)

Flow structures that allows executing different code sections according to a `boolean`.

They are essential ir order to take actions and control the behaviour of the app.

## if-else statement

Most basic conditional structure. It evaluates a condition and executes a block of code if the condition is true or an alternative block if the condition is false.

```javascript
let edad = 18;

if (edad >= 18) {
    console.log("Eres mayor de edad");
} else {
    console.log("Eres menor de edad");
}
```

## Ternary operator

It is a simplified version of the if-else statement.

```javascript
let edad = 18;
let mensaje = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";
```

## Switch statement

It is used to select one of many code blocks to be executed.

```javascript
let dia = 3;
let nombreDia;

switch (dia) {
    case 1:
        nombreDia = "Lunes";
        break;
    case 2:
        nombreDia = "Martes";
        break;
    case 3:
        nombreDia = "Miércoles";
        break;
    default:
        nombreDia = "Día no válido";
        break;
}

console.log(nombreDia);
```

# Loops
[(Up)](#table-of-contents)

## for loop

It is used to execute a block of code a number of times.

```javascript
for (let i = 0; i < 5; i++) {
    console.log(i);
}
```

## while loop

It is used to execute a block of code as long as a condition is true.

The condition is evaluated before each iteration.

```javascript
let i = 0;

while (i < 5) {
    console.log(i);
    i++;
}
```

## do-while loop

It is used to execute a block of code as long as a condition is true.

The condition is evaluated after each iteration.

It is guaranteed that the block of code will be executed at least once.

```javascript
let i = 0;

do {
    console.log(i);
    i++;
} while (i < 5);
```

## for-in loop

It is used to iterate over the properties of an object.

```javascript
let persona = {
    nombre: "Juan",
    edad: 30,
    ciudad: "Madrid"
};

for (let propiedad in persona) {
    console.log(propiedad + ": " + persona[propiedad]);
}
```

```javascript
let persona = { nombre: "Juan", edad: 30, profesion: "Desarrollador" };
for (let propiedad in persona) {
console.log(`${propiedad}: ${persona[propiedad]}`);
}
```

The difference between the two examples is the use of the template string. It is a way to concatenate strings in a more readable way.

## for-of loop

It is used to iterate over the values of an iterable object.

Generally used with arrays.

```javascript
let colores = ["rojo", "verde", "azul"];

for (let color of colores) {
    console.log(color);
}
```

```javascript
let numeros = [10, 20, 30];
for (let numero of numeros) {
console.log(numero);
}
```
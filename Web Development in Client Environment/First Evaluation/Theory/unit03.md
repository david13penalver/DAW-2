# Table of Contents
- [Table of Contents](#table-of-contents)
- [Predefined Objects](#predefined-objects)
- [Window](#window)
  - [Important properties](#important-properties)
  - [Important methods](#important-methods)
- [String](#string)
  - [Creation of strings](#creation-of-strings)
  - [Properties](#properties)
  - [Important Methods](#important-methods-1)
- [Date](#date)
  - [Creation of a Date Object](#creation-of-a-date-object)
  - [Methods](#methods)
- [Number \& Math](#number--math)
- [Local Storage](#local-storage)
  - [Cookies](#cookies)
  - [Web Storage API](#web-storage-api)
  - [IndexedDB](#indexeddb)

# Predefined Objects
[Up] (#table-of-contents)

They are objects that are already defined in JavaScript. They are used to perform specific tasks. Some of the predefined objects are:
- Window
  - Represents the browser window.
  - It provides access to the browser's properties and methods.
- Document Object
  - Represents the HTML document.
  - It provides access to the document's properties and methods, like the DOM.
- String
  - Represents a sequence of characters.
  - It provides access to the string's properties and methods (concatenate, split, convert to upper/lower case...).
- Date
  - Used to work with dates and times.
  - It provides access to the date's properties and methods (get the current date, set the date, get the day, month, year...).
- Math
  - It provides constant and mathematical functionts.
- Array
  - Used to store multiple values in a single variable.
  - It provides access to the array's properties and methods (add, remove, sort, search...).
- Object
  - It is the basic object type.
  - The rest of objects inherit from it.
  - It provides access to the object's properties and methods (add, remove, search...).
- Error
  - Used to handle errors.
  - It provides access to the error's properties and methods (get the error message, the error name, line of the error...).
- JSON
  - Used to work with JSON data.
  - A JSON data is a lightweight data-interchange format.
- XMLHttpRequest
  - Used to exchange data with a server.

# Window
[Up] (#table-of-contents)

The window object in JavaScript is a global object that represents the browser window and provides access to its properties and methods. 

It is one of the most important objects in JavaScript and is used to interact with the browser window, obtain information about the current web page, manipulate HTML elements, and control browser behavior.

## Important properties

- `location`: Contains information about the current URL.
```javascript
console.log(window.location.href); // Imprime la URL actual window.location.href = "https://www.example.com"; // Redirige a otra página
```
- `document`: Contains the document object that represents the HTML document.
```javascript
let titulo = document.getElementById("tituloPagina");
titulo.textContent = "Nuevo título de la página";
```
- `history`: Contains the browser's history.
```javascript
window.history.back(); // Navega a la página anterior
window.history.go(2); // Navega dos páginas hacia atrás
```
- `screen`: Contains information about the user's screen (dimentions, color profundity, resolution).
```javascript
let anchoPantalla = window.screen.width;
console.log(`Ancho de la pantalla: ${anchoPantalla} pixeles`);
```
- `navigator`: Contains information about the user's browser.
```javascript
let navegador = window.navigator.userAgent;
console.log(`Navegador: ${navegador}`);
```

## Important methods

- `alert()`
  - Displays an alert box with a message and an OK button.
  - Used to display a message to the user or show simple errors.
```javascript
window.alert("¡Hola, mundo!");
```
- `prompt()`
  - Displays a dialog box that prompts the user for input and the buttons OK and Cancel.
  - Used to get input from the user.
  - If we click OK, we get the value entered by the user. 
  - If we click Cancel, we get `null`.
```javascript
let nombre = window.prompt("Dime un nombre:");
console.log("Nombre:", nombre);
```
- `confirm()`
  - Displays a dialog box with a message and OK and Cancel buttons.
  - Used to confirm an action.
  - If we click OK, we get `true`.
  - If we click Cancel, we get `false`.
```javascript
let confirmar = window.confirm("¿Desea continuar?");
if (confirmar) {
console.log("Usuario confirmó la acción");
} else {
console.log("Usuario canceló la acción");
}
```

# String
[Up] (#table-of-contents)

In JavaScript, data is stored as strings. A string is a sequence of characters enclosed in single or double quotes.

There is not a `char` type in JavaScript, so a single character is also a string.

There are 3 types of putting quotation marks:
- Single and double quotes
  - They represent only text in one line.
```javascript
let texto = "Hola, mundo";
let texto = 'Hola, mundo';
```
- Backticks
  - They represent text in one or multiple lines.
  - They allow to include variables in the string.
```javascript
let nombre = "Juan";
let saludo = `Hola, ${nombre}`;
console.log(saludo); // Imprime "Hola, Juan"
```

## Creation of strings

  - String literals: single or double quotation marks
```javascript
let saludo = "Hola";
```
- String() constructor:
```javascript
let nombre = new String("Juan");
```

## Properties

- `.length`: returns de length of the chain.

## Important Methods

- `charAt(T)`: returns the character at the speified position at the index.
```javascript
let texto = "ABCDEFGHIJKLMN";
// Prints "F" (character at position 5)
console.log(texto.charAt(5));
```
- `charCodeAt(T)`: returns de Unicode code at the specified position at the index.
```javascript
let letra = "ñ";
// Imprime "165" (código Unicode de la letra "ñ")
console.log(letra.charCodeAt(0));
```
- `indexOf(substring, beginning)`: searches the first aparition of a substring inside a chain, returning the beginning position.
```javascript
let frase = "Esta frase contiene la palabra programación";
let indice = frase.indexOf("programación");
if (indice !== -1) {
console.log(`programación esta en la posición: ${indice}`);
} else {
console.log("programación no se encuentra en la frase");
}
```
- `lastIndexOf(substring, beginning)`: searches the last aparition of a substring inside a chain, returning the beginning position.
```javascript
let frase = "Esta frase contiene la palabra programación";
let indice = frase.lastIndexOf("programación");
if (indice !== -1) {
console.log(`programación esta en la posición: ${indice}`);
} else {
console.log("programación no se encuentra en la frase");
}
```
- `replace(old, new)`: replaces the first aparition of a substring with another substring.
```javascript
let texto = "Hola a todos, soy un robot";
let textoReemplazado = texto.replace("robot", "humano");
// Imprime "Hola a todos, soy un humano"
console.log(textoReemplazado);
```
- `toUpperCase()`: converts all the characters of a string to uppercase.
```javascript
let texto = "Hola, mundo";
// Imprime "HOLA, MUNDO"
console.log(texto.toUpperCase());
```
- `toLowerCase()`: converts all the characters of a string to lowercase.
```javascript
let texto = "Hola, mundo";
// Imprime "hola, mundo"
console.log(texto.toLowerCase());
```
- `trim()`: removes the white spaces at the beginning and end of a string.
```javascript
let texto = "   Hola Mundo   ";
console.log(texto.trim()); // Imprime "Hola Mundo"
```
- `startTrim()`: removes the white spaces at the beginning of a string.
```javascript
let texto = "   Hola Mundo   ";
console.log(texto.startTrim()); // Imprime "Hola Mundo   "
```
- `endTrim()`: removes the white spaces at the end of a string.
```javascript
let texto = "   Hola Mundo   ";
console.log(texto.endTrim()); // Imprime "   Hola Mundo"
```
- `concat(string1, string2, ...)`: concatenates two or more strings.
```javascript
let texto1 = "Hola";
let texto2 = "Mundo";
let textoConcatenado = texto1.concat(", ", texto2);
// Imprime "Hola, Mundo"
console.log(textoConcatenado);
```
- `slice(start, end)`: extracts a part of a string and returns it as a new string.
```javascript
let frase = "JavaScript es un lenguaje de programación";
// Extrae la subcadena "es un lenguaje"
let subcadena = frase.slice(10, 25);
console.log(subcadena);
```
- `split(separator, limit)`: divides a string into an array of substrings.
  - `separator`: specifies the character, or the regular expression, to use for dividing the string. By default, it is a comma.
  - `limit`: specifies the number of splits. Without it, the string is divided completely.
```javascript
let frase = "Esta frase se divide por espacios";
let palabras = frase.split(" ");
console.log(palabras); // Imprime un array con las palabras: ["Esta", "frase", "se", "divide", "por", "espacios"]

let lista = "rojo,verde,azul,amarillo";
let colores = lista.split(",");
console.log(colores); 
// Imprime un array con los colores: ["rojo", "verde", "azul", "amarillo"]

let cadenaLarga = "Lorem ipsum dolor sit amet, consectetur
adipiscing elit.
let partes = cadenaLarga.split(" ", 5); // Límite de 5 subcadenas
console.log(partes); // Imprime las primeras 5 palabras de la cadena

let texto = "Hola, mundo!";
let caracteres = texto.split("");
console.log(caracteres); // Imprime un array con cada caracter
```

[Every method](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String)


# Date
[Up] (#table-of-contents)

It represents a date and time in JavaScript. It is used to work with dates and times (past, present or future).

## Creation of a Date Object

- Without arguments: it creates a Date object with the current date and time.
```javascript
let fechaActual = new Date();
```
- With numeric arguments: it creates a Date object with the specified date and time.
```javascript
let fecha = new Date(2024, 5, 12, 10, 30, 15, 500);
```
- With a string argument: it creates a Date object with the specified date and time.
```javascript
let fechaCadena = "2024-06-12T10:30:15.500+02:00";
let fechaObjeto = new Date(fechaCadena);
console.log(fechaObjeto);
```

## Methods

- `getFullYear`: 

# Number & Math
[Up] (#table-of-contents)

*Notes here*

# Local Storage
[Up] (#table-of-contents)

*Notes here*

## Cookies
[Up] (#table-of-contents)

*Notes here*

## Web Storage API
[Up] (#table-of-contents)

*Notes here*

## IndexedDB
[Up] (#table-of-contents)

*Notes here*

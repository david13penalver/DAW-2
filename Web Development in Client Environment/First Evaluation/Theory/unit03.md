# Table of Contents
- [Table of Contents](#table-of-contents)
- [Predefined Objects](#predefined-objects)
- [Window](#window)
  - [Important properties](#important-properties)
  - [Important methods](#important-methods)
- [String](#string)
- [Date](#date)
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

# Date
[Up] (#table-of-contents)

*Notes here*

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

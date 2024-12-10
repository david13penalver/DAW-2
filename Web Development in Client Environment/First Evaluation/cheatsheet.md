# Table of Contents
- [Table of Contents](#table-of-contents)
- [Syntax](#syntax)
  - [If-else](#if-else)
  - [Ternary](#ternary)
  - [Switch](#switch)
  - [For](#for)
  - [While](#while)
  - [Do-while](#do-while)
  - [For-in](#for-in)
  - [For-of](#for-of)
- [Objects](#objects)
  - [String](#string)
    - [charAt](#charat)
    - [charCodeAt](#charcodeat)
    - [indexOf](#indexof)
    - [lastIndexOf](#lastindexof)
    - [replace](#replace)
    - [toUpperCase](#touppercase)
    - [toLowerCase](#tolowercase)
    - [trim (startTrim, endTrim)](#trim-starttrim-endtrim)
    - [concat](#concat)
    - [slice](#slice)
  - [Functions](#functions)
    - [Default message](#default-message)
    - [Rest parameter](#rest-parameter)
  - [Arrays](#arrays)
    - [push](#push)
    - [pop](#pop)
    - [shift](#shift)
    - [unshift](#unshift)
    - [splice](#splice)
    - [slice](#slice-1)
    - [concat](#concat-1)
    - [forEach](#foreach)
    - [indexOf](#indexof-1)
    - [lastIndexOf](#lastindexof-1)
    - [includes](#includes)
    - [find](#find)
    - [findIndex](#findindex)
    - [findLast](#findlast)
    - [filter](#filter)
    - [map](#map)
    - [revert](#revert)
    - [split](#split)
    - [join](#join)
  - [Set](#set)
    - [add](#add)
    - [delete](#delete)
    - [has](#has)
    - [size](#size)
    - [clear](#clear)
    - [values](#values)
    - [forEach](#foreach-1)
  - [Map](#map-1)
    - [has](#has-1)
    - [get](#get)
    - [set](#set-1)
    - [delete](#delete-1)
    - [keys](#keys)
    - [values](#values-1)
    - [entries](#entries)
    - [forEach](#foreach-2)
  - [Objects](#objects-1)
    - [For in](#for-in-1)
    - [Object keys](#object-keys)
    - [Methos in an object](#methos-in-an-object)
- [Class](#class)
- [Forms](#forms)
  - [Access](#access)
  - [submit](#submit)
  - [change](#change)
  - [radiobutton](#radiobutton)
  - [checkbox](#checkbox)
  - [select](#select)
    - [add option](#add-option)
    - [delete option](#delete-option)
- [DOM](#dom)
  - [Create node](#create-node)
  - [Replacing node](#replacing-node)
  - [Assigning events](#assigning-events)
- [Asynchronous Communication](#asynchronous-communication)
  - [Fetch](#fetch)
  - [Enchainment](#enchainment)
  - [Refactor](#refactor)
- [Async / Await](#async--await)

# Syntax
[Up](#table-of-contents)
## If-else

```javascript
let edad = 18;

if (edad >= 18) {
    console.log("Eres mayor de edad");
} else {
    console.log("Eres menor de edad");
}
```
## Ternary
```javascript
let edad = 18;
let mensaje = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";
```
## Switch
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
## For
```javascript
for (let i = 0; i < 5; i++) {
    console.log(i);
}
```
## While
```javascript
let i = 0;

while (i < 5) {
    console.log(i);
    i++;
}
```
## Do-while
```javascript
let i = 0;

do {
    console.log(i);
    i++;
} while (i < 5);
```
## For-in
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
## For-of
```javascript
let colores = ["rojo", "verde", "azul"];

for (let color of colores) {
    console.log(color);
}
```
# Objects
## String
[Up](#table-of-contents)
### charAt
```javascript
let texto = "ABCDEFGHIJKLMN";
// Prints "F" (character at position 5)
console.log(texto.charAt(5));
```
### charCodeAt
```javascript
let letra = "ñ";
// Imprime "165" (código Unicode de la letra "ñ")
console.log(letra.charCodeAt(0));
```
### indexOf
```javascript
let frase = "Esta frase contiene la palabra programación";
let indice = frase.indexOf("programación");
if (indice !== -1) {
console.log(`programación esta en la posición: ${indice}`);
} else {
console.log("programación no se encuentra en la frase");
}
```
### lastIndexOf
```javascript
let frase = "Esta frase contiene la palabra programación";
let indice = frase.lastIndexOf("programación");
if (indice !== -1) {
console.log(`programación esta en la posición: ${indice}`);
} else {
console.log("programación no se encuentra en la frase");
}
```
### replace
```javascript
let texto = "Hola a todos, soy un robot";
let textoReemplazado = texto.replace("robot", "humano");
// Imprime "Hola a todos, soy un humano"
console.log(textoReemplazado);
```
### toUpperCase
```javascript
let texto = "Hola, mundo";
// Imprime "HOLA, MUNDO"
console.log(texto.toUpperCase());
```
### toLowerCase
```javascript
let texto = "Hola, mundo";
// Imprime "hola, mundo"
console.log(texto.toLowerCase());
```
### trim (startTrim, endTrim)
```javascript
let texto = "   Hola Mundo   ";
console.log(texto.trim()); // Imprime "Hola Mundo"
```
### concat 
```javascriptlet texto1 = "Hola";
let texto2 = "Mundo";
let textoConcatenado = texto1.concat(", ", texto2);
// Imprime "Hola, Mundo"
console.log(textoConcatenado);
```
### slice
```javascript
let frase = "Esta frase se divide por espacios";
let palabras = frase.split(" ");
console.log(palabras); // Imprime un array con las palabras: ["Esta", "frase", "se", "divide", "por", "espacios"]

let lista = "rojo,verde,azul,amarillo";
let colores = lista.split(",");
console.log(colores); 
// Imprime un array con los colores: ["rojo", "verde", "azul", "amarillo"]

let cadenaLarga = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
let partes = cadenaLarga.split(" ", 5); // Límite de 5 subcadenas
console.log(partes); // Imprime las primeras 5 palabras de la cadena

let texto = "Hola, mundo!";
let caracteres = texto.split("");
console.log(caracteres); // Imprime un array con cada caracter
```
## Functions
[Up](#table-of-contents)
### Default message
```javascript
function muestraMensaje(msg = "No hay texto...") {
    alert(msg);
}
muestraMensaje(); // Llamamos a la funcion sin parametro
```
### Rest parameter
```javascript
function sumar(...numeros) {
// Cuerpo de la función
}
const numeros = [10, 5, 3, 2];
sumar(...numeros); // Equivalente a sumar(10, 5, 3, 2)
```
## Arrays
[Up](#table-of-contents)
### push
```javascript
const numeros = [10, 5, 3, 2];
numeros.push(7);
console.log(numeros); // Imprime: [10, 5, 3, 2, 7]
```
### pop
```javascript
const numeros = [10, 5, 3, 2];
const ultimo = numeros.pop();
console.log(ultimo); // Imprime: 2
```
### shift
```javascript
const numeros = [10, 5, 3, 2];
const primero = numeros.shift();
console.log(primero); // Imprime: 10
```
### unshift
```javascript
const numeros = [10, 5, 3, 2];
numeros.unshift(7);
console.log(numeros); // Imprime: [7, 10, 5, 3, 2]
```
### splice
```javascript
const numeros = [10, 5, 3, 2];
numeros.splice(1, 2, 7, 8);
console.log(numeros); // Imprime: [10, 7, 8, 2]
```
### slice
```javascript
const numeros = [10, 5, 3, 2];
const subArray = numeros.slice(1, 3);
console.log(subArray); // Imprime: [5, 3]
```
### concat
```javascript
const numeros = [10, 5, 3, 2];
const numeros2 = [7, 8];
const resultado = numeros.concat(numeros2);
console.log(resultado); // Imprime: [10, 5, 3, 2, 7, 8]
```
### forEach
```javascript
const numeros = [10, 5, 3, 2];
numeros.forEach(function(elemento, indice) {
    console.log(`En la posición ${indice} hay el valor ${elemento}`);
});
```
### indexOf
```javascript
const numeros = [10, 5, 3, 2];
const posicion = numeros.indexOf(5);
console.log(posicion); // Imprime: 1
```
### lastIndexOf
```javascript
const numeros = [10, 5, 3, 2, 5];
const posicion = numeros.lastIndexOf(5);
console.log(posicion); // Imprime: 4
```
### includes
```javascript
const numeros = [10, 5, 3, 2];
const incluido = numeros.includes(5);
console.log(incluido); // Imprime: true
```
### find
```javascript
const numeros = [10, 5, 3, 2];
const encontrado = numeros.find(function(elemento) {
    return elemento > 3;
});
console.log(encontrado); // Imprime: 10
```
### findIndex
```javascript
const numeros = [10, 5, 3, 2];
const indice = numeros.findIndex(function(elemento) {
    return elemento > 3;
});
console.log(indice); // Imprime: 0
```
### findLast
```javascriptçconst numeros = [10, 5, 3, 2];
const encontrado = numeros.findLast(function(elemento) {
    return elemento > 3;
});
console.log(encontrado); // Imprime: 5
```
### filter
```javascript
const numeros = [10, 5, 3, 2];
const filtrados = numeros.filter(function(elemento) {
    return elemento > 3;
});
console.log(filtrados); // Imprime: [10, 5]
```
### map
```javascript
const numeros = [10, 5, 3, 2];
const duplicados = numeros.map(function(elemento) {
    return elemento * 2;
});
console.log(duplicados); // Imprime: [20, 10, 6, 4]
```
### revert
```javascript
const numeros = [10, 5, 3, 2];
const revertido = numeros.reverse();
console.log(revertido); // Imprime: [2, 3, 5, 10]
```
### split
```javascript
const texto = "Hola, soy un texto";
const palabras = texto.split(" ");
console.log(palabras); // Imprime: ["Hola,", "soy", "un", "texto"]
```
### join
```javascript
const palabras = ["Hola,", "soy", "un", "texto"];
const texto = palabras.join(" ");
console.log(texto); // Imprime: "Hola, soy un texto"
```
## Set
[Up](#table-of-contents)
### add
```javascript
const frutas = new Set(["uva", "pera"]);
frutas.add("manzana");
console.log(frutas); // Imprime: Set { "uva", "pera", "manzana" }
```
### delete
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
frutas.delete("pera");
console.log(frutas); // Imprime: Set { "uva", "manzana" }
```
### has
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
const existe = frutas.has("pera");
console.log(existe); // Imprime: true
```
### size
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
console.log(frutas.size); // Imprime: 3
```
### clear
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
frutas.clear();
console.log(frutas); // Imprime: Set {}
```
### values
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
const iterador = frutas.values();
console.log(iterador.next().value); // Imprime: uva
console.log(iterador.next().value); // Imprime: pera
console.log(iterador.next().value); // Imprime: manzana
```
### forEach
```javascript
const frutas = new Set(["uva", "pera", "manzana"]);
frutas.forEach(function(valor) {
    console.log(valor);
});

// Imprime: uva pera manzana
```
## Map
[Up](#table-of-contents)
### has
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const existe = clientes.has(2);
console.log(existe); // Imprime: true
```
### get
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const cliente = clientes.get(2);
console.log(cliente); // Imprime: {nombre: "Ana", ciudad:" Barna", edad:25}
```
### set
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.set(3, {nombre: "Carlos", ciudad: "Valencia", edad: 40});
```
### delete
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.delete(2);
```
### keys
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const iterador = clientes.keys();
console.log(iterador.next().value); // Imprime: 1
console.log(iterador.next().value); // Imprime: 2
```
### values
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const iterador = clientes.values();
console.log(iterador.next().value); // Imprime: {nombre: "Juan", ciudad: "Madrid", edad: 30}
console.log(iterador.next().value); // Imprime: {nombre: "Ana", ciudad:" Barna", edad:25}
```
### entries
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
const iterador = clientes.entries();
console.log(iterador.next().value); // Imprime: [1, {nombre: "Juan", ciudad: "Madrid", edad: 30}]
console.log(iterador.next().value); // Imprime: [2, {nombre: "Ana", ciudad:" Barna", edad:25}]
```
### forEach
```javascript
const clientes = new Map([
[1, {nombre: "Juan", ciudad: "Madrid", edad: 30}],
[2, {nombre: "Ana", ciudad:" Barna", edad:25}]
]);
clientes.forEach(function(valor, clave) {
    console.log(`Cliente ${clave}: ${valor.nombre}`);
});
```
## Objects
[Up](#table-of-contents)
### For in
```javascript
for (key in persona){
console.log(`${key}: ${persona[key]}`)
}
```
### Object keys
```javascript
let propiedades=Object.keys(persona)
console.log(propiedades)
```
### Methos in an object
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
# Class
[Up](#table-of-contents)
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
# Forms
[Up](#table-of-contents)
## Access
```javascript
  const nombreInput = document.getElementById('nombre');
  const emailInput = document.querySelector('input[name="correo"]');
  const formulario = document.forms['registro'];
  const botonEnviar = formulario.elements['enviar'];
```
## submit
```javascript
formulario.addEventListener('submit', function(event) {
  event.preventDefault(); // Evita el envío del formulario por defecto
                          // Validar los datos del formulario
                          // Si son válidos, enviar el formulario
});
```
## change
```javascript
nombreInput.addEventListener('change', function() {
  const nombre = nombreInput.value;
  console.log('El nombre ha cambiado a:', nombre);
});
```
## radiobutton
```javascript
let elementos = document.getElementsByName("estadoCivil");

let seleccionado = Array.from(elementos).find(ec => ec.checked);

alert("El estado civil seleccionado es " + seleccionado.value);
```
## checkbox
```javascript
function verCondicionesPrivacidad(){
  let el = document.getElementById("condiciones");
  texto= " no se ha aceptado"
  if (el.checked){
    let texto=" se ha aceptado"
  }
  alert(el.value + texto);

  el = document.getElementById("privacidad");
  texto= " no se ha aceptado"
  if (el.checked){
  let texto=" se ha aceptado"
  }
  alert(el.value + texto);
}
```
## select
[Up](#table-of-contents)
```javascript
// Acceder a lista
let lista = document.getElementById("lista");

// Obtener el texto que muestra la opción seleccionada
let textoSeleccionado = lista.options[lista.selectedIndex].text;

// Obtener el valor de la opción seleccionada
let valorSeleccionado = lista.options[lista.selectedIndex].value;
```
### add option
```javascript
function anyadirElementoLista(){
  let texto=prompt("Dime Text");
  let valor=prompt("Dime Value");

  mioption=document.createElement("option");
  mioption.value=valor;
  mioption.text=texto;

  lista2.appendChild(mioption);
// Specific way to add an option in a select:
  function addLista(){
  let texto=prompt("Dime Text");
  let valor=prompt("Dime Value");

  mioption=document.createElement("option");
  mioption.value=valor;
  mioption.text=texto;

  lista.add(mioption,2)
}
}
```
### delete option
```javascript
selectObject.remove(index)
```
# DOM
[Up](#table-of-contents)
Finding HTML elements:

    document.getElementById(id): Finds an element by id.
    document.getEelementsByTagName(name): Finds elements by HTML tag.
    document.getElements ByClassName(name): Finds elements by CSS class.
    querySelector(css): Allows finding an element using CSS selectors.
    querySelectorAll(css): Returns a collection of all the elements with that selector.
Adding and deleting elements:

    document.createElement(element): Creates an HTML element.
    document.removeChild(element): Deletes an HTML element.
    document.appendChild(element): Adds an HTML element.
    document.replaceChild(new, old): Replaces an HTML element.
    document.write(text): Writes on the HTML website.

    document.getElementById(id).onclick = function() {code}: Adds an event handler to an HTML element.
        In this case, a function to manage the "click" on an element with that id.

## Create node
```javascript
<div id="texto">
  <p>Parrafo 1</p>
  <p>Parrafo 2</p>
</div>
<div id="fotos"> //inicialmente vacia
</div>

<script>
  let divFotos=document.getElementById("fotos");
  let imagen=document.createElement("img");

  imagen.id="mi_foto"
  imagen.src="./fotos/logo.jpg"

  divFotos.appendChild(imagen)
</script>
```
## Replacing node
```javascript
<div>
  <p id="p1">Este es el parrafo1</p>
  <p id="p2">Este es el parrafo2</p>
</div>

<script>
  let parrafo = document.getElementById("p1");
  parrafo.remove();
</script>
```
## Assigning events
```javascript
<button id="btn1">Pulsame...</button>
<p id="p1"></p>

<script>
  document.getElementById("btn1").onclick = displayDate;

  function displayDate() {
    document.getElementById("p1").innerHTML = Date();
  }
</script>
```
```javascript
// With fat arrow
document.getElementById("btn1").onclick = function() {
  document.getElementById("p1").innerHTML = Date();
};
```
# Asynchronous Communication
## Fetch
[Up](#table-of-contents)
```javascript
let url='http://localhost:3000/articulos/5'

fetch(url,{})
  .then(response => {
    if (!response.ok) {
    throw new Error(`Mi Error ${response.status} ${response.statusText}`);
    }
    return response.json();
  })
  .then(articulo => console.log(articulo))
  .catch(error => alert(error))
```
## Enchainment
```javascript
let url='http://localhost:3000/'

let idProveedor=prompt("Dime el id del proveedor: ")

fetch(url + "proveedores" + "/" + idProveedor)
  .then(response => {
    if (!response.ok) {
      throw new Error(`Error proveedor ${response.status} ${response.statusText}`);
    }
    return response.json();
  })
  .then(p => {console.log(p)
    return fetch(url + "articulos" + "/" + p.idArticulo)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Error articulo ${response.status} ${response.statusText}`);
        }
        return response.json();
      })
    })
  .then(a=>console.log(a))
  .catch(error => alert(error))
```
## Refactor
```javascript
function getArticulo(id){
  return fetch(url+"articulos"+"/"+id)
    .then(response => {
      if (!response.ok) {
        throw new Error(`Error en articulo ${response.status} ${response.statusText}`);
      }
    return response.json()
  });
}
```
```javascript
getProveedor(1)
  .then(proveedor => {
    console.log(proveedor);
    return getArticulo(proveedor.idArticulo);
  })
  .then(articulo => console.log(articulo))
  .catch(error => alert(error));
```
# Async / Await
[Up](#table-of-contents)
```javascript
async function gtArticuloProveedor() {
  let ur = "http://localhost:3000/";
  let idProveedor = prompt("Dime el id del proveedor: ");

  // Petition for the provider
  try {
    let response = await fetch(url + "proveedores" + "/" + idProveedor);
    if (!response.ok) {
      throw new Error(`Error proveedor ${response.status} ${response.statusText}`);
    }
    let proveedor = await response.json();

    // Petition for the article
    response = await fetch(url + "articulos" + "/" + proveedor.idArticulo);
    if (!response.ok) {
      throw new Error(`Error articulo ${response.status} ${response.statusText}`);
    }
    let articuo = await response.json();
    console.log(articulo);
  } catch (error) {
    alert(error);
  }
}
```
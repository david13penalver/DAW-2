# Table of contents
- [Table of contents](#table-of-contents)
- [HTML DOM](#html-dom)
  - [What is DOM?](#what-is-dom)
  - [What is HTML DOM?](#what-is-html-dom)
- [DOM programming interface](#dom-programming-interface)
  - [`getElementById` method](#getelementbyid-method)
  - [`innerHTML` property](#innerhtml-property)
- [DOM HTML document object](#dom-html-document-object)
- [DOM Nodes](#dom-nodes)
  - [Relationship between nodes](#relationship-between-nodes)
  - [Node properties](#node-properties)
    - [Basic properties](#basic-properties)
    - [Properties of the relationship between nodes](#properties-of-the-relationship-between-nodes)
    - [Secundary nodes and values of a node](#secundary-nodes-and-values-of-a-node)
- [Finding and accessing HTML elements](#finding-and-accessing-html-elements)
  - [Accessing elements by ID](#accessing-elements-by-id)
  - [Accessing elements by tag name](#accessing-elements-by-tag-name)
    - [Search of child elements](#search-of-child-elements)
  - [Accessing elements by class name](#accessing-elements-by-class-name)
  - [Accessing elements by CSS selectors](#accessing-elements-by-css-selectors)
  - [Accessing elements by HTML object collections](#accessing-elements-by-html-object-collections)
- [Modifying DOM elements](#modifying-dom-elements)
  - [Modifying the value of an attribute](#modifying-the-value-of-an-attribute)
  - [Modifying the style of an element](#modifying-the-style-of-an-element)
- [Operations on DOM nodes](#operations-on-dom-nodes)
  - [Creating new nodes](#creating-new-nodes)
  - [Deleting nodes](#deleting-nodes)
  - [Replacing nodes](#replacing-nodes)
  - [Cloning nodes](#cloning-nodes)
- [Assigning events using the DOM HTML](#assigning-events-using-the-dom-html)

# HTML DOM
[Up](#table-of-contents)

When a website loads, the browser creates the DOM (Document Object Model).
- Model: Means taht the DOM offers a structured representation of the HTML document.
- Object: Each element of the DOM is an object you can access and manipulate with JavaScript.
- Document: It refers to the HTML page.

The HTML DOM is built like a tree of objects:
![DOM Tree](./Assets/06_DOM_tree.png)

JavaScript can:
- Change all the HTML elements of the website.
- Change all the attributes.
- Change all the CSS styles.
- Create new elements and attributes.
- Delete elements and attributes.
- React to all the events.
- Create new events.

## What is DOM?
[Up](#table-of-contents)

It is a W3C (World Wide Web Consortium) standard.

It is separated in 3 different parts:
- Core DOM: Standard model for all types of documents.
- XML DOM: Standard model for XML documents.
- HTML DOM: Standard model for HTML documents.

## What is HTML DOM?
[Up](#table-of-contents)

It is a standard model of objects and a programming interface for HTML.

Defines:
- HTML elements as objects.
- The properties of all HTML elements
- The methods to access to all HTML elements.
- The events of all HTML elements.

# DOM programming interface
[Up](#table-of-contents)

We can access to the HTML DOM with JS and other programming languages.

## `getElementById` method
[Up](#table-of-contents)

The most common way to access an HTML element.

```html
<html>
  <body>
    <p id="demo"></p>
    <script>
      document.getElementById("demo").innerHTML = "Hello World!";
    </script>
  </body>
</html>
```

## `innerHTML` property
[Up](#table-of-contents)

Easiest way to obtain the content of an element.

This property is useful to obtain or replace the content of HTML elements. Including `<body>` and `<html>`.

It is a shortcut to the strict methods.

# DOM HTML document object
[Up](#table-of-contents)

Finding HTML elements:
- `document.getElementById(id)`: Finds an element by id.
- `document.getEelementsByTagName(name)`: Finds elements by HTML tag.
- `document.getElements ByClassName(name)`: Finds elements by CSS class.
- `querySelector(css)`: Allows finding an element using CSS selectors.
- `querySelectorAll(css)`: Returns a collection of all the elements with that selector.

Changing HTML elements:
- `element.innerHTML = X`: Changes the HTML content of an element.
- `element.attribute = X`: Changes the value of an attribute of an HTML element.
- `element.style.property = X`: Changes the style of an HTML element.
- `element.setAttribute(attribute, value)`: It does the same as the previous one, but it has the value and the attribute as arguments.

Adding and deliting elements:
- `document.createElement(element)`: Creates an HTML element.
- `document.removeChild(element)`: Deletes an HTML element.
- `document.appendChild(element)`: Adds an HTML element.
- `document.replaceChild(new, old)`: Replaces an HTML element.
- `document.write(text)`: Writes on the HTML website.

Adding event handlers:
- `document.getElementById(id).onclick = function() {code}`: Adds an event handler to an HTML element. 
  - In this case, a function to manage the "click" on an element with that id.

# DOM Nodes
[Up](#table-of-contents)

Everything in an HTML document is a node.
- All the document is a document node.
- Each HTML element es an element node.
- The text inside the HTML elements are text nodes.
- Each HTML attribute is an attribute HTML (deprecated).
- Every comment is a comment node.

![Node tree](./Assets/06_node_tree.png)

JS can access to every node of the node tree.

It can create new ones, modify or delete them.

## Relationship between nodes
[Up](#table-of-contents)

- The nodes in a tree have a hierarchical relationship.
- The superior node is the root node.
- Each node has a parent, except the root node.
- A node can have several children.
- Siblings are nodes of a same parent.

![Node relathionship](./Assets/06_node_relationship.png)

## Node properties
[Up](#table-of-contents)

### Basic properties
[Up](#table-of-contents)

- `nodeName`: Specifies the name of the node.
  - Only readable.
  - The node name of a node element is the same as the tag.
  - The node name of an attribute node is the name of the attribute.
  - The node name of a text node is always `#text`.
  - The node name of the doccument is always `#document`.

```html
<h1 id="h1">My First Page</h1>

<script>
  alert(document.getElementById("h1").nodeName);
</script>
```

`nodeName` always contains the name of the tag in upper case.

- `nodeValue`: Specifies the value of a node.
  - Only readable.
  - The node value for elements nodes is `null`.
  - The node value for text nodes is the inner text.
  - The node value for attribute nodes is the value of the attribute.
  - More important:

![Node types](./Assets/06_node_types.png)

### Properties of the relationship between nodes
[Up](#table-of-contents)

- `parentNode`: parent node.
- `childNodes[nodeNumber]`: collection of child nodes.
- `firstChild`: first child of a node.
- `lastChild`: last child of a node.
- `nextSibling`: next sibling of a node.
- `previousSibling`: previous sibling of a node.

### Secundary nodes and values of a node

A common mistake is expecting that  a node element contains text.

```html
<p id="p1">Tutorial DOM </p>
```

The node of the `<p>` element does not contain text. It contains a text node that contains text.

We can access to the value of a node with `innerHTML`:

```javascript
let miP = document.getElementById("demo").innerHTML;
```

Accessing to the first child can be done like this:

```javascript
let miP = document.getElementById("demo").firstChild.nodeValue;
```

Or like this too:

```javascript
let miP = document.getElementById("demo").childNodes[0].nodeValue;
```

For the objects taht contain text, we can also use `textContent`.

# Finding and accessing HTML elements
[Up](#table-of-contents)

## Accessing elements by ID
[Up](#table-of-contents)

```javascript
let myElement = document.getElementById("intro");
```

If it finds the element,the method will return the element as an object. If not, it will return `null`.

## Accessing elements by tag name
[Up](#table-of-contents)

```javascript
<p>Hola mundo!</p>
<p>Como funciona <b>getElementsByTagName</b> en selecciones.</p>
<p id="p1"></p>

<script>
  let parrafos = document.getElementsByTagName("p");

  for(i=0;parrafos.length;i++)
    alert(parrafos[i].innerHTML)
</script>
```

If it finds the element(s), it returns an HTML Collection (we can not use the methods of arrays).

We can convert them with `Array.from(element)`.

### Search of child elements

Every search starts from the root node.

Sometimes we need to search from the father node.

The first step is finding the father node.

```html
<div id="c1">
  <p> Parrafo 1 de la capa c1 </p>
  <p> Parrafo 2 de la capa c1 </p>
</div>
<div id="c2">
  <p> Parrafo 1 de la capa c2 </p>
  <p> Parrafo 2 de la capa c2 </p>
</div>
<div id="c3">
  <p> Parrafo 1 de la capa c3 </p>
  <p> Parrafo 2 de la capa c3 </p>
</div>

<script>
  let divC2 = document.getElementById("c2");
  let parrafosC2=divC2.getElementsByTagName("p")

  arrayDeParrafos=Array.from(parrafosC2);
  arrayDeParrafos.forEach(n=>alert(n.innerHTML));
</script>
```

## Accessing elements by class name
[Up](#table-of-contents)

We use the method `getElementsByClassName("class")`.

Usually we use a fake class to select items rather than to give them a CSS style.

It returns a `Node List`.

```javascript
<div id="c1" class="prueba">
  <p class="prueba"> Parrafo 1 de la capa c1 </p>
  <p> Parrafo 2 de la capa c1 </p>
</div>
  <div id="c2">
  <p> Parrafo 1 de la capa c2 </p>
  <p class="prueba"> Parrafo 2 de la capa c2 </p>
</div>
<div id="c3" class="prueba">
  <p class="prueba"> Parrafo 1 de la capa c3 </p>
  <p> Parrafo 2 de la capa c3 </p>
</div>

<script>
  let clasePrueba=document.getElementsByClassName("prueba")
  
  let arrayClasePrueba=Array.from(clasePrueba);
  arrayClasePrueba.forEach(n=>alert(n));
</script>
```

## Accessing elements by CSS selectors
[Up](#table-of-contents)

We use the method `querySelectorAll("css")`. This method is recent.

We can use this method with pseudoclasses too.

```javascript
<ul>
  <li>elemento 1 lista 1</li>
  <li>elemento 2 lista 1</li>
</ul>
<ul>
  <li>elemento 1 lista 2</li>
  <li>elemento 2 lista 2</li>
</ul>

<script>
  let elements = document.querySelectorAll('ul > li:last-child');

  for (let elem of elements) {
    alert(elem.innerHTML); // elemento 2 lista 1 y elemento 2 lista 2
  }
</script>
```

The method `querySelector("class")` returns the first element that matches the selector.

## Accessing elements by HTML object collections
[Up](#table-of-contents)

We can access all the images of a document with `document.images`.

```javascript
let imagenes = document.images;
```

We can access all the links of a document with `document.links`.

```javascript
let enlaces = document.links;
```

We can access all the forms of a document with `document.forms`.

```javascript
let formularios = document.forms;
```

# Modifying DOM elements
[Up](#table-of-contents)

## Modifying the value of an attribute
[Up](#table-of-contents)

To change the value of an HTML attribute with `element.attribute = value`.

The next example changes the `src` attribute of an image.

```javascript
<img id="miImagen" src="imagen1.gif">

<script>
  document.getElementById("miImagen").src = "imagen2.jpg";
</script>
```

## Modifying the style of an element
[Up](#table-of-contents)

To change the style of an HTML element with `element.style.property = style`.

The next example changes the color of a paragraph.

```javascript
<p id="p1">Hola mundo!</p>

<script>
  document.getElementById("p1").style.color = "blue";
</script>
```

# Operations on DOM nodes
[Up](#table-of-contents)

Sometimes we need creating, deleting, replacing or cloning nodes.

These operations are used to create dynamic content that was not in the original HTML document.

The shortcut is `innerHTML`.

In this case, we are going to create or delete DOM nodes and then we will add or delete them in a container.

## Creating new nodes
[Up](#table-of-contents)

1. Create a new element node with `document.createElement("element")`.
2. Add the new element to an existing element with `element.appendChild(newElement)`.

Example:

We create a node called `imagen` that is an HTML element of the class `<img>`.
Then we add an id and a source to the image.

```javascript
let imagen=document.createElement("img")
imagen.id="mi_foto"
imagen.src="./fotos/logo.jpg"
```

Then, we add the image to the body of the document.

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

With elements that have a text, we can use `document.createTextNode("text")`.

```javascript
let miParafo = document.createElement("p");
let miTexto= document.createTextNode("Texto del parrafo.");

miParrafo.appendChild(miTexto);

let padre = document.getElementById("div1");

padre.appendChild(miParrafo);
```

1. We create the paragraph.
2. We create the text node.
3. We add the text node to the paragraph.
4. We add the paragraph to the container.

We can also access with the property `textContent`.

```javascript
<p id="miParrafo">Este es un párrafo. <b>Texto en negrita.</b></p>
const parrafo = document.getElementById("miParrafo");

// Obtener el texto completo del párrafo:
console.log(parrafo.textContent);

// Cambiar el texto del párrafo:
parrafo.textContent = "Nuevo contenido para el párrafo.";
```

The method `appendChild` adds the new node at the end of the list of children. 

If we want to add it in other position, we can use `insertBefore(node)` or `insertAfter(node)`.

In this example, we create a new paragraph and we add it before the paragraph with id `p1`.

```javascript
<div id="div1">
  <p id="p1">Este es el parrafo1</p>
  <p id="p2">Este es el parrafo2</p>
</div>

<script>
  let miparrafo = document.createElement("p");
  let miTexto = document.createTextNode("Parrafo nuevo");

  miParrafo.appendChild(miTexto);

  let padre = document.getElementById("div1");
  let elementoHijo = document.getElementById("p1");

  padre.insertBefore(miParrafo, elementoHijo);
</script>
```

## Deleting nodes
[Up](#table-of-contents)

We use the method `remove()`.

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

## Replacing nodes
[Up](#table-of-contents)

We use the method `parentNode.replaceChild(new, old)`.

```javascript
<div id="div1">
  <p id="p1">Este es el parrafo1</p>
  <p id="p2">Este es el parrafo2</p>
</div>

<script>
  let miParrafo = document.createElement("p");
  let node = document.createTextNode("Parrafo nuevo");

  miParrafo.appendChild(node);

  let parent = document.getElementById("div1");
  let child = document.getElementById("p1");

  parent.replaceChild(miParrafo, child);
</script>
```

## Cloning nodes
[Up](#table-of-contents)

We use the method `cloneNode(deep)`.

It copies all the properties and methods.

The parameter `deep` is an optional boolean that indicates if the children of the node are copied too.

```javascript
<ul id="lista1">
  <li>Cafe</li>
  <li>Te</li></ul>
<ul id="lista2">
  <li>Agua</li>
  <li>Leche</li>
</ul>

<script>
  let item = document.getElementById("lista2").lastChild;
  let clon = item.cloneNode(true);

  document.getElementById("lista1").appendChild(clon);
</script>
```

The HTML will be the next:

```html
<ul id="lista1">
  <li>Cafe</li>
  <li>Te</li>
  <li>Leche</li>
</ul>
<ul id="lista2">
  <li>Agua</li>
  <li>Leche</li>
</ul>
```

# Assigning events using the DOM HTML
[Up](#table-of-contents)

The HTML DOM allows us assigning events to HTML elements.

Events are handled with functions.

Example adding an `onclick` event to a button:

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

It is **very important** to assign the function to the event without the parentheses. If we use them, the function will be executed when the page is loaded.

With an anonymous function, we must do this:

```javascript
document.getElementById("btn1").onclick = function() {
  document.getElementById("p1").innerHTML = Date();
};
```

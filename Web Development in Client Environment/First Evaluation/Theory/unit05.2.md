# Table of contents

- [Table of contents](#table-of-contents)
- [Forms](#forms)
  - [Basic Structure of an HTTP Form](#basic-structure-of-an-http-form)
- [Interaction With Forms Using JavaScript](#interaction-with-forms-using-javascript)
  - [Access To The Form Elements](#access-to-the-form-elements)
  - [Managing The Form Events](#managing-the-form-events)
  - [Validation of Form Data](#validation-of-form-data)
    - [Regular Expressions (RegExp)](#regular-expressions-regexp)
- [Form Controls](#form-controls)
  - [Text and Textarea](#text-and-textarea)
  - [Radio Buttons](#radio-buttons)
  - [Checkboxes](#checkboxes)
  - [Select](#select)
    - [Access To Every Element of a Select](#access-to-every-element-of-a-select)
    - [Adding and Removing Options of a Select](#adding-and-removing-options-of-a-select)

# Forms
[Up](#table-of-contents)

Fundamental HTML elements in the creation of interactive websites.

They allow the user to enter data that can be sent to the server for processing.

JavaScript proposes tools to improve the user experience when interacting with forms.

Main uses of forms:
- Login forms.
- Registration forms.
- Contact forms.
- Search forms.
- Shopping online.
- Comments.

## Basic Structure of an HTTP Form
[Up](#table-of-contents)

It is defined by the `<form>` tag.

Basic structure:

```html
<form name="registro">
  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre">

  <label for="correo">Correo electrónico:</label>
  <input type="email" id="correo" name="correo">

  <button type="submit">Enviar</button>
</form>
```

Elements:
- Input fields (`<input>`): They allow the user to enter data.
- Labels (`<label>`): They provide a description of the input fields.
- Text areas (`<textarea>`): They allow the user to enter multiple lines of text.
- Verification boxes (`<input type="checkbox">`): They allow the user to select multiple options.
- Radio buttons (`<input type="radio">`): They allow the user to select only one option.
- Drop-down menu (`<select>`): They allow the user to select an option from a list.
- Buttons (`<button>`): They allow the user to send the form.

The elements of the form can have the following attributes:
- `name`: Name of the element.
- `id`: Identifier of the element.
- `type`: Type of the element.
- `value`: Value of the element.
- `placeholder`: Placeholder of the element.
- `required`: Indicates that the element is required.

# Interaction With Forms Using JavaScript 
[Up](#table-of-contents)

JavaScript can interact with the HTML forms dinamically and adding functionalities that are not possible wit pure HTML.

## Access To The Form Elements
[Up](#table-of-contents)

To interact with the elements of a form, first it is necessary to access the form itself.
- `document.getElementById('id')`: Gets an element by its ID.
- `document.querySelector('selector')`: Gets the first element that matches the CSS selector.
- `document.forms['name']`: Gets a form by its name.
- `form.elements['name']`: Gets an element of a form by its name.

Example:
```javascript
<script>
  const nombreInput = document.getElementById('nombre');
  const emailInput = document.querySelector('input[name="correo"]');
  const formulario = document.forms['registro'];
  const botonEnviar = formulario.elements['enviar'];
</script>
```

## Managing The Form Events
[Up](#table-of-contents)

- `submit`: It is triggered when the form is submitted.
- `reset`: It is triggered when the form is reset.
- `change`: It is triggered when the value of an element changes.
- `focus`: It is triggered when an element receives focus.
- `blur`: It is triggered when an element loses focus.

To manage the events of a form, we use event handlers. Those handlers are functions that are executed when the event is triggered.

Different methods:
- `addEventListener('event', function)`: Adds an event listener to the element.
- `removeEventListener('event', function)`: Removes an event listener from the element.
- `on<event>: function`: Assigns a function to the event.

Example:
```javascript
nombreInput.addEventListener('change', function() {
  const nombre = nombreInput.value;
  console.log('El nombre ha cambiado a:', nombre);
});
```

In this case, we are listening to the `change` event of the `nombreInput` element. When the event is triggered, the function is executed and the value of the element is printed in the console.

The most important event is the `submit` event, which is triggered when the form is submitted. This event allows us to validate the data before sending it to the server.

```javascript
formulario.addEventListener('submit', function(event) {
  event.preventDefault(); // Evita el envío del formulario por defecto
                          // Validar los datos del formulario
                          // Si son válidos, enviar el formulario
});
```

The most common is the next:
- Prevent the default behavior of the form.
- Validate the data of the form.
- If the data is not valid, show an error message.
- If the data is valid, send the form.

## Validation of Form Data
[Up](#table-of-contents)

The validation of the data of a form is essential to ensure that the data is correct before sending it to the server.

JavaScript provides tools to validate the data of a form

We can check that the data of a field has the required information using the elements that JavaScript provides for objects like string or number.

```javascript
formulario.addEventListener('submit', function(event) {
  event.preventDefault();
  const nombre = nombreInput.value;
  const email = emailInput.value;

  if (nombre.trim() === '') {
    alert('El nombre es obligatorio');
    return;
  }

  if (email.trim() === '') {
    alert('El correo electrónico es obligatorio');
    return;
  }

  formulario.submit();
});
```

For more complex validations, we can use regular expressions.

### Regular Expressions (RegExp)
[Up](#table-of-contents)

They are a sequence of characters that define a search pattern.

They are used in a wide variety of tasks, such as:
- Data validation.
- Search and extraction of information.
- Text processing.

Basic components:
- Literal characters: They are the simplest regular expressions.
- Meta-characters: They have a special meaning.
  - `.`: Any character except the newline character.
  - `*`: Zero or more occurrences of the previous character.
  - `+`: One or more occurrences of the previous character.
  - `?`: Zero or one occurrence of the previous character.
  - `[]`: A set of characters. For example, `[aeiou]` matches any vowel.
  - `^`: The beginning of a string.
  - `$`: The end of a string.
- Quantifiers: They specify the number of occurrences of a character.
  - `{n}`: Exactly `n` occurrences.
  - `{n,}`: At least `n` occurrences.
  - `{n,m}`: Between `n` and `m` occurrences.

To use a regular expression, we need a regexp motor that interprets the pattern.

In JavaScript, we must build the regular expression and apply the method test passing as a parameter the value we want to validate.

Example for a mail:
```javascript
function validarEmail(email) {
  const regex =
/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-
9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-
zA-Z]{2,}))$/;
  return regex.test(email);
}

emailInput.addEventListener('blur', function() {
  const email = emailInput.value;
  if (!validarEmail(email)) {
    alert('El correo electrónico no es válido.');
  }
});
```

The form management is adapted to the needs of the project. The most common is the next:
- Add, generally below, a `div`to show if there is an error on it for every field of the form.
  - Initially, it is hidden.
- In the submit handler, validate the data of the form.
  - If the data is not valid, show the error message.
  - If the data is valid, send the form.

# Form Controls
[Up](#table-of-contents)

## Text and Textarea
[Up](#table-of-contents)

The value of a text field is accessed through the `value` property.

```javascript
<input type="text" id="texto">
<textarea id="parrafo"></textarea>

<script>
  const valorText= document.getElementById("texto").value;
  const valorTextArea = document.getElementById("parrafo").value;
</script>
```

There are times where wwe want that the textarea is not visible:
```html
<textarea id="parrafo" type="hidden"></textarea>
```

There are times where we want that the field is only read:
```html
<input type="text" id="texto" readonly>
```

## Radio Buttons
[Up](#table-of-contents)

The most important is that the radio buttons have the same name to be able to select only one of them.

If we have the next radio buttons:

```html
<input type="radio" value="casado" name="estadoCivil" id="casado"/> casado
<input type="radio" value="soltero" name="estadoCivil" id="soltero"/> soltero
<input type="radio" value="divorciado" name="estadoCivil" id="divorciado"/>
divorciado
<input type="radio" value="viudo" name="estadoCivil" id="viudo"/> viudo
<input type="radio" value="otro" name="estadoCivil" id="otro"/> otro
```

This code will allow us determine if each radio button is selected:

```javascript
let elements = document.getElementsByName("estadoCivil");

Array.frm(elementos).forEach(ec => alert(ec.value + " es " + ec.checked));

// If "soltero" is selected, the next alerts will appear:

// casado es false
// soltero es true
// divorciado es false
// viudo es false
// otro es false
```

Generally, what we want if checking which is selected:

```javascript
let elements = document.getElementsByName("estadoCivil");

let seleccionado = Array.from(elementos).find(ec => ec.checked);

alert("El estado civil seleccionado es " + seleccionado.value);
```

## Checkboxes
[Up](#table-of-contents)

In this case, we have to check if the checkbox is checked indepently:

We have the next checkboxes:

```html
<input type="checkbox" value="condiciones" id="condiciones"/>
He leído y acepto las condiciones

<input type="checkbox" value="privacidad" id="privacidad"/>
He leído la política de privacidad

<button onclick="verCondicionesPrivacidad()">Ver seleccion</button>
```

This code will allow us determine if each checkbox is checked:

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

## Select
[Up](#table-of-contents)

These are the elements with more properties.

We can see it as an array of elements with two properties:
- `text`: what we see in the list.
- `value`: what we get when we select it.

With the next HTML:

```html
<select id="lista">
  <option value="1">Primer valor</option>
  <option value="2">Segundo valor</option>
  <option value="3">Tercer valor</option>
  <option value="4">Cuarto valor</option>
</select>
```

We can access to the selected option with the next code:

```javascript
let lista=document.getElementById("lista")
alert ("Valor lista " + lista.value)

lista.addEventListener("change",()=>alert(lista.value));
```

### Access To Every Element of a Select
[Up](#table-of-contents)

In general, what we want is obtaining the selected element and, generally, when the option is changed, to get the new one.

We must nedd the next properties:
- `options`: It is an array with all the options. It is created automatically and contains the reference for each option of the list.
- `selectedIndex`: It is the index of the selected option. If there ir no selection, the value is `-1`.

```javascript
// Obtener la referencia a la lista
let lista = document.getElementById("lista");

// Obtener el índice de la opción que se ha seleccionado
var indiceSeleccionado = lista.selectedIndex;

// Con el índice y el array "options", obtener la opción seleccionada
var opcionSeleccionada = lista.options[indiceSeleccionado];

// Obtener el valor y el texto de la opción seleccionada
var textoSeleccionado = opcionSeleccionada.text;
var valorSeleccionado = opcionSeleccionada.value;

alert("Opción seleccionada: " + textoSeleccionado)
alert("Valor de la opción: " + valorSeleccionado)
```

Normally, it is abbreviated in the next way:

```javascript
// Acceder a lista
let lista = document.getElementById("lista");

// Obtener el texto que muestra la opción seleccionada
let textoSeleccionado = lista.options[lista.selectedIndex].text;

// Obtener el valor de la opción seleccionada
let valorSeleccionado = lista.options[lista.selectedIndex].value;
```

### Adding and Removing Options of a Select
[Up](#table-of-contents)

We have the next code:

```html
<select id="lista2">
</select>

<button onclick="anyadirElementoLista()">Añadir elemento</button>
```

We can use the DOM:

```javascript
function anyadirElementoLista(){
  let texto=prompt("Dime Text");
  let valor=prompt("Dime Value");

  mioption=document.createElement("option");
  mioption.value=valor;
  mioption.text=texto;

  lista2.appendChild(mioption);
}
```

Or the specific methods:

```javascript
selectObject.add(option, index)
```
- `option`: The option to add.
- `index`: The position where the option will be added. If it is not specified, the option will be added at the end.

```javascript
function addLista(){
  let texto=prompt("Dime Text");
  let valor=prompt("Dime Value");

  mioption=document.createElement("option");
  mioption.value=valor;
  mioption.text=texto;

  lista.add(mioption,2)
}
```

In this case, we have added the option in the position second position (third element: 0, 1, 2...).

To delete an option, we can use the next code:

```javascript
selectObject.remove(index)
```

Examples:

- It will delete the third element of the dropdown menu:
```javascript
function deleteLista(){
  lista.remove(2);
}
```

- It will delete the last element of the dropdown menu:
```javascript
if (lista.length > 0) {
lista.remove(lista.length-1);
}
```

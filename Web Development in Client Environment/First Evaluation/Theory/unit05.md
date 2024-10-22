# Table of contents

- [Table of contents](#table-of-contents)
- [Events](#events)
  - [Mouse events](#mouse-events)
  - [Keyboard events](#keyboard-events)
  - [Form events](#form-events)
  - [DOM events](#dom-events)
- [Event Handlers](#event-handlers)
  - [HTML attributes](#html-attributes)
  - [DOM properties](#dom-properties)
  - [Event listeners](#event-listeners)
    - [addEventListener](#addeventlistener)
    - [removeEventListener](#removeeventlistener)
- [Event Propagation](#event-propagation)
- [Event Object](#event-object)
- [Event onload](#event-onload)
- [Personalized Events](#personalized-events)
  - [Creating personalized events](#creating-personalized-events)
  - [Dispatching personalized events](#dispatching-personalized-events)
  - [Listening to personalized events](#listening-to-personalized-events)
  - [Advanced uses of personalized events](#advanced-uses-of-personalized-events)

# Events
[Up](#table-of-contents)

It is an action or ocurrency that occurs in an HTML document.

Analogy with a house:
- HTML elements: rooms, doors, windows, etc.
- Events: actions that occur in the house, such as opening a door, turning on a light, etc.
- JavaScript: the person who performs the actions.

## Mouse events
[Up](#table-of-contents)

- `click`: when the user clicks on an element.
- `contextmenu`: when the user right-clicks on an element to open a context menu.
- `dblclick`: when the user double-clicks on an element.
- `mouseover`/`mouseout`: when the user moves the mouse over/out of an element.
- `mousedown`/`mouseup`: when the user presses/releases a mouse button over an element.
- `mousemove`: when the user moves the mouse pointer while it is over an element.

## Keyboard events
[Up](#table-of-contents)

- `keydown`: when the user is pressing a key.
- `keyup`: when the user releases a key.
- `keypress`: when the user presses a key.

## Form events
[Up](#table-of-contents)

- `submit`: when the user submits a form.
- `change`: when the user changes the value of a form element.
- `focus`: when the user gives focus to an element.
- `blur`: when the user removes focus from an element.
- `reset`: when the user resets a form.

## DOM events
[Up](#table-of-contents)

- `load`: when an object has loaded.
- `resize`: when the browser window is resized.
- `scroll`: when the user scrolls up or down the page.

# Event Handlers
[Up](#table-of-contents)

In order to react to an event, we need to assign an event handler to an element.

It is a function that is executed when an event occurs.

Handlers are a form of executing JavaScript code in response to an user action.

There are different forms of assigning event handlers:
- HTML attributes.
- DOM properties.
- Event listeners.

## HTML attributes
[Up](#table-of-contents)

An HTML attribuye is not a convenient way to write too much code.

It is better to create a JS function and to call it from the HTML attribute.

```html
<body>
    <h3>Demo de eventos</h3>
    <button class="btn btn-primary" onclick="saludar()">Saludar</button>
</body>

<script>
    function saludar(){
        alert ("Hola...")
    }
</script>
```

## DOM properties
[Up](#table-of-contents)

We have to assign the event handler to the `on` property of the element.

```html
<body>
    <h3>Demo de eventos</h3>
    <button class="btn btn-primary" id="btn">Saludar</button>
</body>

<script>
    document.getElementById("btn").onclick = function(){
        alert("Hola...")
    }
</script>
```

We cannot use `document.getElementById("btn").onclick = saludar()` because it would execute the function immediately and storage the information os `saludar()`on the button.

## Event listeners
[Up](#table-of-contents)

The main problem we have seen until now is that we can only assign one event handler to an element. The second one would override the first one.

Solution: addEventListener and removeEventListener.

### addEventListener
[Up](#table-of-contents)

```javascript
element.addEventListener(event, handler, useCapture);
```

- `event`: the event we want to listen to (example: click). 
- `handler`: the function that will be executed when the event occurs.
- `useCapture`: a boolean value that indicates if the event should be executed in the capture phase (true) or in the bubbling phase (false).

### removeEventListener
[Up](#table-of-contents)

```javascript
element.removeEventListener(event, handler, useCapture);
```

We have to pass the same parameters as in `addEventListener`.

If we want to remove an event listener, we have to store the function in a variable.

```javascript
let handler = function(){
    alert("Hola...")
}

document.getElementById("btn").addEventListener("click", handler);

document.getElementById("btn").removeEventListener("click", handler);
```

If we use a function expression, we cannot remove the event listener.

```javascript
document.getElementById("btn").addEventListener("click", function(){
    alert("Hola...")
});

document.getElementById("btn").removeEventListener("click", function(){
    alert("Hola...")
});
// It will not work.
```

The use of addEventListener is more universal and is generally the most used, leaving the event handler by DOM property for dynamically created elements and being able to assign them at the time of their creation their event handler.   

# Event Propagation
[Up](#table-of-contents)

- Bubbling: the child event is executed first and then the parent event.
- Capture: the parent event is executed first and then the child event.

The default value of the `useCapture` parameter is `false`, so the event is executed in the bubbling phase.

# Event Object
[Up](#table-of-contents)

When an event occurs, the browser creates an object that contains information about the event.

Properties:
- `event.type`: the type of event that occurred (example: click).
- `event.currentTarget`: the element that has the event listener.
- `event.clientX`/`event.clientY`: the coordinates of the mouse pointer when the event occurred.

```javascript
function handler(){
alert("Evento " + event.type + " en " + event.currentTarget);
alert("Coordenadas: " + event.clientX + ":" + event.clientY);
}

let miBoton2=document.getElementById("miBoton2")
miBoton2.addEventListener("click", handler)
```

In functions that handle events, the event object is available even if it is not passed as a parameter, since JavaScript makes sure that it is available to the controller code.    

# Event onload
[Up](#table-of-contents)

In order to access the DOM elements, we have to wait until the document is fully loaded.

The easiest solution is to put the script at the end of the body.

To avoid this situation, we have the event `onload`.

If we want to be sure that the page has loaded completely, we should check the body element or the window object.

```javascript
<script>
    window.onload=()=>{
        let myP1=document.getElementById("myP1");
        alert(myP1.innerHTML);
}
</script>

<body>
    <p id="myP1">Soy el parrafo1</p>
</body>
```

We can also use the `addEventListener` method.

```javascript
<script>
    window.addEventListener("load", ()=>{
        let myP1=document.getElementById("myP1");
        alert(myP1.innerHTML);
    });
</script>

<body>
    <p id="myP1">Soy el parrafo1</p>
</body>
```

# Personalized Events
[Up](#table-of-contents)

Personalized events are events that we create ourselves to represent specific actions or situations.

It allows us:
- Communicate between different parts of the code.
- Create personalized workflows: we can create specific events to represent actions os states that are not covered by native events.
- Simplify the code: when we encapsulate the code in personalized events, it becomes more legible and maintainable.

## Creating personalized events
[Up](#table-of-contents)

We have to use the `CustomEvent` constructor.

```javascript
const myEvent = new CustomEvent('myCustomEvent', {
    detail: {
        message: 'Hola desde el evento personalizado',
        data: 42
    }
}
);
```

It accepts two main parameters:
- Name of the event.
- Options:
  - `Bubble`: if the event should bubble up through the DOM.
  - `Cancelable`: if the event can be canceled.
  - `Detail`: an object that contains additional information about the event.

## Dispatching personalized events
[Up](#table-of-contents)

We have to use the `dispatchEvent` method.

We will use `window` always.

```javascript
window.dispatchEvent(myEvent);
```

## Listening to personalized events
[Up](#table-of-contents)

We have to use the `addEventListener` method.

```javascript
window.addEventListener('myCustomEvent', () => {
    console.log(event.detail.message); // Acceder a los datos adicionales
});
```

Example:
    
```javascript
<body>
    <button id="miBoton">Lanzar evento</button>
</body>

<script>
    const myEvent = new CustomEvent('myCustomEvent', {
        detail: {
            message: 'Hola desde el evento personalizado',
            data: 42}
        });

let miBoton=document.getElementById("miBoton")

miBoton.addEventListener("click", ()=>window.dispatchEvent(myEvent))

window.addEventListener('myCustomEvent', () => {
    console.log(event.detail.message); // Acceder a los datos adicionales
});
</script>
```

## Advanced uses of personalized events
[Up](#table-of-contents)

- Communication between components in frameworks: Personalized events are fundamental in the communication between components in frameworks such as Angular or React.
- Creation of personalized events systems: We can create our own event systems to manage the communication between different parts of the code.
- Events simulation: We can simulate events of the user to test the behavior of the application.

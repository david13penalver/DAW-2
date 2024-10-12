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
- [Event Propagation](#event-propagation)
- [Event Object](#event-object)
- [Event onload](#event-onload)
- [Personalized Events](#personalized-events)

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



# Event Propagation
[Up](#table-of-contents)

*Notes here*

# Event Object
[Up](#table-of-contents)

*Notes here*

# Event onload
[Up](#table-of-contents)

*Notes here*

# Personalized Events
[Up](#table-of-contents)


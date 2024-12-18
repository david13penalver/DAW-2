UNIT 02 - MODULES AND COMPONENTS

# Table of Contents
- [Table of Contents](#table-of-contents)
- [Data Binding](#data-binding)
- [Interpolation](#interpolation)
- [Property Binding](#property-binding)
- [Event Binding](#event-binding)
- [Two-way Data Binding](#two-way-data-binding)

# Data Binding
[Up](#table-of-contents)

Data Binding is a fundamental concept in Angular.

It stablished a dynamic connection between the data of the component and the view.

It guarantees that the changes in the model are reflected in the view and vice versa.

Types of connections:
- From model to view.
- From view to model.
- Two-way data binding.

# Interpolation
[Up](#table-of-contents)

Interpolation is the mechanism to substitute the expression for a value in the view.

This type of binding is unidirectional, from the component to the view.

First, we define que variable:
```typescript
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
export class AppComponent {
    titulo:string="Data Binding"
}
```

Then, we use the variable in the view:
```html
<h2>Estamos viendo el {{titulo}}</h2>
```

# Property Binding
[Up](#table-of-contents)

Property Binding helps to stabish value for the propertiesof the HTML elements of directives.

This proccess is unidirection from the component to the view.

To bind the property, we use the square brackets `[]`.

First, we define the variable:
```typescript
export class AppComponent {
    titulo:string="Data Binding"
    imagen:string="../assets/logo.png"
}
```

Then, we use the variable in the view:
```html
<img [src]="imagen" alt="Logo">
```

Another option is to determine the value of the property `disabled` of a button:
```typescript
desactivado:boolean=false
```

```html
[disabled]="desactivado">Boton</button>
```

We can even set timeouts, for example:
```typescript
ngOnInit(){
    setTimeout(() => {console.log("Desactivamos boton...");
                     this.desactivado = true
                     }, 5000)
}
```

We can also use expressions in the Property Binding. We can assign conditions that will determine the value of the property we are binding.

We define the CSS of the classes `.activado` and `.desactivado`:
```css
.activado{background-color:green}
.desactivado{background-color:red}
```

We define the HTML style of the button according to the status:
```html
<button [class]="desactivado ? 'desactivado' : 'activado'"
[disabled]="desactivado">Boton</button>
```

To avoid problems with the DOM, if we have enabled a project with SSR, we will add to the `@Component` decorator the property `host` with the value `{ngSkipHydration: true}`.

```typescript
@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet],
    host:{ngSkipHydration: 'true'},
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
```

# Event Binding
[Up](#table-of-contents)

Event Binding allows sending data from the view to the controller.

The binding is stablished by events.

To bind an event, we use the parentheses `()` and withour the `on` (like the `addEventListener`).

Example implementing a function to a button:
```typescript
onSave(){
    alert("Has pulsado en grabar...")
}
```

```html
<button (click)="onSave()">Grabar</button>
```

We can also pass parameters to the function:
```typescript
onSaveCliente(cliente:string){
    alert("Grabamos a " + cliente)
}
```

```html
<button (click)="onSaveCliente('Juan')">Grabar</button>
```

We can also pass the Object `$event`, that will aloww passing to the function the event that triggered the action in order to have all the information of the event:
```html
<button (click)="onSaveCliente($event)">Grabar</button>
<!--- Or --->
<button (click)="onSaveCliente('Juan', $event)">Grabar</button>
```

```typescript
onSaveCliente(cliente:string, event:any){
    console.log(event)
}
// Or
onSaveCliente(cliente:string, event:any){
    alert("Grabamos a " + cliente)
    console.log(event)
}
```

# Two-way Data Binding
[Up](#table-of-contents)

Two Way Data Binding allows passing information in a birirectional way between the component and the view.

It combines the Property Binding and the Event Binding. For that, it uses the syntax knows as `banana in a box -> [()]` `[(ngModel)]`.

We will do the next:
In the HTML:
```html
<input type="text" [(ngModel)]="nombre">
```

In the TypeScript (we need `FormsModule`):
```typescript
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet, FormsModule],
    host:{ngSkipHydration: 'true'},
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})

nombre:string="Pepe Pérez"
```

In this way, we are binding the value of the input with the variable property of the controller. Now we should see initially the name "Pepe Pérez" in the input.

Example asking for the name:
```html
<input type="text" [(ngModel)]="nombre">
<h3>{{nombre}}</h3>
<button (click)="cambiarValor()">Cambiar valor</button>
```

```typescript
cambiarValor(){
    let nuevoNombre:string | null =prompt("Nuevo valor")
    this.nombre=nuevoNombre==null ? this.nombre : nuevoNombre
}
```

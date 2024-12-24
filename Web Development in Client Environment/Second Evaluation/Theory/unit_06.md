UNIT 06 - SERVICES AND DEPENDENCY INJECTION

# Table of Contents
- [Table of Contents](#table-of-contents)
- [Services](#services)
- [Dependency Injection](#dependency-injection)
- [Providing Services](#providing-services)
  - [Registering a provider in the service](#registering-a-provider-in-the-service)
  - [Registering a provider in the module](#registering-a-provider-in-the-module)
  - [Registering a provider in the module](#registering-a-provider-in-the-module-1)

# Services
[Up](#table-of-contents)

The components of our app must present data and allow that the user interacts with it. 

The components should not fetch data from the server, validate user input, or log directly to the console. These tasks should be delegated to services.

Services must be integrated with the components through Dependency Injection.

A service is a class that can be used to share data or logic across different parts of the app. It is decorated with the `@Injectable` decorator.

They are Singleton objects, which means that there is only one instance of the service in the app.

This allows that the components can share data and communicate with each other.

Creation of a service:

```bash
ng g s /Services/articulos
```

Initially, Angular will create a file called `articulos.service.ts` with the following content:

```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArticulosService {

  constructor() { }
}
```

Now let's create a service that will manage the data manipulation of our app, that is getting the data and implement the right methods to manage that data.

We will define a variable called `ARTICULOS` that will store the data of the app.

The methods will be the common ones from a REST api: `get`, `post`, `put`, `delete`.

```typescript
import { Injectable } from '@angular/core';
import { ARTICULOS, Articulo } from '../Modelos/articulo';

@Injectable({
providedIn: 'root'
})

export class ArticulosService {

    constructor() { }

    articulos:Articulo[]=ARTICULOS

    getArticulos(){
        return this.articulos
    }

    getArticulo(id:string){
        let pos=this.articulos.findIndex(a=>a.id==id)
        return this.articulos[pos]
    }

    postArticulo(articulo:Articulo){
        let pos=this.articulos.findIndex(a=>a.id==articulo.id)
        if(pos==-1)
            this.articulos.push(articulo)
        else
            alert("Ya existe un artículo con ese id")
    }

    putArticulo(articulo:Articulo){
        let pos=this.articulos.findIndex(a=>a.id==articulo.id)
        this.articulos[pos]=articulo
    }

    deleteArticulo(id:string){
        let pos=this.articulos.findIndex(a=>a.id==id)
        this.articulos.splice(pos, 1)
    }
}
```

# Dependency Injection
[Up](#table-of-contents)

Once created the service, now we need to inject it into the components that will use it.

The **injector** is the main mechasnism that Angular uses to provide the services to the components.

A **provider** is an object that tells the injector how to obtain or create a service.

For every dependency that we need in our app, we must register a provider with the injector. For a service, a provider is usually the service itself. When Angular creates a new instance of a class of a component, determines which services or other dependencies need that component when looking at the parameters of the constructor of the component.

We are going to use our service wieh a component call `articulos`.

```bash
ng g c /Components/articulos
```

```typescript
import { Component } from '@angular/core';
import { Articulo } from '../../Modelos/articulo';
import { ArticulosService } from '../../Services/articulos.service';

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})

export class ArticulosComponent {

    articulos!:Articulo[]

    constructor(private miServicio:ArticulosService){}
    
    ngOnInit(){
        this.articulos=this.miServicio.getArticulos()
    }
}
```

The variable of the constructor has to be public or private, otherwise, Angular will not be able to inject the service.
- `private`: We cannot access the service from the view.
- `public`: We can access the service from the view.

Here we have the HTML of the component:

```html
<h3>Listado de articulos</h3>

<table class="table ">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Descripcion</th>
            <th scope="col">Precio</th>
            <th scope="col">Unidades</th>
        </tr>
    </thead>
    <tbody>
    @for (articulo of articulos; track articulo.id){
        <tr>
            <td>{{articulo.id}}</td>
            <td>{{articulo.nombre}}</td>
            <td>{{articulo.descripcion}}</td>
            <td>{{articulo.precio}}</td>
            <td>{{articulo.unidades}}</td>
        </tr>
    } @empty {
        <div class="alert alert-danger">No hay articulos</div>
    }
    </tbody>
</table>
```

Result:
![Articulos](./Assets/06_injection.png)

# Providing Services
[Up](#table-of-contents)

We shoyld register at least one provider of any service we are going to use.

The provider can be part of the own metadata of the service, making the service available everywhere in the app; or we can register it in a specific module, making it available only in that module.

For each case, we must register providers in:
- The metadata of the service: `@Injectable()`.
- The metadata `@Component()` of the component.
- The metadata `@NgModule()` of the module.

## Registering a provider in the service
[Up](#table-of-contents)

By default, the Angular CLI registers a provider with the root injector for the service.

```typescript
@Injectable({
    providedIn: 'root'
})
```

When we provide the service at the root level, Angular creates a single shared instance of the service and injects it into any class that requests it. Registering the provider in the `@Injectable()` metadata also allows Angular to optimize an application by removing the service from the compiled application if it is not used.

## Registering a provider in the module
[Up](#table-of-contents)

When we register a provider at the component level, we get a new instance of the service with each new instance of that component. At the component level, we will register a service provider in the providers property of the `@Component()` metadata.

```typescript
@Component({
    selector: 'app-articulos',
    standalone: true,
    imports: [],
    providers:[ArticulosService],
    templateUrl: './articulos.component.html',
    styleUrl: './articulos.component.css'
})
```

In this case, the service is available only in the component and its children.

## Registering a provider in the module
[Up](#table-of-contents)

When we register a provider with a specific `@NgModule`, the same instance of a service is available to all components in that NgModule. To register at this level, we will use the providers property of the `@NgModule()` decorator within the module's ts file.

```typescript
@NgModule({
    declarations: [
        AppComponent,
        ArticulosComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
    providers: [ArticulosService],
    bootstrap: [AppComponent]
})
```

import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ArticulosComponent} from './Components/articulos/articulos.component';
import {ErrorComponent} from './Components/error/error.component';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ArticulosComponent, ErrorComponent, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Practise_exercise';

  titulo:string = "'Hola interpolado'";
  img:string = "logo.jpg";

  nombre2WDB:string = "Juan";

  desactivado:boolean = false;
  isChecked: boolean = true; // Asi el checkbox está marcado por defecto. Por ejemplo, para los términos y condiciones automáticos
  numeroSwitch: number = 10;

  ngOnInit(){
    setTimeout(() => {console.log("Desactivamos boton...");
      this.desactivado = true
    }, 5000)
  }

  mensaje() {
    alert("Hola desde el evento click");
  }

  cambiarNombre() {
    let nuevoNombre:string | null = prompt("Introduce el nuevo nombre");
    if (nuevoNombre == null)
      this.nombre2WDB = this.nombre2WDB;
    else
      this.nombre2WDB = nuevoNombre;
  }

  idBoton($event:any) {
    alert($event.target.id);
  }
}

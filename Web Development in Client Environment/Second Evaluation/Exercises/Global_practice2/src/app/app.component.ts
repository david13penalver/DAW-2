import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HeaderComponent} from './Components/header/header.component';
import {HijoParaPadreHijoComponent} from './Components/hijo-para-padre-hijo/hijo-para-padre-hijo.component';
import {HijoParaHijoPadreComponent} from './Components/hijo-para-hijo-padre/hijo-para-hijo-padre.component';
import {CardsComponent} from './Components/cards/cards.component';
import {PokedexComponent} from './Components/pokedex/pokedex.component';
import {DigipediaComponent} from './Components/digipedia/digipedia.component';
import {ArticulosConServiciosComponent} from './Components/articulos-con-servicios/articulos-con-servicios.component';
import {EjemploObservablesComponent} from './Observable/ejemplo-observables/ejemplo-observables.component';
import {RouterInicioComponent} from './Components/router-inicio/router-inicio.component';
import {RouterHeaderComponent} from './Components/router-header/router-header.component';
import {ArticulosComponent} from './Components/aaHttp/articulos/articulos.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, HeaderComponent, HijoParaPadreHijoComponent, HijoParaHijoPadreComponent, CardsComponent, PokedexComponent, DigipediaComponent, ArticulosConServiciosComponent, EjemploObservablesComponent, RouterInicioComponent, RouterHeaderComponent, ArticulosComponent],
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
  numeroSwitch: number = 3;

  bucleFor:Array<number> = [1,2,3,4,5,6,7,8,9,10];
  bucleFor2!:Array<any>;

  variablePadreHijo:number = 0;
  mensajeDelHijo!: string;
  valorTexto: string = "hola";

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
    if (nuevoNombre == null || nuevoNombre == "") {}
    else
      this.nombre2WDB = nuevoNombre;
  }

  idBoton(dato:any) {
    alert(dato.target.id);
  }

  incrementar() {
    this.variablePadreHijo++;
  }

  muestraMensaje(dato: string) {
    this.mensajeDelHijo = dato;
  }

  cambiarValor() {
    let nuevoValor!: string | null;
    nuevoValor = prompt("Introduce el nuevo valor");
    if (nuevoValor == null)
      this.valorTexto = "Pene";
    else
      this.valorTexto = nuevoValor;
  }
}

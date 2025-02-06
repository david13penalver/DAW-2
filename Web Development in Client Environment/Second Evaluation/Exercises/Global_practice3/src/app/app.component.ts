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

}

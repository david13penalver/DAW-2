import { Component } from '@angular/core';
import {Articulo, articulos} from "../../Interface/articulo";
import {CardComponent} from '../card/card.component';

@Component({
  selector: 'app-cards',
  imports: [
    CardComponent
  ],
  templateUrl: './cards.component.html',
  styleUrl: './cards.component.css'
})
export class CardsComponent {

    articulos:Articulo[] = articulos;

    borrar(id:number) {
      let pos = this.articulos.findIndex(a => a.id == id);
      this.articulos.splice(pos, 1);
    }
}

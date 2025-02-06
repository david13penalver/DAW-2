import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Articulo} from '../../Interface/articulo';

@Component({
  selector: 'app-card',
  imports: [],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {
  @Input() articulito!:Articulo;
  @Output() borrarArticulo = new EventEmitter<number>;

  borrar(id:number) {
    this.borrarArticulo.emit(id);
  }
}

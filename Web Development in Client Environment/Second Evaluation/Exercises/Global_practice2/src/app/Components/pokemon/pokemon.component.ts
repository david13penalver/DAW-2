import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Monstruitos, monstruitosss} from '../../Interface/monstruitos';

@Component({
  selector: 'app-pokemon',
  imports: [],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {
  @Input() pokemoncito!: Monstruitos;
  @Output() hijoBorrar = new EventEmitter;


  dato(id: number) {
    this.hijoBorrar.emit(id);
  }
}

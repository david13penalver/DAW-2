import {Component, Input} from '@angular/core';
import {Pokemons} from '../../interface/pokemons';

@Component({
  selector: 'app-pokemon',
  imports: [],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {

  @Input() pokemon!:Pokemons;

  borrar(id: number) {
    return console.log(`Borrando pokemon con id ${id}`);
  }

}

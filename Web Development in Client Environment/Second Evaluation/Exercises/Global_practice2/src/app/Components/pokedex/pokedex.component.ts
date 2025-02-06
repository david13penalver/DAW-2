import { Component } from '@angular/core';
import {Monstruitos, monstruitosss} from '../../Interface/monstruitos';
import {PokemonComponent} from '../pokemon/pokemon.component';

@Component({
  selector: 'app-pokedex',
  imports: [
    PokemonComponent
  ],
  templateUrl: './pokedex.component.html',
  styleUrl: './pokedex.component.css'
})
export class PokedexComponent {

  monstruito:Monstruitos[] = monstruitosss;

  padreBorrar(id: number) {
    let pos = monstruitosss.findIndex(p => p.id == id);
    monstruitosss.splice(pos, 1);
  }
}

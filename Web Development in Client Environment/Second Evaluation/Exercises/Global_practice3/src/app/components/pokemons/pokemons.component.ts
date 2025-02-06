import { Component } from '@angular/core';
import {Pokemons} from '../../interface/pokemons';
import {PokemonServiceService} from '../../services/pokemon-service.service';
import {PokemonComponent} from '../pokemon/pokemon.component';

@Component({
  selector: 'app-pokemons',
  imports: [PokemonComponent],
  templateUrl: './pokemons.component.html',
  styleUrl: './pokemons.component.css'
})
export class PokemonsComponent {
  pokemons!:Pokemons[];

  constructor(private miServicio:PokemonServiceService) {
  }

  cargar() {
    this.miServicio.getAll().subscribe({
      next: datos => this.pokemons = datos,
      error: error => console.log(error.status)
    });
  };

  ngOnInit() {
    return this.cargar();
  }

  nuevo() {

  }
}

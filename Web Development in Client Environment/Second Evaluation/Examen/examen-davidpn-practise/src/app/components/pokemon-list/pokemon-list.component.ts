import { Component } from '@angular/core';
import {PokemonService} from '../../service/pokemon.service';
import {Pokemon} from '../../interface/pokemon';
import {PokemonItemComponent} from '../pokemon-item/pokemon-item.component';

@Component({
  selector: 'app-pokemon-list',
  imports: [
    PokemonItemComponent
  ],
  templateUrl: './pokemon-list.component.html',
  styleUrl: './pokemon-list.component.css'
})
export class PokemonListComponent {

  pokemons!:Pokemon[];

  constructor(private miServicio:PokemonService) {
  }

  ngOnInit() {
    this.cargar();
  }

  cargar() {
    this.miServicio.getAll().subscribe({
      next: list => {
        this.pokemons = list;
      },
      error: error => console.log(error.status)
    })
  }

}

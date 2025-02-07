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

  newPokemon!:Pokemons;

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
    this.newPokemon = {
      id: 0,
      name: "",
      type: "",
      description: "",
      height: "",
      weight: ""
    }
    this.newPokemon.id = Number(prompt("Introduce el id del pokemon")) || this.newPokemon.id;
    this.newPokemon.name = prompt("Introduce el nombre del pokemon") || this.newPokemon.name;
    this.newPokemon.type = prompt("Introduce el tipo del pokemon") || this.newPokemon.type;
    this.newPokemon.description = prompt("Introduce la descripción del pokemon") || this.newPokemon.description;
    this.newPokemon.height = prompt("Introduce la altura del pokemon") || this.newPokemon.height;
    this.newPokemon.weight = prompt("Introduce el peso del pokemon") || this.newPokemon.weight;

    this.miServicio.post(this.newPokemon).subscribe({
      next: () => this.cargar(),
      error: error => console.log(error.status)
    })
  }

  delete(id:number) {
    this.miServicio.delete(id).subscribe({
      next: () => this.cargar(),
      error: error => console.log(error.status)
    })
  }

  put(id:number, pokemon: Pokemons) {
    this.miServicio.put(id, pokemon).subscribe({
      next: () => this.cargar(),
      error: error => console.log(error.status)
    })
  }
}

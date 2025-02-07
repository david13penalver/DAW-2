import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Pokemons} from '../../interface/pokemons';
import {provideRouter, RouterLink} from '@angular/router';

@Component({
  selector: 'app-pokemon',
  imports: [
    RouterLink
  ],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
})
export class PokemonComponent {

  @Input() pokemon!:Pokemons;
  @Output() deleteChild = new EventEmitter<number>();
  @Output() modifyChild = new EventEmitter<Pokemons>();

  updatedPokemon!:Pokemons;

  delete(id: number) {
    this.deleteChild.emit(id);
  }

  modify(id:number, pokemon:Pokemons) {
    this.updatedPokemon = pokemon;

    this.updatedPokemon.id = id;
    this.updatedPokemon.name = prompt("Introduce el nuevo nombre del pokemon") || pokemon.name;
    this.updatedPokemon.type=prompt("Introduce el nuevo tipo del pokemon") || pokemon.type;
    this.updatedPokemon.description=prompt("Introduce la nueva descripción del pokemon", pokemon.description) || pokemon.description;
    this.updatedPokemon.height=prompt("Introduce la nueva altura del pokemon", pokemon.height) || pokemon.height;
    this.updatedPokemon.weight=prompt("Introduce el nuevo peso del pokemon", pokemon.weight) || pokemon.weight;

    this.modifyChild.emit(this.updatedPokemon);
  }

  protected readonly provideRouter = provideRouter;
}

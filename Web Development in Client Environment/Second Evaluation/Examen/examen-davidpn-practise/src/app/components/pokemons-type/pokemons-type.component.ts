import { Component } from '@angular/core';
import {Pokemon} from '../../interface/pokemon';
import {PokemonService} from '../../service/pokemon.service';
import {PokemonItemComponent} from '../pokemon-item/pokemon-item.component';

@Component({
  selector: 'app-pokemons-type',
  imports: [
    PokemonItemComponent
  ],
  templateUrl: './pokemons-type.component.html',
  styleUrl: './pokemons-type.component.css'
})
export class PokemonsTypeComponent {

  pokemonList!: Pokemon[];
  selectedType:string = "-";
  optionPossibilities:string[] = ["-", "fire", "water", "grass", "electric", "ice", "fighting", "poison", "ground", "flying", "psychic", "bug", "rock", "ghost", "dark", "dragon", "steel", "fairy"];

  constructor(private miServicio:PokemonService) {};

  ngOnInit() {
    this.getAll();
  }

  selectedValue(event:any) {
    this.selectedType = event.target.value;
    this.getAll();
  }

  getAll() {
    if (this.selectedType == "-") {
      this.miServicio.getAll().subscribe({
        next: data => this.pokemonList = data,
        error: error => console.error(error)
      });
    } else {
      this.miServicio.getAllByType(this.selectedType).subscribe({
        next: data => this.pokemonList = data,
        error: error => console.error(error)
      })
    }
  }
}

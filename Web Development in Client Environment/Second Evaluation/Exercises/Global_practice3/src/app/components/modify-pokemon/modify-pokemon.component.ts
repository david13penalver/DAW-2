import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PokemonServiceService} from '../../services/pokemon-service.service';
import {Pokemons} from '../../interface/pokemons';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-modify-pokemon',
  imports: [
    FormsModule
  ],
  templateUrl: './modify-pokemon.component.html',
  styleUrl: './modify-pokemon.component.css'
})
export class ModifyPokemonComponent {

  constructor(
    private route:ActivatedRoute,
    private miServicio:PokemonServiceService,
    private router:Router
  ) {
  }

  pokemon!:Pokemons;
  updatedPokemon!:Pokemons;

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.miServicio.getById(id).subscribe({
      next: data => this.pokemon = data,
      error: error => console.error(error)
    });
  }

  modifyPokemon(pokemon:Pokemons) {
    this.updatedPokemon = pokemon;

    this.miServicio.put(this.pokemon.id, this.updatedPokemon).subscribe({
      next: data => this.router.navigate(['/pokemons']),
      error: error => console.error(error.status)
    })
  }
}

import { Component } from '@angular/core';
import {Pokemons} from '../../interface/pokemons';
import {PokemonServiceService} from '../../services/pokemon-service.service';
import {ActivatedRoute, RouterLink} from '@angular/router';

@Component({
  selector: 'app-view-pokemon',
  imports: [
    RouterLink
  ],
  templateUrl: './view-pokemon.component.html',
  styleUrl: './view-pokemon.component.css'
})
export class ViewPokemonComponent {

  constructor(
    private route:ActivatedRoute,
    private miServicio:PokemonServiceService) {
  }

  pokemon!:Pokemons;

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.miServicio.getById(id).subscribe({
      next: data => this.pokemon = data,
      error: error => console.error(error.status)
    })
  }

}

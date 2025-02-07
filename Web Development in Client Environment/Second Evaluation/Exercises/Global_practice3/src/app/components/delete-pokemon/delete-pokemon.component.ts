import { Component } from '@angular/core';
import {Pokemons} from '../../interface/pokemons';
import {ActivatedRoute, Router} from '@angular/router';
import {PokemonServiceService} from '../../services/pokemon-service.service';

@Component({
  selector: 'app-delete-pokemon',
  imports: [],
  templateUrl: './delete-pokemon.component.html',
  styleUrl: './delete-pokemon.component.css'
})
export class DeletePokemonComponent {
  pokemon!: Pokemons;

  constructor(
    private route:ActivatedRoute,
    private miServicio:PokemonServiceService,
    private router:Router
  ) {
  }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.miServicio.getById(id).subscribe({
      next: data => this.pokemon = data,
      error: error => console.error(error)
    });
  }

  delete() {
    this.miServicio.delete(this.pokemon.id).subscribe({
      next: () => this.router.navigate(['/pokemons']),
      error: error => console.error(error)
    });
  }

  cancel() {
    this.router.navigate(['/pokemons']);
  }
}

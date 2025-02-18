import { Component } from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {PokemonService} from '../../service/pokemon.service';
import {Pokemon} from '../../interface/pokemon';

@Component({
  selector: 'app-pokemon-view',
  imports: [
    RouterLink
  ],
  templateUrl: './pokemon-view.component.html',
  styleUrl: './pokemon-view.component.css'
})
export class PokemonViewComponent {

  constructor(
    private ruta:ActivatedRoute,
    private miServicio:PokemonService,
    private router:Router
  ) {
  }

  pokemon!:Pokemon;

  ngOnInit() {
    const id = Number(this.ruta.snapshot.paramMap.get('id'));

    this.miServicio.getById(id).subscribe({
      next: datos => this.pokemon = datos,
      error: error => console.log(error.status)
    });
  }

  eliminar(id:string) {
    this.miServicio.deleteById(id).subscribe({
      next: () => this.router.navigate(['/pokemons']),
      error: error => console.log(error.status)
    })
  }
}

import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Character } from '../../interface/character';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-character-detail',
  imports: [
    RouterLink
  ],
  templateUrl: './character-detail.component.html',
  styleUrl: './character-detail.component.css'
})
export class CharacterDetailComponent {

  character!: Character;

  constructor(private miRutaActiva: ActivatedRoute,
              private miServicio: CharacterService) {
  }

  ngOnInit() {
    this.miRutaActiva
      .params
      .subscribe(
        params => {
          this.miServicio.findById(params["id"]).subscribe(
            character => this.character = character
          );
        }
      );
  }
}

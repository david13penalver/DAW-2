import {Component, Input} from '@angular/core';
import {Pokemon} from '../../interface/pokemon';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-pokemon-item',
  imports: [
    RouterLink
  ],
  templateUrl: './pokemon-item.component.html',
  styleUrl: './pokemon-item.component.css'
})
export class PokemonItemComponent {
  @Input() pokemon!: Pokemon;

}

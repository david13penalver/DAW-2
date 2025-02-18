import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Character} from '../../interface/character';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-character-item',
  imports: [
    RouterLink
  ],
  templateUrl: './character-item.component.html',
  styleUrl: './character-item.component.css'
})
export class CharacterItemComponent {

  @Input() character!:Character;
  @Output() volverAtras = new EventEmitter<number>;
  @Output() verDetalles = new EventEmitter<number>;

  volver() {
    this.volverAtras.emit();
  }
}

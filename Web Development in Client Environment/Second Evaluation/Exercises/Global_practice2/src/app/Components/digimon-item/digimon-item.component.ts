import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Digimones, digimonesss} from '../../Interface/digimones';

@Component({
  selector: 'app-digimon-item',
  imports: [],
  templateUrl: './digimon-item.component.html',
  styleUrl: './digimon-item.component.css'
})
export class DigimonItemComponent {
  @Input() digimooooon!: Digimones;
  @Output() borrarDigimon = new EventEmitter;

  borrarUnDigimon(id:number) {
    this.borrarDigimon.emit(id);
  }

}

import {Component, Input} from '@angular/core';
import {Digimones, digimonesss} from '../../Models/digimones';
import {DigimonItemComponent} from '../digimon-item/digimon-item.component';

@Component({
  selector: 'app-digipedia',
  imports: [
    DigimonItemComponent
  ],
  templateUrl: './digipedia.component.html',
  styleUrl: './digipedia.component.css'
})
export class DigipediaComponent {
  digimonList: Digimones[] = digimonesss;

  deleteDigimon(id:number) {
    let pos = digimonesss.findIndex(d => d.id == id);
    digimonesss.splice(pos, 1);
  }

  addDigimon() {
    alert("botón clicado");
    let digimonNuevo: Digimones = {id: 10, name: "", chosenBoy: "", type: ""};
    digimonNuevo.id = 10;
    let digimonNuevoName = prompt('Name');
    if (digimonNuevoName == null)
      digimonNuevoName = ""
    digimonNuevo.name = digimonNuevoName;
    digimonesss.push(digimonNuevo);
  }
}

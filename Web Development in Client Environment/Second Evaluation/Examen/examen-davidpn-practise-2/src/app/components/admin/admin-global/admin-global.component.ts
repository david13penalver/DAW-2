import { Component } from '@angular/core';
import {Character} from '../../../interface/character';
import {CharacterService} from '../../../services/character.service';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-admin-global',
  imports: [
    RouterLink
  ],
  templateUrl: './admin-global.component.html',
  styleUrl: './admin-global.component.css'
})
export class AdminGlobalComponent {

  characters!:Character[];

  constructor(private miServicio:CharacterService) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.miServicio.getAll().subscribe({
      next: data => this.characters = data,
      error: error => console.error(error)
    });
  }
}

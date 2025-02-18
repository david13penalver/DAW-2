import { Component } from '@angular/core';
import {Character} from '../../interface/character';
import {CharacterService} from '../../services/character.service';
import {CharacterItemComponent} from '../character-item/character-item.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-character-list',
  imports: [
    CharacterItemComponent
  ],
  templateUrl: './character-list.component.html',
  styleUrl: './character-list.component.css'
})
export class CharacterListComponent {

  characters!:Character[];

  constructor(private miServicio:CharacterService, private miRuter:Router) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.miServicio.getAll().subscribe({
      next: data => this.characters = data,
      error: err => console.log(err)
    });
  };

  back($event: number) {
    this.miRuter.navigate(['/']);
  }
}

import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import {CharacterService} from '../../services/character.service';

@Component({
  selector: 'app-header',
  imports: [
    RouterLink
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  totalNumber!:number;

  constructor(private miServicio:CharacterService) {
  }

  ngOnInit() {
    this.cargar();
  }

  cargar() {
    this.miServicio.count().subscribe({
      next: data => this.totalNumber = data,
      error: error => console.error(error)
    })
  }

  incrementar() {
    this.totalNumber++;
  }

  decrementar() {
    this.totalNumber--;
  }

}

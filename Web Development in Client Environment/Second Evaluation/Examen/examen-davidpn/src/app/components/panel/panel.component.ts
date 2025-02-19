import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import {Tarea} from '../../models/tarea';
import {TareaService} from '../../services/tarea.service';
import {TareaComponent} from '../tarea/tarea.component';

@Component({
  selector: 'app-panel',
  imports: [
    RouterLink,
    TareaComponent
  ],
  templateUrl: './panel.component.html',
  styleUrl: './panel.component.css'
})
export class PanelComponent {

  tareas!:Tarea[];

  constructor(private miServicio:TareaService) {
  }

  ngOnInit() {
    this.miServicio.getAll().subscribe({
      next: datos => this.tareas = datos,
      error: err => console.log(err.status)
    });
  }

}

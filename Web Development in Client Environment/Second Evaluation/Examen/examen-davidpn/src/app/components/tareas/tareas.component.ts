import { Component } from '@angular/core';
import {Tarea} from '../../models/tarea';
import {TareaService} from '../../services/tarea.service';
import {FormsModule} from '@angular/forms';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-tareas',
  imports: [
    FormsModule,
    RouterLink
  ],
  templateUrl: './tareas.component.html',
  styleUrl: './tareas.component.css'
})
export class TareasComponent {

  tareas!:Tarea[];
  tareasFiltradas!:Tarea[];
  tareasPendientes:number = 0;
  tareasRealizadas:number = 0;
  selectedOption:string = "Todas";

  constructor(private miServicio:TareaService) {
  }

  ngOnInit() {
    this.cargar();
    console.log(this.selectedOption);
  }

  cargar() {
    this.miServicio.getAll().subscribe({
      next: datos => {
        this.tareas = datos
        this.tareasRealizadasMethod();
        this.tareasPendientesMethod();

        this.tareasFiltradas = this.tareas;
        console.log(this.tareasFiltradas);
      },
      error: err => console.log(err.status)
    });
  }

  onSelectChange() {
    if (this.selectedOption === "Todas") {
      this.tareasFiltradas = this.tareas;
    } else {
      this.tareasFiltradas = this.tareas.filter(tarea => tarea.estado === this.selectedOption);
    }
  }

  tareasPendientesMethod() {
    this.tareas.forEach(tarea => {
      if (tarea.estado == "Pendiente") {
        this.tareasPendientes++;
      }
    });
  };

  tareasRealizadasMethod() {
    this.tareas.forEach(tarea => {
      if (tarea.estado == "Realizada") {
        this.tareasRealizadas++;
      }
    })
  }

}

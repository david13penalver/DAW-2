import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TareaService} from '../../services/tarea.service';
import {Tarea} from '../../models/tarea';

@Component({
  selector: 'app-fin',
  imports: [],
  templateUrl: './fin.component.html',
  styleUrl: './fin.component.css'
})
export class FinComponent {
  tarea!:Tarea;

  constructor(private miRutaActivada:ActivatedRoute,
              private miServicio:TareaService,
              private miRuter:Router) {
  }

  ngOnInit() {
    this.miRutaActivada
      .params
      .subscribe(
        params => {
          this.miServicio.get(params["id"]).subscribe(
            tarea => this.tarea = tarea
          );
        }
      );
  }

  borrar(option: boolean) {
    if (option) {
      this.tarea.estado = "Realizada";
      this.miServicio.put(this.tarea).subscribe({
        next: tarea => this.miRuter.navigate(["/tareas"]),
        error: err => console.log(err.status)
      })
    } else {
      this.miRuter.navigate(["/tareas"]);
    };
  }
}

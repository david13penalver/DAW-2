import { Component } from '@angular/core';
import {BehaviorSubject, Subject} from 'rxjs';

@Component({
  selector: 'app-ejemplo-observables',
  imports: [],
  templateUrl: './ejemplo-observables.component.html',
  styleUrl: './ejemplo-observables.component.css'
})
export class EjemploObservablesComponent {

  mensajeBasico:Subject<string> = new Subject();

  mensaje: BehaviorSubject<string> = new BehaviorSubject("Valor inicial");

  miSuscripcion:any;

  suscribir() {
    alert("Suscribiendo al observable");
    this.miSuscripcion = this.mensaje.subscribe({
      next: dato => alert(dato),
      error: error => alert(error),
      complete: () => alert("Completado")
    })
  }

  emitir() {
    alert("Emitiendo valores por el observable");
    this.mensaje.next("Valor 1");
    this.mensaje.next("Valor 2");
    this.mensaje.next("Valor 3");
  }

  cancelar(){
    this.miSuscripcion.unsubscribe;
    alert("Suscripción cancelada al observable");
  }

  finalizar() {
    this.mensaje.complete();
    alert("Finalizado el observable");
  }
}

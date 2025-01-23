import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-hijo-para-hijo-padre',
  imports: [],
  templateUrl: './hijo-para-hijo-padre.component.html',
  styleUrl: './hijo-para-hijo-padre.component.css'
})
export class HijoParaHijoPadreComponent {

  @Output() mensajeParaPadre = new EventEmitter<string>();

  valorAMandarAPadre() {
    let mensaje: string | null;
    mensaje = prompt("Introduce un mensaje para el padre");
    if (mensaje == null)
      mensaje = "";
    this.mensajeParaPadre.emit(mensaje);
  }
}

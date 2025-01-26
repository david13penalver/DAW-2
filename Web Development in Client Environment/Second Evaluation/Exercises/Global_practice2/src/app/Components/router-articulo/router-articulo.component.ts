import {Component, EventEmitter, Input, Output} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {Articulo} from '../../Models/articulo';
import {ArticulosServiceService} from '../../Services/articulos-service.service';

@Component({
  selector: 'app-router-articulo',
  imports: [RouterLink],
  templateUrl: './router-articulo.component.html',
  styleUrl: './router-articulo.component.css'
})
export class RouterArticuloComponent {

  articulo!:Articulo;

  constructor(private miRutaActiva:ActivatedRoute, private miServicio:ArticulosServiceService) {
  }

  ngOnInit(){
    this.miRutaActiva
      .params
      .subscribe(params=>this.articulo=this.miServicio.getArticulo(params["id"]))
  }
}

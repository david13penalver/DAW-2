import { Component } from '@angular/core';
import {ArticulosServiceService} from '../../Services/articulos-service.service';
import {Articulo} from '../../Interface/articulo';

@Component({
  selector: 'app-articulos-con-servicios',
  imports: [],
  templateUrl: './articulos-con-servicios.component.html',
  styleUrl: './articulos-con-servicios.component.css'
})
export class ArticulosConServiciosComponent {
  articulos!:Articulo[];

  constructor(private miServicio:ArticulosServiceService) {
  }

  ngOnInit() {
    this.articulos = this.miServicio.getArticulos();
  }
}

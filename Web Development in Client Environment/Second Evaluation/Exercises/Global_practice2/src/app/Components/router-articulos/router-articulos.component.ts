import { Component } from '@angular/core';
import {Articulo} from '../../Models/articulo';
import {ArticulosServiceService} from '../../Services/articulos-service.service';
import {Router, RouterLink} from '@angular/router';

@Component({
  selector: 'app-router-articulos',
  imports: [
    RouterLink
  ],
  templateUrl: './router-articulos.component.html',
  styleUrl: './router-articulos.component.css'
})
export class RouterArticulosComponent {

  articulos!:Articulo[];

  constructor(private miServicio:ArticulosServiceService, private router:Router) {
  }

  ngOnInit() {
    this.articulos = this.miServicio.getArticulos();
  }

  volverAInicio() {
    this.router.navigate(['/']);
  }
}

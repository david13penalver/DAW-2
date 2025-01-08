import { Component } from '@angular/core';
import {Articulo, ARTICULOS} from '../../Models/articulo';

@Component({
  selector: 'app-articulo',
  imports: [],
  templateUrl: './articulo.component.html',
  styleUrl: './articulo.component.css'
})
export class ArticuloComponent {
  articulos:Array<Articulo>=ARTICULOS;
}

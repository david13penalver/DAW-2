import { Component } from '@angular/core';
import { ARTICULOS } from '../../Modelos/articulos';
import {Articulo} from '../../Modelos/articulo';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-articulos',
  imports: [
    FormsModule
  ],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {
  articulos:Array<Articulo>=ARTICULOS;
  articulo:Articulo = this.articulos[3];

  id:string="";

  comprar(articulo:Articulo) {
    console.log(articulo);
  }

  ver(){
    let art = this.articulos.find(articulo => articulo.id == this.id);
    if (art) {
      this.articulo = art;
    } else {
      alert("El artículo no existe");
    }
  }

  aumentar(){
    let art = this.articulos.find(a => a.id == this.articulo.id);
    if (art) {
      art.unidades++;
    } else {
      alert("El artículo no existe");
    }
  }

  disminuir(){
    let art = this.articulos.find(a => a.id == this.articulo.id);
    if ( art) {
      art.unidades--;
    } else {
      alert("El artículo no existe");
    }
  }

}

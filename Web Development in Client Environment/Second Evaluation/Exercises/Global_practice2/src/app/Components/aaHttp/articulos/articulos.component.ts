import { Component } from '@angular/core';
import {Articulos} from '../../../Interface/articulos';
import {ArticulosHttpService} from '../../../Services/articulos-http.service';
import {Articulo} from '../../../Interface/articulo';

@Component({
  selector: 'app-articulos',
  imports: [],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {

  articulos!: Articulos[];

  constructor(private miServicio: ArticulosHttpService) {  }

  ngOnInit() {
    this.cargar();
  }

  cargar() {
    this.miServicio.getAll().subscribe({
      next: datos => this.articulos = datos,
      error: error => console.log(error.status)
    })
  }

  ver(id: number) {
    this.miServicio.getById(id).subscribe({
      next: datos => console.log(datos),
      error: error => console.log(error.status)
    })

  }

  borrar(id: number) {
    this.miServicio.detele(id).subscribe({
      next: datos => console.log("Borrado jeje"),
      error: error => console.log(error.status)
    })
    this.cargar();
  }

  nuevo() {
    let articulo:Articulo = {
      id: Number(prompt('Id del artículo:') || 0),
      nombre: prompt('Nombre del artículo:') || '',
      descripcion: prompt('Descripción del artículo:') || '',
      precio: Number(prompt('Precio del artículo:') || 0)
    }
    this.miServicio.post(articulo).subscribe({
      next: datos => {
        console.log("Creado jeje");
        this.cargar();
      },
      error: error => console.log(error.status)
    })
  }

  modificar(articulo: Articulo) {
    let artModificado: Articulo = {
      id: articulo.id,
      nombre: prompt('Nuevo Nombre: ', articulo.nombre) || '',
      descripcion: prompt('Nueva Descripción: ', articulo.descripcion) || '',
      precio: Number(prompt('Nuevo Precio: ', articulo.precio.toString()) || 0)
    };
    this.miServicio.put(articulo.id, artModificado).subscribe({
      next: (dato) => {
        console.log('Articulo modificado');
        this.cargar();
      },
      error: (error) => console.log('Error ' + error.status),
    });
  }
}

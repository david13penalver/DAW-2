import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Articulo} from '../Interface/articulo';
import {Articulos} from '../Interface/articulos';

@Injectable({
  providedIn: 'root'
})
export class ArticulosHttpService {

  constructor(private miHttp:HttpClient) { }

  url:string = 'http://localhost:3000/articulos';

  getAll():Observable<Articulo[]> {
    return this.miHttp.get<Articulos[]>(this.url);
  }

  getById(id:number):Observable<Articulo> {
    return this.miHttp.get<Articulos>(this.url + '/' + id);
  }

  detele(id:number):Observable<Articulo>{
    return this.miHttp.delete<Articulo>(this.url + '/' + id);
  }

  post(articulo:Articulo):Observable<Articulo> {
    return this.miHttp.post<Articulo>(this.url, articulo);
  }

  put(id:number, articulo:Articulo):Observable<Articulo>{
    return this.miHttp.put<Articulo>(this.url + '/' + id, articulo);
  }

}

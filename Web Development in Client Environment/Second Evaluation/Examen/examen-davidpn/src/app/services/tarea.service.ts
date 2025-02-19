import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Tarea} from '../models/tarea';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  constructor(private miHttp:HttpClient) { }

  url:string = "http://localhost:3000/tareas";
  static password:string = "123";

  getAll():Observable<Tarea[]> {
    return this.miHttp.get<Tarea[]>(this.url);
  }

  get(id:string):Observable<Tarea> {
    return this.miHttp.get<Tarea>(this.url + "/" + id);
  }

  put(tarea:Tarea):Observable<Tarea> {
    return this.miHttp.put<Tarea>(this.url + "/" + tarea.id, tarea);
  }

  static getPassword() {
    return this.password;
  }
}

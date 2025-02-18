import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Book} from '../interface/book';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(private miHttp: HttpClient) { }

  url:string = "http://localhost:8080/api/games";

  getAll():Observable<Book[]> {
    return this.miHttp.get<Book[]>(this.url);
  }

  getById(id:number):Observable<Book>{
    return this.miHttp.get<Book>(`${this.url}/${id}`);
  }

  deleteById(id:string):Observable<Book>{
    return this.miHttp.delete<Book>(`${this.url}/${id}`);
  }

}

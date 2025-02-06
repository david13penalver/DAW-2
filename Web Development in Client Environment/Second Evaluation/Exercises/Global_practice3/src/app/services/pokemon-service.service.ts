import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pokemons} from '../interface/pokemons';

@Injectable({
  providedIn: 'root'
})
export class PokemonServiceService {

  constructor(private miHttp: HttpClient) { }

  url:string = "http://localhost:3000/pokemons";

  getAll():Observable<Pokemons[]> {
    return this.miHttp.get<Pokemons[]>(this.url);
  }

  getById(id:number):Observable<Pokemons> {
    return this.miHttp.get<Pokemons>(this.url + "/" + id);
  }

  delete(id:string):Observable<Pokemons> {
    return this.miHttp.delete<Pokemons>(this.url + "/" + id);
  }

  post(pokemon:Pokemons):Observable<Pokemons> {
    return this.miHttp.post<Pokemons>(this.url, pokemon);
  }

  put(id:number, pokemon:Pokemons):Observable<Pokemons> {
    return this.miHttp.put<Pokemons>(this.url + "/" + id, pokemon);
  }
}

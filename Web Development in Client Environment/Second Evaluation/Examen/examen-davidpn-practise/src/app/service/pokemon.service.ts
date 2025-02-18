import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Pokemon} from '../interface/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private miHttp: HttpClient) { }

  url: string = "http://localhost:3000/pokemons";

  getAll():Observable<Pokemon[]> {
    return this.miHttp.get<Pokemon[]>(this.url);
  }

  getAllByType(type:string) {
    return this.miHttp.get<Pokemon[]>(this.url)
      .pipe(
        map((pokemons:Pokemon[]) => pokemons.filter(pokemon => pokemon.type.toLowerCase() == type))
      );
  }

  getById(id:number):Observable<Pokemon>{
    return this.miHttp.get<Pokemon>(`${this.url}/${id}`);
  }

  deleteById(id:string):Observable<Pokemon>{
    return this.miHttp.delete<Pokemon>(`${this.url}/${id}`);
  }

  post(pokemon:Pokemon):Observable<Pokemon>{
    return this.miHttp.post<Pokemon>(this.url, pokemon);
  }

  put(id:string, pokemon:Pokemon):Observable<Pokemon>{
    return this.miHttp.put<Pokemon>(`${this.url}/${id}`, pokemon)
  }

}

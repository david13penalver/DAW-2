import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Character} from '../interface/character';
import {map, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  private url = "http://localhost:3000/mariobroscharacters";

  constructor(private miHttp:HttpClient) { }

  getAll():Observable<Character[]> {
    return this.miHttp.get<Character[]>(this.url);
  }

  findById(id:string):Observable<Character> {
    return this.miHttp.get<Character>(this.url + '/' + id);
  }

  post(character:Character):Observable<Character> {
    return this.miHttp.post<Character>(this.url, character);
  }

  put(id:string, character:Character):Observable<Character> {
    return this.miHttp.put<Character>(this.url + "/" + id, character);
  }

  deleteById(id:string):Observable<Character> {
    return this.miHttp.delete<Character>(this.url + "/" + id);
  }

  count() {
    return this.miHttp.get<Character[]>(this.url).pipe(
      map((characters:Character[]) => characters.length)
    )
  }

}

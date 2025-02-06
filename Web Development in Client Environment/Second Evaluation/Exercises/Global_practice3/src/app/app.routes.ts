import { Routes } from '@angular/router';
import {RouterInicioComponent} from './components/router-inicio/router-inicio.component';
import {RouterErrorComponent} from './components/router-error/router-error.component';
import {PokemonsComponent} from './components/pokemons/pokemons.component';
import {PokemonComponent} from './components/pokemon/pokemon.component';

export const routes: Routes = [
  {path: "", component: RouterInicioComponent},
  {path: "pokemons", component: PokemonsComponent},
  {path: "pokemons/:id", component: PokemonComponent},
  {path: "**", component: RouterErrorComponent}
];

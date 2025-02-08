import { Routes } from '@angular/router';
import {RouterInicioComponent} from './components/router-inicio/router-inicio.component';
import {RouterErrorComponent} from './components/router-error/router-error.component';
import {PokemonsComponent} from './components/pokemons/pokemons.component';
import {PokemonComponent} from './components/pokemon/pokemon.component';
import {DeletePokemonComponent} from './components/delete-pokemon/delete-pokemon.component';
import {ModifyPokemonComponent} from './components/modify-pokemon/modify-pokemon.component';
import {ViewPokemonComponent} from './components/view-pokemon/view-pokemon.component';

export const routes: Routes = [
  {path: "", component: RouterInicioComponent},
  {path: "pokemons", component: PokemonsComponent},
  {path: "pokemons/:id", component: ViewPokemonComponent},
  {path: "pokemons/delete/:id", component: DeletePokemonComponent},
  {path: "pokemons/modify/:id", component: ModifyPokemonComponent},
  {path: "**", component: RouterErrorComponent}
];

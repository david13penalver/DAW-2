import { Routes } from '@angular/router';
import {InicioComponent} from './components/inicio/inicio.component';
import {ErrorComponent} from './components/error/error.component';
import {PokemonListComponent} from './components/pokemon-list/pokemon-list.component';
import {PokemonDeleteComponent} from './components/pokemon-delete/pokemon-delete.component';
import {PokemonModifyComponent} from './components/pokemon-modify/pokemon-modify.component';
import {PokemonViewComponent} from './components/pokemon-view/pokemon-view.component';
import {inicioSesionGuard} from './guards/inicio-sesion.guard';
import {PokemonsTypeComponent} from './components/pokemons-type/pokemons-type.component';
import {BooksComponent} from './bookstore/books/books.component';

export const routes: Routes = [
  {path: "", component: InicioComponent},
  {path: "pokemons", component: PokemonListComponent},
  {path: "pokemons/:id", component: PokemonViewComponent,
    canActivate: [inicioSesionGuard]},
  {path: "pokemonss", component: PokemonsTypeComponent},
  {path: "pokemons/delete/:id", component: PokemonDeleteComponent},
  {path: "pokemons/modify/:id", component: PokemonModifyComponent},
  {path: "games", component: BooksComponent},
  {path: "**", component: ErrorComponent}
];

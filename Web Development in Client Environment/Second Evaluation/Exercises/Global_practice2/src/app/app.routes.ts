import { Routes } from '@angular/router';
import {RouterInicioComponent} from './Components/router-inicio/router-inicio.component';
import {RouterErrorComponent} from './Components/router-error/router-error.component';
import {RouterArticulosComponent} from './Components/router-articulos/router-articulos.component';
import {RouterArticuloComponent} from './Components/router-articulo/router-articulo.component';

export const routes: Routes = [
  {path: "", component: RouterInicioComponent},
  {path:"articulos", component:RouterArticulosComponent},
  {path:"articulos/:id", component:RouterArticuloComponent},
  {path: "**", component: RouterErrorComponent}

];

import { Routes } from '@angular/router';
import {RouterInicioComponent} from './Components/router-inicio/router-inicio.component';
import {RouterErrorComponent} from './Components/router-error/router-error.component';
import {RouterArticulosComponent} from './Components/router-articulos/router-articulos.component';
import {RouterArticuloComponent} from './Components/router-articulo/router-articulo.component';
import {RouterVerArticulosComponent} from './Components/router-ver-articulos/router-ver-articulos.component';
import {guard1Guard} from './guards/guard1.guard';
import {guard2Guard} from './guards/guard2.guard';

export const routes: Routes = [
  {path: "", component: RouterInicioComponent},
  {path:"articulos",
    component:RouterArticulosComponent,
  canActivate: [guard1Guard, guard2Guard]},
  {path:"articulos/:id", component:RouterArticuloComponent},
  {path: "verarticulos", component: RouterVerArticulosComponent},
  {path: "**", component: RouterErrorComponent}
];

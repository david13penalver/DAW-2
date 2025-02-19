import { Routes } from '@angular/router';
import {InicioComponent} from './components/inicio/inicio.component';
import {ErrorComponent} from './components/error/error.component';
import {TareasComponent} from './components/tareas/tareas.component';
import {FinComponent} from './components/fin/fin.component';
import {PanelComponent} from './components/panel/panel.component';
import {loginGuard} from './guards/login.guard';

export const routes: Routes = [
  {path: "", component: InicioComponent},
  {path: "tareas", component: TareasComponent},
  {path: "tareas/fin/:id", component: FinComponent},
  {path: "tareas/panel", component: PanelComponent,
  canActivate: [loginGuard]},
  {path: "tareas/panel/error", component: ErrorComponent},
  {path: "**", component: InicioComponent}
];

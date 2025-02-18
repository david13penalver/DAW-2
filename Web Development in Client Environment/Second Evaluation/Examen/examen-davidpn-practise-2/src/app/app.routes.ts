import { Routes } from '@angular/router';
import {InicioComponent} from './components/inicio/inicio.component';
import {ErrorComponent} from './components/error/error.component';
import {CharacterListComponent} from './components/character-list/character-list.component';
import {CharacterDetailComponent} from './components/character-detail/character-detail.component';
import {AdminGlobalComponent} from './components/admin/admin-global/admin-global.component';
import {AdminDeleteComponent} from './components/admin/admin-delete/admin-delete.component';
import {loginGuard} from './guards/login.guard';

export const routes: Routes = [
  {path: '', component: InicioComponent},
  {path: "characters", component: CharacterListComponent},
  {path: "characters/:id", component: CharacterDetailComponent},
  {path: "admin", component: AdminGlobalComponent,
  canActivate: [loginGuard],
  children: [
    {path: "delete/:id", component: AdminDeleteComponent}
  ]},
  {path: '**', component: ErrorComponent}
];

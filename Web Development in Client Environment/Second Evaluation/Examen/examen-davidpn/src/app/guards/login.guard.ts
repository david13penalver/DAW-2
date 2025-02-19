import {CanActivateFn, Router} from '@angular/router';
import {ErrorComponent} from '../components/error/error.component';
import {TareaService} from '../services/tarea.service';
import {inject} from '@angular/core';

export const loginGuard: CanActivateFn = (route, state) => {

  const password = prompt("Introduce la contraseña:");
  const correctPassword = TareaService.getPassword();
  const ruter = inject(Router);

  if (password == correctPassword) {
    return true;
  } else {
    ruter.navigate(["/tareas/panel/error"]);
    return false;
  };

};

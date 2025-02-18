import { CanActivateFn } from '@angular/router';

export const inicioSesionGuard: CanActivateFn = (route, state) => {
  const pass = prompt("Inserte contraseña:") || "";
  if (pass == "1") {
    return true;
  } else {
    alert("Contraseña incorrecta");
    return false;
  }
};

import { CanActivateFn } from '@angular/router';

export const guard1Guard: CanActivateFn = (route, state) => {
  let password = prompt("Inserte contraseña:");
  return (password == "1");


};

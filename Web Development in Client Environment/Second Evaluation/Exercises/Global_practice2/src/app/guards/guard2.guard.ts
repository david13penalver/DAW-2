import { CanActivateFn } from '@angular/router';

export const guard2Guard: CanActivateFn = (route, state) => {
  let date = new Date();
  let hour = date.getHours();
  return (hour >= 9 && hour <= 18);
};

import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { inicioSesionGuard } from './inicio-sesion.guard';

describe('inicioSesionGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => inicioSesionGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});

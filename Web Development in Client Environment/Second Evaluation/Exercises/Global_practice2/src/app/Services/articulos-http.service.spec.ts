import { TestBed } from '@angular/core/testing';

import { ArticulosHttpService } from './articulos-http.service';

describe('ArticulosHttpService', () => {
  let service: ArticulosHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArticulosHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

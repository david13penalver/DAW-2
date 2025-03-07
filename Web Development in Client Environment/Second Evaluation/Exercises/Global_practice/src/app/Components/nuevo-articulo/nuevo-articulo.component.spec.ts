import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoArticuloComponent } from './nuevo-articulo.component';

describe('NuevoArticuloComponent', () => {
  let component: NuevoArticuloComponent;
  let fixture: ComponentFixture<NuevoArticuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NuevoArticuloComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NuevoArticuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EjemploObservablesComponent } from './ejemplo-observables.component';

describe('EjemploObservablesComponent', () => {
  let component: EjemploObservablesComponent;
  let fixture: ComponentFixture<EjemploObservablesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EjemploObservablesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EjemploObservablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

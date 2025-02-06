import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterInicioComponent } from './router-inicio.component';

describe('RouterInicioComponent', () => {
  let component: RouterInicioComponent;
  let fixture: ComponentFixture<RouterInicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterInicioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RouterInicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

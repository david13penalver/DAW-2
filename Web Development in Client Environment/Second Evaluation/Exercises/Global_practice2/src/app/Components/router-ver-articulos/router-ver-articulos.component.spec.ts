import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterVerArticulosComponent } from './router-ver-articulos.component';

describe('RouterVerArticulosComponent', () => {
  let component: RouterVerArticulosComponent;
  let fixture: ComponentFixture<RouterVerArticulosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterVerArticulosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RouterVerArticulosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

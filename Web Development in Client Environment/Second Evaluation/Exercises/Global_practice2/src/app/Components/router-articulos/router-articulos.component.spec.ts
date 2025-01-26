import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterArticulosComponent } from './router-articulos.component';

describe('RouterArticulosComponent', () => {
  let component: RouterArticulosComponent;
  let fixture: ComponentFixture<RouterArticulosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterArticulosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RouterArticulosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

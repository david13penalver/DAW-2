import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterArticuloComponent } from './router-articulo.component';

describe('RouterArticuloComponent', () => {
  let component: RouterArticuloComponent;
  let fixture: ComponentFixture<RouterArticuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterArticuloComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RouterArticuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

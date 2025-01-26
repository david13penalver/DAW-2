import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticulosConServiciosComponent } from './articulos-con-servicios.component';

describe('ArticulosConServiciosComponent', () => {
  let component: ArticulosConServiciosComponent;
  let fixture: ComponentFixture<ArticulosConServiciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArticulosConServiciosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticulosConServiciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

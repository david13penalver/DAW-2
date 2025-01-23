import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HijoParaHijoPadreComponent } from './hijo-para-hijo-padre.component';

describe('HijoParaHijoPadreComponent', () => {
  let component: HijoParaHijoPadreComponent;
  let fixture: ComponentFixture<HijoParaHijoPadreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HijoParaHijoPadreComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HijoParaHijoPadreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

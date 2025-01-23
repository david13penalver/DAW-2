import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HijoParaBidireccionalComponent } from './hijo-para-bidireccional.component';

describe('HijoParaBidireccionalComponent', () => {
  let component: HijoParaBidireccionalComponent;
  let fixture: ComponentFixture<HijoParaBidireccionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HijoParaBidireccionalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HijoParaBidireccionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HijoParaPadreHijoComponent } from './hijo-para-padre-hijo.component';

describe('HijoParaPadreHijoComponent', () => {
  let component: HijoParaPadreHijoComponent;
  let fixture: ComponentFixture<HijoParaPadreHijoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HijoParaPadreHijoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HijoParaPadreHijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

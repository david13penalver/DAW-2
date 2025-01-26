import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigipediaComponent } from './digipedia.component';

describe('DigipediaComponent', () => {
  let component: DigipediaComponent;
  let fixture: ComponentFixture<DigipediaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DigipediaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DigipediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigimonItemComponent } from './digimon-item.component';

describe('DigimonItemComponent', () => {
  let component: DigimonItemComponent;
  let fixture: ComponentFixture<DigimonItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DigimonItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DigimonItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

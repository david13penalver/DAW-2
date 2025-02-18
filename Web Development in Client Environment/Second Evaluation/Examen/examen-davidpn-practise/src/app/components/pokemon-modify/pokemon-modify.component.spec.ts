import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonModifyComponent } from './pokemon-modify.component';

describe('PokemonModifyComponent', () => {
  let component: PokemonModifyComponent;
  let fixture: ComponentFixture<PokemonModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokemonModifyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokemonModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

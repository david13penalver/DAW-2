import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePokemonComponent } from './delete-pokemon.component';

describe('DeletePokemonComponent', () => {
  let component: DeletePokemonComponent;
  let fixture: ComponentFixture<DeletePokemonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeletePokemonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeletePokemonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

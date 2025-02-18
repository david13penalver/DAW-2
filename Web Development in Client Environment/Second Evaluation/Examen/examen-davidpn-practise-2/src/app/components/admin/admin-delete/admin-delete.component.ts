import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CharacterService} from '../../../services/character.service';

@Component({
  selector: 'app-admin-delete',
  imports: [],
  templateUrl: './admin-delete.component.html',
  styleUrl: './admin-delete.component.css'
})
export class AdminDeleteComponent {

  id!: any;

  constructor(private miRutaActivada:ActivatedRoute,
              private miServicio:CharacterService,
              private miRouter:Router) {
  }

  ngOnInit() {
    this.id = this.miRutaActivada.snapshot.paramMap.get('id');
  }

  delete(boolean: boolean) {
    if (boolean) {
      this.miServicio.deleteById(this.id).subscribe({
        next: data => {
          this.miRouter.navigate(['/admin']);
          //decrementar();
        },
        error: error => console.error(error)
      })
    } else {
      this.miRouter.navigate(['/admin']);
      console.log("Not deleted");
    }
  }
}

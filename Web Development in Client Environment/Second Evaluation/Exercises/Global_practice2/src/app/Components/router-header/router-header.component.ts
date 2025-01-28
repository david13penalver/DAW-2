import { Component } from '@angular/core';
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-router-header',
    imports: [
        RouterLink
    ],
  templateUrl: './router-header.component.html',
  styleUrl: './router-header.component.css'
})
export class RouterHeaderComponent {

  constructor(private miRouter:Router) {
  }
  verArticulos() {
    this.miRouter.navigate(["verarticulos"]
    ,{queryParams: {
      precio: 300,
          orden: 'asc'
        }});
  }
}

import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-router-header',
    imports: [
        RouterLink
    ],
  templateUrl: './router-header.component.html',
  styleUrl: './router-header.component.css'
})
export class RouterHeaderComponent {

}

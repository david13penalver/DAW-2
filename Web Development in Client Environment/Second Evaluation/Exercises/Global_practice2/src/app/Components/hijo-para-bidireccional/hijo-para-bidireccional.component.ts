import { Component } from '@angular/core';

@Component({
  selector: 'app-hijo-para-bidireccional',
  imports: [],
  templateUrl: './hijo-para-bidireccional.component.html',
  styleUrl: './hijo-para-bidireccional.component.css'
})
export class HijoParaBidireccionalComponent {

  articulos:Array<Object> = [
    {
      id: 1,
      name: "David"
    },
    {
      id: 2,
      name: "Iván"
    },
    {
      id: 3,
      name: "Asun"
    },
    {
      id: 4,
      name: "Ricardo"
    }
  ]


}

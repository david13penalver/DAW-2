import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-hijo-para-padre-hijo',
  imports: [],
  templateUrl: './hijo-para-padre-hijo.component.html',
  styleUrl: './hijo-para-padre-hijo.component.css'
})
export class HijoParaPadreHijoComponent {
  @Input() dato1!: number;

  @Input() dato2!: number;

}

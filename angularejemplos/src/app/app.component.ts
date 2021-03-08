import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularejemplos';
  euros = 5.123;
  objeto = { id: 5, texto: 'Yepa', pruebas: [ {id:1, texto: 'Uno'}, {id:2, texto:'Dos'}] };
}

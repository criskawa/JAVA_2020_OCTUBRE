import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-padre',
  templateUrl: './padre.component.html',
  styleUrls: ['./padre.component.css']
})
export class PadreComponent implements OnInit {

  valor: string;
  valorHijo: string;
  constructor() { }

  ngOnInit(): void {
  }

  textoCambiado(texto: string) {
    this.valorHijo = texto;
  }

}

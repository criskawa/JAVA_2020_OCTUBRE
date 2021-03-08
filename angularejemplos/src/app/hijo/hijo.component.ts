import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-hijo',
  templateUrl: './hijo.component.html',
  styleUrls: ['./hijo.component.css']
})
export class HijoComponent implements OnInit {

  @Input() valor: string;
  @Output() textoCambiado = new EventEmitter<string>();

  valorHijo: string;
  
  constructor() { }

  ngOnInit(): void {
  }

  notificarAPapa() {
    this.textoCambiado.emit(this.valorHijo);
  }

}

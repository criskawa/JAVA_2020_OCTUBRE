import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/modelos/cliente';
import { ClienteService } from 'src/app/servicios/cliente.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  constructor(public location: Location, private clienteService: ClienteService) { }

  ngOnInit(): void {
  }

  btnAceptar(id: number, nombre: string, apellidos: string, fechaNacimiento: object): void {
    const cliente: Cliente = {id, nombre, apellidos, fechaNacimiento};
    console.log(cliente);

    this.clienteService.post(cliente).subscribe(
      cliente => this.location.back()
    );
  }

}

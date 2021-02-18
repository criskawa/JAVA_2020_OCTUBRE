import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/modelos/cliente';
import { ClienteService } from 'src/app/servicios/cliente.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  clientes: Cliente[];

  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.cargarListado();
  }

  borrar(cliente: Cliente): void {
    if (confirm('¿Estás seguro de que quieres borrar el registro ' + cliente.id)) {
      this.clienteService.delete(cliente.id).subscribe(this.cargarListado.bind(this))
    }
  }

  cargarListado(): void {
    this.clienteService.get().subscribe(
      clientesRecibidos => this.clientes = clientesRecibidos);
  }

}

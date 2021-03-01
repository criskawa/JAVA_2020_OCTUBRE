import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Producto } from 'src/app/modelos/producto';
import { ProductoService } from 'src/app/servicios/producto.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];

  constructor(
    private productoService: ProductoService,
    private route: ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(param => {
      const id:number = +param.get('id');
      this.productoService.obtenerPorIdCategoria(id).subscribe(productos => this.productos = productos);
    });
  }

}

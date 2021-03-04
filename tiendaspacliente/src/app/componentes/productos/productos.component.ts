import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Categoria } from 'src/app/modelos/categoria';
import { Producto } from 'src/app/modelos/producto';
import { CategoriaService } from 'src/app/servicios/categoria.service';
import { ProductoService } from 'src/app/servicios/producto.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  nombre: string;
  categoria: number;
  
  categorias: Categoria[] = [];
  productos: Producto[] = [];

  constructor(
    private productoService: ProductoService,
    private categoriaService: CategoriaService,
    private route: ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.categoriaService.obtenerCategorias().subscribe(categorias => this.categorias = categorias);

    this.route.paramMap.subscribe(param => {
      const id:number = +param.get('id');
      this.productoService.obtenerPorIdCategoria(id).subscribe(productos => this.productos = productos);
    });
  }

  buscarPorNombreYCategoria() {
    let productos$: Observable<Producto[]>;
    
    if(this.categoria && this.nombre) {
      productos$ = this.productoService.obtenerPorNombreYCategoria(this.nombre, this.categoria);
    } else if(this.categoria && !this.nombre) {
      productos$ = this.productoService.obtenerPorIdCategoria(this.categoria);
    } else if(!this.categoria && this.nombre) {
      productos$ = this.productoService.obtenerPorNombre(this.nombre);
    } else {
      productos$ = this.productoService.obtenerTodos();
    }
    
    productos$.subscribe(productos => this.productos = productos);
  }

}

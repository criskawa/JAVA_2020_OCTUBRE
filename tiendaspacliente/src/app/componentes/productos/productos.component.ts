import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap, tap } from 'rxjs/operators';
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

  private sujeto = new Subject<void>(); // Escuchador y generador de eventos string

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

    this.sujeto.pipe(
      debounceTime(300),
      tap(dato => console.log(dato)),
      //distinctUntilChanged(),
      switchMap(
        //(nombre: string) 
        () => this.obtenerProductos() //this.productoService.obtenerPorNombre(nombre)
      ),
      tap(dato => console.log(dato)),
    ).subscribe(productos => this.productos = productos);
  }

  buscarPorNombreYCategoria() {
    this.sujeto.next();//this.nombre);
  }

  obtenerProductos(): Observable<Producto[]> {
    
    if(this.categoria && this.nombre) {
      return this.productoService.obtenerPorNombreYCategoria(this.nombre, this.categoria);
    } else if(this.categoria && !this.nombre) {
      return this.productoService.obtenerPorIdCategoria(this.categoria);
    } else if(!this.categoria && this.nombre) {
      return this.productoService.obtenerPorNombre(this.nombre);
    } else {
      return this.productoService.obtenerTodos();
    }
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Producto } from '../modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  
  private url: string = 'http://localhost:8080/api/productos/'

  constructor(private http: HttpClient) { }
  
  obtenerTodos(): Observable<Producto[]> {
    return this.http.get<any>(this.url + '?projection=productoConCategoria').pipe(
      //tap(datos => console.log(datos)),
      map(datos => datos._embedded.productos)
    );
  }
  
  obtenerPorIdCategoria(id: number): Observable<Producto[]> {
    return this.http.get<any>(this.url + 'search/findByCategoriaId?projection=productoConCategoria&id=' + id).pipe(
      //tap(datos => console.log(datos)),
      map(datos => datos._embedded.productos)
    );
  }

  obtenerPorNombre(nombre: string) : Observable<Producto[]> {
    return this.http.get<any>(`${this.url}search/findByNombreContaining?nombre=${nombre}&projection=productoConCategoria`).pipe(
      map(datos => datos._embedded.productos)
    );
  }
  
  obtenerPorNombreYCategoria(nombre: string, id: number)  : Observable<Producto[]> {
    return this.http.get<any>(`${this.url}search/findByNombreYCategoria?nombre=${nombre}&id=${id}&projection=productoConCategoria`).pipe(
      map(datos => datos._embedded.productos)
    );
  }
}

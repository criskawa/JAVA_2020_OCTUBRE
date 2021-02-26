import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../modelos/categoria';

import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private url: string = 'http://localhost:8080/api/categorias/'
  constructor(private http: HttpClient) { }

  public obtenerCategorias(): Observable<Categoria[]> {
    return this.http.get<any>(this.url).pipe(
      map(datos => datos._embedded.categorias)
    );
  }
}

import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Cliente, CLIENTE_VACIO } from '../modelos/cliente';
@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private url = 'http://localhost:3000/clientes/';

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  get(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.url).pipe(
      catchError(this.gestionarError<Cliente[]>('get', []))
    )
  }

  getPorId(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(this.url + id).pipe(
      catchError(this.gestionarError<Cliente>('getPorId', CLIENTE_VACIO))
    );
  }

  post(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.url, cliente, this.httpOptions).pipe(
      catchError(this.gestionarError<Cliente>('post', CLIENTE_VACIO))
    );
  }

  put(cliente: Cliente): Observable<Cliente> {
    console.log(this);
    return this.http.put<Cliente>(this.url + cliente.id, cliente, this.httpOptions).pipe(
      catchError(this.gestionarError<Cliente>('put', CLIENTE_VACIO))
    );
  }

  delete(id: number): Observable<Cliente> {
    return this.http.delete<Cliente>(this.url + id, this.httpOptions).pipe(
      catchError(this.gestionarError<Cliente>('delete', CLIENTE_VACIO))
    );
  }

  gestionarError<T>(operacion: string, resultado?: T) {
    return (error: HttpErrorResponse) => {
      alert('Ha habido un error en la operación ' + operacion);
      return of(resultado as T);
    };
  }
}

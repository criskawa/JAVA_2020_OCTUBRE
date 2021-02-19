import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../modelos/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private url = 'http://localhost:3000/clientes/';

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  constructor(private http: HttpClient) { }

  get() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.url);
  }

  getPorId(id: number) : Observable<Cliente> {
    return this.http.get<Cliente>(this.url + id);
  }

  post(cliente: Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>(this.url, cliente, this.httpOptions);
  }

  put(cliente: Cliente) : Observable<Cliente> {
    console.log(this);
    return this.http.put<Cliente>(this.url + cliente.id, cliente, this.httpOptions);
  }

  delete(id: number) : Observable<Cliente> {
    return this.http.delete<Cliente>(this.url + id, this.httpOptions);
  }
}

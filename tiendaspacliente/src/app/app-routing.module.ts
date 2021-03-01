import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductosComponent } from './componentes/productos/productos.component';

const routes: Routes = [
  { path: '', redirectTo: '/categorias', pathMatch: 'full' },
  { path: 'categorias/:id', component: ProductosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

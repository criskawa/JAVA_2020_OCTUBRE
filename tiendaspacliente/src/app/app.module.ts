import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './componentes/menu.component';

import { HttpClientModule } from '@angular/common/http';
import { ProductosComponent } from './componentes/productos/productos.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ProductosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

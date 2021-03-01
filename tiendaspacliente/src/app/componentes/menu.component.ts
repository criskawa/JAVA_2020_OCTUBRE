import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Categoria } from "../modelos/categoria";
import { CategoriaService } from "../servicios/categoria.service";

@Component({
    selector: 'app-menu',
    template: `
        <ul *ngFor="let categoria of categorias$ | async">
            <li><a routerLink="/categorias/{{categoria.id}}">{{categoria.nombre}}: {{categoria.descripcion}}</a></li>
        </ul>
        `,
    styles: [ 'ul { background: lightgray }' ]
})
export class MenuComponent implements OnInit {
    categorias$: Observable<Categoria[]>;
    categorias: Categoria[];
    
    constructor(public categoriaService: CategoriaService) {}
    
    ngOnInit(): void {
        this.categorias$ = this.categoriaService.obtenerCategorias(); //.subscribe(datos => this.categorias = datos);
    }


}
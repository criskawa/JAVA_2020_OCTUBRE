import { Component, OnInit } from "@angular/core";
import { CategoriaService } from "../servicios/categoria.service";

@Component({
    selector: 'app-menu',
    template: `
        <ul *ngFor="let categoria of categoriaService.obtenerCategorias() | async">
            <li>{{categoria.nombre}}</li>
            <li>{{categoria.descripcion}}</li>
        </ul>`,
    styles: [ 'ul { background: lightgray }' ]
})
export class MenuComponent {
    constructor(public categoriaService: CategoriaService) {}
}
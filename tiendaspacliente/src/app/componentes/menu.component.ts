import { Component, OnInit } from "@angular/core";
import { Categoria } from "../modelos/categoria";
import { CategoriaService } from "../servicios/categoria.service";

@Component({
    selector: 'app-menu',
    template: `
        <ul *ngFor="let categoria of categorias">
            <li>{{categoria.nombre}}: {{categoria.descripcion}}</li>
        </ul>
        `,
    styles: [ 'ul { background: lightgray }' ]
})
export class MenuComponent implements OnInit {
    categorias: Categoria[];
    
    constructor(public categoriaService: CategoriaService) {}
    
    ngOnInit(): void {
        this.categoriaService.obtenerCategorias().subscribe(datos => this.categorias = datos);
    }


}
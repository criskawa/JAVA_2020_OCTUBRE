// Generated by https://quicktype.io

import { Categoria } from "./categoria";

export interface Producto {
    id:              number;
    nombre:          string;
    descripcion:     string;
    precio:          number;
    categoria:       Categoria;
    fechaCaducidad:  Date;
    nombreCategoria: string;
    //_links:          Links;
}
/*
export interface Links {
    self:      Self;
    producto:  ProductoClass;
    categoria: ProductoClass;
}

export interface ProductoClass {
    href:      string;
    templated: boolean;
}

export interface Self {
    href: string;
}

*/
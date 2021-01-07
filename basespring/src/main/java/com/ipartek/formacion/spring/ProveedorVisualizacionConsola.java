package com.ipartek.formacion.spring;

public class ProveedorVisualizacionConsola implements ProveedorVisualizacion {
    private ProveedorMensajes proveedorMensajes;
    
    public void setProveedorMensajes(ProveedorMensajes proveedorMensajes) {
        this.proveedorMensajes = proveedorMensajes;
    }

    @Override
    public void visualizar() {
        System.out.println(proveedorMensajes.obtenerMensaje());
    }
    
}

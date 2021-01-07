package com.ipartek.formacion.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProveedorVisualizacionConsola implements ProveedorVisualizacion {
    private ProveedorMensajes proveedorMensajes;
    
    @Autowired
    public void setProveedorMensajes(ProveedorMensajes proveedorMensajes) {
        this.proveedorMensajes = proveedorMensajes;
    }

    @Override
    public void visualizar() {
        System.out.println(proveedorMensajes.obtenerMensaje());
    }
    
}

package com.ipartek.formacion.spring;

public class ProveedorVisualizacionConsolaAdornado extends ProveedorVisualizacionConsola {
    @Override
    public void visualizar() {
        System.out.println("------------");
        super.visualizar();
        System.out.println("------------");
    }
}

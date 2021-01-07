package com.ipartek.formacion.spring;

public class App {
    public static void main(String[] args) {

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        Fabrica fabrica = new Fabrica(path + "configuracion.properties");

        // ProveedorMensajes pm = fabrica.getProveedorMensajes(); // new
        // ProveedorMensajesConstante();
        ProveedorVisualizacion pv = fabrica.getProveedorVisualizacion(); // new ProveedorVisualizacionConsola(pm);

        pv.visualizar();
    }
}

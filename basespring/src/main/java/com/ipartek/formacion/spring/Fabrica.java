package com.ipartek.formacion.spring;

import java.io.FileInputStream;
import java.util.Properties;

public class Fabrica {
    private ProveedorMensajes proveedorMensajes;
    private ProveedorVisualizacion proveedorVisualizacion;

    public Fabrica(String pathConfiguracion) {
        
        try (FileInputStream fis = new FileInputStream(pathConfiguracion)){
            Properties properties = new Properties();
            properties.load(fis);

            String strMensajes = (String)properties.get("proveedores.mensajes");
            String strVisualizacion = (String)properties.get("proveedores.visualizacion");

            proveedorMensajes = (ProveedorMensajes) Class.forName(strMensajes).getDeclaredConstructor().newInstance();
            proveedorVisualizacion = (ProveedorVisualizacion) Class.forName(strVisualizacion).getDeclaredConstructor().newInstance();

            proveedorVisualizacion.setProveedorMensajes(proveedorMensajes);
        } catch (Exception e) {
           throw new RuntimeException("No se ha podido cargar los datos de configuración", e);
        }
    }

    public ProveedorVisualizacion getProveedorVisualizacion() {
        return proveedorVisualizacion;
    }

    public ProveedorMensajes getProveedorMensajes() {
        return proveedorMensajes;
    }
}

package com.ipartek.formacion.spring;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class ProveedorMensajesConsola implements ProveedorMensajes {

    @Override
    public String obtenerMensaje() {
        System.out.print("Por favor introduce el texto a mostrar: ");
        try(Scanner s = new Scanner(System.in)) {
            return s.nextLine();
        } catch(Exception e) {
            throw e;
        }
    }
    
}

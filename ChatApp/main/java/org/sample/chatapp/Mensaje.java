package org.sample.chatapp;

/**
 *@author kevin
 * 
 * Esta clase es la estructura del mensaje que se estará manipulando
 */
public class Mensaje {
    
    private String nombre, mensaje;

    public Mensaje() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }    
}

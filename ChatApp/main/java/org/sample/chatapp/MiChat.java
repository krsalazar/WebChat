package org.sample.chatapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *@author kevin
 * Esta clase se creó como websocket endpoint
 */
@ServerEndpoint(value = "/chatendpoint", encoders ={EncoderMensaje.class}, decoders = {DecoderMensaje.class})
public class MiChat {
    
//Lo que haremos será enviar un mensaje a todos los que esten conectados
//Para esto creamos una lista donde añadiremos a los usuarios conectados
    private static final List<Session> conectados = new ArrayList<>();
 
//En este método se van a agregar los usuarios que se conecten
    @OnOpen
    public void iniciar(Session sesion){
        //Agregamos los conectados a la lista de conectados
        conectados.add(sesion);
    }
 
//Cuando un usuario sale, lo eliminamos de la lista
    @OnClose
    public void salida(Session sesion){
        conectados.remove(sesion);
    }

//Este metodo envia el mensaje a los usuarios conectados
    @OnMessage
    public void mensajero(Mensaje mensaje) throws IOException, EncodeException{
        //Vamos a enviar un mensaje a todos los que esten conectados
        for(Session sesion : conectados){
            sesion.getBasicRemote().sendObject(mensaje);
        }
    }
    
}

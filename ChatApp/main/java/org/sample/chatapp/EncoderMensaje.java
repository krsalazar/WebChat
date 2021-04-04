package org.sample.chatapp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *@author kevin
 * 
 * El encoder convierte nuestro código a objeto Json para que pueda ser enviado
 */
public class EncoderMensaje implements Encoder.TextStream<Mensaje>{
    @Override
    public void encode(Mensaje t, Writer writer) throws EncodeException, IOException {
        //Se va a encargar de convertir el codigo a Json
        JsonObject json = Json.createObjectBuilder().add("nombre", t.getNombre()).add("mensaje", t.getMensaje()).build();
        try(JsonWriter jsonWriter = Json.createWriter(writer)){
            jsonWriter.writeObject(json);
        
        }
    }

    @Override
    public void init(EndpointConfig ec) {
        //En caso se necesite inicializar una variable 
    }

    @Override
    public void destroy() {
        //Si se necesita hacer algo al destruir el procedimiento
    }    
}

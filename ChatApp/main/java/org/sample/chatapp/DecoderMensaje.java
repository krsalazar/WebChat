package org.sample.chatapp;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *@author kevin
 * 
 * El decoder traduce el objeto Json
 */
public class DecoderMensaje implements Decoder.TextStream<Mensaje>{
    
    @Override
    public Mensaje decode(Reader reader) throws DecodeException, IOException {
        Mensaje mensaje = new Mensaje();
        try(JsonReader jsonReader = Json.createReader(reader)){
            JsonObject json = jsonReader.readObject();
            mensaje.setNombre(json.getString("nombre"));
            mensaje.setMensaje(json.getString("mensaje"));
        }
        return mensaje;
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
    
}

//Contiene las funciones que permitirán interactuar con el navegador

//URL para conectaarse al chat http://localhost:8080/ChatApp/
var url = 'ws://'+document.location.host + document.location.pathname+'chatendpoint';
//Se obtienen los elementos del html que contiene la interfaz
var ws = new WebSocket(url),
    mensajes = document.getElementById('conversacion'),
    boton = document.getElementById('btnEnviar'),
    nombre = document.getElementById('usuario'),
    mensaje = document.getElementById('mensaje');
ws.onopen = onOpen;
ws.onclose = onClose;
ws.onmessage = onMessage;
//Se agrega la acción al botón
boton.addEventListener('click', enviar);

function onOpen(){
//Al conectarse, muestra un mensaje en la consola del navegador
    console.log('Conectado...');
}
function onClose(){
//Al desconectarse, muestra un mensaje en la consola del navegador
    console.log('Desconectado...');
}
function enviar(){
//Esta funcion toma los valores que se ingresaron en la interfaz y los envia
    var msg = {
      nombre:nombre.value,
      mensaje: mensaje.value
    };
    ws.send(JSON.stringify(msg));
    mensaje.value = "";
}
function onMessage(evento){
//Cuando recibe el mensaje, lo muestra en la pantalla
    var obj = JSON.parse(evento.data),
            msg = 'Usuario:'+ ' ' +obj.nombre+' '+'dice:'+' '+obj.mensaje + '<br/>';
    mensajes.innerHTML += msg;
}


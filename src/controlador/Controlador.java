/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import mundo.Codificacion;
import mundo.HelloSocket;

/**
 *
 * @author ACER
 */
public class Controlador {

    Codificacion cod;
    HelloSocket socket;

    public Controlador() {
        socket = new HelloSocket();
        cod = new Codificacion(socket);
    }

    public void iniciar() {
        cod.codificar();
    }

    public void agregarIp(String ip) {
        socket.agregarIp(ip);
    }

}

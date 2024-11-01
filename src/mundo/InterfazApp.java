/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author ACER
 */
public class InterfazApp {

    public static void main(String[] args) {
        Ascii diccionario = new Ascii();
        HelloSocket socket = new HelloSocket();
        Codificacion cod = new Codificacion(diccionario, socket);
        cod.codificar("wabba-wabba-wabba-wabba-woo-woo-woo");
    }
}

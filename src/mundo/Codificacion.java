/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author David
 */
public class Codificacion {

    private String pe;
    private String se;
    private String ps;
    
    private String[] textoArr;
    private Ascii diccionario;
    private HelloSocket socket;
    private String texto;

    public Codificacion(HelloSocket socket) {
        diccionario = new Ascii();
        texto = diccionario.getTexto();
        this.socket = socket;
    }

    public void codificar() {
        textoArr = texto.split("");
        pe = textoArr[0];
        System.out.println(se);

        for (int i = 0; i <= texto.length() - 1; i++) {
            if (i == texto.length() - 1) {
                System.out.println("Se envia " + String.valueOf(diccionario.getIndex(pe)));
                socket.socket(String.valueOf(diccionario.getIndex(pe))); //si es la ultima iteracion se codifica pe
                break;
            }
            se = textoArr[i + 1];
            ps = pe + se;
            if (!diccionario.contains(ps)) {
                diccionario.put(ps);
                System.out.println("Se envia " + String.valueOf(diccionario.getIndex(pe)));
                socket.socket(String.valueOf(diccionario.getIndex(pe)));
                pe = se;
            } else {
                pe = ps;
            }
        }

    }
}

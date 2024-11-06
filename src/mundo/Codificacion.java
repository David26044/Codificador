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

    public Codificacion() {
        diccionario = new Ascii();
        socket = new HelloSocket();
        texto = diccionario.getTexto();
    }

    public void codificar() {
        String cd_codificada = "";
        textoArr = texto.split("");
        pe = textoArr[0];
        System.out.println(se);

        for (int i = 0; i <= texto.length() - 1; i++) {
            if (i == texto.length() - 1) {
                socket.socket(String.valueOf(diccionario.getIndex(pe)));
                break;
            }
            se = textoArr[i + 1];
            ps = pe + se;
            if (!diccionario.contains(ps)) {
                diccionario.put(ps);
                socket.socket(String.valueOf(diccionario.getIndex(pe)));
                pe = se;
            } else {
                pe = ps;
            }
        }

    }
}

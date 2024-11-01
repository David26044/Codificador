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
    private String[] texto;
    private StringBuilder codigo;
    private Ascii diccionario;
    private HelloSocket socket;

    public Codificacion(Ascii diccionario, HelloSocket socket) {
        codigo = new StringBuilder();
        this.diccionario = diccionario;
        this.socket = socket;
    }

    public void codificar(String texto) {
        this.texto = texto.split("");
        String cd_codificada = "";
        pe = this.texto[0];
        System.out.println(se);

        for (int i = 0; i <= texto.length() - 1; i++) {
            if (i == texto.length() - 1) {
                codigo.append(diccionario.contains(pe));
                socket.socket(String.valueOf(diccionario.contains(pe)));
                System.out.println("Se envió: " + String.valueOf(diccionario.contains(pe)));
                break;
            }
            se = this.texto[i + 1];
            ps = pe + se;
            if (diccionario.contains(ps) == -1) {
                diccionario.put(ps);
                socket.socket(String.valueOf(diccionario.contains(pe)));
                codigo.append(diccionario.contains(pe) + ",");
                System.out.println("Se envio: " +  String.valueOf(diccionario.contains(pe)));
                pe = se;
            } else {
                pe = ps;
            }
        }
        cd_codificada = codigo.toString();//este era el retorno
        System.out.println(cd_codificada);
    }
}

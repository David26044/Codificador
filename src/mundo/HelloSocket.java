/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class HelloSocket implements Runnable {

    private List<String> ips;

    /* Constructor */
    public HelloSocket() {
        ips = new ArrayList<String>();
        Thread treadListener = new Thread(this);
        treadListener.start();
    }

    /* Client:Data >> Socket >> Server */
    public void socket(String msg) {
        try {
            ips.add("172.16.128.182");
            for (String ip : ips) {
                Socket client = new Socket(ip, 5000); // portSend 5000
                DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());
                outBuffer.writeUTF(msg);
                client.close();
            }
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Client: socket(1) : UnknownHostException: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client: socket(2) : IOException: " + e.getMessage());
        }
    }

    @Override
    /* Client: Listen */
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;

        try {
            serverSocket = new ServerSocket(5050); // portListen 5050

            while (true) {
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
                String msg = inDataBuffer.readUTF();
                System.out.println(msg);
                socket.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
        }
    }

    public void agregarIp(String ip) {
        ips.add(ip);
    }
}

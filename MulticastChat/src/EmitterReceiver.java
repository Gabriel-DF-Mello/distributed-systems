
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class EmitterReceiver {
    
    InetAddress group;
    MulticastSocket s;
    int port = 3456;
    String address = "239.1.2.3";
    JTextField sender;
    JTextArea log;
    String user;
    
    ComunicadorUDP com = new ComunicadorUDP();

    class Receiver extends Thread {

        public void run() {
            while (true) {
                try {

                    DatagramPacket pacote = com.receiveMessage(s);

                    String msgRecebida = new String(pacote.getData(), 0, pacote.getLength());
                    
                    log.append(msgRecebida);
                } catch (Exception e) {
                }
            }
        }
    }

    public void sendMessage()
    {
        try 
        {
            String msg = "";
            msg = "[" +  user + "]: " +  sender.getText() + "\n";
            DatagramPacket pacote = com.makeMessage(msg, address, port);

            s.send(pacote);
            
            sender.setText("");
        } catch (Exception e) {

        }
    }

    public EmitterReceiver(String user, String address, int port, JTextField sender, JTextArea log) {
        try {
            this.user = user;
            this.sender = sender;
            this.log = log;
            
            if(!address.equals("")){
                this.address = address;
            }
            
            if(port > 0){
                this.port = port;
            }
            
            group = InetAddress.getByName(this.address);
            s = new MulticastSocket(this.port);
            s.joinGroup(group);
            
            Receiver tR = new Receiver();
            tR.start();
            
        } catch (Exception e) {
        }
    }
}

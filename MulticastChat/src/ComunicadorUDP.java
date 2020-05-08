
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
class ComunicadorUDP {
    
    public ComunicadorUDP() {}

    public DatagramPacket makeMessage(String message, String ip, int port) {
        try {
            byte[] buffer = message.getBytes();
            DatagramPacket pkg = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port);
            return pkg;
        } catch (UnknownHostException ex) {
            return null;
        }
    }
	
	public void sendMessage(DatagramSocket s, DatagramPacket pkg) {
        try {
            s.send(pkg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DatagramPacket receiveMessage(DatagramSocket s) {
        try {
            //cria um pacote vazio de 512 bytes
            DatagramPacket pkg = new DatagramPacket(new byte[512], 512);
            s.receive(pkg);
            return pkg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

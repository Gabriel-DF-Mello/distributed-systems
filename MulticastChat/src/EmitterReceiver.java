
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    int port = 2345;
    String address = "224.0.0.1";
    JTextField sender;
    JTextArea log;
    String user;
    int events;
    int event_rate = 10; // Event occurs 1 in r times
    int message_rate = 20; // Message occurs 1 in r times
    
    ComunicadorUDP com = new ComunicadorUDP();

    class Receiver extends Thread {
    	EmitterReceiver er;
        public Receiver(EmitterReceiver emitterReceiver) {
			this.er = emitterReceiver;
		}

		public void run() {
            while (true) {
                try {
                    DatagramPacket pacote = com.receiveMessage(s);

                    String msgRecebida = new String(pacote.getData(), 0, pacote.getLength());
                    
                    System.out.println(msgRecebida);
                    
                    String name = msgRecebida.substring(msgRecebida.indexOf("[") + 1);
                    name = name.substring(0, name.indexOf(":"));
                    
                    if(!name.equals(user)) {
                    	er.events += 1;
                    }
                    
                    log.append(msgRecebida);
                    
                } catch (Exception e) {
                	System.out.println(e);
                }
            }
        }
    }
    
    class EventGenerator implements Runnable {
    	EmitterReceiver er;
        public EventGenerator(EmitterReceiver emitterReceiver) {
			this.er = emitterReceiver;
		}

		public void run() {
            try {
            	Random rand = new Random();
            	
            	int evnum = rand.nextInt(event_rate);
            	
            	if(evnum == 0) {
            		er.events += 1;
            		er.log.append("Ocorreu um evento aleatório!\n");
            	}
            	
            	int msgnum = rand.nextInt(event_rate);
            	
            	if(msgnum == 0) {
            		er.sendRandomMessage();
            	}
            	
            } catch (Exception e) {
            	System.out.println(e);
            }
        }
    }

    public void sendMessage()
    {
        try 
        {
            String msg = "";
            msg = "[" +  user + ":" + this.events +"] - " +  sender.getText() + "\n";
            DatagramPacket pacote = com.makeMessage(msg, address, port);
            
            s.send(pacote);
            
            this.events += 1;
            
            sender.setText("");
        } catch (Exception e) {

        }
    }
    
    public void sendRandomMessage()
    {
        try 
        {
            String msg = "";
            msg = "[" +  user + ":" + this.events +"] - " +  "PING" + "\n";
            DatagramPacket pacote = com.makeMessage(msg, address, port);
            
            s.send(pacote);
            
            this.events += 1;
            
        } catch (Exception e) {

        }
    }

    public EmitterReceiver(String user, String address, int port, JTextField sender, JTextArea log) {
        try {
        	
            this.user = user;
            this.sender = sender;
            this.log = log;
            this.events = 1;
            
            this.address = "224.0.0.1";
 
            this.port = 2345;
            
            group = InetAddress.getByName(this.address);
            s = new MulticastSocket(this.port);
            s.joinGroup(group);

            log.append("Connected!\n");
            
            Receiver tR = new Receiver(this);
            tR.start();
            
            EventGenerator evnt = new EventGenerator(this);
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(evnt, 0, 1, TimeUnit.SECONDS);
            
        } catch (Exception e) {
        	System.out.println(e);
        }
    }
}

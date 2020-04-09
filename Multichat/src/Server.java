
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Server {
    
    String HOST_URL = "rmi://localhost/Messenger";
    
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Messenger msg = new Messenger();
            Naming.bind(HOST_URL, msg);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String[] args) {
        new Server();
    }
}


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Messenger extends UnicastRemoteObject implements IMessenger {
    ArrayList<String> messages;
    public Messenger() throws RemoteException{
        messages = new ArrayList<String>();
    }

    @Override
    public void addMessage(String sender, String message) throws RemoteException {
        messages.add("[" + sender + "]: " + message);
    }

    @Override
    public String returnLog() throws RemoteException {
        String log = "";
        for (String message:messages){
            log += message + "\n";
        }
        return log;
    }
}

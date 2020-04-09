
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public interface IMessenger extends Remote {
    public void addMessage(String sender, String message) throws RemoteException;
    public String returnLog() throws RemoteException;
}

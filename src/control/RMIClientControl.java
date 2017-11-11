/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import model.User;
import view.LoginFrm;


public class RMIClientControl implements RMIInterface{

    private String serverHost = "localhost";
    private int serverPort = 6666;
    private RMIInterface rmiServer;
    private Registry registry;
    private String rmiService = "rmiService";

    public RMIClientControl() throws RemoteException {
        try {

            registry = LocateRegistry.getRegistry(serverHost,serverPort);
            rmiServer = (RMIInterface) (registry.lookup(rmiService));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public boolean checkLogin(User user) throws RemoteException {
        return rmiServer.checkLogin(user);
    }
    
    public static void main(String[] args) {
        try {
            RMIClientControl ctr = new RMIClientControl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        LoginFrm view = new LoginFrm();
//        view.setVisible(true);
    }
}
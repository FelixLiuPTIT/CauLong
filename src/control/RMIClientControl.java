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
import model.Doi;
import model.NoiDung;
import model.QuocGia;
import model.San;
import model.User;
import model.VanDongVien;
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

    @Override
    public QuocGia[] getListQuocGia() throws RemoteException {
        return rmiServer.getListQuocGia();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean themVDV(VanDongVien v) throws RemoteException {
        return rmiServer.themVDV(v);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NoiDung[] getNoiDungList() throws RemoteException {
        return rmiServer.getNoiDungList();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean themSan(San s) throws RemoteException {
        return rmiServer.themSan(s);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean themDoi(Doi d) throws RemoteException {
        return rmiServer.themDoi(d);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VanDongVien[] searchVDVbyQuocGia(int idquocgia, int gioitinh) throws RemoteException{
        return rmiServer.searchVDVbyQuocGia(idquocgia,gioitinh);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addVanDongVienDoi(VanDongVien v, int maxid) throws RemoteException {
        return rmiServer.addVanDongVienDoi(v, maxid);
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int maxIdDoi() throws RemoteException {
        return rmiServer.maxIdDoi();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
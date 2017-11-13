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
import model.TranDau;
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
    public NoiDung[] getNoiDungList() {
        try {
            return rmiServer.getNoiDungList();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public San[] getSanList() {
        try {
            return rmiServer.getSanList();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public QuocGia[] getListQuocGia(){
        try {
            return rmiServer.getListQuocGia();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TranDau[] getTranDauList() {
        try {
            return rmiServer.getTranDauList();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean themTranDau(TranDau td){
        try {
            return rmiServer.themTranDau(td);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean themVDV(VanDongVien v) throws RemoteException {
        return rmiServer.themVDV(v);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public VanDongVien[] searchVDVbyQuocGia(int idquocgia, int gioitinh){
        try {
            return rmiServer.searchVDVbyQuocGia(idquocgia, gioitinh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    
    public boolean dangKyThiDauCaNhan(TranDau td) {
        try {
             return rmiServer.dangKyThiDauCaNhan(td);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
     }

    @Override
    public boolean checkDangKyVanDongVien(TranDau td) {
        try {
             return rmiServer.checkDangKyVanDongVien(td);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Doi[] getDoiByNoiDung(NoiDung nd) {
        try {
            return rmiServer.getDoiByNoiDung(nd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean dangKyThiDauDoi(TranDau td) {
        try {
             return rmiServer.dangKyThiDauDoi(td);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
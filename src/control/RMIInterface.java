/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Doi;
import model.NoiDung;
import model.QuocGia;
import model.San;
import model.TranDau;
import model.User;
import model.VanDongVien;

/**
 *
 * @author HIEU
 */
public interface RMIInterface extends Remote{
    
    public boolean checkLogin(User user) throws RemoteException;
    public NoiDung [] getNoiDungList() throws RemoteException;
    public QuocGia[] getListQuocGia() throws RemoteException;
    public San [] getSanList() throws RemoteException;
    public TranDau [] getTranDauList() throws RemoteException;
    public boolean themTranDau(TranDau td) throws RemoteException;
    public boolean themVDV(VanDongVien v) throws RemoteException;
    public boolean themSan(San s) throws RemoteException;
    public boolean themDoi(Doi d) throws RemoteException;
    public VanDongVien[] searchVDVbyQuocGia(int idquocgia, int gioitinh) throws RemoteException;
    public boolean addVanDongVienDoi(VanDongVien v, int maxid) throws RemoteException;
    public int maxIdDoi() throws RemoteException;
    
    public boolean dangKyThiDauCaNhan(TranDau td) throws RemoteException;
    
    public boolean dangKyThiDauDoi(TranDau td) throws RemoteException;
    
    public boolean checkDangKyVanDongVien(TranDau td) throws RemoteException;
    
    public Doi [] getDoiByNoiDung(NoiDung nd) throws RemoteException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RMIClientControl;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NoiDung;
import model.San;
import model.TranDau;

/**
 *
 * @author HIEU
 */
public class ThemTranDauFrm extends javax.swing.JFrame implements MouseListener {

    private RMIClientControl clientCtr;
    private NoiDung [] listND = null;
    private San [] listSan = null;
    private TranDau [] listTD = null;
    private ArrayList<JButton> listBtnUpdate;
    /**
     * Creates new form ThemTranDauFrm
     */
    public ThemTranDauFrm() {
        try {
            clientCtr = new RMIClientControl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        tbLich.addMouseListener(this);
        initListNoiDung();
        initListVong();
        initListCap(1);
        initListSan();
        initThoiGianList();
        initListTranDau();
    }
    
    private void initListNoiDung() {
        listND = clientCtr.getNoiDungList();
        cbNoiDung.removeAllItems();
        for(NoiDung n : listND) {
            cbNoiDung.addItem(n.getTen().toString());
        }
    }
    
    private void initListVong() {
        cbVong.removeAllItems();
        cbVong.addItem("Vong 1");
        cbVong.addItem("Vong 2");
        cbVong.addItem("Vong 3 (Ban ket)");
        cbVong.addItem("Vong 4 (Chung ket)");
    }
    
    private void initListCap(int vong) {
        cbCap.removeAllItems();
        int soCap = 16 / vong / 2;
        if(vong == 4)
            soCap = 1;
        for(int i=1; i<= soCap; i++) {
            cbCap.addItem("Cap " + i);
        }
    }
    
    private void initListSan() {
        listSan = clientCtr.getSanList();
        cbSan.removeAllItems();
        for(San s : listSan) {
            cbSan.addItem(s.getTen());
        }
    }
    
    private void initThoiGianList() {
        cbThoiGian.removeAllItems();
        cbThoiGian.addItem("8:00");
        cbThoiGian.addItem("11:00");
        cbThoiGian.addItem("13:00");
        cbThoiGian.addItem("15:00");
        cbThoiGian.addItem("17:00");
    }
    
    private void initNgay(int vong){
        switch(vong) {
            case 1:
                txtNgay.setText("11-11-2017");
                break;
            case 2:
                txtNgay.setText("12-11-2017");
                break;
            case 3:
                txtNgay.setText("13-11-2017");
                break;
            case 4:
                txtNgay.setText("14-11-2017");
                break;
        }
    }
    
    private void initDiemThuong(int vong) {
        switch(vong) {
            case 1:
                txtDiem.setText("10");
                break;
            case 2:
                txtDiem.setText("50");
                break;
            case 3:
                txtDiem.setText("100");
                break;
            case 4:
                txtDiem.setText("1000");
                break;
        }
    }
    
    private void initListTranDau() {
        listTD = clientCtr.getTranDauList();
        listBtnUpdate = new ArrayList<JButton>();
        if(listTD != null) {
            DefaultTableModel model = (DefaultTableModel)tbLich.getModel();
            tbLich.setDefaultRenderer(Object.class, new ButtonRender());
            model.setRowCount(0);
            for(TranDau td: listTD) {
                JButton btn = new JButton();
                if(td.getNoiDung().getId() < 3) {
                    if(td.getListDangKyCN() != null) {
                        btn.setText("Xem chi tiết");
                    }
                    else {
                        btn.setText("Đăng ký vận động viên");
                    }
                }
                else {
                    if(td.getListDangKyDoi() != null) {
                        btn.setText("Xem chi tiết");
                    }
                    else {
                        btn.setText("Đăng ký đôi");
                    }
                }
                listBtnUpdate.add(btn);
                Object[] o = new Object[]{td.getId(), td.getNoiDung().getTen(),
                                            td.getVong(),
                                            td.getCap(),
                                            td.getSan().getTen(),
                                            td.getThoiGian(),
                                            td.getDiemThuong(), btn};
                model.addRow(o);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbVong = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbCap = new javax.swing.JComboBox<>();
        cbNoiDung = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbSan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbThoiGian = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLich = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        txtNgay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Thêm trận đấu");

        jLabel2.setText("Nội dụng");

        jLabel3.setText("Vòng");

        cbVong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbVong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVongItemStateChanged(evt);
            }
        });

        jLabel4.setText("Cặp số");

        cbCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbNoiDung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Sân thi đấu");

        cbSan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Ngày");

        jLabel7.setText("Thời gian");

        cbThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Điểm thưởng");

        txtDiem.setEnabled(false);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Lịch thi đấu");

        tbLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID trận đấu", "Nội dung", "Vòng", "Cặp", "Sân thi đấu", "Thời gian", "Điểm thưởng", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLich);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtNgay.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSan, javax.swing.GroupLayout.Alignment.LEADING, 0, 193, Short.MAX_VALUE)
                            .addComponent(cbThoiGian, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(255, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbVong, 0, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(325, 325, 325))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(330, 330, 330))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbVong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnThem)
                .addGap(48, 48, 48)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Xu ly khi click vao vong thi hien cac cap tuong ung
    private void cbVongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVongItemStateChanged
        // TODO add your handling code here:
        int vong = cbVong.getSelectedIndex() + 1;
        switch(vong) {
            case 1:
                initListCap(1);
                initNgay(1);
                initDiemThuong(1);
                break;
            case 2:
                initListCap(2);
                initNgay(2);
                initDiemThuong(2);
                break;
            case 3:
                initListCap(3);
                initNgay(3);
                initDiemThuong(3);
                break;
            case 4:
                initListCap(4);
                initNgay(4);
                initDiemThuong(4);
                break;
        }
    }//GEN-LAST:event_cbVongItemStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        initListTranDau();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateString = txtNgay.getText() + " " + cbThoiGian.getSelectedItem().toString() + ":00";
        try {
            java.util.Date utilDate = format.parse(dateString);
            java.sql.Timestamp thoiGian = new java.sql.Timestamp(utilDate.getTime());
            
            
            TranDau td = new TranDau();
            NoiDung nd = listND[cbNoiDung.getSelectedIndex()];
            San san = listSan[cbSan.getSelectedIndex()];
            int vong = cbVong.getSelectedIndex() + 1;
            int cap = cbCap.getSelectedIndex() + 1;
            boolean isTeam = cbNoiDung.getSelectedIndex() > 1;
            td.setNoiDung(nd);
            td.setSan(san);
            td.setVong(vong);
            td.setCap(cap);
            td.setDiemThuong(Integer.parseInt(txtDiem.getText()));
            td.setThoiGian(thoiGian);
            td.setIsTeam(isTeam);
            
            if(clientCtr.themTranDau(td)) {
                JOptionPane.showMessageDialog(null, "Them thanh cong");
                //dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Them khong thanh cong");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemTranDauFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemTranDauFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemTranDauFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemTranDauFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemTranDauFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbCap;
    private javax.swing.JComboBox<String> cbNoiDung;
    private javax.swing.JComboBox<String> cbSan;
    private javax.swing.JComboBox<String> cbThoiGian;
    private javax.swing.JComboBox<String> cbVong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLich;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtNgay;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == tbLich) {
            int row = tbLich.getSelectedRow();
            int col = tbLich.getSelectedColumn();
            if(row >= 0 && col == 7) {
                TranDau td = listTD[row];
                System.out.println("row: " + row + " col: " + col);
                if(td.getNoiDung().getId() < 3) {
                    if(td.getListDangKyCN() == null)
                        new DangKyThiDauDonFrm(td).setVisible(true);
                    else
                        new ChiTietTranDauDon(td).setVisible(true);
                }
                else {
                    if(td.getListDangKyDoi() == null)
                        new DangKyThiDauDoiFrm(td).setVisible(true);
                    else
                        new ChiTietTranDauDoi(td).setVisible(true);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

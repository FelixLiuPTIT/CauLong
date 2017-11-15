/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RMIClientControl;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DangKyThiDauCaNhan;
import model.QuocGia;
import model.TranDau;
import model.VanDongVien;

/**
 *
 * @author HIEU
 */
public class DangKyThiDauDonFrm extends javax.swing.JFrame {

    private RMIClientControl clientCtr;
    private TranDau trandau;
    private QuocGia [] listQuocGia = null;
    private VanDongVien[] listVDV1 = null;
    private VanDongVien [] listVDV2 = null;
    
    /**
     * Creates new form DangKyThiDau
     */
    public DangKyThiDauDonFrm() {
        initComponents();
    }
    
    public DangKyThiDauDonFrm(TranDau td) {
        try {
            clientCtr = new RMIClientControl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.trandau = td;
        initThongTinLich();
        initQuocGiaList();
        initVanDongVienList1(listQuocGia[0]);
        initVanDongVienList2(listQuocGia[0]);
    }
    
    private void initThongTinLich() {
        txtNoiDung.setText(trandau.getNoiDung().getTen());
        txtVong.setText(""+trandau.getVong());
        txtCap.setText(""+trandau.getCap());
        txtThoiGian.setText(trandau.getThoiGian().toString());
        txtSan.setText(trandau.getSan().getTen());
    }
    
    private void initQuocGiaList() {
        try {
            listQuocGia = clientCtr.getListQuocGia();
            cbQuocGia1.removeAllItems();
            cbQuocGia2.removeAllItems();
            if(listQuocGia != null) {
                for(QuocGia q : listQuocGia) {
                    cbQuocGia1.addItem(q.getTen());
                    cbQuocGia2.addItem(q.getTen());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initVanDongVienList1(QuocGia q) {
        cbTen1.removeAllItems();
        int idQuocGia = q.getId();
        int idNoiDung = trandau.getNoiDung().getId();
        try {
            switch(idNoiDung) {
                case 1: //don nam
                    listVDV1 = clientCtr.searchVDVbyQuocGia(idQuocGia, 0);
                    break;
                case 2:
                    listVDV1 = clientCtr.searchVDVbyQuocGia(idQuocGia, 1);
                    break;
            }
            if(listVDV1 != null) {
                for(VanDongVien v: listVDV1) {
                    cbTen1.addItem(v.getHoten());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initVanDongVienList2(QuocGia q) {
        cbTen2.removeAllItems();
        int idQuocGia = q.getId();
        int idNoiDung = trandau.getNoiDung().getId();
        try {
            switch(idNoiDung) {
                case 1: //don nam
                    listVDV2 = clientCtr.searchVDVbyQuocGia(idQuocGia, 0);
                    break;
                case 2:
                    listVDV2 = clientCtr.searchVDVbyQuocGia(idQuocGia, 1);
                    break;
            }
            if(listVDV2 != null) {
                for(VanDongVien v: listVDV2) {
                    cbTen2.addItem(v.getHoten());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        txtNoiDung = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVong = new javax.swing.JTextField();
        txtCap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbQuocGia1 = new javax.swing.JComboBox<>();
        cbTen1 = new javax.swing.JComboBox<>();
        cbQuocGia2 = new javax.swing.JComboBox<>();
        cbTen2 = new javax.swing.JComboBox<>();
        btnDangKy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Trận đấu nội dung đơn");

        jLabel2.setText("Nội dung");

        jLabel3.setText("Sân");

        jLabel4.setText("Thời gian");

        jLabel5.setText("Vòng");

        jLabel6.setText("Cặp");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Vận động viên 1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Vận động viên 2");

        jLabel9.setText("Quốc gia");

        jLabel10.setText("Tên");

        jLabel11.setText("Quốc gia");

        jLabel12.setText("Tên");

        cbQuocGia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbQuocGia1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbQuocGia1ItemStateChanged(evt);
            }
        });

        cbTen1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbQuocGia2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbQuocGia2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbQuocGia2ItemStateChanged(evt);
            }
        });

        cbTen2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtVong)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCap, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbQuocGia2, 0, 182, Short.MAX_VALUE)
                                    .addComponent(cbTen2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtThoiGian))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNoiDung)
                                            .addComponent(txtSan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 113, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbQuocGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtVong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbQuocGia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbQuocGia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(cbTen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnDangKy)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbQuocGia1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbQuocGia1ItemStateChanged
        // TODO add your handling code here:
        if(listQuocGia != null && cbQuocGia1.getSelectedIndex() >= 0) {
            QuocGia q = listQuocGia[cbQuocGia1.getSelectedIndex()];
            initVanDongVienList1(q);
        }
        
    }//GEN-LAST:event_cbQuocGia1ItemStateChanged

    private void cbQuocGia2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbQuocGia2ItemStateChanged
        // TODO add your handling code here:
        if(listQuocGia != null && cbQuocGia2.getSelectedIndex() >= 0) {
            QuocGia q = listQuocGia[cbQuocGia2.getSelectedIndex()];
            initVanDongVienList2(q);
        }
    }//GEN-LAST:event_cbQuocGia2ItemStateChanged

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
        VanDongVien v1, v2;
        if(listVDV1 == null)
            System.out.println("null");
        if(cbTen1.getSelectedIndex() >= 0 && cbTen2.getSelectedIndex() >= 0) {
            v1 = listVDV1[cbTen1.getSelectedIndex()];
            v2 = listVDV2[cbTen2.getSelectedIndex()];
        }
        else {
            JOptionPane.showMessageDialog(null, "Khong duoc de trong van dong vien");
            return;
        }
        if(v1.getId() == v2.getId()) {
            JOptionPane.showMessageDialog(null, "Khong duoc trung van dong vien");
            return;
        }
        DangKyThiDauCaNhan dk1 = new DangKyThiDauCaNhan(v1, true, "Van dong vien dang ky dau tien");
        DangKyThiDauCaNhan dk2 = new DangKyThiDauCaNhan(v2, false, "Van dong vien dang ky thu 2");
        ArrayList<DangKyThiDauCaNhan> listDK = new ArrayList<DangKyThiDauCaNhan>();
        listDK.add(dk1);
        listDK.add(dk2);
        trandau.setListDangKyCN(listDK);
        if(clientCtr.dangKyThiDauCaNhan(trandau)) {
            JOptionPane.showMessageDialog(null, "Dang ky thanh cong");
            dispose();
        }
        else {
             JOptionPane.showMessageDialog(null, "Dang ky khong thanh cong");
        }
    }//GEN-LAST:event_btnDangKyActionPerformed

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
            java.util.logging.Logger.getLogger(DangKyThiDauDonFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyThiDauDonFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyThiDauDonFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyThiDauDonFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyThiDauDonFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JComboBox<String> cbQuocGia1;
    private javax.swing.JComboBox<String> cbQuocGia2;
    private javax.swing.JComboBox<String> cbTen1;
    private javax.swing.JComboBox<String> cbTen2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCap;
    private javax.swing.JTextField txtNoiDung;
    private javax.swing.JTextField txtSan;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextField txtVong;
    // End of variables declaration//GEN-END:variables
}
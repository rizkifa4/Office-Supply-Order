/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oso_app;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rizki
 */
public class Form_Supplier extends javax.swing.JFrame {
    koneksi kon=new koneksi();
    private Object [][] datasupplier=null;
    private String[]label={"Id Supplier","Nama Supplier"};

    /**
     * Creates new form Form_Supplier
     */
    public Form_Supplier() {
        initComponents();
        kon.setKoneksi();
        BacaTabelSupplier();
    }
    
    private void BacaTabelSupplier(){
        try{
            String sql="Select *From supplier order by id_supplier";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datasupplier=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datasupplier[x][0]=kon.rs.getString("id_supplier");
                datasupplier[x][1]=kon.rs.getString("nama_supplier");
                x++;
            }
            tbl_sup.setModel(new DefaultTableModel(datasupplier,label));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void BacaTabelSupplier2(){
        try{
            String sql="select *from supplier where nama_supplier like '%"+tcari.getText()+ "%' ";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datasupplier=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datasupplier[x][0]=kon.rs.getString("id_supplier");
                datasupplier[x][1]=kon.rs.getString("nama_supplier");
                x++;
            }
            tbl_sup.setModel(new DefaultTableModel(datasupplier,label));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setTable(){
        int row=tbl_sup.getSelectedRow();
        tkd_sup.setText((String)tbl_sup.getValueAt(row,0));
        tnmsup.setText((String)tbl_sup.getValueAt(row,1));
    }
    
    private String kdsupp()
    {
        String no=null;
        try{
            String sql = "Select right(id_supplier,3)+1 from supplier ";
            ResultSet rs = kon.st.executeQuery(sql);
            if (rs.next()){
                rs.last();
                no = rs.getString(1);
                while (no.length()<3){
                    no="00"+no;
                    no="SP"+no;
                    tkd_sup.setText(no);
                }
            }else{
                no="SP001";
                tkd_sup.setText(no);
            }
        }catch (Exception e){
        }return no;
    }
    
    private void BersihField(){
        tkd_sup.setText("");
        tnmsup.setText("");
    }

    private void aktif(){
        tkd_sup.setEnabled(true);
        tnmsup.setEnabled(true);
    }

    private void nonaktif(){
        tkd_sup.setEnabled(false);
        tnmsup.setEnabled(false);
        bt_edit.setEnabled(false);
        bt_update.setEnabled(false);
        bt_hapus.setEnabled(false);
        bt_simpan.setEnabled(false);
    }

    private void SimpanData(){
        try{
            String sql="insert into supplier values('"+tkd_sup.getText()+"','"+tnmsup.getText()+"')";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
            BersihField();
            BacaTabelSupplier();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    private void EditData(){
        try{
            String sql="Update supplier set id_supplier='"+tkd_sup.getText()+
            "',nama_supplier='"+tnmsup.getText()+"'where id_supplier='"+tkd_sup.getText()+"'";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
            BersihField();
            BacaTabelSupplier();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void HapusData(){
        try{
            String sql="Delete from supplier where id_supplier='"+tkd_sup.getText()+"'";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
            BersihField();
            BacaTabelSupplier();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        Kode_Supplier = new javax.swing.JLabel();
        Nama_Supplier = new javax.swing.JLabel();
        tkd_sup = new javax.swing.JTextField();
        tnmsup = new javax.swing.JTextField();
        Tabel_Data_Supplier = new javax.swing.JPanel();
        Cari_Supplier = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sup = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bt_tambah = new javax.swing.JButton();
        bt_simpan = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_batal = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Input Data Supplier"));

        Kode_Supplier.setText("Kode Supplier");

        Nama_Supplier.setText("Nama Supplier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Kode_Supplier)
                        .addGap(55, 55, 55)
                        .addComponent(tkd_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Nama_Supplier)
                        .addGap(52, 52, 52)
                        .addComponent(tnmsup, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kode_Supplier)
                    .addComponent(tkd_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nama_Supplier)
                    .addComponent(tnmsup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 360, 100));

        Tabel_Data_Supplier.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tabel Data Supplier"));

        Cari_Supplier.setText("Cari Supplier");

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });

        tbl_sup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_sup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_supMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sup);

        javax.swing.GroupLayout Tabel_Data_SupplierLayout = new javax.swing.GroupLayout(Tabel_Data_Supplier);
        Tabel_Data_Supplier.setLayout(Tabel_Data_SupplierLayout);
        Tabel_Data_SupplierLayout.setHorizontalGroup(
            Tabel_Data_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tabel_Data_SupplierLayout.createSequentialGroup()
                .addGroup(Tabel_Data_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tabel_Data_SupplierLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Cari_Supplier)
                        .addGap(40, 40, 40)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Tabel_Data_SupplierLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tabel_Data_SupplierLayout.setVerticalGroup(
            Tabel_Data_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tabel_Data_SupplierLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(Tabel_Data_SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cari_Supplier)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(Tabel_Data_Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 500, 190));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });
        jPanel2.add(bt_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));

        bt_simpan.setText("Simpan");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });
        jPanel2.add(bt_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 80, 40));

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        jPanel2.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 80, 40));

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });
        jPanel2.add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 80, 40));

        bt_batal.setText("Batal");
        bt_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_batalActionPerformed(evt);
            }
        });
        jPanel2.add(bt_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 80, 40));

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });
        jPanel2.add(bt_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 80, 40));

        bt_keluar.setText("Tutup");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });
        jPanel2.add(bt_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 320, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 520, 100));

        setBounds(0, 0, 556, 491);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bt_keluarActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
        // TODO add your handling code here:
        aktif();
        BersihField();
        kdsupp();
        tkd_sup.setEnabled(false);
        tnmsup.requestFocus();
        bt_batal.setEnabled(true);
        bt_tambah.setEnabled(false);
        bt_simpan.setEnabled(true);
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_batalActionPerformed
        // TODO add your handling code here:
        nonaktif();
        BersihField();
        bt_tambah.setEnabled(true);
    }//GEN-LAST:event_bt_batalActionPerformed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        // TODO add your handling code here:
        if (tkd_sup.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi Data",
            "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bt_tambah.setEnabled(true);
        } else {
            bt_tambah.setEnabled(true);
            bt_keluar.setEnabled(true);
            SimpanData();
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void tcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyTyped
        // TODO add your handling code here:
        BacaTabelSupplier2();
    }//GEN-LAST:event_tcariKeyTyped

    private void tbl_supMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_supMouseClicked
        // TODO add your handling code here:
        setTable();
        bt_hapus.setEnabled(true);
        bt_edit.setEnabled(true);
        bt_tambah.setEnabled(false);
    }//GEN-LAST:event_tbl_supMouseClicked

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "yakin mau dihapus?",
        "konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            HapusData();
            bt_tambah.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data Batal Dihapus",
            "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bt_tambah.setEnabled(true);
            return;
        }
        formWindowActivated(null);
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
        tnmsup.setEnabled(true);
        bt_edit.setEnabled(false);
        bt_update.setEnabled(true);
        bt_batal.setEnabled(true);
        bt_hapus.setEnabled(false);
        bt_tambah.setEnabled(false);
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        // TODO add your handling code here:
        bt_update.setEnabled(false);
        bt_tambah.setEnabled(true);
        EditData();
    }//GEN-LAST:event_bt_updateActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cari_Supplier;
    private javax.swing.JLabel Kode_Supplier;
    private javax.swing.JLabel Nama_Supplier;
    private javax.swing.JPanel Tabel_Data_Supplier;
    private javax.swing.JButton bt_batal;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JButton bt_update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_sup;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tkd_sup;
    private javax.swing.JTextField tnmsup;
    // End of variables declaration//GEN-END:variables
}

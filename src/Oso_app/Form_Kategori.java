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
public class Form_Kategori extends javax.swing.JFrame {
    koneksi kon=new koneksi();
    private Object [][] datakategori=null;
    private String[]label={"Id Kategori","Nama Kategori"};

    /**
     * Creates new form Form_Kategori
     */
    public Form_Kategori() {
        initComponents();
        kon.setKoneksi();
        BacaTabelKategori();
        tid_kategori.setVisible(false);
    }
    
    private void BacaTabelKategori(){
        try{
            String sql="Select *From kategori order by id_kategori";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datakategori=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datakategori[x][0]=kon.rs.getString("id_kategori");
                datakategori[x][1]=kon.rs.getString("nama_kategori");
                x++;
            }
            tbl_kategori.setModel(new
            DefaultTableModel(datakategori,label));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void BacaTabelKategori2(){
        try{
            String sql="select *from kategori where nama_kategori like '%"+tcari.getText()+ "%' ";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datakategori=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datakategori[x][0]=kon.rs.getString("id_kategori");
                datakategori[x][1]=kon.rs.getString("nama_kategori");
                x++;
            }
            tbl_kategori.setModel(new
            DefaultTableModel(datakategori,label));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setTable(){
        int row=tbl_kategori.getSelectedRow();
        tid_kategori.setText((String)tbl_kategori.getValueAt(row,0));
        tkategori.setText((String)tbl_kategori.getValueAt(row,1));
    }
    
    private void BersihField(){
        tkategori.setText("");
        tcari.setText("");
    }

    private void aktif(){
        tkategori.setEnabled(true);
    }

    private void nonaktif(){
        tkategori.setEnabled(false);
        bt_edit.setEnabled(false);
        bt_update.setEnabled(false);
        bt_hapus.setEnabled(false);
        bt_simpan.setEnabled(false);
    }

    private String NoOtomatis()
    {
        String Next_nobp;
        String no=null;
        int Next_nobp_int=0;
        try{
            String sql = "Select *from kategori ";
            ResultSet rs = kon.st.executeQuery(sql);
            if(rs.last()){
                Next_nobp=rs.getString("id_kategori");
                Next_nobp_int=Integer.parseInt(Next_nobp) + 1;
                no=String.valueOf(Next_nobp_int);
            }
        }catch (Exception e){
        }return no;
    }
    
    private void SimpanData(){
        try{
            String sql="insert into kategori values('"+NoOtomatis()+"','"+tkategori.getText()+"')";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
            BersihField();
            BacaTabelKategori();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void EditData(){
        try{
            String sql="Update kategori set nama_kategori='"+tkategori.
            getText()+"' where id_kategori='"+tid_kategori.getText()+"'";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
            BersihField();
            BacaTabelKategori();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void HapusData(){
        try{
            String sql="Delete from kategori where id_kategori='"+tid_kategori.getText()+"'";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
            BersihField();
            BacaTabelKategori();
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
        Kategori = new javax.swing.JLabel();
        tkategori = new javax.swing.JTextField();
        tid_kategori = new javax.swing.JTextField();
        Cari_Kategori = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kategori = new javax.swing.JTable();
        tcari = new javax.swing.JTextField();
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Input Data Kategori"));

        Kategori.setText("Kategori");

        Cari_Kategori.setText("Cari Kategori");

        tbl_kategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kategori);

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kategori)
                    .addComponent(Cari_Kategori))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tid_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tcari))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kategori)
                    .addComponent(tkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tid_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cari_Kategori)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_simpan.setText("Simpan");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_batal.setText("Batal");
        bt_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_batalActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_keluar.setText("Tutup");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(bt_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(bt_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 380, 100));

        setBounds(0, 0, 418, 398);
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
        BersihField();
        aktif();
        tkategori.setEnabled(true);
        tkategori.requestFocus();
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
        if (tkategori.getText().isEmpty()) {
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
        BacaTabelKategori2();
    }//GEN-LAST:event_tcariKeyTyped

    private void tbl_kategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kategoriMouseClicked
        // TODO add your handling code here:
        setTable();
        bt_hapus.setEnabled(true);
        bt_edit.setEnabled(true);
        bt_tambah.setEnabled(false);
    }//GEN-LAST:event_tbl_kategoriMouseClicked

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
        aktif();
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
            java.util.logging.Logger.getLogger(Form_Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Kategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cari_Kategori;
    private javax.swing.JLabel Kategori;
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
    private javax.swing.JTable tbl_kategori;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tid_kategori;
    private javax.swing.JTextField tkategori;
    // End of variables declaration//GEN-END:variables
}

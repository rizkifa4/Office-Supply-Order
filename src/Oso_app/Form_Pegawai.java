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
public class Form_Pegawai extends javax.swing.JFrame {
    koneksi kon=new koneksi();
    private Object [][] datapegawai=null;
    private String[]label={"Id Pegawai","Username","Password","Departemen","Manajer"};

    /**
     * Creates new form Form_Pegawai
     */
    public Form_Pegawai() {
        initComponents();
        kon.setKoneksi();
        BacaTabelPegawai();
    }
    
    private String idPegawai()
    {
        String no=null;
        try{
            String sql = "Select right(id_pegawai,3)+1 from pegawai ";
            ResultSet rs = kon.st.executeQuery(sql);
            if (rs.next()){
                rs.last();
                no = rs.getString(1);
                while (no.length()<3){
                    no="00"+no;
                    no="P"+no;
                    tid_pegawai.setText(no);
                }
            }else{
                no="P001";
                tid_pegawai.setText(no);
            }
        }catch (Exception e){
        }return no;
    }
    
    private void BacaTabelPegawai(){
        try{
            String sql="Select *From pegawai order by id_pegawai";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datapegawai=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datapegawai[x][0]=kon.rs.getString("id_pegawai");
                datapegawai[x][1]=kon.rs.getString("username");
                datapegawai[x][2]=kon.rs.getString("password");
                datapegawai[x][3]=kon.rs.getString("departemen");
                datapegawai[x][4]=kon.rs.getString("manajer");
                x++;
            }
            tbl_pegawai.setModel(new DefaultTableModel(datapegawai,label));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void BacaTabelPegawai2(){
        try{
            String sql="select *from pegawai where username like '%"+tcari.getText()+ "%' ";
            kon.rs=kon.st.executeQuery(sql);
            ResultSetMetaData m=kon.rs.getMetaData();
            int kolom=m.getColumnCount();
            int baris=0;
            while(kon.rs.next()){
                baris=kon.rs.getRow();
            }
            datapegawai=new Object[baris][kolom];
            int x=0;
            kon.rs.beforeFirst();
            while(kon.rs.next()){
                datapegawai[x][0]=kon.rs.getString("id_pegawai");
                datapegawai[x][1]=kon.rs.getString("username");
                datapegawai[x][2]=kon.rs.getString("password");
                datapegawai[x][3]=kon.rs.getString("departemen");
                datapegawai[x][4]=kon.rs.getString("manajer");
                x++;
            }
            tbl_pegawai.setModel(new DefaultTableModel(datapegawai,label));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setTable(){
        int row=tbl_pegawai.getSelectedRow();
        tid_pegawai.setText((String)tbl_pegawai.getValueAt(row,0));
        tusername.setText((String)tbl_pegawai.getValueAt(row,1));
        tpassword.setText((String)tbl_pegawai.getValueAt(row,2));
        tdepartemen.setText((String)tbl_pegawai.getValueAt(row,3));
        tmanajer.setText((String)tbl_pegawai.getValueAt(row,4));
    }

    private void BersihField(){
        tid_pegawai.setText("");
        tusername.setText("");
        tdepartemen.setText("");
        tpassword.setText("");
        tmanajer.setText("");
        tcari.setText("");
    }

    private void aktif(){
        tid_pegawai.setEnabled(true);
        tusername.setEnabled(true);
        tdepartemen.setEnabled(true);
        tpassword.setEnabled(true);
        tmanajer.setEnabled(true);
    }

    private void nonaktif(){
        tid_pegawai.setEnabled(false);
        tusername.setEnabled(false);
        tdepartemen.setEnabled(false);
        tmanajer.setEnabled(false);
        tpassword.setEnabled(false);
        bt_edit.setEnabled(false);
        bt_update.setEnabled(false);
        bt_hapus.setEnabled(false);
        bt_simpan.setEnabled(false);
    }
    
    private void SimpanData(){
        try{
            String sql="insert into pegawai values('"+tid_pegawai.getText()+"','"+tusername.getText()+
            "','"+tpassword.getText()+"','"+tdepartemen.getText()+"','"+tmanajer.getText()+"')";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
            BersihField();
            BacaTabelPegawai();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void EditData(){
        try{
            String sql="Update pegawai set id_pegawai='"+tid_pegawai.getText()+"',username='"+
            tusername.getText()+"',password='"+tpassword.getText()+"',departemen='"+tdepartemen.
            getText()+"',manajer='"+tmanajer.getText()+"' where id_pegawai='"+tid_pegawai.getText()+"'";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
            BersihField();
            BacaTabelPegawai();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void HapusData(){
        try{
            String sql="Delete from pegawai where id_pegawai='"+tid_pegawai.getText()+"'";
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
            BersihField();
            BacaTabelPegawai();
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

        Input_Data_Pegawai = new javax.swing.JPanel();
        Id_Pegawai = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        Departemen = new javax.swing.JLabel();
        Manajer = new javax.swing.JLabel();
        tid_pegawai = new javax.swing.JTextField();
        tusername = new javax.swing.JTextField();
        tpassword = new javax.swing.JTextField();
        tdepartemen = new javax.swing.JTextField();
        tmanajer = new javax.swing.JTextField();
        Tabel_Data_Pegawai = new javax.swing.JPanel();
        Cari_Pegawai = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pegawai = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
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

        Input_Data_Pegawai.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Input Data Pegawai"));
        Input_Data_Pegawai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Id_Pegawai.setText("Id Pegawai");
        Input_Data_Pegawai.add(Id_Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        Username.setText("Username");
        Input_Data_Pegawai.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        Password.setText("Password");
        Input_Data_Pegawai.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        Departemen.setText("Departemen");
        Input_Data_Pegawai.add(Departemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        Manajer.setText("Manajer");
        Input_Data_Pegawai.add(Manajer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        Input_Data_Pegawai.add(tid_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 130, -1));
        Input_Data_Pegawai.add(tusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 150, -1));
        Input_Data_Pegawai.add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, -1));
        Input_Data_Pegawai.add(tdepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 150, -1));
        Input_Data_Pegawai.add(tmanajer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, -1));

        getContentPane().add(Input_Data_Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 350, 170));

        Tabel_Data_Pegawai.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tabel Data Pegawai"));
        Tabel_Data_Pegawai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cari_Pegawai.setText("Cari Pegawai");
        Tabel_Data_Pegawai.add(Cari_Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });
        Tabel_Data_Pegawai.add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, -1));

        tbl_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pegawai);

        Tabel_Data_Pegawai.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 480, 100));

        getContentPane().add(Tabel_Data_Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 520, 160));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(bt_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));

        bt_simpan.setText("Simpan");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });
        jPanel1.add(bt_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 80, 40));

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        jPanel1.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 80, 40));

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });
        jPanel1.add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 40));

        bt_batal.setText("Batal");
        bt_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_batalActionPerformed(evt);
            }
        });
        jPanel1.add(bt_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 80, 40));

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(bt_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 80, 40));

        bt_keluar.setText("Tutup");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 80, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 360, 100));

        setBounds(0, 0, 558, 529);
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
        idPegawai();
        aktif();
        tid_pegawai.setEnabled(false);
        tusername.requestFocus();
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
        if (tid_pegawai.getText().isEmpty() || tpassword.getText().isEmpty()
        || tusername.getText().isEmpty() || tdepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi",
            JOptionPane.INFORMATION_MESSAGE);
            bt_tambah.setEnabled(true);
        } else {
            bt_tambah.setEnabled(true);
            bt_keluar.setEnabled(true);
            SimpanData();
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void tcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyTyped
        // TODO add your handling code here:
        BacaTabelPegawai2();
    }//GEN-LAST:event_tcariKeyTyped

    private void tbl_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pegawaiMouseClicked
        // TODO add your handling code here:
        setTable();
        bt_hapus.setEnabled(true);
        bt_edit.setEnabled(true);
        bt_tambah.setEnabled(false);
    }//GEN-LAST:event_tbl_pegawaiMouseClicked

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
        tid_pegawai.setEnabled(false);
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
            java.util.logging.Logger.getLogger(Form_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cari_Pegawai;
    private javax.swing.JLabel Departemen;
    private javax.swing.JLabel Id_Pegawai;
    private javax.swing.JPanel Input_Data_Pegawai;
    private javax.swing.JLabel Manajer;
    private javax.swing.JLabel Password;
    private javax.swing.JPanel Tabel_Data_Pegawai;
    private javax.swing.JLabel Username;
    private javax.swing.JButton bt_batal;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JButton bt_update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_pegawai;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tdepartemen;
    private javax.swing.JTextField tid_pegawai;
    private javax.swing.JTextField tmanajer;
    private javax.swing.JTextField tpassword;
    private javax.swing.JTextField tusername;
    // End of variables declaration//GEN-END:variables
}

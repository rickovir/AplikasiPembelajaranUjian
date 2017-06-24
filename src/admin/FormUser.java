/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
// library yg perlu di import
import aplikasipembelajaranujian.Pengguna;
import aplikasipembelajaranujian.TingkatKelas;
import javax.swing.JOptionPane;
import admintablemodel.TableModelPengguna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Firman Alamsyah
 */
public class FormUser extends javax.swing.JFrame {

    /**
     * Creates new form FormUser
     */
    private Pengguna user; // membuat object dari kelas pengguna untuk operasi2 dari kelas Pengguna
    private TingkatKelas kelas; // membuat object dari kelas TingkatKelas untuk operasi2 dari kelas TingkatKelas
    private TableModelPengguna tableModel; // objek kelas TableModelPengguna
    private int[] idKelas; // deklarasi array integer id kelas nntinya untuk menampung idKelas dari table tingkatKelas
    private String[] namaKelas; // deklarasi array String nama kelas nntinya untuk menampung namaKelas dari table tingkatKelas
    
    // konstruktor FormUser
    public FormUser() {
        initComponents();
        // inisialisasi kelas Pengguna dan kelas TingkatKelas
        user = new Pengguna();
        kelas = new TingkatKelas();
        // inisialisasi idkelas dan namakelas index diambil dari banyak baris table TingkatKelas
        idKelas = new int[kelas.ambilDataKelas().size()];
        namaKelas = new String[kelas.ambilDataKelas().size()];
        // inisialisasi tabelmodelpengguna data didapat dari kelas Pengguna method ambilDataPengguna()
        tableModel = new TableModelPengguna(user.ambilDataPengguna());
        // inisialisasi tabel pengguna yg tampil dari data bentukan dari tabel model
        tablePengguna.setModel(tableModel);
        // inisialisasi combokelas diisi data dari table TingkatKelas
        initComboKelas();
    }
    // inisialisasi combobox kelas
    public void initComboKelas()
    {
        List<TingkatKelas> dataKelas = kelas.ambilDataKelas();
        for(int i=0; i< dataKelas.size(); i++)
        {
            idKelas[i] = dataKelas.get(i).getIdKelas();
            namaKelas[i] = dataKelas.get(i).getNamaKelas();
        }
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(namaKelas);
        comboKelas.setModel(comboModel);
    }
    // reset semua value
    public void kosongkan()
    {
        // menset nilai user dari awal lagi class Pnegguna
        user = new Pengguna();
        // resert nilai inputan
        textNama.setText("");
        textUsername.setText("");
        textPassword.setText("");
        textCari.setText("");
        labelIdPengguna.setText("");
        // reset nilai combobox
        comboKelas.setSelectedIndex(0);
        comboVerification.setSelectedIndex(0);
        // nonaktifkan semua tombol kecuali tambah
        buttonTambah.setEnabled(true);
        buttonUbah.setEnabled(false);
        buttonSimpan.setEnabled(false);
        buttonHapus.setEnabled(false);
    }
    // form dalam mode operasi sedang berjalan ubah atau hapus
    public void editDeleteMode()
    {
        // semua inputan diaktifkan
        textNama.setEnabled(true);
        textUsername.setEnabled(true);
        textPassword.setEnabled(true);
        comboKelas.setEnabled(true);
        comboVerification.setEnabled(true);
        // semua tombol aktif kecuali simpan
        buttonTambah.setEnabled(true);
        buttonUbah.setEnabled(true);
        buttonSimpan.setEnabled(false);
        buttonHapus.setEnabled(true);
    }
    // untuk ambil data yang telah di inputkan text maupun combobox
    public void ambilData()
    {
        // jika labelidpengguna tidak kosong atau ada isinya berarti dalam proses ubah dan delete data 
        //maka idPengguna diambil dari labelIdPengguna
        if(labelIdPengguna.getText() != "")
            user.setIdPengguna(Integer.valueOf(labelIdPengguna.getText())); // ambil dari label
        else
        {
            // jika labelidPengguna kosong berarti dalam proses tambah maka idPengguna diambil default dari sistem 
            user.setIdPengguna();
        }
        user.setNamaPengguna(textNama.getText());
        user.setUsername(textUsername.getText());
        user.setPassword(textPassword.getText());
        // jika index 0 berarti value nya No
        if(comboVerification.getSelectedIndex() == 0)
        {    
            user.setVerificationStatus(0); // dan input kedatabasenya juga 0
        }
        else
        {
            user.setVerificationStatus(1); // dan sebaliknya
        }
        // id kelas diambil dari index combobox yg di select kemudian digenerate indexnya ke idkelas
        user.setIdKelas(idKelas[comboKelas.getSelectedIndex()]);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        textUsername = new javax.swing.JTextField();
        textPassword = new javax.swing.JTextField();
        comboKelas = new javax.swing.JComboBox<>();
        comboVerification = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePengguna = new javax.swing.JTable();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        buttonKembali = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        labelIdPengguna = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form User");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Kelas");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Verifcation");

        textNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaActionPerformed(evt);
            }
        });

        textUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsernameActionPerformed(evt);
            }
        });

        comboKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        comboVerification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));

        tablePengguna.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenggunaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePengguna);

        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonUbah.setText("Ubah");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonKembali.setText("Kembali");
        buttonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliActionPerformed(evt);
            }
        });

        jLabel7.setText("Cari Pengguna");

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCariKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCariKeyTyped(evt);
            }
        });

        jLabel8.setText("UserId");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNama, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(textUsername)
                                    .addComponent(textPassword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboVerification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(labelIdPengguna)
                                    .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCari)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboVerification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdPengguna))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTambah)
                            .addComponent(buttonHapus)
                            .addComponent(buttonSimpan)
                            .addComponent(buttonUbah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonKembali)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // ambil data kemudian diubah di class Pengguna menggunakan method ubah
        ambilData();
        user.ubah();
        // ambil index dimana table diselect atau dipilih
        int index = tablePengguna.convertRowIndexToModel(tablePengguna.getSelectedRow());
        // update tampilan tabel
        tableModel.update(user, index);
        kosongkan();
        JOptionPane.showMessageDialog(null,"Berhasil Diubah");
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // JOptionPane memberikan pilihan yes no atau cancel
        
        if(JOptionPane.showConfirmDialog(this, "Anda yakin mau menghapus ?") == JOptionPane.OK_OPTION)
        {                                           
            // jika OK maka
            // ambil data
            ambilData();
            // hapus data
            user.hapus();
            // ambil index
            int index = tablePengguna.convertRowIndexToModel(tablePengguna.getSelectedRow());
            // delete data pada tampilan table
            tableModel.delete(index);
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // ambil data
        ambilData();
        // simpan data
        user.simpan();
        // insert ke tampilan table
        tableModel.insert(user);
        kosongkan();
        JOptionPane.showMessageDialog(null,"Berhasil Simpan");
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKembaliActionPerformed

    private void textUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsernameActionPerformed

    private void textNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // method form saat dibuka
        kosongkan();
        textNama.setEnabled(false);
        textUsername.setEnabled(false);
        textPassword.setEnabled(false);
        comboKelas.setEnabled(false);
        comboVerification.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // kosongkan
        kosongkan();
        // semua inputan di aktifkan
        textNama.setEnabled(true);
        textUsername.setEnabled(true);
        textPassword.setEnabled(true);
        
        comboKelas.setEnabled(true);
        comboVerification.setEnabled(true);
        // button simpan di aktifkan
        buttonSimpan.setEnabled(true);
    }//GEN-LAST:event_buttonTambahActionPerformed
    // table tampilan atau tablePengguna saat di klik row tertentu
    private void tablePenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenggunaMouseClicked
        // ambil row number dimana di klik
        int rowNum = tablePengguna.getSelectedRow();
        // aktifkan edit delete mode
        editDeleteMode();
        // ambil data dari table pengguna sesuai dengan nomor rownya dan kolomnya yg mana. tablePengguna.getValueAt(row number, col number)
        labelIdPengguna.setText(tablePengguna.getValueAt(rowNum, 0).toString());
        textNama.setText(tablePengguna.getValueAt(rowNum, 1).toString());
        textUsername.setText(tablePengguna.getValueAt(rowNum, 2).toString());
        textPassword.setText(tablePengguna.getValueAt(rowNum, 3).toString());
        comboVerification.setSelectedIndex(Integer.valueOf(tablePengguna.getValueAt(rowNum, 4).toString()));
        // index untuk select combo kelas
        int indexSelect = 0;
        // ambil idKelasnya
        int tIdKelas = Integer.valueOf(tablePengguna.getValueAt(rowNum, 5).toString());
        // cari dimana indexnya
        for(int i = 0; i<idKelas.length; i++)
        {
            // jika sama maka
            if(tIdKelas == idKelas[i])
            {
                // ambil indexnya
                indexSelect = i;
                // keluar dari perulangan
                break;
            }
        }
        // select index pada comboKelas
        comboKelas.setSelectedIndex(indexSelect);
    }//GEN-LAST:event_tablePenggunaMouseClicked

    private void textCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyPressed
        
    }//GEN-LAST:event_textCariKeyPressed
    // aksi ketika di ketik text cari
    private void textCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyTyped
        // ambil valuenya
        String key = textCari.getText().toString();
        // tampilkan table sesuai key yang diminta
        tableModel = new TableModelPengguna(user.ambilDataPengguna(key));
        // set model tabel
        tablePengguna.setModel(tableModel);
    }//GEN-LAST:event_textCariKeyTyped

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
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKembali;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox<String> comboKelas;
    private javax.swing.JComboBox<String> comboVerification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIdPengguna;
    private javax.swing.JTable tablePengguna;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipembelajaranujian;
// yang perlu di import ke class
import java.io.*;
import data.Model;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp431
 */


public class Pengguna {
    private int idPengguna;
    private int idKelas;
    private String namaPengguna;
    private String username;
    private String password;
    private int verificationStatus;
    private Model model; // untuk operasi database
    
    public Pengguna()
    {
        idPengguna = 0;
        idKelas = 0;
        namaPengguna = "";
        username ="";
        password = "";
        verificationStatus = 0;
        model = new Model();
    }
    
    public int getIdPengguna()
    {
        return idPengguna;
    }
    
    public int getIdKelas()
    {
        return idKelas;
    }
    
    public String getNamaPengguna()
    {
        return namaPengguna;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public int getVerificationStatus()
    {
        return verificationStatus;
    }
    
    public void setNamaPengguna(String newNama)
    {
        namaPengguna = newNama;
    }
    
    public void setUsername(String newUsername)
    {
        username = newUsername;
    }
    
    public void setPassword(String newPassword)
    {
        password = newPassword;
    }
    
    public void setVerificationStatus(int newStatus)
    {
        verificationStatus = newStatus;
    }
    
    public void setIdKelas(int newIdKelas)
    {
        idKelas = newIdKelas;
    }
    
    public void setIdPengguna(int newIdPengguna)
    {
        idPengguna = newIdPengguna;
    }
    
    public void setIdPengguna()
    {
        idPengguna = model.randInt(10000, 99999); // set id dengan random integer
    }
    
    public void simpan()
    {
        // penampung data dalam bentuk string arraylist yg akan di insert
        ArrayList<String> row= new ArrayList<String>();
        
        // add data yang mau di insert
        row.add(String.valueOf(idPengguna));
        row.add(namaPengguna);
        row.add(username);
        row.add(password);
        row.add(String.valueOf(verificationStatus));
        row.add(String.valueOf(idKelas));
        // insert ke database model.insert("nama table", row);
        model.insert("pengguna", row);
    }
    public void ubah()
    {
        // penampung data
        ArrayList<String> col = new ArrayList<String>(); // untuk nama kolomnya
        ArrayList<String> row= new ArrayList<String>();  // untuk isi barisnya yang mau di update
        
        // nama nama kolom table pengguna
        col.add("idPengguna");
        col.add("namaPengguna");
        col.add("username");
        col.add("password");
        col.add("verificationStatus");
        col.add("idKelas");
        // baris data yang mau diubah di table pengguna
        row.add(String.valueOf(idPengguna));
        row.add(namaPengguna);
        row.add(username);
        row.add(password);
        row.add(String.valueOf(verificationStatus));
        row.add(String.valueOf(idKelas));
        
        // update table ke database model.update("nama table", col, row);
        model.update("pengguna", col, row);
    }
    public void hapus()
    {
        // delete data ke database model.delete("nama table", id);
        model.delete("pengguna", idPengguna);
    }
    
    // fungsi kembali nilai List Class Pengguna buat ambil data dari database
    public List<Pengguna> ambilDataPengguna()
    {
        List<Pengguna> res = new ArrayList<Pengguna>(); // membuat list class pengguna
        // model.selectAll("nama table"); untuk select data dan di jadikan result set
        ResultSet data = model.selectAll("pengguna");
        
        try
        {
            while(data.next())
            {
                // variabel newpengguna untuk menampung data dari database, tipe datanya class Pengguna
                Pengguna newPengguna = new Pengguna();
                
                // ini untuk masukan data dari database ke objek newPengguna
                // kalo di Classnya integer maka perlu di translate ke integer dulu pake Integer.valueOf( data string )
                newPengguna.idPengguna = Integer.valueOf(data.getString("idPengguna"));
                newPengguna.namaPengguna = data.getString("namaPengguna");
                newPengguna.username = data.getString("username");
                newPengguna.password = data.getString("password");
                newPengguna.verificationStatus = Integer.valueOf(data.getString("verificationStatus"));
                newPengguna.idKelas = Integer.valueOf(data.getString("idKelas"));
                
                // lalu data newPengguna tersebut di kirim ke result set tadi
                res.add(newPengguna);
            }
        }  
        catch(Exception e) // catch buat kalo error pas udah running
        {
            JOptionPane.showMessageDialog(null, "Gagal "+e);
        }
        // kemudian di keluarkan/dikembalikan
        return res;
    }
    
    // sama aja seperti yg diatas cuma ini untuk search data
    public List<Pengguna> ambilDataPengguna(String searchKey)
    {
        List<Pengguna> res = new ArrayList<Pengguna>();
        // ini buat mencari data ada inputan nama kolom itu kolom apa yg mu di cari 
        // model.selectOption("nama table").like("nama kolom", searchKey)
        ResultSet data = model.selectOption("pengguna").like("namaPengguna", searchKey);
        // kebawah sama seperti yg sebelumnya
        try
        {
            while(data.next())
            {
                Pengguna newPengguna = new Pengguna();
                newPengguna.idPengguna = Integer.valueOf(data.getString("idPengguna"));
                newPengguna.namaPengguna = data.getString("namaPengguna");
                newPengguna.username = data.getString("username");
                newPengguna.password = data.getString("password");
                newPengguna.verificationStatus = Integer.valueOf(data.getString("verificationStatus"));
                newPengguna.idKelas = Integer.valueOf(data.getString("idKelas"));
                
                res.add(newPengguna);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Gagal "+ e);
        }
        return res;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipembelajaranujian;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import data.Model;
/**
 *
 * @author hp431
 */
public class TingkatKelas {
    private int idKelas;
    private String namaKelas;
    private Model model;
    
    public TingkatKelas()
    {
        idKelas = 0;
        namaKelas ="";
        model = new Model();
    }
    
    public void setIdKelas(int newIdKelas)
    {
        idKelas = newIdKelas;
    }
    public int getIdKelas()
    {
        return idKelas;
    }
    public void setNamaKelas(String newNamaKelas)
    {
        namaKelas = newNamaKelas;
    }
    public String getNamaKelas()
    {
        return namaKelas;
    }
    public void tambah()
    {
        
    }
    public void hapus()
    {
        
    }
    public void edit()
    {
        
    }
    public List<TingkatKelas> ambilDataKelas()
    {
        List<TingkatKelas> res = new ArrayList<TingkatKelas>();
        ResultSet data = model.selectAll("tingkatKelas");
        try
        {
            while(data.next())
            {
                TingkatKelas kelas = new TingkatKelas();
                kelas.idKelas = Integer.valueOf(data.getString("idKelas").toString());
                kelas.namaKelas = data.getString("namaKelas").toString();
                res.add(kelas);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Gagal "+e);
        }
        return res;
    }
}

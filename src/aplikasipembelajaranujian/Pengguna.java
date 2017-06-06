/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipembelajaranujian;

/**
 *
 * @author hp431
 */
public class Pengguna {
    private int idPengguna;
    private char kelas;
    private String namaPengguna;
    private String email;
    private String tgl_lahir;
    private boolean vertificationStatus;
    
    public int getIdPengguna()
    {
        return idPengguna;
    }
    
    public int getKelas()
    {
        return kelas;
    }
    
    public String getNamaPengguna()
    {
        return namaPengguna;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public boolean getVertificationStatus()
    {
        return vertificationStatus;
    }
    
    public void editBiodata(String newNama, String newEmail, char newKelas)
    {
        namaPengguna = newNama;
        email = newEmail;
        kelas = newKelas;
    }
    
    public void callData()
    {
        
    }
}

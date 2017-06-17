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
public class Nilai extends Ujian {
    private int idNilai;
    private int besarNilai;
    private char grade;
    
    public int getIdNilai()
    {
        return idNilai;
    }
    public int getBesarNilai()
    {
        return besarNilai;
    }
    public char getGrade()
    {
        return grade;
    }
    public void setBesarNilai(int newNilai)
    {
        besarNilai = newNilai;
    }
    public char hitungGrade(int sourceNilai)
    {
        char hitGrade;
        hitGrade = 'y';
        return hitGrade ;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admintablemodel;

import aplikasipembelajaranujian.Pengguna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp431
 */
// ini adalah kelas untuk model tampilan tablePengguna pada formuser
public class TableModelPengguna extends AbstractTableModel { // mengekstend dari interface AbstractTableModel
    // untuk penampungnya, diambil dari masing2 kelas
    List<Pengguna> list; // menjadikan class pengguna sebagai penampung List
    
    // kostruktor
    public TableModelPengguna(List<Pengguna> newPengguna)
    {
        list = newPengguna; // set data baru inisialisasi list
    }

    public Pengguna getPengguna(int index) {
        return list.get(index);
    }

    public void insert(Pengguna pengguna) {
        list.add(pengguna);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void update(Pengguna pengguna, int index) {
        list.set(index, pengguna);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 6; //jumlah kolom yang mau ditampilkan
    }
    // row valuenya untuk mengambil value pada baris dan kolom sekian atau ini barisnya
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdPengguna(); 
            case 1:
                return list.get(rowIndex).getNamaPengguna();
            case 2:
                return list.get(rowIndex).getUsername();
            case 3:
                return list.get(rowIndex).getPassword();
            case 4:
                return list.get(rowIndex).getVerificationStatus();
            case 5:
                return list.get(rowIndex).getIdKelas();
            default:
                return null;
        }
    }
    
    //ini untuk mengambil kolom2nya. atau ini kolomnya
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return ("Id Pengguna");
            case 1:
                return ("Nama Pengguna");
            case 2:
                return ("Username");
            case 3:
                return ("Password");
            case 4:
                return ("Verification Status");
            case 5:
                return ("Id Kelas");
            default:
                return null;
        }
    }
}

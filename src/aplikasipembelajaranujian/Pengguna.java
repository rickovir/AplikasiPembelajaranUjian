/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipembelajaranujian;
import java.io.*;
import data.Model;
import data.TableField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    private Model modelTable;
    private TableField tableField;
    
    public Pengguna()
    {
        idPengguna = 0;
        idKelas = 0;
        namaPengguna = "";
        username ="";
        password = "";
        verificationStatus = 0;
        modelTable = new Model();
        tableField = new TableField();
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
    
    public void editBiodata(String newNama, String newEmail, int newKelas)
    {
        namaPengguna = newNama;
        username = newEmail;
        idKelas = newKelas;
    }
    public void simpan()
    {
        modelTable.insert("pengguna", this);
    }
    
    public JTable getTableData() // import jtable
    {
        DefaultTableModel tbl = new DefaultTableModel(); // import table model
        ArrayList<String> rowsName = new ArrayList<String>(); //import array list
        JTable resTableModel = new JTable();
        ResultSet rows;
        tableField.setField(this);
        tableField.getField().remove("modelTable");
        tableField.getField().remove("tableField");
        for(int i=0; i<tableField.getField().size(); i++)
        {
            tbl.addColumn(tableField.getField().get(i));
            rowsName.add(tableField.getField().get(i));
        }
        resTableModel.setModel(tbl);
        try
        {
            rows = modelTable.selectAll("pengguna");
            while(rows.next())
            {
                Object[] objectTable = new Object[rowsName.size()];
                for(int i=0; i<rowsName.size(); i++)
                {
                    objectTable[i] = rows.getString(rowsName.get(i));
                }
                tbl.addRow(objectTable);
                resTableModel.setModel(tbl);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        return resTableModel;
    }
    
    public void saveData()
    {
//        String fileName = "Pengguna.txt";
//
//        try {
//            // Assume default encoding.
//            FileWriter fileWriter =
//                new FileWriter(fileName);
//
//            // Always wrap FileWriter in BufferedWriter.
//            BufferedWriter bufferedWriter =
//                new BufferedWriter(fileWriter);
//
//            // Note that write() does not automatically
//            // append a newline character.
//            bufferedWriter.write("Hello there,");
//            bufferedWriter.write(" here is some text.");
//            bufferedWriter.newLine();
//            bufferedWriter.write("We are writing");
//            bufferedWriter.write(" the text to the file.");
//
//            // Always close files.
//            bufferedWriter.close();
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error writing to file '"
//                + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }
                String FILENAME = "src/data/Pengguna.txt";
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = " This is new content";

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write("#namaPengguna:" + namaPengguna);
			bw.write("#email:" + username);
                        bw.newLine();
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

    }
}
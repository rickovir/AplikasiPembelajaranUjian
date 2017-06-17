/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipembelajaranujian;

import java.io.*;
/**
 *
 * @author hp431
 */
public class Pengguna {
    private int idPengguna;
    private int kelas;
    private String namaPengguna;
    private String email;
    private String tglLahir;
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
    
    public void editBiodata(String newNama, String newEmail, int newKelas)
    {
        namaPengguna = newNama;
        email = newEmail;
        kelas = newKelas;
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
			bw.write("#email:" + email);
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

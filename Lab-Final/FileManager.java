import java.io.*;
public class FileManager {
    private File plainTextFile;
    private File cipherTextFile;

    public FileManager(String plainTextFileName, String cipherTextFileName) {
        plainTextFile = new File(plainTextFileName);
        cipherTextFile = new File(cipherTextFileName);
    }


    public void writePlainText(String plainText) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(plainTextFile));
            bw.write(plainText);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public String readPlainText() {
        String plainText = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(plainTextFile));
            String line;
            while ((line = br.readLine()) != null) {
                plainText += line;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return plainText;
    }

    public void writeCipherText(String cipherText) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cipherTextFile));
            bw.write(cipherText);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}


 



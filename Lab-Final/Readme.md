
#Name: Waseem Ghulam
#Reg # 409600
#CE-44(A);


#Classes:

import java.io.*;
import java.util.Scanner;
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


 public class CaesarCipher {
    String plainText;
    String cipherText;
    int key;

    public CaesarCipher(String plainText, int key) {
        this.plainText = plainText;
        this.key = key;
        cipherText = encrypt(plainText, key);
    }

    public String encrypt(String plainText, int key) {
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + key);
                if (ch > 'z') {
                    ch = (char) (ch - 'z' + 'a' - 1);
                }
                cipherText += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + key);
                if (ch > 'Z') {
                    ch = (char) (ch - 'Z' + 'A' - 1);
                }
                cipherText += ch;
            } else {
                cipherText += ch;
            }
        }
        return cipherText;
    }

    public  String decrypt(String cipherText, int key) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - key);
                if (ch < 'a') {
                    ch = (char) (ch + 'z' - 'a' + 1);
                }
                plainText += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - key);
                if (ch < 'A') {
                    ch = (char) (ch + 'Z' - 'A' + 1);
                }
                plainText += ch;
            } else {
                plainText += ch;
            }
        }
        return plainText;
    }

    public String getPlainText() {
        return plainText;
    }

    public String getCipherText() {
        return cipherText;
    }


}


public class TestCaesarCipher {

    public static void main(String[] args) {
        FileManager file = new FileManager("plaintext.txt", "ciphertext.txt");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter key: ");
        int key = input.nextInt();
        String plainText = "I d r i n k o n l y d e c a f";
        file.writePlainText(plainText);
        CaesarCipher cipher = new CaesarCipher(plainText, key);
        String cipherText = cipher.getCipherText();

        file.writeCipherText(cipherText);
        System.out.println("Plain text: " + cipher.decrypt(cipherText, key));
        System.out.println("Cipher text: " + cipher.getCipherText());
        
        
    }
}






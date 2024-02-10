import javax.swing.JFrame;

public class CaesarCipher extends JFrame {
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

    public String decrypt(String cipherText, int key) {
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

   

    public String getCipherText() {
        return null;
    }

    
}

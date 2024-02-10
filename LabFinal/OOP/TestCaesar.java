public class TestCaesar {
    public static void main(String[] args) {
        String plainText = "Hello World";
        int key = 3;
        CaesarCipher cc = new CaesarCipher(plainText, key);
        System.out.println("Plain Text: " + plainText);
        System.out.println("Cipher Text: " + cc.cipherText);
        System.out.println("Decrypted Text: " + cc.decrypt(cc.cipherText, key));
    }
}

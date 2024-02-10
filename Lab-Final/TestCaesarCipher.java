
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCaesarCipher extends JFrame {
    private JTextField plainTextField;
    private JTextField keyTextField;
    private JTextArea cipherTextArea;

    public TestCaesarCipher() {
        setTitle("Caesar Cipher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel plainTextLabel = new JLabel("Plain Text:");
        plainTextField = new JTextField(20);
        JLabel keyLabel = new JLabel("Key:");
        keyTextField = new JTextField(5);
        JButton encryptButton = new JButton("Encrypt");
        JButton clearButton = new JButton("Clear");
        cipherTextArea = new JTextArea(10, 10);
        cipherTextArea.setEditable(false);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plainText = plainTextField.getText();
                int key = Integer.parseInt(keyTextField.getText());

                FileManager file = new FileManager("plaintext.txt", "ciphertext.txt");
                file.writePlainText(plainText);

                CaesarCipher cipher = new CaesarCipher(plainText, key);
                String cipherText = cipher.getCipherText();
                file.writeCipherText(cipherText);

                cipherTextArea.setText(cipherText);

                
            }
            
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plainTextField.setText("");
                keyTextField.setText("");
                cipherTextArea.setText("");
            }
        });

        add(plainTextLabel);
        add(plainTextField);
        add(keyLabel);
        add(keyTextField);
        add(encryptButton);
        add(new JScrollPane(cipherTextArea));
        add(clearButton);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestCaesarCipher();
            }
        });
    }
}



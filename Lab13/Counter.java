

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Counter {

    private JFrame frame;
    private JTextField textField;
    private int count = 0; // Define a counter variable

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Counter window = new Counter();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Counter() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Count");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                textField.setText(String.valueOf(count));
            }
        });
        btnNewButton.setBounds(322, 21, 89, 23);
        frame.getContentPane().add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(141, 21, 146, 23);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }
}

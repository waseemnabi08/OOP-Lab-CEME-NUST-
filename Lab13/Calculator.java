import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField textField;
    private int firstNumber = 0;
    private int secondNumber = 0;
    private String operator = "";

    public Calculator() {
        setLayout(new BorderLayout());

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        add(panel, BorderLayout.CENTER);

        String [] label1 = {"7", "8", "9", "/"};
        String [] label2 = {"4", "5", "6", "*"};
        String [] label3 = {"1", "2", "3"};
        String [] label4 = {"0", "+", "-"};

        addButtons(panel, label1, 0);
        addButtons(panel, label2, 1);
        addButtons(panel, label3, 2);
        addButtons(panel, label4, 3);

        JButton equalsButton = new JButton("=");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        equalsButton.addActionListener(e -> {
            if (!operator.isEmpty()) {
                secondNumber = Integer.parseInt(textField.getText());
                switch (operator) {
                    case "+":
                        textField.setText(String.valueOf(firstNumber + secondNumber));
                        break;
                    case "-":
                        textField.setText(String.valueOf(firstNumber - secondNumber));
                        break;
                    case "*":
                        textField.setText(String.valueOf(firstNumber * secondNumber));
                        break;
                    case "/":
                        textField.setText(String.valueOf(firstNumber / secondNumber));
                        break;
                }
            }
        });
        panel.add(equalsButton, gbc);
    }

    private void addButtons(Container container, String[] labels, int row) {
    for (int i = 0; i < labels.length; i++) {
        final String label = labels[i];
        JButton button = new JButton(label);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = i;
        gbc.gridy = row;
        button.addActionListener(e -> {
            if (label.matches("\\d")) {
                textField.setText(textField.getText() + label);
            } else {
                firstNumber = Integer.parseInt(textField.getText());
                operator = label;
                textField.setText("");
            }
        });
        container.add(button, gbc);
    }
}

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.pack();
        calculator.setVisible(true);
    }
}



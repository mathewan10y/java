import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField display;
    private String operator;
    private double firstOperand;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(300, 50)); // Set preferred size for the text field
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Increase font size
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        ActionListener buttonListener = e -> {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("");
                operator = null;
                firstOperand = 0;
            } else if (command.equals("=")) {
                try {
                    double secondOperand = Double.parseDouble(display.getText());
                    double result = calculate(firstOperand, secondOperand, operator);
                    display.setText(String.valueOf(result));
                    operator = null; // Reset operator after calculation
                } catch (Exception ex) {
                    display.setText("Error");
                }
            } else {
                try {
                    firstOperand = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText("");
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
            }
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private double calculate(double first, double second, String operator) throws ArithmeticException {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return first / second;
            default:
                throw new UnsupportedOperationException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}

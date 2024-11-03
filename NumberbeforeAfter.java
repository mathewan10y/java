import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NumberbeforeAfter extends JFrame implements ActionListener {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public NumberbeforeAfter() {
        // Set the frame properties
        setSize(400, 200);
        setLayout(new GridLayout(4, 2, 10, 10)); // Grid layout with gaps
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Number Before and After");
        setLocationRelativeTo(null); // Center the frame

        // Create and add labels
        label1 = new JLabel("Enter a number:");
        add(label1);

        textField1 = new JTextField();
        add(textField1);

        label2 = new JLabel("The previous number:");
        add(label2);

        textField2 = new JTextField();
        textField2.setEditable(false); // Make this field non-editable
        add(textField2);

        label3 = new JLabel("The next number:");
        add(label3);

        textField3 = new JTextField();
        textField3.setEditable(false); // Make this field non-editable
        add(textField3);

        // Create and add the button
        button = new JButton("Submit");
        button.addActionListener(this);
        add(button);

        setVisible(true); // Make the frame visible
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Get the number from the first text field
            int number = Integer.parseInt(textField1.getText());
            // Calculate the previous and next numbers
            int previous = number - 1;
            int next = number + 1;
            // Update the second and third text fields
            textField2.setText(String.valueOf(previous));
            textField3.setText(String.valueOf(next));
        } catch (NumberFormatException ex) {
            // Show an error message if the input is invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid integer.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the program on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberbeforeAfter();
            }
        });
    }
}

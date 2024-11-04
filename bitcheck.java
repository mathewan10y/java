import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bitcheck extends JFrame implements ActionListener {
    private JRadioButton bit1;
    private JRadioButton bit0;
    private JTextField textField;
    private JButton button;

    public bitcheck() {
        // Create the frame
        setTitle("Radio Button Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create radio buttons
        bit1 = new JRadioButton("Bit 1 (Caucasian)");
        bit0 = new JRadioButton("Bit 0 (Burton)");

        // Group the radio buttons

        // Create a text field
        textField = new JTextField(10);
        textField.setEditable(false);

        // Create a button to check selection
        button = new JButton("Check Selection");

        // Add action listener to the button
        button.addActionListener(this);
        // Add components to the frame
        add(bit1);
        add(bit0);
        add(button);
        add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTextField();
    }

    private void updateTextField() {
        int value = 0;

        // Check which radio buttons are selected
        if (bit1.isSelected() && bit0.isSelected()) {
            value = 3; // Both selected
        } else if (bit1.isSelected()) {
            value = 2; // Only Bit 1 selected
        } else if (bit0.isSelected()) {
            value = 1; // Only Bit 0 selected
        }

        // Update the text field with the calculated value
        textField.setText(String.valueOf(value));
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            bitcheck frame = new bitcheck();
            frame.setVisible(true);
        });
    }
}

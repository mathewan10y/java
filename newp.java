import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class newp extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1;
    String s;
    JTextArea ja;
    char[] ch = new char[100];

    newp() {
        setTitle("lab");

        setSize(480, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        t1 = new JTextField();
        add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        b1 = new JButton("permutations");
        b1.setActionCommand("permutations"); // Set the action command for b1
        b1.addActionListener(this);
        add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        b2 = new JButton("combinations");
        b2.setActionCommand("combinations"); // Set the action command for b2
        b2.addActionListener(this);
        add(b2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 4;
        ja = new JTextArea();
        ja.setEditable(false);
        add(new JScrollPane(ja), gbc);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        s = t1.getText();
        char ch[] = s.toCharArray();
        ja.setText("");
        String str = ae.getActionCommand(); // Use getActionCommand() to identify the button
        if (str.equals("permutations")) {
            perm(ch, 0);
        } else if (str.equals("combinations")) {
            generateCombinationsWithRepetition(s, 0, new StringBuilder());
        }
    }

    void perm(char ch[], int index) {
        if (index == ch.length) {
            ja.append(new String(ch) + "\n");
            return;
        }

        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            perm(ch, index + 1);
            swap(ch, index, i);
        }
    }

    void generateCombinationsWithRepetition(String s, int index, StringBuilder current) {
        // Print the current combination if it's non-empty
        if (current.length() > 0) {
            ja.append(current.toString() + "\n");
        }

        // Loop through the remaining characters starting from 'index'
        for (int i = index; i < s.length(); i++) {
            // Include the character at index 'i' and recurse
            current.append(s.charAt(i));
            generateCombinationsWithRepetition(s, i + 1, current); // Keep 'i' the same for repetition
            current.deleteCharAt(current.length() - 1); // Backtrack by removing the last character
        }
    }

    void swap(char ch[], int index, int i) {
        char temp = ch[index];
        ch[index] = ch[i];
        ch[i] = temp;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new newp();
            }
        });
    }
}

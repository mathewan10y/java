
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class permutations extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1;
    String s;
    JTextArea ja;
    char[] ch = new char[100];
    String k = new String();
    String a;
    HashSet<String> hs = new HashSet<>();
    HashSet<String> ps = new HashSet<>();

    permutations() {
        setTitle("lab");
        setSize(480, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 2;
        gbc.weighty = 2;
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
        gbc.fill = GridBagConstraints.BOTH;
        b1 = new JButton("permutations");
        b1.addActionListener(this);
        add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        b2 = new JButton("combinations");
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
        JButton c = (JButton) ae.getSource();
        String str = c.getActionCommand();
        if (str.equals("permutations")) {
            perm(ch, 0);
        } else if (str.equals("combinations")) {
            generateCombinationsWithRepetition(s, 0, new StringBuilder());
        }

    }

    void perm(char ch[], int index) {

        if (index == ch.length) {

            if (!ps.contains(new String(ch) + "\n")) {
                ja.append(new String(ch) + "\n");
                ps.add(new String(ch) + "\n");

            }
        }

        // if (index == ch.length) {
        // int c = 0;

        // StringTokenizer tk = new StringTokenizer(k);
        // while (tk.hasMoreTokens()) {

        // if ((tk.nextToken()).equals(new String(ch))) {
        // c = 1;
        // }

        // }
        // if (c == 0) {
        // ja.append(new String(ch) + "\n");
        // k = k + (new String(ch) + "\n");
        // return;

        // }
        // }

        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            perm(ch, index + 1);
            swap(ch, index, i);
        }

    }

    void generateCombinationsWithRepetition(String s, int index, StringBuilder current) {
        // Print the current combination if it's non-empty
        if (current.length() > 0) {

            if (!hs.contains(current.toString() + "\n")) {
                ja.append(current.toString() + "\n");
                hs.add(current.toString() + "\n");
            }

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
                new permutations();
            }
        });
    }
}

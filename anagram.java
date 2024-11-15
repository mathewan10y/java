
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.*;

class anagram extends JFrame implements ActionListener {
    JButton b1;
    JTextField t1, b2;
    String s;
    JTextArea ja;
    char[] ch = new char[100];
    String k = new String();
    String a;

    anagram() {
        this.setTitle("anagrams");
        this.setSize(480, 600);
        this.setLayout(new GridBagLayout());
        GridBagConstraints var1 = new GridBagConstraints();
        this.setDefaultCloseOperation(3);

        var1.gridx = 0;
        var1.gridy = 0;
        var1.gridwidth = 2;
        var1.weightx = 2.0;
        var1.weighty = 2.0;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        this.t1 = new JTextField();
        this.add(this.t1, var1);

        var1.gridx = 0;
        var1.gridy = 1;
        var1.gridwidth = 1;
        var1.weightx = 1.0;
        var1.weighty = 1.0;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        this.b1 = new JButton("submit");
        this.b1.addActionListener(this);
        this.add(this.b1, var1);

        var1.gridx = 1;
        var1.gridy = 1;
        var1.gridwidth = 1;
        var1.weightx = 1.0;
        var1.weighty = 1.0;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        this.b2 = new JTextField();
        this.add(this.b2, var1);

        var1.gridx = 0;
        var1.gridy = 2;
        var1.gridwidth = 2;
        var1.gridheight = 4;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        var1.weightx = 1.0;
        var1.weighty = 4.0;
        this.ja = new JTextArea();
        this.ja.setEditable(false);
        this.add(new JScrollPane(this.ja), var1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent var1) {
        String a = t1.getText();
        String b = b2.getText();
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();

        Arrays.sort(m);
        Arrays.sort(n);
        if (Arrays.equals(m, n)) {
            ja.setText("the strings are anagrams");
        } else {
            ja.setText("the strings are not");
        }

    }

    public static void main(String[] var0) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new anagram();
            }
        });
    }
}

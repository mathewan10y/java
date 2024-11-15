
// Source code is decompiled from a .class file using FernFlower decompiler.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class lengthy extends JFrame implements ActionListener {
    JButton b1;
    JTextField t1, b2;
    String s;
    JTextArea ja;
    char[] ch = new char[100];
    String k = new String();
    String a;

    lengthy() {
        setTitle("legthy");
        setSize(480, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints var1 = new GridBagConstraints();
        setDefaultCloseOperation(3);

        var1.gridx = 0;
        var1.gridy = 0;
        var1.gridwidth = 2;
        var1.weightx = 2.0;
        var1.weighty = 2.0;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        t1 = new JTextField();
        add(this.t1, var1);

        var1.gridx = 0;
        var1.gridy = 1;
        var1.gridwidth = 1;
        var1.weightx = 1.0;
        var1.weighty = 1.0;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        b1 = new JButton("submit");
        b1.addActionListener(this);
        add(this.b1, var1);

        var1.gridx = 0;
        var1.gridy = 2;
        var1.gridwidth = 2;
        var1.gridheight = 4;
        var1.insets = new Insets(10, 10, 10, 10);
        var1.fill = 1;
        var1.weightx = 1.0;
        var1.weighty = 4.0;
        ja = new JTextArea();
        ja.setEditable(false);
        add(new JScrollPane(this.ja), var1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent var1) {
        String s = t1.getText();
        String[] str = s.split(" ");
        int max = 0;
        String l = new String();
        for (String d : str) {
            if (d.length() > max) {
                max = d.length();
                l = d;
            }
        }

        ja.setText("the longest word is  " + l);

    }

    public static void main(String[] var0) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new lengthy();
            }
        });
    }
}

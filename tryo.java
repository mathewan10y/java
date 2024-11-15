//write a java program to enter text from a textfield, when user presses a button, it writes the text into the text field, removing repeated characters.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class tryo extends JFrame implements ActionListener {
    JButton b1;
    JTextField t1;
    String s;
    char[] ch2 = new char[100];
    char[] ch = new char[100];
    ArrayList<Character> c = new ArrayList<>();

    tryo() {
        setTitle("lab");
        setSize(480, 600);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        t1 = new JTextField();
        t1.addActionListener(this);
        add(t1);

        b1 = new JButton("submit");
        b1.addActionListener(this);
        add(b1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        char[] ch2 = new char[100];
        char[] ch = new char[100];
        s = t1.getText();
        int l = s.length();
        int k = 0;
        s.getChars(0, l, ch, 0);
        for (int i = 0; ch[i] != '\0'; i++) {
            if (!c.contains((ch[i]))) {
                c.add(ch[i]);
                ch2[k] = ch[i];
                k++;
            }

        }

        // String str= new String(ch2);

        try {
            File f = new File("test.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter("test.txt");
            for (int i = 0; ch2[i] != '\0'; i++) {
                fw.write(ch2[i]);
            }
            JOptionPane.showMessageDialog(this, "the data is entered into the file", "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE);
            fw.close();

        } catch (FileNotFoundException fe) {
            System.out.println(("file not found"));
        } catch (IOException io) {
            System.out.print("exception caught");

        }

    }

    public boolean notpre(char c) {
        for (int i = 0; ch2[i] != '\0'; i++) {
            if (ch2[i] == c && c != ' ') {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new tryo();
            }
        });
    }
}

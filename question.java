import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class question extends JFrame implements ActionListener {
    JLabel lb1;
    JLabel lb2;
    JLabel lb3;
    JButton b1;
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;

    public question() {
        setTitle("number before and after");
        setLocationRelativeTo(null);
        setSize(1000, 1000);
        setLayout(new GridLayout(4, 2, 10, 10));
        setBounds(0, 0, 640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(240, 240, 240));

        lb1 = new JLabel("ENTER THE TEXT:");
        add(lb1);

        tf1 = new JTextField();
        tf1.setFont(new Font("papyrus", Font.BOLD, 20));

        tf1.addActionListener(this);
        add(tf1);

        lb2 = new JLabel("THE NUMBER BEFORE:");
        add(lb2);

        tf2 = new JTextField("XXXX");
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.addActionListener(this);
        add(tf2);

        lb2 = new JLabel("THE NUMBER AFTER:");
        add(lb2);
        tf3 = new JTextField("XXXX");
        tf3.setEditable(false);
        tf3.setFont(new Font("Arial", Font.BOLD, 20));

        tf3.addActionListener(this);
        add(tf3);
        JLabel g = new JLabel();
        add(g);
        b1 = new JButton("submit");
        b1.addActionListener(this);
        add(b1);

        tf2.setEditable(false);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String inp = tf1.getText();
        int a = Integer.parseInt(inp) - 1;
        int c = a + 2;
        String b = String.valueOf(a);
        String d = String.valueOf(c);
        tf2.setText(b);
        tf3.setText(d);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new question();
            }
        });
    }
}

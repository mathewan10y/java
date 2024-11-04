import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class dividesw {

    class gui extends JFrame implements ActionListener {
        JTextField tex1, t2, t3, t4;
        JButton b1;
        JLabel j1, j2, j3, j4, j5;

        gui() {
            setTitle("prg");
            setSize(400, 600);
            setLayout(new GridLayout(5, 2));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            j1 = new JLabel("enter number 1");
            add(j1);

            tex1 = new JTextField("");
            tex1.addActionListener(this);
            add(tex1);

            j2 = new JLabel("enter number 2");
            add(j2);

            t2 = new JTextField("");
            t2.addActionListener(this);
            add(t2);

            j3 = new JLabel("result:");
            add(j3);

            t3 = new JTextField("");
            t3.addActionListener(this);
            add(t3);

            j4 = new JLabel("");
            add(j4);

            b1 = new JButton("divide");
            b1.addActionListener(this);
            add(b1);

            j5 = new JLabel("exception");
            add(j5);

            t4 = new JTextField("");
            t4.addActionListener(this);
            add(t4);

            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(tex1.getText());
                double b = Double.parseDouble(t2.getText());

                if (b == 0) {
                    throw new ArithmeticException("zero division");
                }

                double c = a / b;
                String s = "" + c;
                t3.setText(s);
                t4.setText("");

            } catch (ArithmeticException ae) {
                System.out.println(" zero division");
                String h = ae.getMessage();
                t4.setText(h);
            }

            catch (NumberFormatException ek) {
                System.out.println("exception caught");
                String h = "invalid input ";
                t4.setText(h);
            }

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new dividesw().new gui();

            }
        });

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class swthr {

    class gui extends JFrame implements ActionListener {
        JTextField tex1;
        JButton b1;

        gui() {
            setTitle("prg");
            setSize(400, 600);
            setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tex1 = new JTextField("");
            tex1.setPreferredSize(new Dimension(400, 100));
            tex1.addActionListener(this);
            b1 = new JButton("print");
            b1.addActionListener(this);

            add(b1, BorderLayout.CENTER);
            add(tex1, BorderLayout.NORTH);
            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                int t = Integer.parseInt(tex1.getText());
                new kochi(t);
                new thri(t);
            } catch (NumberFormatException ek) {
                System.out.println("exception caught");
            }

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new swthr().new gui();

            }
        });

    }
}

class kochi implements Runnable {
    int n;

    kochi(int n) {
        this.n = n;
        Thread t = new Thread(this, "thread2");
        t.start();
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.err.println("kochi");
        }
    }
}

class thri implements Runnable {
    int n;

    thri(int n) {
        this.n = n;
        Thread t = new Thread(this, "thread");
        t.start();
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.err.println("thrikkakara");
        }
    }

}
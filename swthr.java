import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

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

public class swthr {

    public class gui extends JFrame implements ActionListener {

        gui() {
            setTitle("prg");
            setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextField t1 = new JTextField("");
            t1.addActionListener(this);

            JButton b1 = new JButton("print");
            b1.addActionListener(this);

            add(b1);
            add(t1);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            String s = t1.getText(t1);

        }

    }

    public static void main(String[] args) {

        new thri(3);
        new kochi(4);
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
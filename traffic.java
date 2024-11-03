import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Traffic extends JFrame implements ActionListener, AdjustmentListener {

    private JScrollBar scb1;
    private JLabel lbs;
    private TrafficLight traf;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private Color red_c = Color.white;
    private Color green_c = Color.white;
    private Color yellow_c = Color.white;

    public Traffic() {
        setSize(400, 480);
        setLayout(new BorderLayout());
        setBounds(0, 0, 640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scb1 = new JScrollBar(JScrollBar.VERTICAL, 0, 5, 0, 100);// scrollbar
        lbs = new JLabel("scroll");

        traf = new TrafficLight();
        add(traf, BorderLayout.CENTER);
        add(lbs, BorderLayout.SOUTH);
        add(scb1, BorderLayout.EAST);
        scb1.addAdjustmentListener(this);

        r1 = new JRadioButton("Red");
        r2 = new JRadioButton("Yellow");
        r3 = new JRadioButton("Green");

        ButtonGroup gp = new ButtonGroup();
        gp.add(r1);
        gp.add(r2);
        gp.add(r3);

        JPanel jp = new JPanel();
        jp.add(r1, BorderLayout.NORTH);
        jp.add(r2, BorderLayout.NORTH);
        jp.add(r3, BorderLayout.NORTH);
        jp.setBounds(140, 350, 640, 480);
        add(jp);

        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (r1.isSelected() == true) {
            red_c = Color.red;
            yellow_c = getBackground();
            green_c = getBackground();
        } else if (r2.isSelected() == true) {
            yellow_c = Color.yellow;
            red_c = getBackground();
            green_c = getBackground();

        } else if (r3.isSelected() == true) {
            yellow_c = getBackground();
            red_c = getBackground();
            green_c = Color.green;

        }
        traf.repaint();
    }

    public void adjustmentValueChanged(AdjustmentEvent ae) {
        int value = scb1.getValue();
        traf.setPreferredSize(new Dimension(traf.getWidth(), 300 + value)); // Adjust the height based on scrollbar
                                                                            // value
        traf.revalidate(); // to refresh the panel
        lbs.setText("Scrollbar value: " + value);
    }

    class TrafficLight extends JPanel {
        public TrafficLight() {
            setPreferredSize(new Dimension(100, 300)); // Initial size
        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.drawOval(50, 50, 50, 50);
        g.drawOval(50, 110, 50, 50);
        g.drawOval(50, 170, 50, 50);
        g.setColor(red_c);
        g.fillOval(50, 50, 50, 50);
        g.setColor(yellow_c);
        g.fillOval(50, 110, 50, 50);
        g.setColor(green_c);
        g.fillOval(50, 170, 50, 50);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Traffic();

            }
        });

    }

}

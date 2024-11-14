import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class sliding extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[9];
    private int[] order = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
    private JTextField display = new JTextField("");

    public sliding() {
        setTitle("puzzle");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonpanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            if (i != 0) {
                buttons[i] = new JButton(String.valueOf(i));
            } else {
                buttons[i] = new JButton("");
            }
            buttons[i].addActionListener(this);
            buttonpanel.add(buttons[i]);
        }
        add(buttonpanel, BorderLayout.CENTER);
        
        shuffle();
        updatebuttons();
        setVisible(true);
    }

    private void shuffle() {
        for (int i = 0; i < 9; i++) {
            int j = (int) (Math.random() * 9);
            int temp = order[i];
            order[i] = order[j];
            order[j] = temp;
        }
    }

    public void updatebuttons() {
        for (int i = 0; i < 9; i++) {
            if (order[i] == 0) {
                buttons[i].setText("");
            } else {
                buttons[i].setText(String.valueOf(order[i]));
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        int index = -1;

        for (int i = 0; i < 9; i++) {

            if (buttons[i] == clicked) {
                index = i;
                break;
            }
        }
        int emptyindex = findEmptyIndex();
        if (isadjacent(index, emptyindex)) {
            order[emptyindex] = order[index];
            order[index] = 0;
            updatebuttons();
            check();
        }

    }

    private int findEmptyIndex() {
        for (int i = 0; i < 9; i++) {
            if (order[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    boolean isadjacent(int index1, int index2) {
        int row1 = index1 / 3;
        int row2 = index2 / 3;
        int col1 = index1 % 3;
        int col2 = index2 % 3;
        return ((Math.abs(row1 - row2) + Math.abs(col1 - col2)) == 1);
    }

    void check() {
        for (int i = 0; i < 8; i++) {
            if (order[i] != i + 1) {
                return;
            }

        }
        display.setText("you win");
    }

    public static void main(String[] args) {
        new sliding();
    }
}
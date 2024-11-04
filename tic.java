
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tic extends JFrame implements ActionListener {
    JButton[][] buttons = new JButton[3][3];
    char player = 'X';

    tic() {
        setSize(400, 400);
        setTitle("Tic tac toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        // Just only for look. Ignore if cant understand
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new tic();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton current = (JButton) e.getSource();
        if (!current.getText().equals(""))
            return;
        current.setText(String.valueOf(player));

        if (checkWin()) {
            JOptionPane.showMessageDialog(this, "Player " + player + " won");
            resetBoard();
        } else if (isFull()) {
            JOptionPane.showMessageDialog(this, "Tie!!");
            resetBoard();
        } else {
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    private boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(player)) &&
                    buttons[i][1].getText().equals(String.valueOf(player)) &&
                    buttons[i][2].getText().equals(String.valueOf(player))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(player)) &&
                    buttons[1][i].getText().equals(String.valueOf(player)) &&
                    buttons[2][i].getText().equals(String.valueOf(player))) {
                return true;
            }
        }
        if (buttons[0][0].getText().equals(String.valueOf(player)) &&
                buttons[1][1].getText().equals(String.valueOf(player)) &&
                buttons[2][2].getText().equals(String.valueOf(player))) {
            return true;
        }
        if (buttons[0][2].getText().equals(String.valueOf(player)) &&
                buttons[1][1].getText().equals(String.valueOf(player)) &&
                buttons[2][0].getText().equals(String.valueOf(player))) {
            return true;
        }
        return false;
    }

    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals(""))
                    return false;
            }
        }
        return true;
    }
}
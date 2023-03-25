import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame implements ActionListener {

    char ch = 'o';
    int cnt = 0;
    JButton[] button = new JButton[9];
    JTextField headField;
    boolean gameOver = false;

    TicTacToe() {

        headField = new JTextField();
        headField.setBounds(0, 0, 300, 48);
        headField.setBorder(new LineBorder(Color.BLACK, 1));
        headField.setEditable(false);
        add(headField);

        headField.setText("'" + ch + "'" + " turn");
        headField.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        headField.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 50, 300, 450);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new GridLayout(3, 3, 1, 1));
        add(buttonPanel);

        for (int i = 0; i < 9; i++) {

            button[i] = new JButton();
            button[i].setText(String.valueOf(i));
            buttonPanel.add(button[i]);
            button[i].setBorder(null);
            button[i].setFont(new Font("Arial Rounded MT Bold", 1, 25));
            button[i].addActionListener(this);
        }

        getContentPane().setLayout(null);
        setSize(315, 500);
        setLocation(440, 110);
        setVisible(true);

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == button[0]) {

            button[0].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[0].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[1]) {

            button[1].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[1].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[2]) {

            button[2].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[2].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[3]) {

            button[3].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[3].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[4]) {

            button[4].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[4].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[5]) {

            button[5].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[5].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[6]) {

            button[6].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[6].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[7]) {

            button[7].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[7].setEnabled(false);
            cnt++;
        } else if (ae.getSource() == button[8]) {

            button[8].setText(String.valueOf(ch));
            ch = change(ch);
            headField.setText("'" + ch + "'" + " turn");
            button[8].setEnabled(false);
            cnt++;
        }
        checkWin();
    }

    public char change(char c) {
        if (c == 'o')
            c = 'x';
        else
            c = 'o';
        return c;
    }

    public void checkWin() {
        if (button[0].getText().equals(button[1].getText()) && (button[1].getText().equals(button[2].getText()))) {
            gameOver = true;
            if (gameOver) {
                gameFinish(0, 1, 2);
            }
            return;
        } else if (button[0].getText().equals(button[3].getText()) && button[3].getText().equals(button[6].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(0, 3, 6);
            }
            return;

        } else if (button[0].getText().equals(button[4].getText()) && button[4].getText().equals(button[8].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(0, 4, 8);
            }
            return;

        } else if (button[2].getText().equals(button[5].getText()) && button[5].getText().equals(button[8].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(2, 5, 8);
            }
            return;
        } else if (button[3].getText().equals(button[4].getText()) && button[4].getText().equals(button[5].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(3, 4, 5);
            }
            return;
        } else if (button[6].getText().equals(button[7].getText()) && button[7].getText().equals(button[8].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(6, 7, 8);
            }
            return;
        } else if (button[1].getText().equals(button[4].getText()) && button[4].getText().equals(button[7].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(1, 4, 7);
            }
            return;
        } else if (button[2].getText().equals(button[4].getText()) && button[4].getText().equals(button[6].getText())) {
            gameOver = true;
            if (gameOver) {
                gameFinish(2, 4, 6);
            }
            return;
        } else if (cnt == 9) {
            headField.setText("It's a Draw");
            int val = JOptionPane.showConfirmDialog(null, "Wanted to play again ???", null, 2);
            if (val == JOptionPane.YES_OPTION) {
                dispose();
                new TicTacToe();
            } else if (val == JOptionPane.CANCEL_OPTION)
                dispose();
        }

    }

    public void gameFinish(int a, int b, int c) {
        for (int i = 0; i < 9; i++)
            button[i].setEnabled(false);
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        headField.setText(button[a].getText() + " wins");

        int val = JOptionPane.showConfirmDialog(null, "Wanted to play again ???", null, 2);
        if (val == JOptionPane.YES_OPTION) {
            dispose();
            new TicTacToe();
        } else if (val == JOptionPane.CANCEL_OPTION)
            dispose();

    }

}

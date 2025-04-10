package ap.excercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main_EX2_PM_3_2 extends JFrame implements KeyListener {//i used Ai to write some part of this code

    private final int k = 9; 
    private final int c = 15; 
    private final int cellSize = 30;
    private char[][] matrix;
    private int pacmanX, pacmanY;
    private int score = 0;
    private int remainingDots = c;

    public Main_EX2_PM_3_2() {
        setTitle("Pacman - Graphical Edition");
        setSize((k + 2) * cellSize, (k + 2) * cellSize + 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
        initializeGame();
        setVisible(true);
    }

    private void initializeGame() {
        matrix = new char[k + 2][k + 2];
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    matrix[i][j] = '*';
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        Random random = new Random();
        int placed = 0;
        while (placed < c) {
            int i = random.nextInt(k) + 1;
            int j = random.nextInt(k) + 1;
            if (matrix[i][j] == ' ') {
                matrix[i][j] = '.';
                placed++;
            }
        }

        int[][] corners = {{1, 1}, {1, k}, {k, 1}, {k, k}};
        int[] start = corners[random.nextInt(4)];
        pacmanX = start[0];
        pacmanY = start[1];
        matrix[pacmanX][pacmanY] = 'X';
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawGame((Graphics2D) g);
    }

    private void drawGame(Graphics2D g) {
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                int x = j * cellSize;
                int y = i * cellSize + 30;

                switch (matrix[i][j]) {
                    case '*':
                        g.setColor(Color.BLACK);
                        g.fillRect(x, y, cellSize, cellSize);
                        break;
                    case '.':
                        g.setColor(Color.RED);
                        g.fillOval(x + cellSize / 4, y + cellSize / 4, cellSize / 2, cellSize / 2);
                        break;
                    case 'X':
                        g.setColor(Color.BLUE);
                        g.fillOval(x, y, cellSize, cellSize);
                        break;
                    default:
                        g.setColor(Color.WHITE);
                        g.fillRect(x, y, cellSize, cellSize);
                }

                g.setColor(Color.GRAY);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, (k + 2) * cellSize + 20);
        g.drawString("Remaining: " + remainingDots, 100, (k + 2) * cellSize + 20);
    }

    private void move(int dx, int dy) {// i dont know what is wrong with this part
        int newX = pacmanX + dx;
        int newY = pacmanY + dy;

        if (matrix[newX][newY] == '*') {
            return;
        }

        if (matrix[newX][newY] == '.') {
            score++;
            remainingDots--;
        }

        matrix[pacmanX][pacmanY] = ' ';
        pacmanX = newX;
        pacmanY = newY;
        matrix[pacmanX][pacmanY] = 'X';

        repaint();

        if (remainingDots == 0) {
            JOptionPane.showMessageDialog(this, "You won! Final Score: " + score);
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                move(-1, 0);
                break;
            case KeyEvent.VK_DOWN:
                move(1, 0);
                break;
            case KeyEvent.VK_LEFT:
                move(0, -1);
                break;
            case KeyEvent.VK_RIGHT:
                move(0, 1);
                break;
            case KeyEvent.VK_Q:
                JOptionPane.showMessageDialog(this, "Game Exited!");
                System.exit(0);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new Main_EX2_PM_3_2();
    }
}

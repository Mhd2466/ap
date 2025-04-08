package ap.excercises.ex2;

import java.io.*;
import java.util.Random;

public class Main_EX2_PM_2_4 {//the code had some problems that i could not fined
    private char[][] matrix;
    private int x, y;
    private int score = 0;
    private int c;
    private int k;
    private long startTime;
    private final Random random = new Random();

    private final String SAVE_FILE = "savegame.txt";

    public Main_EX2_PM_2_4(int k, int c) {
        this.k = k;
        this.c = c;
        matrix = new char[k + 2][k + 2];
        generateMatrix();
        placeDots();
        placePlayer();
        startTime = System.currentTimeMillis();
    }

    private void generateMatrix() {
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                matrix[i][j] = (i == 0 || i == k + 1 || j == 0 || j == k + 1) ? '*' : ' ';
            }
        }
    }

    private void placeDots() {
        int placed = 0;
        while (placed < c) {
            int i = random.nextInt(k) + 1;
            int j = random.nextInt(k) + 1;
            if (matrix[i][j] == ' ') {
                matrix[i][j] = '.';
                placed++;
            }
        }
    }

    private void placePlayer() {
        int[][] corners = {{1, 1}, {1, k}, {k, 1}, {k, k}};
        int[] start = corners[random.nextInt(4)];
        x = start[0];
        y = start[1];
        if (matrix[x][y] == '.') c--;
        matrix[x][y] = 'X';
    }

    public void printMatrix() {
        for (char[] row : matrix) {
            for (char cell : row) System.out.print(cell);
            System.out.println();
        }
    }

    public void printScore() {
        System.out.println("Score: " + score);
    }

    public void printRemainTime() {
        long now = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (now - startTime) + " ms");
    }

    public void move(int direction) {
        int newX = x;
        int newY = y;
    
        switch (direction) {
            case 0:
                newX--; // Up
                break;
            case 1:
                newX++; // Down
                break;
            case 2:
                newY--; // Left
                break;
            case 3:
                newY++; // Right
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }
    
        if (matrix[newX][newY] == '*') {
            System.out.println("Hit a wall!");
            return;
        }
    
        if (matrix[newX][newY] == '.') {
            score++;
            c--;
        }
    
        matrix[x][y] = ' ';
        x = newX;
        y = newY;
        matrix[x][y] = 'X';
    
        if (c == 0) {
            System.out.println("Game Over!");
            printScore();
            printRemainTime();
            System.exit(0);
        }
    }
    
    // Save game to a file
    public void save() {
        try (PrintWriter out = new PrintWriter(new FileWriter(SAVE_FILE))) {
            out.println(k);
            out.println(c);
            out.println(score);
            out.println(x + " " + y);
            out.println(System.currentTimeMillis() - startTime); // Save elapsed time

            for (char[] row : matrix) {
                out.println(new String(row));
            }

            System.out.println("[Game saved]");
        } catch (IOException e) {
            System.out.println("Failed to save the game!");
            e.printStackTrace();
        }
    }

    // Load game from file
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            k = Integer.parseInt(reader.readLine());
            c = Integer.parseInt(reader.readLine());
            score = Integer.parseInt(reader.readLine());

            String[] pos = reader.readLine().split(" ");
            x = Integer.parseInt(pos[0]);
            y = Integer.parseInt(pos[1]);

            long elapsedTime = Long.parseLong(reader.readLine());
            startTime = System.currentTimeMillis() - elapsedTime;

            matrix = new char[k + 2][k + 2];
            for (int i = 0; i < k + 2; i++) {
                String line = reader.readLine();
                matrix[i] = line.toCharArray();
            }

            System.out.println("[Game loaded successfully]");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to load the game!");
            e.printStackTrace();
        }
    }
}

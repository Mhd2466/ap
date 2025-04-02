package ap.excercises.ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {
        private static final String SAVE_FILE = "savegame.txt";// i used AI for understanding some parts and how to use FILE system in this code

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char[][] matrix;
        int k = 0, x = 0, y = 0, c = 0, score = 0;
        long startTime;

        File file = new File(SAVE_FILE);
        if (file.exists()) {
            System.out.println("Loading saved game...");
            int[] gameData = loadGame();
            k = gameData[0];
            x = gameData[1];
            y = gameData[2];
            c = gameData[3];
            score = gameData[4];
            startTime = gameData[5];
            matrix = loadMatrix(k);
        } else {
            System.out.print("Give me k: ");
            k = scanner.nextInt();
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

            int emptyCells = k * k;
            while (true) {
                System.out.print("Give me c (must be ≤ " + emptyCells + "): ");
                c = scanner.nextInt();
                if (c <= emptyCells) break;
                System.out.println("Invalid input! Please enter a valid number.");
            }

            int count = 0;
            while (count < c) {
                int i = random.nextInt(k) + 1;
                int j = random.nextInt(k) + 1;
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = '.';
                    count++;
                }
            }

            int[][] corners = {{1, 1}, {1, k}, {k, 1}, {k, k}};
            int[] startCorner = corners[random.nextInt(4)];
            x = startCorner[0];
            y = startCorner[1];
            matrix[x][y] = 'X';

            score = 0;
            startTime = System.currentTimeMillis();
        }

        printMatrix(matrix);

        while (true) {
            System.out.print("Enter direction (w: UP, s: DOWN, a: LEFT, d: RIGHT, q: QUIT, e: SAVE & EXIT): ");
            char input = scanner.next().charAt(0);

            int newX = x, newY = y;
            switch (input) {
                case 'w': newX--; break;
                case 's': newX++; break;
                case 'a': newY--; break;
                case 'd': newY++; break;
                case 'q': 
                    System.out.println("EXIT");
                    file.delete();
                    scanner.close();
                    return;
                case 'e':
                    saveGame(matrix, k, x, y, c, score, startTime);
                    System.out.println("Game saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input! Use w, a, s, d to move, q to quit.");
                    continue;
            }

            if (matrix[newX][newY] == '*') {
                System.out.println("Hitting the game wall!");
            } else {
                if (matrix[newX][newY] == '.') {
                    score++;
                    c--;
                }

                matrix[x][y] = ' ';
                x = newX;
                y = newY;
                matrix[x][y] = 'X';

                if (c == 0) {
                    long finishTime = System.currentTimeMillis();
                    long timeElapsed = finishTime - startTime;

                    System.out.println("\nGame Over!");
                    System.out.println("Final Score: " + score);
                    System.out.println("Total Time Played: " + timeElapsed + " ms");

                    file.delete();
                    scanner.close();
                    return;
                }
            }

            printMatrix(matrix);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static void saveGame(char[][] matrix, int k, int x, int y, int c, int score, long startTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            writer.write(k + " " + x + " " + y + " " + c + " " + score + " " + startTime);
            writer.newLine();

            for (char[] row : matrix) {
                writer.write(row);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] loadGame() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String[] data = reader.readLine().split(" ");
            return new int[]{
                Integer.parseInt(data[0]),
                Integer.parseInt(data[1]),
                Integer.parseInt(data[2]),
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5])
            };
        } catch (IOException e) {
            e.printStackTrace();
            return new int[6];
        }
    }

    private static char[][] loadMatrix(int k) {
        char[][] matrix = new char[k + 2][k + 2];
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            reader.readLine();
            for (int i = 0; i < k + 2; i++) {
                matrix[i] = reader.readLine().toCharArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }
}

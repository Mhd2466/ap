package ap.excercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_2 {//this code was so messy, so i organised it with AI ;)
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.print("Give me k: ");
        int k = scanner.nextInt();

        char[][] matrix = new char[k + 2][k + 2];


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
        int c;
        while (true) {
            System.out.print("Give me c (must be ≤ " + emptyCells + "): ");
            c = scanner.nextInt();
            if (c <= emptyCells) break;
            System.out.println("Invalid input! Please enter a valid number.");
        }


        int count = 0;
        while (count < c) {
            int i = random.nextInt(k) +1; 
            int j = random.nextInt(k) +1;
            if (matrix[i][j] == ' ') { 
                matrix[i][j] = '.';
                count++;
            }
        }


        int[][] corners = {{1, 1}, {1, k}, {k, 1}, {k, k}};
        int[] startCorner = corners[random.nextInt(4)];
        int x = startCorner[0];
        int y = startCorner[1];
        matrix[x][y] = 'X';

        int score = 0;
        long startTime = System.currentTimeMillis(); 


        printMatrix(matrix);

        while (true) {
            System.out.print("Enter direction (w: UP, s: DOWN, a: LEFT, d: RIGHT, q: QUIT): ");
            char input = scanner.next().charAt(0); 


            int newX = x, newY = y;
            switch (input) {
                case 'w': newX--; break;



                case 's': newX++; break;

                case 'a': newY--; break;
                case 'd': newY++; break;
                case 'q': 
                    System.out.println("EXIT");
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


    private static void printMatrix(char[][] matrix) { //for printing the matrix
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
}
}

package ap.excercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.print("Give me k: ");
        int k = scanner.nextInt();

        char[][] matx = new char[k + 2][k + 2];


        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    matx[i][j] = '*';
                } else {
                    matx[i][j] = ' ';
                }
            }
        }

        int emptyCells = k * k;


        int c;
        while (true) {
            System.out.print("Give me c (must be ≤ " + emptyCells + "): ");
            c = scanner.nextInt();
            if (c <= emptyCells) break;//break is for while looop
            System.out.println("invalid input!");
        }


        int count = 0;
        while (count < c) {
            int i = random.nextInt(k) + 1;
            int j = random.nextInt(k) + 1;
            if (matx[i][j] == ' ') { 
                matx[i][j] = '.';
                count++;
            }
        }

        scanner.close();


        for (int i = 0; i < k + 2; i++) {// for showing the matrix
            for (int j = 0; j < k + 2; j++) {
                System.out.print(matx[i][j]);
            }
            System.out.println();
        }
    }
}

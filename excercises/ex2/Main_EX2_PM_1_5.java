package ap.excercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();


        System.out.print("Give me k: ");



        int k = scanner.nextInt();

        char[][] matrix = new char[k +2][k +2];


        for (int i =0; i <k + 2; i++) {
            for (int j =0; j < k + 2; j++) {





                if (i ==0 ||i == k + 1 || j == 0||j ==k+ 1) {


                    matrix[i][j] = '*';
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        int[][] corners = {{1, 1}, {1, k}, {k, 1}, {k, k}};



        int[] startCorner = corners[random.nextInt(4)];
        int x = startCorner[0];

        int y = startCorner[1];


        matrix[x][y] = 'X';

        scanner.close();


        while (true) {

            int direction = random.nextInt(4);//i used AI for understanding 'random' in this code
            System.out.println("Direction: " + directionToString(direction));


            int newX = x, newY = y;
            switch (direction) {
                case 0: newX--; break; //this form is for going in diferent direction in x and y
                case 1: newY++; break;
                case 2: newX++; break; 

                case 3: newY--; break; 
            }


            if (matrix[newX][newY] == '*') {
                System.out.println("hitting the game wall");
            } else {

                matrix[x][y] =' '; 
                x = newX;


                y = newY;
                matrix[x][y] ='X';
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


    private static String directionToString(int direction) {


        switch (direction) {
            case 0: return "UP";

            case 1: return "RIGHT";


            case 2: return "DOWN";

            case 3: return "LEFT";
            
            default: return "UNKNOWN";

        }
    }
}

package ap.excercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_1 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.print("give me k: ");
        int k = scanner.nextInt();

        scanner.close();


        for (int i = 0; i < k + 2; i++) {
            System.out.print("*");
        }
        System.out.println();


        for (int i = 0; i < k; i++) {

            System.out.print("*");

            for (int j = 0; j < k; j++) {

                System.out.print(" ");
            }
            System.out.println("*");
        }


        for (int i = 0; i < k + 2; i++) {


            System.out.print("*");
        }
        System.out.println();
    }
}

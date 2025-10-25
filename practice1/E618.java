package ap.practice1;

import java.util.Scanner;

public class E618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("enter the length of the diamund: ");
        int Length = scanner.nextInt();



    
        


        for (int i = 1; i <= Length; i++) {
            for (int j = 1; j <= Length- i; j++) {
                System.out.print(" ");
            }

            for (int j =1; j <= 2 *i -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (int i = Length -1; i >= 1;i--) {

            for (int j = 1; j <= Length - i; j++) {
                System.out.print(" ");
            }
            for (int j =1; j <= 2 * i - 1;j++) {
                System.out.print("*");
            }



            System.out.println();
        }
        scanner.close();

    }


    
}

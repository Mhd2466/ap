package ap.practice1;

import java.util.Scanner;

public class E613 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        if (number == 0) {
            System.out.println(0);
        } else {
            while (number > 0) {
                System.out.println(number % 2); 
                number /= 2;
            }
        }
        
        scanner.close();
    }
}


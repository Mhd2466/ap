package ap.practice1;

import java.util.Scanner;

public class E61e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); 

        int sum = 0;

        

        while (num > 0) {
            int digit = num % 10; 

            if (digit % 2 != 0) { 
                sum += digit;
            }

            num /= 10;
        }


        System.out.println("Sum of all odd digits: " + sum);


    }
    
}

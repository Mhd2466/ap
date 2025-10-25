package ap.practice1;

import java.util.Scanner;

public class E62a {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of integers (enter 0 to stop):");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int num;
 
        
        while (true) {
            num = scanner.nextInt();
            if (num == 0) break; 
            
            if (num < min) min = num;
            if (num > max) max = num;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("No valid input provided.");
        } else {
            System.out.println("Smallest number: " + min);
            System.out.println("Largest number: " + max);
        }


    }
    
}

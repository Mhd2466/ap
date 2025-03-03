package ap.practice1;

import java.util.Scanner;

public class E62b {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of integers (enter 0 to stop):");

        int evenCount = 0;
        int oddCount = 0;
        int num;

        while (true) {
            num = scanner.nextInt();
            if (num == 0) break; 
            
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count: " + oddCount);


    }
    
}

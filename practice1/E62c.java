package ap.practice1;

import java.util.Scanner;

public class E62c {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of integers (enter 0 to stop):");

        int sum = 0;
        int num;

        
        while (true) {
            num = scanner.nextInt();
            if (num == 0) break; 
            
            sum += num;
            System.out.print(sum + " ");
        }

        System.out.println();

    }
    
}

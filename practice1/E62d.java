package ap.practice1;

import java.util.Scanner;

public class E62d {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of integers (enter -1 to stop):");

        int prev = -1; /*  Previous number*/
        int num;
        boolean firstDuplicate = true;

        
        while (true) {
            num = scanner.nextInt();
            if (num == -1) break; 
            
            if (num == prev) {
                if (firstDuplicate) { 
                    System.out.print(num + " ");
                    firstDuplicate = false;
                }
            } else {
                firstDuplicate = true;
            }

            prev = num;
        }

    }
}

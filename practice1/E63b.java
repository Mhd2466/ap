package ap.practice1;

import java.util.Scanner;

public class E63b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");


        String input = scanner.nextLine();

        System.out.print("Every second letter: ");  


        for (int i = 1; i < input.length(); i += 2) {
            
            System.out.print(input.charAt(i));
        }

        System.out.println();
    }
    
}

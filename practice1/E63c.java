package ap.practice1;

import java.util.Scanner;

public class E63c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String output = input.replaceAll("[AEIOUaeiou]", "_");//i used AI for " input.replaceAll("[AEIOUaeiou]", "_") "

        System.out.println("Modified string: " + output);
        
    }
    
}

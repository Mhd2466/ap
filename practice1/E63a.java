package ap.practice1;

import java.util.Scanner;

public class E63a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.print("Uppercase letters: ");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {//I used AI for this part of code, i did not know about "Character.isUpperCase"
                System.out.print(ch);
            }
        }

        System.out.println();
       
    }
    
}

package ap.practice1;

import java.util.Scanner;

public class E69 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word: ");


        String word = scanner.nextLine();
        
        
        
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) { 


            reversed += word.charAt(i);
        }
        
        System.out.println("Reversed word: " + reversed);
        
        
        scanner.close();
    }
}

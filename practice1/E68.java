package ap.practice1;

import java.util.Scanner;

public class E68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word: ");  
         
        String word = scanner.nextLine();
        
        for (int i = 0; i < word.length(); i++) {
            
            System.out.println(word.charAt(i));
        }
        
        scanner.close();
    }
}


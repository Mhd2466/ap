package ap.practice1;

import java.util.Scanner;

public class E63e {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();


    System.out.print("Positions of vowels: ");

    for (int i = 0; i < input.length(); i++) {


        char ch = input.charAt(i);
        if ("AEIOUaeiou".indexOf(ch) != -1) {


            System.out.print(i + " ");
        }
    }

    System.out.println();
    }
}

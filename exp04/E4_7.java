package ap.exp04;

import java.util.Scanner;

public class E4_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("give me your string");
        String s = input.nextLine();

        System.out.println("all numbers");
        generatePermutations("", s);

        input.close();
    }

    public static void generatePermutations(String prefix, String remain) {
        if (remain.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < remain.length(); i++) {
                char ch = remain.charAt(i);
                String left = remain.substring(0, i);
                String right = remain.substring(i + 1);
                generatePermutations(prefix + ch, left + right);
            }
        }
    }
}

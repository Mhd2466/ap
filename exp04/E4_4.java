package ap.exp04;

import java.util.Scanner;

public class E4_4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("give me your String");
        String s = input.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                System.out.print(Character.toUpperCase(ch));
            }
            else if (Character.isUpperCase(ch)) {
                System.out.print(Character.toLowerCase(ch));
                
            }
            else{
                System.out.print(ch);
            }
        }


        



        input.close();
    }
}

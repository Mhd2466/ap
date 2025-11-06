package ap.exp04;

import java.util.Scanner;

public class E4_2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("give me your String");
        String s = input.nextLine();


        for (int i = s.length()-1; i >=0 ; i--) {

            System.out.print(s.charAt(i));
            
        }


        



        input.close();
    }
}

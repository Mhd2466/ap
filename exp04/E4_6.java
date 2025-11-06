package ap.exp04;

import java.util.Scanner;

public class E4_6 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("give me your String");
        String s = input.nextLine();
        StringBuilder p = new StringBuilder("");


        p.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (p.charAt(p.length()-1) != s.charAt(i)) {
                p.append(s.charAt(i));
            }
            
            
        }
        System.out.print(p);


        



        input.close();
    }
}

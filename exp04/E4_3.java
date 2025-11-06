package ap.exp04;

import java.util.Scanner;

public class E4_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("give me your String");


        String s = input.nextLine();

        int[] count= new int[256];//there are 8 bit in a byte

        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            count[ch]++;


            
        }
        char mychar = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch] == 1){
                mychar=ch;
                break;
            }
        }
        System.out.println(mychar);


        



        input.close();
    }
}

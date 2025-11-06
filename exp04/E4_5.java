package ap.exp04;

import java.util.Scanner;

public class E4_5 {
    public static void main(String[] args) {
        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("give me your String");
        String s = input.nextLine();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '1':
                    num+=1;
                    break;
                case '2':
                    num+=2;
                    break;
                case '3':
                    num+=3;
                    break;
                case '4':
                    num+=4;
                    break;
                case '5':
                    num+=5;
                    break;
                case '6':
                    num+=6;
                    break;
                case '7':
                    num+=7;
                    break;
                case '8':
                    num+=8;
                    break;
                case '9':
                    num+=9;
                    break;

                
            
                default:
                    break;
            }
            
        }


        System.out.println(num);

        



        input.close();
    }
}

package ap.P;

import java.util.Scanner;

public class E510 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] x =new int[6];
        int o=0;

        for (int i = 0; i < 6; i++) {
            
            System.out.println("give me the number " +(i+1));
            x [i]= input.nextInt();
            
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
                if(x[i] == x[j]){
                    o++;
                    break;
                }

                
            }
        }
        if(o==0) {
            System.out.println("no pair");
        }
        if(o==1) {
            System.out.println("one pair");
        }
        if(o==2) {
            System.out.println("two pair");
        }

        input.close();
    }
    
}

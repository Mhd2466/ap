package ap.exp03;

import java.util.Scanner;

public class E3_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int temp = 0;
        int max = 0 ;
        System.out.println("give me the length");
        int length = input.nextInt();

        int[][] a = new int [length][length];
        System.out.println("give me a");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                a[i][j]=input.nextInt();
            }
        }

        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                temp +=a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1];
                if (temp>max) {
                    max=temp;
                
                    
                }
                temp=0;
            }
        }
        System.out.println(max);
        input.close();
    }
}

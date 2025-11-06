package ap.exp03;

import java.util.Scanner;

public class E3_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("give me length");
        int length = input.nextInt();
        int[][] a = new int [length][length];

        int temp=0;
        int max=0;
        System.out.println("give me matrix");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                a[i][j]=input.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                temp+=a[i][j];

    
            }
            if (temp>max) {
                    max=temp;
                }
            temp=0;
        }
        System.out.println(max);

        input.close();
    }
}

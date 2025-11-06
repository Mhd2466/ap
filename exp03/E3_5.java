package ap.exp03;

import java.util.Scanner;

public class E3_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("give me the length");
        int length = input.nextInt();

        int[][] a = new int [length][length];

        System.out.println("give me a");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                a[i][j]=input.nextInt();
            }
        }

        System.out.println("give me the x");
        int x = input.nextInt();
        System.out.println("give me the y");
        int y = input.nextInt();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i!=x && j!=y) {
                    System.out.print(a[i][j]+" ");
                    
                }
            
            }
            System.out.println("\n");
        }
        input.close();
    }
}

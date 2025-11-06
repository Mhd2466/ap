package ap.exp03;

import java.util.Scanner;

public class E3_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("give me the lengthx");
        int lengthx = input.nextInt();
        System.out.println("give me the lengthy");
        int lengthy = input.nextInt();

        int[][] a = new int [lengthx][lengthy];
        int[][] b = new int [lengthy][lengthx];

        System.out.println("give me a");
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < lengthy; j++) {
                a[i][j]=input.nextInt();
            }
        }
        System.out.println("T");
        for (int i = 0; i < lengthy; i++) {
            for (int j = 0; j < lengthx; j++) {
                b[i][j]=a[j][i];
                System.out.print(b[i][j]+" ");
            }
            System.out.println("\n");
    }
    input.close();
}
}

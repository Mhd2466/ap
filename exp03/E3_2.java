package ap.exp03;

import java.util.Scanner;

public class E3_2 {
    public static void main(String[] args) {
            Scanner input = new Scanner (System.in);

            int[][] a = new int [2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j]=input.nextInt();
            }
        }

        System.out.println(a[0][0]*a[1][1]-a[0][1]*a[1][0]);
        input.close();
    }
}

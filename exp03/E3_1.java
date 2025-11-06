package ap.exp03;
import java.util.Scanner;

public class E3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("give me the length");
        int length = input.nextInt();

        int[][] a = new int [length][length];
        int[][] b = new int [length][length];
        int[][] c = new int [length][length];
        System.out.println("give me a");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                a[i][j]=input.nextInt();
            }
        }
        System.out.println("give me b");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                b[i][j]=input.nextInt();
            }
        }



        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int j2 = 0; j2 < length; j2++) {
                    c[i][j]+=a[i][j2]*b[j2][j];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println("\n");
            for (int j = 0; j < length; j++) {
                System.out.print(c[i][j]+"  ");
            }
        }


        input.close();
    }
}

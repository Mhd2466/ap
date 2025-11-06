package ap.exp04;

import java.util.Scanner;

public class E4_11 {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        generate(s.toCharArray(), 0);
        input.close();
    }

    public static void generate(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        if (Character.isLetter(arr[index])) {
            arr[index] = Character.toLowerCase(arr[index]);
            generate(arr, index + 1);
            arr[index] = Character.toUpperCase(arr[index]);
            generate(arr, index + 1);
        } else {
            generate(arr, index + 1);
        }
    }
}

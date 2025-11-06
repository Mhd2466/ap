package ap.exp04;

import java.util.Scanner;

public class E4_12 {
      static String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a three-digit number: ");
        int n = input.nextInt();
        System.out.println(toWords(n));
        input.close();
    }

    public static String toWords(int n) {
        if (n < 100 || n > 999) return "Invalid number";
        int h = n / 100;
        int t = (n / 10) % 10;
        int o = n % 10;
        String result = ones[h] + " hundred";
        if (t == 0 && o == 0) return result;
        result += " and ";
        if (t == 1) result += teens[o];
        else result += tens[t] + (o > 0 ? " " + ones[o] : "");
        return result;
    }
}

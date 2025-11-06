package ap.exp04;

import java.util.HashSet;
import java.util.Scanner;

public class E4_8 {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("give me string");
        String s = input.nextLine();

        String longest = "";

        
        String current = "";
        HashSet<Character> seen = new HashSet<>();

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            while (seen.contains(ch)) {
                seen.remove(s.charAt(start));
                start++;
            }

            seen.add(ch);

            if (end - start + 1 > longest.length()) {
                longest = s.substring(start, end + 1);
            }
        }

        System.out.println(longest);
        System.out.println(longest.length());

        input.close();
    }
}

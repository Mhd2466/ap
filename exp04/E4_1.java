package ap.exp04;
import java.util.Scanner;
public class E4_1 {
    public static void main(String[] args) {
        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("give me your String");
        String s = input.nextLine();
        System.out.println("give me your char");
        String c = input.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c.charAt(0)) {
                num+=1;
                
            }
            
        }
        System.out.println(num);

        



        input.close();
    }
}

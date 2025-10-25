package ap.P;
import java.util.*;

public class E51 {
    public static void main(String[] args) {
        
    
    Scanner input = new Scanner (System.in);
    System.out.println("give me some number");
    int num = input.nextInt();
    if(num  > 0){
        System.out.println("+");
        
    }
    if(num == 0){
        System.out.println("0");
    }
    if(num < 0){
        System.out.println("-");
    }

    input.close();
    }
}

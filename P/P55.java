package ap.P;
import java.util.Scanner;

public class P55 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String x ;
        String y ;
        System.out.println("give me your first form");
        x=input.nextLine();
        System.out.println("give me your first form");
        y=input.nextLine();
        System.out.println("give me your number");
        float num=input.nextFloat();
        
        if(x.equals("km")  && y.equals("m") ){
            num*=1000;

        }
        if(x.equals("m")  && y.equals("km") ){
            
            num/=1000;


    }
    System.out.println(num);
    input.close();
}
}

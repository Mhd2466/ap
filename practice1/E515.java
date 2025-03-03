package ap.practice1;
import java.util.Scanner;

public class E515 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
    
        System.out.println("Give me your salary:"); 
        float myNum = myObj.nextFloat(); 
        float tax = 0;

        if (myNum<=50000) {
            tax+=0.01*myNum;
            
        }
        if (myNum>50000 & myNum<=75000) {
            myNum-=50000;
            tax+=0.02*myNum;
            
        }
         if (myNum>75000 & myNum<=100000) {
           
            tax+=0.02*25000;
            myNum-=75000;
            tax+=0.03*myNum;
        }
        if (myNum>100000 & myNum<=250000) {
         
            tax+=0.02*25000;
            tax+=0.03*25000;
            myNum-=100000;
            tax+=0.04*myNum;
        }
        if (myNum>250000 & myNum<=500000) {
            
            tax+=0.02*25000;
            tax+=0.03*25000;
            tax+=0.04*150000;
            myNum-=250000;
            tax+=0.05*myNum;
        }
        if (myNum>500000) {
  
            tax+=0.02*25000;
            tax+=0.03*25000;
            tax+=0.04*150000;
            tax+=0.05*250000;
            myNum-=500000;
            tax+=0.06*myNum;
        }
        System.out.println("your tax is"+tax+"$");
}
}

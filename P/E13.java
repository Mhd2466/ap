package ap.P;
import java.util.Scanner;

public class E13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("give me your grade in a b c d: ");
        String x = input.nextLine();
        float grade=0;
        for (int i = 0; i < x.length(); i++) {
            switch (x.charAt(i)) {
                case 'a':
                grade+=3.7;
                    
                    break;
                case 'b':
                grade+=3.1;
                    
                    break;
                case 'c':
                grade+=2.5;
                    
                    break;
                case 'd':
                grade+=1.9;
                    
                    break;
                case 'f':
                grade+=1.3;
                    
                    break;
                case '+':
                grade+=0.3;
                    
                    break;
                case '-':
                grade-=0.3;
                    
                    break;
                default:
                    break;
            }

            
        }
        System.out.println("this is your grade: " + grade);



        input.close();

    }

}

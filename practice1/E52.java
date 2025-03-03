package ap.practice1;
import java.util.Scanner;
public class E52 {
    public static void main(String[] args) {
      Scanner myObj = new Scanner(System.in);
      

      System.out.println("Give me a number:"); 
      float myNum = myObj.nextFloat(); 
      if (myNum==0) {
        System.out.println("zero");
        
      }
      else if (myNum>0) {
        System.out.println("positive");
        
      }
      else if (myNum<0) {
        System.out.println("negative");
        
      }
      if (myNum<1) {
        System.out.println("small");
        
      }
      if (myNum>1000000) {
        System.out.println("large");
        
      }
      
    }
  }

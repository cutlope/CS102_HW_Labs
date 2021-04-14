import java.util.Scanner;

/**
 * Lab06e 
 * @author Abdullah Riaz
 * @version 12.04.2021
*/ 
public class App
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Variables
        int n;
        
        // Program Code
        System.out.println("Enter n");
        n = scan.nextInt();
        nEvenDigits(n);
    }

    public static void nEvenDigits(int n) {
        for ( int i = ((int) Math.pow(10, n-1)); i < ((int) Math.pow(10, n)); i++) {
            if ( i % 2 == 0) {
                if (isConditionTrue(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    public static boolean isConditionTrue(int i ) {
        if ( ( (i % 10) > ( (i / 10) % 10)  && i > 10 )  ) {
            return isConditionTrue(i / 10);
         }
        else if ( i < 10) {
            return true;
         }
         else {
            return false;
         }
      }
    
    
}
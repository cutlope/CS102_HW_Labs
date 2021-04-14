import java.util.Scanner;

/**
 * Lab06b
 * @author Abdullah Riaz
 * @version 11.04.2021
*/ 

public class DecToHex
{
    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Variables
        int decimal;
        // Program Code
        System.out.println("Enter Decimal:");
        decimal = scan.nextInt();
        scan.close();
        System.out.println(toHex(decimal));
    }


    
    /** 
     * Converts Decimal to Hexadecimal
     * @param decimal
     * @return Convert Hexadecimal String
     */
    public static String toHex(int decimal){
        // Properties
        int rem;
        String converted ="";
        final char list[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        
        //Base Case
        if (decimal == 0) {
            return converted;
        }

        else {
            rem = decimal % 16;
            converted = list[rem] + converted;
            return toHex(decimal/16) + converted;
        }
        
        
    }
    
}
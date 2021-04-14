import java.util.Scanner;

/**
 * String Reverse
 * @author Abdullah Riaz
 * @version 11.04.2021
*/ 
public class App
{
    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Variables
        String orignal;

        // Program Code
        System.out.println("Enter a line");
        orignal = scan.nextLine();
        reverse(orignal);
    }

    
    /** 
     * Prints out passed string in reverse
     * @param line
     */
    public static void reverse(String line){
        if ( line.length() <=1 ) {
            System.out.println(line);
        }

        else {
            System.out.print(line.charAt(line.length()-1));
            reverse(line.substring(0,line.length()-1));
        }
    } 
    
}
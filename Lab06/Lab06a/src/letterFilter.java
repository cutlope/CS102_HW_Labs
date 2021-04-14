import java.util.Scanner;

/**
 * Lab06a
 * @author Abdullah Riaz
 * @version 11.04.2021
*/ 
public class letterFilter
{
    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Variables
        String line;

        // Program Code
        System.out.println("Enter a Line");
        line = scan.nextLine();
        scan.close();
        System.out.println( removeR(line));
    }

    
    /** 
     * Filters a string for the letter 'r'
     * @param line Take a line as argument
     * @return the filtered line
     */
    public static String removeR(String line){

        //Base Case
        if (line.length() == 0 ) {
            return line; 
        }

        else {
            if (line.charAt(0) == 'r') {
                return removeR(line.substring(1));
            }

            else {
                return line.charAt(0) + removeR(line.substring(1));
            }
        }




    }
    
}
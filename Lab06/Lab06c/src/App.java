import java.util.ArrayList;

/**
 * Lab06c 
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
        // Variables
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("aab");
        list.add("abb");
        list.add("aba");

        // Program Code
        System.out.println(isOrdered(list));

    }

    
    /** 
     * Check is ArrayList is sorted Lexicographically
     * @param list
     * @return Boolean
     */
    public static Boolean isOrdered(ArrayList<String> list) {
        boolean isSorted = true;

            if (list.size() == 1) {
                return true;
            }

            else if (list.get(0).compareTo(list.get(1) ) > 0)  {
                isSorted = false ;
            } 
            else {
                list.remove(0);
                isSorted = isOrdered(list);
            }
    
            return isSorted;
    }
    
}
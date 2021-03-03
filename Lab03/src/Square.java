/**
 * Square Shape class which extends Shape2D to inherit the common methods
*/
public class Square extends Shape2D {
    
    //Properties
    private int sideLength;

    //Constructor
    public Square(int sideLength, int x, int y) {
        super(x, y);
        this.sideLength = sideLength;
    };

    /**
     * Calculates area of the square using the formula sideLength^2
     * @return area value.
     */
    public double calculateArea(){
        return Math.pow(sideLength, 2);
    };


    /**
     * Calculates perimeter of the square using the formula 4*sideLength
     * @return perimeter value.
     */
    public double calculatePerimeter(){
        return 4 * sideLength ;
    };

     /**
     * @return sideLength of circle
     */
    public int getSideLength()
    {
        return sideLength;

    };
    

    /**
     * Overides the superclass 
     * Adds the properties of class into a string
     * @return string containing properties
     */
    @Override
    public String toString() {
        String s;
        s = super.toString()+ " and sideLength = " + sideLength;
        return s;
    }

    /**
     * Overides the superclass 
     * Checks if the objects are equal by equating their properties
     * @return boolean true or false
     */
    @Override
    public boolean equals( Object o ) { 
        
        if (super.equals(o) && ((Square) o).getSideLength() == sideLength) {
            return true;
        }

        else 
            return false;


    };


}

/**
 * Rectangle Shape class which extends Shape2D to inherit the common methods
*/
public class Rectangle extends Shape2D {
    //Properties
    private int height;
    private int width;

    //Constructor
    public Rectangle(int height, int width, int x, int y) {
        super(x, y);
        this.height = height;
        this.width = width;
    };

    /**
     * Calculates area of the Rectangle using the formula w*h
     * @return area value.
     */
    public double calculateArea(){
        return width * height;
    };


    /**
     * Calculates perimeter of the rectangle using the formula 2(w + h)
     * @return perimeter value.
     */
    public double calculatePerimeter(){

        return 2 * (width + height) ;
    };

     /**
     * @return height of circle
     */
    public int getHeight() {
        return height;
    };

     /**
     * @return Width of circle
     */
    public int getWidth() {
        return width;
    };
    

    /**
     * Overides the superclass 
     * Adds the properties of class into a string
     * @return string containing properties
     */
    @Override
    public String toString() {
        String s;
        s = super.toString()+ ", height = " + height + " and width = " + width;
        return s;
    }

    /**
     * Overides the superclass 
     * Checks if the objects are equal by equating their properties
     * @return boolean true or false
     */
    @Override
    public boolean equals( Object o ) { 
        
        if (super.equals(o) && ((Rectangle) o).getHeight() == height && ((Rectangle) o).getWidth() == width) {
            return true;
        }

        else 
            return false;


    };


}

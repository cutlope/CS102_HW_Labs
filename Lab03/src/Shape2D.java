/**
 * Main class which contains the abstract methods
*/
public abstract class Shape2D {
    //Properties
    int x, y;

    //Constructor
    public Shape2D(int x, int y){
        this.x = x;
        this.y = y;
    };

    /**
     * @return y coordinate of the shape
     */
    public int getY()
    {
        return y;
    };
    
    /**
     * @return x coordinate of the shape
     */
    public int getX()
    {
        return x;
    };
    
    public abstract double calculatePerimeter();
    public abstract double calculateArea();

    /**
     * Initially checks if the passed object is of class Shape2D
     * Calculates the euclidean distance between the centers of two Shape2D object
     * @return -1 if the passed object is not of class Shape2D 
     *          Otherwise returns the euclidean distance
     */
    public double calculateDistance( Object anyShape ) {

        if ( !(anyShape instanceof Shape2D) ) {
            return -1;
        }

        double deltaX = x - ((Shape2D) anyShape).getX();
        double deltaY = y - ((Shape2D) anyShape).getY();
        double result = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        return result; 

    }

    /**
     * Overides the superclass Object
     * Checks if the objects are equal by equating their properties
     * @return boolean true or false
     */
    @Override
    public boolean equals( Object o ) { 
        
        if (x == ((Shape2D) o).getX() && y == ((Shape2D) o).getY()) {
            return true;
        }

        else 
            return false;

    };


    /**
     * Overides the superclass 
     * Adds the properties of class into a string
     * @return string containing properties
     */
    @Override
    public String toString() {
        String s;
        s = "[class " + this.getClass().getSimpleName() + "] " + "The coordinates of this shape: x = " + x + ", y = " + y;
        return s;
    }

}

public class Circle extends Shape2D {
    //Properties
    private int radius;

    //Constructor
    public Circle(int radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    };

    /**
     * Calculates area of the circle using the formula pi * r^2
     * @return area value.
     */
    public double calculateArea(){
        return Math.PI * Math.pow(radius, 2);
    };


    /**
     * Calculates perimeter of the circle using the formula 2*pi*r 
     * @return perimeter value.
     */
    public double calculatePerimeter(){
        return 2 * Math.PI * radius ;
    };

     /**
     * @return radius of circle
     */
    public int getRadius()
    {
        return radius;
    };
    

    /**
     * Overides the superclass 
     * Adds the properties of class into a string
     * @return string containing properties
     */
    @Override
    public String toString() {
        String s;
        s = "[Class Circle]" + super.toString()+ " and radius = " + radius;
        return s;
    }
    

    /**
     * Overides the superclass 
     * Checks if the objects are equal by equating their properties
     * @return boolean true or false
     */
    @Override
    public boolean equals( Object o ) { 
        
        if (super.equals(o) && ((Circle) o).getRadius() == radius) {
            return true;
        }

        else 
            return false;


    };


 


}

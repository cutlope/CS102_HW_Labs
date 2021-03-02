public class ShapeTest
{

    /**
     * Uses a for loop and gets the area of each object and compares them to get the largest
     * @return shape2d object
     */
    public static Shape2D findLargestArea(Shape2D[] collection){
        int largestArea = 0;
        double temp = 0;

        for (int i = 0; i < 3; i++) {
            if (collection[i].calculateArea() > temp) {
                temp = collection[i].calculateArea();
                largestArea = i;
            } 
        }


        return collection[largestArea];
    }

    /**
     * Uses a for loop and gets the perimeter of each object and compares them to get the largest
     * @return shape2d object
     */
    public static Shape2D findLongestPerimeter(Shape2D[] collection){
        int largestPerimeter = 0;
        double temp = 0;

        for (int i = 0; i < 3; i++) {
            if (collection[i].calculatePerimeter() > temp) {
                temp = collection[i].calculatePerimeter();
                largestPerimeter = i;
            } 
        }


        return collection[largestPerimeter];
    }

    public static void main(String[] args) {
        
        Shape2D[] collection;
        collection = new Shape2D[3];

        collection[0] = new Rectangle(8, 15, 2, 3);
        collection[1] = new Circle(3, 13, 15);
        collection[2] = new Square(5, -2, -5);

        Shape2D sq2 = new Square(5, -2, -5);
        Shape2D sq3 = new Square(5, -1, -5);
        Shape2D sq4 = null;









        System.out.println(collection[0].toString());
        System.out.println(collection[1].toString());
        System.out.println("sq: " + collection[2].toString() );
        System.out.println("sq2: " + sq2.toString() );
        System.out.println("sq3: " + sq3.toString() );
        System.out.println("sq4: " + sq4 );
        System.out.println("sq. equals ( sq2 ) is " + collection[2].equals(sq2));
        System.out.println("sq. equals ( sq3 ) is " + collection[2].equals(sq3));
        System.out.println("sq. equals ( circle ) is " + collection[2].equals(collection[1]));
        System.out.println("The Shape Array: " + collection[0].toString() + ", " + collection[1].toString() +  " and " + collection[2].toString() );
        System.out.println(findLargestArea(collection).getObjectType() + " has largest area");
        System.out.println(findLongestPerimeter(collection).getObjectType() + " has longest perimeter ");
        System.out.println("Distance between shape 1 and 2 is " + collection[0].calculateDistance(collection[1]));
        System.out.println("Distance between shape 1 and 3 is " + collection[0].calculateDistance(collection[2]));
        System.out.println("Distance between shape 2 and 3 is " + collection[1].calculateDistance(collection[2]));






    }
    
    
    
}
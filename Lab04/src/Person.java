/** 
 * Person Class
 */
public abstract class Person implements Locatable {
    String name;
    int posX;
    int posY;

    public Person(String name, int x, int y) {
        this.name = name;
        this.posX = x;
        this.posY = y;
    }

    public Person(String name) {
        this.name = name;
    }

    
    /** 
     * Returns Person Name
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * Helper method to get x coordinate of postion
     * @return int
     */
    public int getX() {
        return posX;
    }

    
    /** 
     * Helper method to get x coordinate of postion
     * @return int
     */
    public int getY() {
        return posY;
    }

    
    /** 
     * Sets the position
     * @param x
     * @param y
     */
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }

    
    /** 
     * Prints the properties
     * @return String
     */
    public String toString(){
        return name;
    }
}

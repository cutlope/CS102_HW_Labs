/** 
 * Item Class
 */
public class Item {
    double weight;
    String content;


    public Item( double weight, String content) {
        this.weight = weight;
        this.content = content;
    }


    
    /** 
     * returns the weight
     * @return double
     */
    public double getWeight(){
        return weight;
    }

    
    /** 
     * returns content
     * @return String
     */
    public String getContent(){
        return content;
    }

    
    /** 
     * Returns Properties in string 
     * @return String
     */
    public String toString() {
        return "Content: " + content + " , Weight: " + weight ;
    }



}

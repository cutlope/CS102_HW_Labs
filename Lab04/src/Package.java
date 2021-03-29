/** 
 * Package Class
 */
public class Package extends Delivery{
    
    Item packedItem;

    public Package(Item content, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        packedItem = content;
    }

    
    /** 
     * Helper method
     * @return double
     */
    public double getWeight() {
       return packedItem.getWeight();
    }

    
    /**
     * Prints properties 
     * @return String
     */
    public String toString() {
        return "PackedItem: " + packedItem + ", Sender: " + super.getSender() + ", Receiver: " + this.getReceiver() + ", PackageNo: " + this.getPackageNo();
    }

}


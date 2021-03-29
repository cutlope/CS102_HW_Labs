/** 
 * Mail Class
 */
public class Mail extends Delivery {
    String content;

    public Mail(String content, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        this.content = content;
    }

    
    /** 
     * Prints weight 
     * @return double
     */
    public double getWeight() {
        return 0.1;
    }

    
    /** 
     * Prints Properties
     * @return String
     */
    public String toString() {
        return "Package No: " + super.getPackageNo() + ", Sender: " + super.getSender() + ", Receiver: " + super.getReceiver() + ", Content: " + this.content;
    }

}

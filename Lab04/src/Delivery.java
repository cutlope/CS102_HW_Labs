/** 
 * Abstract Delivery Class
 */
public abstract class Delivery {
    int packageNo;
    Customer sender;
    Customer receiver;

    Delivery( Customer sender, Customer receiver, int packageNo) {
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }

    
    /** 
     * gets the packageno
     * @return int
     */
    public int getPackageNo() {
        return packageNo;
    }

    
    /** 
     * returns customer property
     * @return Customer
     */
    public Customer getSender() {
        return sender;
    }

    
    /** 
     * Returns reciever 
     * @return Customer
     */
    public Customer getReceiver() {
        return receiver;
    }

    abstract double getWeight();
    
}

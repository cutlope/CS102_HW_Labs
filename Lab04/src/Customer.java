/** 
 * Customer Class
 */
public class Customer extends Person {

    Item currentItem;

    public Customer(String name) {
        super(name);
    }

    
    /** 
     * @return Item
     */
    public Item getCurrentItem() {
        return currentItem;
    }

    
    /** 
     * @param item
     */
    public void setCurrentItem(Item item) {
        currentItem = item;
    }

    
    /** 
     * @param company
     * @param item
     * @param receiver
     * @return boolean
     */
    public boolean sendItem(Company company, Item item, Customer receiver) {

        return company.createDeliverable(currentItem, this, receiver);


    }

    
    /** 
     * @return String
     */
    public String toString() {
        return super.toString() +", CurrentItem: " + currentItem;
    }


}
/** 
 * Employee Class which extends Person
 */
public class Employee extends Person {

    final int MAX_JOBS = 5;
    int currentJobs;
    Delivery[] deliveries;
    double salary;
    int employeeNo;
    boolean available;

    public Employee(int employeeNo, String name) {
        super(name);
        this.employeeNo = employeeNo;
        currentJobs = 0;
        salary = 0;
        available = true;
        deliveries = new Delivery[6];
    }

    
    /** 
     * Adjust Salary
     * @param value
     */
    public void adjustSalary(double value) {
        salary += value;
    }
    
    
    /** 
     * Checks if employee available
     * @return boolean
     */
    public boolean getAvailability() {

        if (currentJobs <= MAX_JOBS) {

            available = true;

        } else {

            available = false;
        }

        return available;
    }

    
    /** 
     * Adds a delivery job to employee
     * @param sendItem
     * @param sender
     * @param receiver
     * @param packageNo
     */
    public void addJob(Item sendItem, Customer sender, Customer receiver, int packageNo) {
        
        if (currentJobs < MAX_JOBS) {

            currentJobs += 1;

            if (sendItem.getWeight() > 0.1) {
                deliveries[currentJobs] = new Package(sendItem, sender, receiver, packageNo);
            }
            else {
                deliveries[currentJobs] = new Mail(sendItem.getContent(), sender, receiver, packageNo);
            }

        }

        else {
            System.out.println("Employee is Busy. Try Again Later");
        }
    }

    
    /** 
     * Get total ammount of jobs.
     * @return int
     */
    public int getJobs(){
        return this.currentJobs;
    }

    /** 
     * Clears Job queue
     */
    public void deliverPackages() {

        for (int i = 0; i < deliveries.length; i++) {

            System.out.println(deliveries[i]);
            deliveries[i] = null;
        }

        currentJobs = 0;

    }

    
    /** 
     * Prints Deliveries
     * @return int
     */
    public int deliveriesString(){
        int s = 0;
        for (int i = 0; i < 5; i++) {
            if (!(deliveries[i] == null)){
                s +=  1;
            }
        }
            return s;
}

    
    /** 
     * @return String
     */
    public String toString() {
        return "Name: " + super.getName() + ", CurrentJobs: " + currentJobs + ", Deliveries: " + deliveriesString() + ", Salary: " + salary + ", EmployeeNo: " + employeeNo + ", Available: " + available;
    }

}
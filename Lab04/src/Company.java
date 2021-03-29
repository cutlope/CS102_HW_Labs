import java.util.ArrayList;

/** 
 * Main Comapny Class.
 */
public class Company implements Locatable {

    final int EMPLOYEE_CAPACITY = 15;
    Employee[] employees;
    ArrayList<Customer> customers;
    int numOfEmployees;
    int employeeNo;
    int packageNo;
    int posX;
    int posY;
    
    
    Company(int x, int y) {
        posX = x;
        posY = y;
        numOfEmployees = 0;
        employees = new Employee[0];
        customers = new ArrayList<Customer>();
    }

    /** 
     * Gets x position
     * @return int
     */
    public int getX() {
        return posX;
    }

    
    /** 
     * @return int
     */
    public int getY() {
        return posY;
    }

    
    /** 
     * @param x
     * @param y
     */
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }
    
    /**
     * returns true if the employee is successfully added
     * @param candidate
     * @return
     */
    public boolean addEmployee(Employee candidate) {

        if (numOfEmployees < EMPLOYEE_CAPACITY) {

            Employee[] newEmployeesArray = new Employee[employees.length + 1];

            for (int i = 0; i < employees.length; i++) {
                newEmployeesArray[i] = employees[i];
            }

            newEmployeesArray[employees.length] = candidate;

            employees = newEmployeesArray;

            numOfEmployees += 1;

            return true;

        }

        else {

            return false;

        }

    }

    
    /** 
     * adds the customer to company
     * @param customer
     */
    public void addCustomer(Customer customer) {
        if (customers.contains(customer) ) {
            System.out.println("Customer already exists");
        }

        else {
            customers.add(customer);
        }

    }

    
    /**
     * Fires the employee
     * @param employeeIndex
     * @return boolean
     */
    public boolean terminateContract(int employeeIndex) {
        Employee[] newEmployeesArray = new Employee[employees.length];
        boolean employeeTerminated = false;

        for (int i = 0; i < employees.length; i++) {

            if (i != employeeIndex || employeeTerminated) {
                newEmployeesArray[i] = employees[i];
            }
            else {
                employeeTerminated = true;
            }

        }

        employees = newEmployeesArray;
        
        if (employeeTerminated) {
            System.out.println("Terminated");
            return true;
        }
        else {
            System.out.println(employeeTerminated);
            return false;
        }
    }

    
    /** 
     * Makes a delivery job
     * @param sendItem
     * @param sender
     * @param receiver
     * @return boolean
     */
    public boolean createDeliverable( Item sendItem, Customer sender, Customer receiver){
        int availableEmployee = -1;
        boolean status = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAvailability())
                {
                    availableEmployee = i;
                    break;
                }
        }

        if (!(availableEmployee == -1)) {
            employees[availableEmployee].addJob(sendItem, sender, receiver, packageNo);
            status = true;
        }

        return status;

    }
    /** 
    * Emptoes the package queue
    */
    public void deliverPackages(){
        for (int i = 0; i < employees.length; i++) {
            employees[i].deliverPackages();
        }
    }

    
    /** 
     * gets total number of jobs
     * @return int
     */
    public int getTotalJobs()
    {
        int totalJobs = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].currentJobs > 0) {
                totalJobs+=employees[i].getJobs();
            }
        }
        return totalJobs;
    }


    
    /** 
     * Prints properties
     * @return String
     */
    public String toString(){
        String s  = "The company currently has the following number of employees : " + employees.length + ", number of jobs: " + getTotalJobs() + " and the following number of customers : " + customers.size();
        return s;
    }



}
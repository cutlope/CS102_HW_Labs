import java.util.Scanner;

/**
 * Company Tester 
 * @author Abdullah Riaz
 * @version 09.03.2021
*/ 


public class CompanyTester {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Company dhl = new Company(0,0);
        Item package1 = new Item(0.05, "document");
        Item package2 = new Item(1, "smartphone");
        Item package3 = new Item(3, "laptop");
        Item package4 = new Item(5, "mirror");
    
        Customer shopper1 = new Customer("Abdullah");
        Customer shopper2 = new Customer("Riaz");
        shopper1.setCurrentItem(package1);
        shopper2.setCurrentItem(package2);
    
        Employee worker1 = new Employee(1, "Ben");
        Employee worker2 = new Employee(2, "Sen");
        int choice;
    
    
        do {
            System.out.println("Welcome! What would you like to do today?");
            System.out.println("1. Employee Menu");
            System.out.println("2. Add Customer");
            System.out.println("3. Take Order");
            System.out.println("4. Deliver Pending Packages");
            System.out.println("5. Company Information");
            choice = Integer.parseInt(scan.nextLine());

            if (choice == 1 ) {

                do {
                System.out.println("1. List Employees");
                System.out.println("2. Add Employee"); 
                System.out.println("3. Fire Employee");
                System.out.println("4. Adjust Salary of Employee");
                System.out.println("5. Return To Main Menu");
                choice = Integer.parseInt(scan.nextLine());



                if (choice == 1 ) {
                    for ( int i = 0; i < dhl.employees.length; i++) {
                        if (dhl.employees[i] != null) {
                        System.out.println(dhl.employees[i]);
                        }
                    }
                }

                else if (choice == 2 ) {
                    System.out.println("Choose EmployeeNo. From Below");
                    System.out.println(worker1.toString());
                    System.out.println(worker2.toString());
                    choice = Integer.parseInt(scan.nextLine());
                        if ( choice == 1) {
                            dhl.addEmployee(worker1);
                        }
                        else if (choice == 2) {
                            dhl.addEmployee(worker2);
                        }
                }

                else if (choice == 3 ) {
                    System.out.println("Choose EmployeeNo. to Fire From Below");
                    for ( int i = 0; i < dhl.employees.length; i++) {
                        System.out.println(dhl.employees[i]);
                    }
                    choice = Integer.parseInt(scan.nextLine());
                    dhl.terminateContract((choice -1));
                    }

                else if (choice == 4 ) {
                    int salary = 0;
                    System.out.println("Choose EmployeeNo. to Adjust Salary");
                    for ( int i = 0; i < dhl.employees.length; i++) {
                        if (dhl.employees[i] != null) {
                            System.out.println(dhl.employees[i]);
                            }
                    }
                    choice = Integer.parseInt(scan.nextLine());
                    System.out.println("Entner New Salary");
                    salary = Integer.parseInt(scan.nextLine());
                    dhl.employees[ (choice - 1 ) ].adjustSalary(salary);
                }
                else if (choice == 5) {
                    break;
                }

               

               

            
        }
                while ( true) ;
            }

            else if (choice == 2) {
                System.out.println("Select Customer to Add");
                System.out.println("1. " + shopper1.toString());
                System.out.println("2. " + shopper2.toString());
                System.out.println("3. Exit");
                choice = Integer.parseInt(scan.nextLine());
                    if ( choice == 1 ) {
                        dhl.addCustomer(shopper1);
                        System.out.println("Added");
                    }
                    else if (choice == 2) {
                        dhl.addCustomer(shopper2);
                        System.out.println("Added");
                    }

            }

            else if (choice == 3) {
                if ( !(dhl.customers.size() == 0) ) {
                System.out.println("Choose Customer: ");
                for ( int i = 0; i < dhl.customers.size(); i++ ) {
                    System.out.println(dhl.customers.get(i).toString());
                }
                choice = Integer.parseInt(scan.nextLine());
                    if ( choice == 1 ) {
                        if (dhl.createDeliverable(package1, shopper1, shopper2) ){
                            System.out.println("Job Created");
                        }
                        else {
                            System.out.println("No Employees Available");
                        }
                        
                    }
                    else if ( choice == 2 ) {
                        if (dhl.createDeliverable(package2, shopper2, shopper2)){
                            System.out.println("Job Created");
                        }
                        else {
                            System.out.println("No Employees Available");
                        }
                    }
                
            }

            else {
                System.out.println("No Customers Available");
            }
        }

            else if (choice == 4) {
                dhl.deliverPackages();
                System.out.println("Delivered");
            }

            else if (choice == 5) {
                System.out.println(dhl.toString());
            }

            else {
                break;
            }

    }
        while(true);

    }

}
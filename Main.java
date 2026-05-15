import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddCustomer add = new AddCustomer();
        GenerateBill bill = new GenerateBill();
        ViewCustomer view = new ViewCustomer();

        while (true) {

            System.out.println("\n===== ELECTRICITY BILL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");

            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    add.addCustomer();
                    break;

                case 2:
                    view.viewCustomers();
                    break;

                case 3:
                    bill.generateBill();
                    break;

                case 4:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
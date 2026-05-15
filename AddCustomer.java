import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddCustomer {

    public void addCustomer() {

        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DatabaseConnection.getConnection();

            System.out.println("Enter Customer ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Address:");
            String address = sc.nextLine();

            System.out.println("Enter Meter Number:");
            String meter = sc.nextLine();

            System.out.println("Enter Phone Number:");
            String phone = sc.nextLine();

            String query = "INSERT INTO customer VALUES(?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, meter);
            pst.setString(5, phone);

            pst.executeUpdate();

            System.out.println("Customer Added Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
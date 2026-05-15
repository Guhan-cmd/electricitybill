import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GenerateBill {

    public void generateBill() {

        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DatabaseConnection.getConnection();

            System.out.println("Enter Customer ID:");
            int id = sc.nextInt();

            System.out.println("Enter Units Consumed:");
            int units = sc.nextInt();

            double amount;

            if (units <= 100) {
                amount = units * 2;
            } else if (units <= 200) {
                amount = (100 * 2) + ((units - 100) * 3);
            } else {
                amount = (100 * 2) + (100 * 3) + ((units - 200) * 5);
            }

            String insertQuery = "INSERT INTO bill(customer_id, units, amount) VALUES(?,?,?)";

            PreparedStatement pst = con.prepareStatement(insertQuery);

            pst.setInt(1, id);
            pst.setInt(2, units);
            pst.setDouble(3, amount);

            pst.executeUpdate();

            String selectQuery = "SELECT * FROM customer WHERE customer_id=?";

            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n------ ELECTRICITY BILL ------");
                System.out.println("Customer ID   : " + rs.getInt("customer_id"));
                System.out.println("Customer Name : " + rs.getString("name"));
                System.out.println("Units         : " + units);
                System.out.println("Bill Amount   : Rs." + amount);
                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
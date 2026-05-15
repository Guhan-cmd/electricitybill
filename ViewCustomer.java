import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewCustomer {

    public void viewCustomers() {

        try {
            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM customer");

            while (rs.next()) {

                System.out.println("------------------------");
                System.out.println("Customer ID : " + rs.getInt("customer_id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Address     : " + rs.getString("address"));
                System.out.println("Meter No    : " + rs.getString("meter_no"));
                System.out.println("Phone       : " + rs.getString("phone"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection con;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/electricity_bill",
                    "root",
                    "Guhan__12"
            );

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
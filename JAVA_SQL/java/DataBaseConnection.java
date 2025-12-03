import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/payment_bank";
    private static final String USER = "root";
    private static final String PASSWORD = "ferennia25";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}

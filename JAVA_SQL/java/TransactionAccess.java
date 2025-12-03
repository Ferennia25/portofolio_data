import java.sql.*;
import java.time.LocalDateTime;

public class TransactionAccess {
    public void saveTransaction(int account_number, String type, double amount, String note) throws Exception {
        Connection con = DataBaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("INSERT INTO transactions_record (account_id, type, amount, timestamp, note) VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, account_number);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(5,note);

        ps.executeUpdate();

    }
}

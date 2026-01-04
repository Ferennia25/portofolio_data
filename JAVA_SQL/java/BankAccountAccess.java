import java.sql.*; // importing Connection, PreparedStatement, ResultSet, SQLException, DriverManager, etc.

public class BankAccountAccess {

    public BankAccount getAccount(int accountNumber) throws Exception {
        Connection con = DataBaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM bank_accounts WHERE account_number = ?");
        ps.setInt(1, accountNumber);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new BankAccount(
                    rs.getInt("account_number"),
                    rs.getString("fullname"),
                    rs.getDouble("balance"));
        }
        return null;

    }
    public void UpdateBalance(int accountNumber, double newBalance) throws Exception {
        Connection con = DataBaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("UPDATE bank_accounts SET balance = ? WHERE account_number = ?");
        ps.setDouble(1,newBalance);
        ps.setInt(2, accountNumber);
        ps.executeUpdate();


    }
}



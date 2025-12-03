import java.sql.*; // importing Connection, PreparedStatement, ResultSet, SQLException, DriverManager, etc.

public class BankAccountAccess {

    public BankAccount getAccount(int account_number) throws Exception {
        Connection con = DataBaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM bank_accounts WHERE account_number = ?");
        ps.setInt(1, account_number);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new BankAccount(
                    rs.getInt("account_number"),
                    rs.getString("fullname"),
                    rs.getDouble("balance"));
        }
        return null;

    }
    public void UpdateBalance(int account_number, double new_balance) throws Exception {
        Connection con = DataBaseConnection.connect();
        PreparedStatement ps = con.prepareStatement("UPDATE bank_accounts SET balance = ? WHERE account_number = ?");
        ps.setDouble(1,new_balance);
        ps.setInt(2, account_number);
        ps.executeUpdate();


    }
}



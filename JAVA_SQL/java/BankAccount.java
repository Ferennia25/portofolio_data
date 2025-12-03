public class BankAccount {
    private int account_number;
    private String fullname;
    private double balance;

    public BankAccount(int account_number, String fullname, double balance) {
        this.account_number=account_number;
        this.fullname=fullname;
        this.balance=balance;
    }

    public int getAcc() {
        return account_number;
    }
    public String getName() {
        return fullname;
    }
    public double getBalance() {
        return balance;
    }
}

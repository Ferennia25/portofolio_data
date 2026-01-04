public class BankAccount {
    private int accountNumber;
    private String fullName;
    private double balance;

    public BankAccount(int accountNumber, String fullName, double balance) {
        this.accountNumber=accountNumber;
        this.fullName=fullName;
        this.balance=balance;
    }

    public int getAcc() {
        return accountNumber;
    }
    public String getName() {
        return fullName;
    }
    public double getBalance() {
        return balance;
    }
}

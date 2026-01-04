public class Services {
    private BankAccountAccess accountAccess = new BankAccountAccess();
    private TransactionAccess transAccess = new TransactionAccess();

    public void deposit(int accountNumber, double amount) throws Exception {
        BankAccount acc = accountAccess.getAccount(accountNumber);
        double new_balance = acc.getBalance() + amount;
        accountAccess.UpdateBalance(accountNumber, new_balance);

        transAccess.saveTransaction(accountNumber, "deposit", amount, "Saving Money");

    }

    public void withdraw(int accountNumber, double amount) throws Exception {
        BankAccount acc = accountAccess.getAccount(accountNumber);

        if (acc.getBalance() < amount) {
            throw new Exception("Dear " + acc.getName() + "you don't have enough money..");
        }

        double new_balance = acc.getBalance() - amount;
        accountAccess.UpdateBalance(accountNumber, new_balance);

        transAccess.saveTransaction(accountNumber, "withdraw", amount, "Taking Money");
    }

    public void transfer(int account_number_sender, int account_number_receiver, double amount) throws Exception {

        // sender
        BankAccount acc1 = accountAccess.getAccount(account_number_sender);
        if (acc1.getBalance() < amount) {
            throw new Exception("Dear " + acc1.getName() + " you don't have enough money..");
        }
        double new_balance1 = acc1.getBalance() - amount;
        accountAccess.UpdateBalance(account_number_sender, new_balance1);
        transAccess.saveTransaction(account_number_sender, "transfer", amount, "sending money to" + account_number_receiver);

        // receiver
        BankAccount acc2 = accountAccess.getAccount(account_number_receiver);
        double new_balance2 = acc2.getBalance() + amount;
        accountAccess.UpdateBalance(account_number_receiver, new_balance2);
        transAccess.saveTransaction(account_number_receiver, "transfer", amount, "receiving money from" + account_number_sender);



    }
}

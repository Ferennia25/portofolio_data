public class Services {
    private BankAccountAccess account_access = new BankAccountAccess();
    private TransactionAccess trans_access = new TransactionAccess();

    public void deposit(int account_number, double amount) throws Exception {
        BankAccount acc = account_access.getAccount(account_number);
        double new_balance = acc.getBalance() + amount;
        account_access.UpdateBalance(account_number, new_balance);

        trans_access.saveTransaction(account_number, "deposit", amount, "Saving Money");

    }

    public void withdraw(int account_number, double amount) throws Exception {
        BankAccount acc = account_access.getAccount(account_number);

        if (acc.getBalance() < amount) {
            throw new Exception("Dear " + acc.getName() + "you don't have enough money..");
        }

        double new_balance = acc.getBalance() - amount;
        account_access.UpdateBalance(account_number, new_balance);

        trans_access.saveTransaction(account_number, "withdraw", amount, "Taking Money");
    }

    public void transfer(int account_number_sender, int account_number_receiver, double amount) throws Exception {

        // sender
        BankAccount acc1 = account_access.getAccount(account_number_sender);
        if (acc1.getBalance() < amount) {
            throw new Exception("Dear " + acc1.getName() + "you don't have enough money..");
        }
        double new_balance1 = acc1.getBalance() - amount;
        account_access.UpdateBalance(account_number_sender, new_balance1);
        trans_access.saveTransaction(account_number_sender, "transfer", amount, "sending money to" + account_number_receiver);

        // receiver
        BankAccount acc2 = account_access.getAccount(account_number_receiver);
        double new_balance2 = acc2.getBalance() + amount;
        account_access.UpdateBalance(account_number_receiver, new_balance2);
        trans_access.saveTransaction(account_number_receiver, "transfer", amount, "receiving money from" + account_number_sender);



    }
}

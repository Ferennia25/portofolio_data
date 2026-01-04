public class MainPayment {
    public static void main(String[] args) {
        try {
            Services service = new Services();

            service.deposit(10001, 100000);
            service.withdraw(10002, 100000);
            service.transfer(10001, 10003, 100000);

            System.out.println("Transaction success!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

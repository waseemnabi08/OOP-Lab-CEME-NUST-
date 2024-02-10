public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("XYZ", 1000);
        System.out.println("Initial Balance: " + account.getBalance());
        try {
            account.withdraw(500);
            System.out.println("Balance after first withdrawal: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdraw(1000);
            System.out.println("Balance after second withdrawal: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

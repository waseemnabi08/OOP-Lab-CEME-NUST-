public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String _name, double balance) {
        this.balance = balance;
        name = _name;
    }

    public void deposit( double amount) {

        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

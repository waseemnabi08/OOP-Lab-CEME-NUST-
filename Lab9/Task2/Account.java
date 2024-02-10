class Account {
    private String name;
    private int account_number;
    private double balance;
    private double intrestRate;


    public Account(String _name , double _balance, double _intrestRate) {
        name = _name;
        setBalance(_balance);
        account_number = 00001;
        intrestRate = _intrestRate;
    }

    public void setBalance(double _balance) {
        if (_balance < 0) {
            System.out.println("Balance cannot be negative. Setting balance to 0.");
            balance = 0.0;
        } else {
            balance = _balance;
        }
    }

    public void credit(double new_amount) {
        if (new_amount < 0) {
            System.out.println("Credit Amount cannot be negative");
        } else {
            balance += new_amount;
           System.out.println("Successfully credited!");
        }
    }

    public void debit(double amount) {
        if (amount <= 0) {
            System.out.println("Debit amount must be positive");
        } else if (amount > balance) {
            System.out.println("Not enough cash");
        } else {
            balance -= amount;
            System.out.println("Successfully debited!");
        }
    }

    public double getIntrestRate(){
        return intrestRate;
    }

    public double getMonthlyInterest(){
        return ((balance * intrestRate)/12);
    }

    public String getName()  {
        return name;
    }

    public int getAccountNo()  {
        return account_number;
    }

    public double getBalance()  {
        return (balance + getMonthlyInterest());
    }
}

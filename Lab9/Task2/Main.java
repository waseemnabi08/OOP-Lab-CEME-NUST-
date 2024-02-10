public class Main{
    public static void main(String[] args)
    {
        Account acc = new Account("Waseem", 1000, 0.5);
        System.out.println("Name: " + acc.getName());
        System.out.println("Account #: " + acc.getAccountNo());
        System.out.println("Saving Balance #: " + acc.getBalance() );
        System.out.println("Intrest Rate: " + acc.getIntrestRate());
        System.out.println("Monthy Intrest: " + acc.getMonthlyInterest());
    }
}

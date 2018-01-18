public class SavingsAccount extends BankAccount
{
    // Fields
    private double rate = 0.025;
    private int savingsNumber = 0;
    private String accountNumber;

    /**
     * SavingsAccount Constructor
     * @param Name Name
     * @param Amount Currency
     */
    public SavingsAccount(String Name, double Amount)
    {
        super(Name, Amount);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /**
     * postInterest Method
     * One Month of Interest
     */
    public void postInterest()
    {
        this.setBalance(this.getBalance() + (this.getBalance() * rate));
    }

    /**
     * getAccountNumber Method
     * @return Account Number
     */
    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    /**
     * SavingsAccount Copy Constructor
     * @param Account Account Object
     * @param Balance Currency Balance
     */
    public SavingsAccount(SavingsAccount Account, double Balance)
    {
        super(Account, Balance);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
}

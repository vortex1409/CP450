public class CheckingAccount  extends BankAccount
{
    // Fields
    private static final double FEE = 0.15;

    /**
     * CheckingAccount Constructor
     * @param Name Name
     * @param Amount Currency
     */
    public CheckingAccount(String Name, double Amount)
    {
        // Constructor Super Class
        super(Name, Amount);

        // Init Acc Number
        super.setAccountNumber(getAccountNumber() + "-10");
    }

    /**
     * withdraw Method
     * @param amount The amount to withdraw from
     * @return
     */
    public boolean withdraw(double amount)
    {
        amount = amount + FEE;
        return super.withdraw(amount);
    }
}

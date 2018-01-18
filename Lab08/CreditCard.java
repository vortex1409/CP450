/**
 * CP450 - LAB 8
 * MICHAEL DORFMAN
 * 11/19/2017
 */

public class CreditCard
{
    // Fields
    Money balance;
    Money creditLimit;
    Person owner;

    /**
     * Constructor CreditCard
     * @param newCardHolder Name of Cardholder
     * @param limit Money Limit
     */
    public CreditCard(Person newCardHolder, Money limit)
    {
        creditLimit = limit;
        owner = newCardHolder;
        balance = new Money(0);
    }

    /**
     * getBalance Method
     * @return Balance
     */
    public Money getBalance()
    {
        return new Money(balance);
    }

    /**
     * getCreditLimit Method
     * @return Credit Limit
     */
    public Money getCreditLimit()
    {
        return new Money(creditLimit);
    }

    /**
     * getPersonals Method
     * @return Data
     */
    public String getPersonals()
    {
        return owner.toString();
    }

    /**
     * charge Method
     * Charges Credit Card
     * Doesn't charge if over limit
     * @param amount Currency
     */
    public void charge(Money amount)
    {
        if(balance.add(amount).compareTo(creditLimit) < 0)
        {
            System.out.println("Charge: " + balance);
            balance = balance.add(amount);
        }
        else
        {
            System.out.println("EXCEEDS CREDIT LIMIT");
        }
    }

    /**
     * payment Method
     * Makes payment to outstanding charges
     * @param amount Currency
     */
    public void payment(Money amount)
    {
        System.out.println("Payment: " + amount);
        balance = balance.subtract(amount);
    }
}

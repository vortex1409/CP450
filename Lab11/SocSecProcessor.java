import java.util.Scanner;

/***
 * Michael Dorfman
 * Lab 11
 * CP450 - OOP Java
 * 01/01/2018
 */

public class SocSecProcessor
{
    static String error="";

    /***
     * Main Method
     * User inputs their name and SSN and the program
     * checks to see if the SSN is valid
     * @param args None
     */
    public static void main(String[] args)
    {
        // Variables
        String name,SSN, KeepAlive = "";

        do
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Name: ");
            name = input.nextLine();
            System.out.println("SSN: ");
            SSN = input.next();

            if(isValid(SSN))
            {
                System.out.println(name + " " + SSN + " is valid.");
            }
            else
            {
                System.out.println(error);
            }
            System.out.println("Restart (Y/N): ");
            KeepAlive = input.next();
        }while(KeepAlive == "Y" || KeepAlive == "y");
    }

    /***
     * isValid Method
     * Checsk to see if the SSN is valid and then
     * returns a true or false based on the validity
     * @param ssn Social Security Number
     * @return True/False of Validity
     */
    public static boolean isValid(String ssn)
    {
        boolean valid = true;

        try{
            if(ssn.length() != 11)
            {
                throw new SocSecException("wrong number of characters.");
            }
            else if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
            {
                throw new SocSecException("dashes at wrong position.");
            }
            else
            {
                for(int x = 0; x < ssn.length(); x++)
                {
                    if(ssn.charAt(x) == '-' || Character.isDigit(ssn.charAt(x)))
                        continue;
                    else
                    {
                        throw new SocSecException("contains a character that is not a number.");
                    }
                }
            }
        }
        catch(SocSecException e)
        {
            error = e.toString();
            valid = false;
        }

        return valid;
    }
}
    
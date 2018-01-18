/***
 * SocSecException Class
 * Extends Exception Class
 * Throws Custom Exceptions
 */
public class SocSecException extends Exception
{
    // Fields
    private String error;

    /**
     * SocSecException Constructor
     * The constructor
     * @param error Error Message
     */
    public SocSecException(String error)
    {
        super(error);
        this.error = error;
    }

    /**
     * toString Method
     * This method returns an error message plus
     * a custom error message attached to it.
     * @return Error Message
     */
    public String toString() {
        return "Invalid Social Security Number, " + error;
    }
}
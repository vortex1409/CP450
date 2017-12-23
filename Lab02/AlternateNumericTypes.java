/*
    Michael Dorfman
    Class: CP450
    Lab: 02
    Date: 09/15/2017
    Description: Alternate Numeric Types using JOptionPane for user input
*/

// Import JOPtionPane for Dialog Input/Output
import javax.swing.JOptionPane;

public class AlternateNumericTypes
{
    public static void main (String [] args)
    {
        // Declaring Variables
        String firstName;
        String lastName;
        String fullName;
        char firstInitial;
        double diameter;
        double radius;
        double volume;

        // Data Entry
        firstName = JOptionPane.showInputDialog ( "Enter First Name" );
        lastName = JOptionPane.showInputDialog ( "Enter Last Name" );

        // String Concat
        fullName = firstName + " " + lastName;

        // Data Output
        JOptionPane.showMessageDialog (null, "Full Name: " + fullName);

        System.out.println();      // To leave a blank line

        // charAt finds first Character (Firstname Initial)
        firstInitial = firstName.charAt(0);

        // Data Output
        JOptionPane.showMessageDialog(null,"First Initial: " + firstInitial);

        // Makes String Upper Case
        fullName = fullName.toUpperCase();

        // Data Output
        JOptionPane.showMessageDialog(null,"Full Name: " + fullName);

        System.out.println();      // To leave a blank line

        // Data Input (Converts String to Double as well)
        diameter = Double.parseDouble(JOptionPane.showInputDialog ( "Enter Diameter" ));

        // Math (Using Math Libraries PI & POW)
        radius = diameter / 2;
        volume = Math.PI * Math.pow(radius,3) * 4/3;

        // Data Output
        JOptionPane.showMessageDialog(null,"Volume: " + volume);
    }
}

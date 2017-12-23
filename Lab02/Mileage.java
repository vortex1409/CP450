/*
    Michael Dorfman
    Class: CP450
    Lab: 02
    Date: 09/15/2017
    Description: Calculates Mileage
*/

//Import Scanner Class
import java.util.Scanner;

public class Mileage
{
    public static void main (String [] args)
    {
        //Create Scanner Object & Declare Variables
        Scanner Console = new Scanner(System.in);
        double Miles;
        double Gallons;
        double MPG;

        // Description
        System.out.println("This Program Calculates Mileage - Created by Michael Dorfman");
        System.out.println();

        // Data Inputs
        System.out.print("# of Miles Driven: ");
        Miles = Console.nextDouble();
        System.out.print("# of Gallons Used: ");
        Gallons = Console.nextDouble();

        // Math
        MPG = Miles / Gallons;

        // Data Output
        System.out.print("Miles Per Gallon: " + MPG);
    }
}

/**
 * CP450 - ASSIGNMENT 1
 * MICHAEL DORFMAN
 * 11/19/2017
 */

import java.util.Scanner;

public class PresentValue
{
    public static void main(String[] args)
    {
        // Input Object (Scanner)
        Scanner s = new Scanner(System.in);

        // Enter FV
        System.out.print("Enter Future Value: ");
        double FV = s.nextDouble();

        // Enter Interest
        System.out.print("Interest Rate: ");
        double I = s.nextDouble();

        // Enter Years
        System.out.print("Number of Years: ");
        int Y = s.nextInt();

        s.close();

        double PV = PVCalc(FV, I, Y);

        System.out.println("Invest $" + PV);
    }

    /**
     * PVCalc Method
     * Calculates Present Value based on Future Value, Interest and Years
     * @param FutureValue Future Value
     * @param Interest Interest
     * @param Years Years
     * @return Present Value
     */
    public static double PVCalc(double FutureValue, double Interest, int Years)
    {
        return FutureValue / Math.pow((1 + Interest), Years);
    }
}

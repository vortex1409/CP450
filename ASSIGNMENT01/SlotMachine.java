/**
 * CP450 - ASSIGNMENT 1
 * MICHAEL DORFMAN
 * 11/19/2017
 */

import java.util.*;
import static java.lang.System.out;
import static java.lang.System.in;

public class SlotMachine
{
    // Global Variables & Objects
    static Scanner t = new Scanner(in);
    static String[] ReelItems = {"Cherries", "Oranges", "Plumbs", "Bells", "Melons", "Bars"};
    static List<String> ReelResults = new ArrayList<>();
    static Random RNG = new Random();
    static double Dollars;
    static double Payment;
    static int Multiplyer;
    static boolean KeepAlive;

    public static void main(String[] args)
    {
        out.println("Welcome to the Slot Machine Simulation");
        do
        {
            Bet();
            Spin();
            ResultGenerator();
            GetResults();
            DeterminKeepAliveStatus();
            if(KeepAlive == true)
            {
                Reset();
            }
        }while(KeepAlive);
    }

    /**
     * Bet Method
     * User Places Bet in Dollars
     */
    static void Bet()
    {
        out.print("Enter Bet Amount: ");
        Dollars = t.nextDouble();
    }

    /**
     * Spin Method
     * Adds Results to Reel
     * Displays Reel Spin
     */
    static void Spin()
    {
        out.println("Spin In Progress");
        for(int i = 0; i < 3; i++)
        {
            ReelResults.add(ReelItems[Randomizer()]);
        }
        for(String O: ReelResults)
        {
            out.print(O + " | ");
        }
        out.println("");
    }

    /**
     * Randomizer Method
     * Generates a Random Number
     * @return Random Number
     */
    static int Randomizer()
    {
        return RNG.nextInt(5);
    }

    /**
     * ResultGenerator Method
     * Generates Random Results
     * Calculates the Payment based on a Multiplyer
     */
    static void ResultGenerator()
    {
        if(ReelResults.get(0) == ReelResults.get(1) && ReelResults.get(1) == ReelResults.get(2) && ReelResults.get(0) == ReelResults.get(2))
        {
            Multiplyer = 3;
        }
        else if(ReelResults.get(0) != ReelResults.get(1) && ReelResults.get(1) != ReelResults.get(2) && ReelResults.get(0) != ReelResults.get(2))
        {
            Multiplyer = 0;
        }
        else
        {
            Multiplyer = 2;
        }

        Payment = Dollars * Multiplyer;
    }

    /**
     * KeepAlive Method
     * Determines if the program will exit
     */
    static void DeterminKeepAliveStatus()
    {
        out.println("Try Again (Y or N): ");
        String KA = t.next();
        if(KA.equalsIgnoreCase("Y"))
        {
            KeepAlive = true;
        }
        else if (KA.equalsIgnoreCase("N"))
        {
            KeepAlive = false;
        }
        else
        {
            KeepAlive = false;
        }
    }

    /**
     * GetResults Method
     * Outputs Information regarding Winning or Losing
     */
    static void GetResults()
    {
        out.println("=== DEBUG ===");
        out.println("Bet: " + Dollars);
        out.println("Payout: " + Payment);
        out.println("Multiplyer: " + Multiplyer);

        if(Payment > 0)
        {
            out.println("");
            out.print("You Won ");
            out.printf("$%.2f", Payment);
            out.println("");
        }
        else
        {
            out.println("You Lost $" + Payment);
        }
    }

    /**
     * Reset Method
     * Resets Variables
     */
    static void Reset()
    {
        ReelResults.clear();
        Multiplyer = 0;
        Dollars  = 0;
        Payment = 0;
    }
}

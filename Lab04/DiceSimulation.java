/*
    Michael Dorfman
    Class: CP450
    Lab: 04
    Date: 09/29/2017
    Description: Dice Simulation using Loops
*/

import java.util.Random;   // Needed for the Random class

/**
 This class simulates rolling a pair of dice 10,000 times
 and counts the number of times doubles of are rolled for
 each different pair of doubles.
 */

public class DiceSimulation
{

    // Global Variables
    private static Random generator = new Random();
    private static final int NUMBER = 10000;  // Number of dice rolls
    private static int die1Value;       // Value of the first die
    private static int die2Value;       // Value of the second die
    private static int count = 0;       // Total number of dice rolls
    private static int snakeEyes = 0;   // Number of snake eyes rolls
    private static int twos = 0;        // Number of double two rolls
    private static int threes = 0;      // Number of double three rolls
    private static int fours = 0;       // Number of double four rolls
    private static int fives = 0;       // Number of double five rolls
    private static int sixes = 0;       // Number of double six rolls

    public static void main(String[] args) {
        // TASK #1 Enter your code for the algorithm here
        System.out.println("----------------------------------");
        System.out.println("While Loop");
        while (count < NUMBER) {
            die1Value = generator.nextInt(6) + 1;
            die2Value = generator.nextInt(6) + 1;
            if (die1Value == die2Value) {
                if (die1Value == 1) {
                    snakeEyes++;
                } else if (die1Value == 2) {
                    twos++;
                } else if (die1Value == 3) {
                    threes++;
                } else if (die1Value == 4) {
                    fours++;
                } else if (die1Value == 5) {
                    fives++;
                } else if (die1Value == 6) {
                    sixes++;
                }
            }
            count++;
        }
        Output();
        Reset();

        System.out.println("----------------------------------");
        System.out.println("Do While Loop");

        do {
            die1Value = generator.nextInt(6) + 1;
            die2Value = generator.nextInt(6) + 1;
            if (die1Value == die2Value) {
                if (die1Value == 1) {
                    snakeEyes++;
                } else if (die1Value == 2) {
                    twos++;
                } else if (die1Value == 3) {
                    threes++;
                } else if (die1Value == 4) {
                    fours++;
                } else if (die1Value == 5) {
                    fives++;
                } else if (die1Value == 6) {
                    sixes++;
                }
            }
            count++;
        } while (count < NUMBER);
        Output();
        Reset();

        System.out.println("----------------------------------");
        System.out.println("For Loop");

        for (int i = 0; i < NUMBER; i++)
        {
            die1Value = generator.nextInt(6) + 1;
            die2Value = generator.nextInt(6) + 1;
            if (die1Value == die2Value) {
                if (die1Value == 1) {
                    snakeEyes++;
                } else if (die1Value == 2) {
                    twos++;
                } else if (die1Value == 3) {
                    threes++;
                } else if (die1Value == 4) {
                    fours++;
                } else if (die1Value == 5) {
                    fives++;
                } else if (die1Value == 6) {
                    sixes++;
                }
            }
            count++;
        }
        Output();
        Reset();
    }

    // Prints Output of Variables (Call After Each Loop)
    private static void Output()
    {
        // Display the results
        System.out.println ("You rolled snake eyes " +
                snakeEyes + " out of " +
                count + " rolls.");
        System.out.println ("You rolled double twos " +
                twos + " out of " + count +
                " rolls.");
        System.out.println ("You rolled double threes " +
                threes + " out of " + count +
                " rolls.");
        System.out.println ("You rolled double fours " +
                fours + " out of " + count +
                " rolls.");
        System.out.println ("You rolled double fives " +
                fives + " out of " + count +
                " rolls.");
        System.out.println ("You rolled double sixes " +
                sixes + " out of " + count +
                " rolls.");
    }

    // Resets All Global Variables (Call After Each Loop
    private static void Reset()
    {
        die1Value = 0;
        die2Value = 0;
        count = 0;
        snakeEyes = 0;
        twos = 0;
        threes = 0;
        fours = 0;
        fives = 0;
        sixes = 0;
    }
}
/*
    Michael Dorfman
    Class: CP450
    Lab: 04
    Date: 09/29/2017
    Description: Stats Demo Using Loops
*/

import java.io.*;
import java.util.Scanner;

/**
 This class reads numbers from a file, calculates the
 mean and standard deviation, and writes the results
 to a file.
 */

public class StatsDemo
{
    // TASK #3 Add the throws clause
    public static void main(String[] args) throws IOException
    {
        // Variables
        double sum = 0;      // The sum of the numbers
        int count = 0;       // The number of numbers added
        double mean = 0;     // The average of the numbers
        double stdDev = 0;   // The standard deviation
        String line;         // To hold a line from the file
        double difference;   // The value and mean difference
        String filename;     // The user input file name

        Scanner input = new Scanner (System.in);                 // Input Scanner Object

        // Prompt the user and read in the file name
        System.out.println("This program calculates " +
                "statistics on a file " +
                "containing a series of numbers");
        System.out.print("Enter the file name:  ");
        filename = input.nextLine();

        // Object Creation
        FileWriter IO_Writer = new FileWriter("Results.txt");
        PrintWriter PTR_Writer = new PrintWriter(IO_Writer);
        FileReader IO_Reader = new FileReader(filename);
        BufferedReader IO_Buffer = new BufferedReader(IO_Reader);

        // Read the Line
        line = IO_Buffer.readLine();
        // Convert to Double
        sum = Double.parseDouble(line);
        // Increment Counter
        count++;

        // While there is Still Data
        while((line = IO_Buffer.readLine()) != null)
        {
            // Convert Line to Double add to Accumulator
            sum+= Double.parseDouble(line);
            // Increment Counter
            count++;
        }

        // Close the File
        IO_Buffer.close();

        // Mean is the Sum Divided by the Count
        mean = (sum / count);

        // Reinitializing FileReader and BufferedReader
        // Passing FileReader Object
        FileReader IO_Reader_2 = new FileReader(filename);
        BufferedReader IO_Buffer_2 = new BufferedReader(IO_Reader_2);

        // Set Sum and Count to 0
        sum = 0;
        count = 0;

        // Prime Read to the first line of the file
        line = IO_Buffer_2.readLine();
        sum += Math.pow((Double.parseDouble(line) - mean), 2);
        count++;

        // Until End of File
        // - Conver Line to Double
        // - Subtract mean from and add the square of the difference to the sum
        // - Increment the Counter
        while ((line = IO_Buffer_2.readLine()) != null) {

            difference = Math.pow((Double.parseDouble(line) - mean), 2);
            sum+=difference;
            count++;
        }

        // Close the File
        IO_Buffer_2.close();

        // Standard Deviation
        stdDev = Math.sqrt((sum / count));

        // Data Output
        PTR_Writer.println("Results:");
        PTR_Writer.printf("The mean is: %.3f", mean);
        PTR_Writer.printf("\nThe standard deviation is: %.3f", stdDev);
        PTR_Writer.close();
    }
}
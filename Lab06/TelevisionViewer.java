/**
 * Television Viewer
 * Contains Objects and User Input
 * Sets Channels, Volume and other Television Properties
 * @author  Michael Dorfman
 * @version 1.0
 * @since   10/13/2017
 */

import java.util.Scanner;

public class TelevisionViewer {

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner (System.in);

        // Declare variables
        int station;         // The user's channel choice

        // Declare and instantiate a television object
        Television bigScreen = new Television("Toshiba", 55);

        // Turn the power on
        bigScreen.power();

        // Display the state of the television
        System.out.println("A " +
                bigScreen.getScreenSize() +
                " inch " +
                bigScreen.getManufacturer() +
                " has been turned on.");

        // Prompt the user for input and store into station
        System.out.print("What channel do you want? ");
        station = keyboard.nextInt();

        // Change the channel on the television
        bigScreen.setChannel(station);

        // Increase the volume of the television
        bigScreen.increaseVolume();

        // Display the the current channel and
        // volume of the television
        System.out.println("Channel: " +
                bigScreen.getChannel() +
                " Volume: " +
                bigScreen.getVolume());
        System.out.println("Too loud! Lowering the volume.");

        // Decrease the volume of the television
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();

        // Display the the current channel and
        // volume of the television
        System.out.println("Channel: " +
                bigScreen.getChannel() +
                " Volume: " +
                bigScreen.getVolume());

        System.out.println();   // For a blank line

        // HERE IS WHERE YOU DO TASK #5
        Television portable = new Television("Sharp", 19);
        portable.power();

        System.out.println("A " +
                portable.getScreenSize() +
                " inch " +
                portable.getManufacturer() +
                " has been turned on.");

        // Prompt the user for input and store into station
        System.out.print("What channel do you want? ");
        station = keyboard.nextInt();

        // Change the channel on the television
        portable.setChannel(station);

        // Change Volume
        portable.decreaseVolume();
        portable.decreaseVolume();

        // Display the the current channel and
        // volume of the television
        System.out.println("Channel: " +
                portable.getChannel() +
                " Volume: " +
                portable.getVolume());

        System.out.println();   // For a blank line
    }
}

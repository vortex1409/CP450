/**
 * CP450 - ASSIGNMENT 1
 * MICHAEL DORFMAN
 * 11/19/2017
 */

import java.util.*;
import static java.lang.System.out;
import static java.lang.System.in;

public class RockPaperScissors
{
    public static void main(String[] args)
    {
        // KeepAlive
        boolean KeepAlive = true;

        // Program Loop
        do {

            // Scanner Object & User Input
            Scanner s = new Scanner(in);
            out.print("Enter 'Rock' or 'Paper' or 'Scissors': ");
            String user = s.nextLine();

            // Choices
            int NPC = NPC();
            int PLAYER = UserChoice(user);
            String ChoiceNPC = DataConverter(NPC);
            String ChoicePLAYER = DataConverter(PLAYER);

            //Parse & Output
            ParseChoice(NPC,PLAYER);

        }while(KeepAlive);
    }

    /**
     * DataConverter Method
     * Converts RPS informatio from numbers to Words
     * @param data Numeric Equivalent
     * @return Words
     */
    public static String DataConverter(int data)
    {
        if(data == 0)
        {
            return "Rock";
        }
        else if(data == 1)
        {
            return "Paper";
        }
        else if(data == 2)
        {
            return "Scissors";
        }
        else
        {
            return "INVALID";
        }
    }

    /**
     * ParseChoice Method
     * Parses the Player and NPC victories and losses
     * @param _NPC NPC Choice
     * @param _PLAYER Player Choice
     */
    public static void ParseChoice(int _NPC, int _PLAYER)
    {
        // Rock = 0
        // Paper = 1
        // Scissors = 2

        out.println("User: " + _PLAYER + " | " + "NPC: " + _NPC);

        if(_PLAYER == 0) // Rock
        {
            if(_NPC == 1) // Paper
            {
                out.println("You Lose - Paper Beats Rock");
            }
            else if(_NPC == 2) // Scissors
            {
                out.println("You Win - Rock Beats Scissors");
            }
            else
            {
                out.println("Draw");
            }
        }
        else if(_PLAYER == 1) // Paper
        {
            if(_NPC == 0) // Rock
            {
                out.println("You Win - Paper Beats Rock");
            }
            else if(_NPC == 2) // Scissors
            {
                out.println("You Lose - Scissors Beats Paper");
            }
            else
            {
                out.println("Draw");
            }
        }
        else if(_PLAYER == 2) // Scissors
        {
            if(_NPC == 0) // Rock
            {
                out.println("You Lose - Rock Beats Scissors");
            }
            else if(_NPC == 1) // Paper
            {
                out.println("You Win - Scissors Beats Paper");
            }
            else
            {
                out.println("Draw");
            }
        }
    }

    /**
     * UserChoice Method
     * @param Choice User Choice as Word
     * @return Numeric Equivalent
     */
    public static int UserChoice(String Choice)
    {
        if(Choice.equalsIgnoreCase("rock"))
        {
            return 0;
        }
        else if(Choice.equalsIgnoreCase("paper"))
        {
            return 1;
        }
        else if(Choice.equalsIgnoreCase("scissors"))
        {
            return 2;
        }
        else
        {
            return 99;
        }
    }

    /**
     * NPC Method
     * Generates random number
     * @return Numeric
     */
    public static int NPC()
    {
        Random RNG = new Random();
        int num = RNG.nextInt(2);
        return num;
    }
}

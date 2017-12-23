/**
 * CP450 - ASSIGNMENT 1
 * MICHAEL DORFMAN
 * 11/19/2017
 */

import java.util.*;
import static java.lang.System.*;

public class Dice
{
    public static void main(String[] args)
    {
        // Variables
        int PLAYER_WINS = 0;
        int NPC_WINS = 0;
        int PLAYER_ROLL =  0;
        int NPC_ROLL = 0;

        for(int i = 0; i < 9; i++)
        {
            // Assigns Roll
            PLAYER_ROLL = RNG();
            NPC_ROLL = RNG();

            // Checks Who Won and adds to their victory counter
            if(PLAYER_ROLL > NPC_ROLL)
            {
                // PLAYER WINS
                out.println("PLAYER WINS - CURRENT ROLL");
                PLAYER_WINS++;
            }
            else if(PLAYER_ROLL == NPC_ROLL)
            {
                // DRAW
                out.println("DRAW - CURRENT ROLL");
            }
            else
            {
                // PLAYER LOSES
                out.println("PLAYER LOSES - CURRENT ROLL");
                NPC_WINS++;
            }
        }

        // Prints Victory Statement
        if(PLAYER_WINS > NPC_WINS)
        {
            out.println("PLAYER WINS GAME");
        }
        else if(PLAYER_WINS == NPC_WINS)
        {
            out.println("GAME IS A DRAW");
        }
        else
        {
            out.println("NPC WINS GAME");
        }
    }

    /**
     * RNG Method
     * Generates a random number
     * @return Random Number
     */
    public static int RNG()
    {
        Random _RNG = new Random();
        return _RNG.nextInt(6) + 1;
    }
}

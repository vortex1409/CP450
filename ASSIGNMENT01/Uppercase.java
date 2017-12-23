/**
 * CP450 - ASSIGNMENT 1
 * MICHAEL DORFMAN
 * 11/19/2017
 */

import java.util.*;
import java.io.*;

public class Uppercase
{
    public static void main(String[] args) throws IOException
    {
        // Use Absolute Path for Reading File
        Scanner s = new Scanner(new File("C:\\Users\\owner\\IdeaProjects\\CP450_ASSIGNMENT1_MDORFMAN\\src\\data.txt"));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.next().toUpperCase());
        }
        s.close();

        // Prints the List Items
        System.out.println(list);

        // Writes a File
        FileWriter Writer = new FileWriter("output.txt", true);

        // Populates file with list items
        for(String object: list)
        {
            Writer.write(object);
            Writer.write("\r\n");
        }
        Writer.close();
    }
}

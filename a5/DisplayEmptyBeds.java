/*
 * CMPT 270
 * Assignment Five
 * Question Five
 *
 * DisplayEmptyBeds.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.LinkedList;


 public class DisplayEmptyBeds implements Command
{
    /**
     * Display the empty beds for the ward.
     */
    public void execute()
    {
        LinkedList<Integer> availableBedList = WardAccess.getInstance().availableBeds();

        IOAccess.getInstance().outputString("\nThe following beds are available:");
        for (Integer bedLabel: availableBedList)
            IOAccess.getInstance().outputString("bed " + bedLabel);
    }
}

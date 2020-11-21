/*
 * CMPT 270
 * Assignment Five
 * Question Three
 *
 * DialogIO.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import javax.swing.*;


/**
 * A simple class for handling ConsoleIO, by following the interface defined
 * in InputOutputInterface.
 */
public class DialogIO extends AbstractDialogIO
{

    /**
     * Display a prompt and read the string entered.
     *
     * Will loop until a non-empty string is read.
     * 
     * @param prompt the string to be displayed as a prompt
     * @return the String read
     */
    public String readString(String prompt)
    {
        String input = (String) JOptionPane.showInputDialog(prompt);
            
        if (! input.isEmpty())
            return input;

        JOptionPane.showMessageDialog(null, "No input received... please try again.\n");            
        return readString(prompt);
    }

    /**
     * Display a prompt and read the int entered.
     * 
     * @param prompt the string to be displayed as a prompt
     * @return the int read
     */
    public int readInt(String prompt)
    {
        int intInput = -1;
        String input = "";

        // keep trying until the user enters an int correctly
        try {
            input = readString(prompt);
            intInput = Integer.parseInt(input);
            return intInput;
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input was not an integer... please try again.\n");
            return readInt(prompt);
        }
    }

    /**
     * Output the String parameter. Also prints a newline.
     * 
     * @param outString the string whose value is to be displayed
     */
    public void outputString(String outString)
    {
        JOptionPane.showMessageDialog(null, outString + "\n");            
    }

    /**
     * Test the DialogIO class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        DialogIO io = new DialogIO();

        // Test outputString()
        io.outputString("Beginning Test...");

        // Test readString()
        String name = io.readString("What is your name?");
        io.outputString("So, your name is " + name + "? Interesting...");

        // Test readInt()
        int age = io.readInt("What is your age?");
        io.outputString("So, you're " + age + " years old? Remarkable...");

        // Test readChoice()
        String movies[] = {"Shrek", "Shrek 2", "Shrek 3"};
        io.outputString("What is your favourite Movie?");
        int choice = io.readChoice(movies);
        io.outputString("Really? " + movies[choice] + "? Weird...");
    }
}
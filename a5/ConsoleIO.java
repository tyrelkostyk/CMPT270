/*
 * CMPT 270
 * Assignment Five
 * Question Two
 *
 * ConsoleIO.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */
 
import java.util.Scanner;
import java.util.Arrays;


/**
 * A simple class for handling ConsoleIO, by following the interface defined
 * in InputOutputInterface.
 */
public class ConsoleIO implements InputOutputInterface
{
    /** 
    One Scanner for all methods 
    */
    private static Scanner consoleIn = new Scanner(System.in);

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
        String input = "";

        while (input.isEmpty()) {
            System.out.print(prompt + " ");
            input = consoleIn.nextLine();
            
            if (input.isEmpty())
                System.out.println("No input received... please try again.");
        }

        return input;
    }

    /**
     * Display a prompt and read the int entered.
     * 
     * @param prompt the string to be displayed as a prompt
     * @return the int read
     */
    public int readInt(String prompt)
    {
        String input = "";
        int intInput = -1;

        // keep trying until the user enters an int correctly
        try {
            input = readString(prompt);
            intInput = Integer.parseInt(input);
            return intInput;
        
        } catch (NumberFormatException e) {
            System.out.println("Input was not an integer... please try again.");
            return readInt(prompt);
        }
    }

    /**
     * Display the list of options and read an int that is the index of one of the options. The
     * first option is the default.
     *
     * Prepends each option with an integer. If option "1. ..." is chosen, 0 will be returned.
     * 
     * @param options an array with the options that are presented to the user
     * @return the int specifying the array index for the option selected by the user
     */
    public int readChoice(String[] options)
    {
        int minChoice = 1;
        int maxChoice = options.length;

        int listedChoice = minChoice;
        for (String option: options) {
            System.out.println(listedChoice + ": " + option);
            listedChoice++;
        }

        int intInput = readInt("Please choose your desired choice {" + minChoice + " - " + maxChoice + "}: ");

        if (intInput >= minChoice && intInput <= maxChoice)
            return intInput - 1;

        System.out.println("Input was not a valid option... please try again.");
        return readChoice(options);
    }

    /**
     * Output the String parameter. Also prints a newline.
     * 
     * @param outString the string whose value is to be displayed
     */
    public void outputString(String outString)
    {
        System.out.println(outString);
    }

    /**
     * Test the ConsoleIO class.
     * @param args not used
     */
    public static void main(String[] args)
    {
        ConsoleIO io = new ConsoleIO();

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

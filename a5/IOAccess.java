/*
 * CMPT 270
 * Assignment Five
 * Question Four
 *
 * IOAccess.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */


public class IOAccess
{

    /**
     * The Ward.
     */
    private static InputOutputInterface io;

    /**
     * The Private Constructor.
     */
    private IOAccess() {}

    /**
     * Initialize the IO Interface.
     */
    public static void initialize(int IOChoice)
    {
        // don't init twice
        if (io != null) throw new IllegalStateException("IOAccess has already been initialized!");
        
        // init implementation based on upper-layer decision
        if      (IOChoice == 0) io = new ConsoleIO();
        else if (IOChoice == 1) io = new DialogIO();
        else throw new IllegalStateException("Invalid IO choice given!");
    }

    /**
     * Return the IOAccess interface.
     * @return the IOAccess interface.
     */
    public static InputOutputInterface getInstance()
    {
        if (io == null)
            throw new IllegalStateException("IOAccess has not been initialized!");
        
        // return io
        return io;
    }
}
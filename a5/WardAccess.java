/*
 * CMPT 270
 * Assignment Five
 * Question Four
 *
 * WardAccess.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */


public class WardAccess
{

    /**
     * The Ward.
     */
    private static Ward ward;

    /**
     * The Private Constructor.
     */
    private WardAccess() {}

    /**
     * Initialize the Ward.
     */
    public static void initialize(String name, int minBedLabel, int maxBedLabel)
    {
        if (ward != null)
            throw new IllegalStateException("Ward has already been initialized!");
        
        ward = new Ward(name, minBedLabel, maxBedLabel);
    }

    /**
     * Return the dictionary that maps to Doctors.
     * @return the dictionary that maps to Doctors.
     */
    public static Ward getInstance()
    {
        if (ward == null)
            throw new IllegalStateException("Ward has not been initialized!");
        
        // return ward
        return ward;
    }
}
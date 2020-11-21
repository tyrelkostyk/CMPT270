/*
 * CMPT 270
 * Assignment Five
 * Question Four
 *
 * DoctorMapAccess.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */
 
import java.util.TreeMap;


public class DoctorMapAccess
{

    /**
     * The keyed dictionary of all doctors.
     */
    private static TreeMap<String, Doctor> dictionary;

    /**
     * The Private Constructor.
     */
    private DoctorMapAccess() {}

    /**
     * Return the dictionary that maps to Doctors.
     * @return the dictionary that maps to Doctors.
     */
    public static TreeMap<String, Doctor> getInstance()
    {
        // create dictionary if not done so yet
        if (dictionary == null)
            dictionary = new TreeMap<String, Doctor>();

        // return dictionary
        return dictionary;
    }
}
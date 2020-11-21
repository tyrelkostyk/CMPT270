/*
 * CMPT 270
 * Assignment Five
 * Question Four
 *
 * PatientMapAccess.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */
 
import java.util.TreeMap;
import java.util.Map;


public class PatientMapAccess
{

    /**
     * The Private Constructor.
     */
    private PatientMapAccess() {}

    /**
     * The keyed dictionary of all patients.
     */
    private static TreeMap<String, Patient> dictionary;

    /**
     * Return the dictionary that maps to Patients.
     * @return the dictionary that maps to Patients.
     */
    public static TreeMap<String, Patient> getInstance()
    {
        // create dictionary if not done so yet
        if (dictionary == null)
            dictionary = new TreeMap<String, Patient>();

        // return dictionary
        return dictionary;
    }
}
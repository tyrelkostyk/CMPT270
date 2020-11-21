/*
 * CMPT 270
 * Assignment Five
 * Question Five
 *
 * AddPatient.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */


 public class AddPatient implements Command
{
    /**
     * Read the information for a new patient and then add the patient
     * to the dictionary of all patients.
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("Adding Patient to Ward...");
        String name = IOAccess.getInstance().readString("Enter the name of the patient: ");
        IOAccess.getInstance().outputString("Entered: " + name);

        String healthNum = IOAccess.getInstance().readString("Enter the health number of the patient: ");
        IOAccess.getInstance().outputString("Entered: " + healthNum);

        if (PatientMapAccess.getInstance().containsKey(healthNum))
        {
            throw new  IllegalStateException("Patient with the health number " + healthNum + " already exsists");
        }

        Patient p = new Patient(name, healthNum);
        Patient result = PatientMapAccess.getInstance().put(healthNum, p);

        // checking to make sure the the key was unique
        if (result != null)
        {
            PatientMapAccess.getInstance().put(healthNum, result);  // put the original patient back
            throw new IllegalStateException("Health number in the patient dictionary even "
                    + "though containsKey failed.  Number " + healthNum + " not entered.");
        }
    }
}

/*
 * CMPT 270
 * Assignment Five
 * Question Five
 *
 * ReleasePatient.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.NoSuchElementException;


 public class ReleasePatient implements Command
{
    /**
     * Release a patient from the ward.
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("Releasing a Patient from a Bed...");
        String healthNumber = IOAccess.getInstance().readString("Enter the health number of the patient: ");

        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        int bedNum = p.getBedLabel();
        if (bedNum == -1)
            throw new IllegalStateException(" Patient " + p
                    + " is currently not in a bed, so they cannot be released from one");

        p.setBedLabel(-1);
        WardAccess.getInstance().freeBed(bedNum);
    }
}

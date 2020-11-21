/*
 * CMPT 270
 * Assignment Five
 * Question Five
 *
 * AssignBed.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.NoSuchElementException;


 public class AssignBed implements Command
{
    /**
     * Assign a patient to a specific bed.
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("Assigning a Patient to a Bed...");
        String healthNumber = IOAccess.getInstance().readString("Enter the health number of the patient: ");

        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        if (p.getBedLabel() != -1)
            throw new IllegalStateException(" Patient " + p
                    + " is already in a bed so cannot be assigned a new bed");

        int bedNum = IOAccess.getInstance().readInt("Enter the bed number for the patient: ");

        if (bedNum < WardAccess.getInstance().getMinBedLabel() || bedNum > WardAccess.getInstance().getMaxBedLabel())
            throw new IllegalArgumentException("Bed label " + bedNum + " is not valid, as "
                    + "the value must be between " + WardAccess.getInstance().getMinBedLabel()
                    + " and " + WardAccess.getInstance().getMaxBedLabel());

        p.setBedLabel(bedNum);
        WardAccess.getInstance().assignPatientToBed(p, bedNum);
    }
}

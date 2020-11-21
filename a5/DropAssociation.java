/*
 * CMPT 270
 * Assignment Five
 * Question Five
 *
 * DropAssociation.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.NoSuchElementException;


 public class DropAssociation implements Command
{
    /**
     * Drop the association between a doctor and a patient.
     */
    public void execute()
    {
        IOAccess.getInstance().outputString("Dropping a new Doctor-Patient Association...");
        IOAccess.getInstance().outputString("Getting Patient information...");
        String healthNumber = IOAccess.getInstance().readString("Enter the health number of the patient: ");

        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        IOAccess.getInstance().outputString("Getting Doctor information...");
        String name = IOAccess.getInstance().readString("Enter the name of the doctor: ");

        Doctor d = DoctorMapAccess.getInstance().get(name);
        if (d == null)
            throw new NoSuchElementException("There is no doctor with name " + name);

        String pHealthNumber = p.getHealthNumber();
        if (!d.hasPatient(pHealthNumber))
            throw new IllegalStateException("This doctor is not associated with this patient.");
        if (!p.hasDoctor(name))
            throw new IllegalStateException("This doctor and this patient are incorrectly "
                    + "associated.  The doctor has the patient, "
                    + "but the patient does not have the doctor");

        p.removeDoctor(name);
        d.removePatient(healthNumber);
    }
}

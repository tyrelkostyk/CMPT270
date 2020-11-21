/*
 * CMPT 270
 * Assignment Five
 * Question Five
 *
 * SystemState.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.Collection;


 public class SystemState implements Command
{
    /**
     * Displays the system state
     */
    public void execute()
    {
        String result = "\nThe patients in the system are \n";
        Collection<Patient> patientsColl = PatientMapAccess.getInstance().values();
        for (Patient p: patientsColl)
            result = result + p;
        result = result + "\nThe doctors in the system are \n";
        Collection<Doctor> doctorsColl = DoctorMapAccess.getInstance().values();
        for (Doctor d: doctorsColl)
            result = result + d;
        result = result + "\nThe ward is " + WardAccess.getInstance();
        IOAccess.getInstance().outputString(result);
    }
}

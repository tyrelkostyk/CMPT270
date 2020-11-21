/*
 * CMPT 270
 * Assignment Five
 * Question Four
 *
 * HospitalSystemA5Q5.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.Collection;


/**
 * A simple hospital system with only one ward. Patients and doctors can be created,
 * and patients assigned to a doctor and/or placed in a bed of the ward.
 */
public class HospitalSystemA5Q5
{
    /**
     * Initialize an instance of the hospital ward
     * relies on user-input to get the relavent information
     */
    public HospitalSystemA5Q5()
    {
        // get the ward information
        IOAccess.getInstance().outputString("Getting Ward information...");
        String name = IOAccess.getInstance().readString("Enter the name of the Ward: ");
        IOAccess.getInstance().outputString("Entered: " + name);
        int firstBedNum = IOAccess.getInstance().readInt("Enter the integer label of the first bed: ");
        IOAccess.getInstance().outputString("Entered: " + firstBedNum);

        int lastBedNum =  IOAccess.getInstance().readInt("Enter the integer label of the last bed: ");
        IOAccess.getInstance().outputString("Entered: " + lastBedNum);

        // initialize the Ward
        WardAccess.initialize(name, firstBedNum, lastBedNum);
    }

    /**
     * Read the information for a new patient and then add the patient
     * to the dictionary of all patients.
     */
    public void addPatient()
    {
        Command cmd = new AddPatient();
        cmd.execute();
    }

    /**
     * Read the information for a new doctor and then add the doctor
     * to the dictionary of all doctors.
     */
    public void addDoctor()
    {
        Command cmd = new AddDoctor();
        cmd.execute();
    }

    /**
     * Assign a doctor to take care of a patient.
     */
    public void assignDoctorToPatient()
    {
        Command cmd = new AssignDoctorToPatient();
        cmd.execute();
    }

    /**
     * Assign a patient to a specific bed.
     */
    public void assignBed()
    {
        Command cmd = new AssignBed();
        cmd.execute();
    }

    /**
     * Drop the association between a doctor and a patient.
     */
    public void dropAssociation()
    {
        Command cmd = new DropAssociation();
        cmd.execute();
    }

    /**
     * Displays the system state
     */
    public void systemState()
    {
        Command cmd = new SystemState();
        cmd.execute();
    }

    /**
     * Return a string representation of the HospitalSystemA5Q5
     * @return a string representation of the HospitalSystemA5Q5
     */
    public String toString() {
        String result = "\nThe patients in the system are \n";
        Collection<Patient> patientsColl = PatientMapAccess.getInstance().values();
        for (Patient p: patientsColl)
            result = result + p;
        result = result + "\nThe doctors in the system are \n";
        Collection<Doctor> doctorsColl = DoctorMapAccess.getInstance().values();
        for (Doctor d: doctorsColl)
            result = result + d;
        result = result + "\nThe ward is " + WardAccess.getInstance();
        return result;
    }

    /**
     * Display the empty beds for the ward.
     */
    public void displayEmptyBeds()
    {
        Command cmd = new DisplayEmptyBeds();
        cmd.execute();
    }


    /**
     * Release a patient from the ward.
     */
    public void releasePatient()
    {
        Command cmd = new ReleasePatient();
        cmd.execute();
    }

    /**
     * Run the hospital system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int task = -1;
        HospitalSystemA5Q5 sys;

        // temporary console IO object to ask the user what type of IO they want
        ConsoleIO initIO = new ConsoleIO();
        
        String IOOptions[] = {
            "Console IO",
            "Dialog IO",
        };

        // ask the user what type of IO they want
        int IOChoice = initIO.readChoice(IOOptions);

        // initialize the IO
        IOAccess.initialize(IOChoice);

        IOAccess.getInstance().outputString("Initializing the system...");
        
        while (true) {
            // keep trying until the user enters the data correctly
            try {
                sys = new HospitalSystemA5Q5();
                break;
            }
            catch (RuntimeException e) {
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }

        String options[] = {
            "quit",
            "add a new patient",
            "add a new doctor",
            "assign a doctor to a patient",
            "display the empty beds of the ward",
            "assign a patient a bed",
            "release a patient",
            "drop doctor-patient association",
            "display current system state",
        };

        while (task != 0) {
            try
            {
                task = IOAccess.getInstance().readChoice(options);

                if      (task == 0) sys.systemState();
                else if (task == 1) sys.addPatient();
                else if (task == 2) sys.addDoctor();
                else if (task == 3) sys.assignDoctorToPatient();
                else if (task == 4) sys.displayEmptyBeds();
                else if (task == 5) sys.assignBed();
                else if (task == 6) sys.releasePatient();
                else if (task == 7) sys.dropAssociation();
                else if (task == 8) sys.systemState();
                else IOAccess.getInstance().outputString("Invalid option, try again.");
            } 
            catch (RuntimeException e) {
                // No matter what  exception is thrown, this catches it
                // Dealing with it means discarding whatever went wrong 
                // and starting the loop over.  Easy for the programmer,
                // tedious for the user.
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }
    }
}
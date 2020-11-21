/*
 * CMPT 270
 * Assignment Five
 * Question Four
 *
 * HospitalSystemA5Q4.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 * A simple hospital system with only one ward. Patients and doctors can be created,
 * and patients assigned to a doctor and/or placed in a bed of the ward.
 */
public class HospitalSystemA5Q4
{
    /**
     * Initialize an instance of the hospital ward
     * relies on user-input to get the relavent information
     */
    public HospitalSystemA5Q4()
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

    /**
     * Read the information for a new doctor and then add the doctor
     * to the dictionary of all doctors.
     */
    public void addDoctor()
    {
        IOAccess.getInstance().outputString("Adding Doctor to Ward...");
        String name = IOAccess.getInstance().readString("Enter the name of the doctor: ");
        IOAccess.getInstance().outputString("Entered: " + name);
        if (DoctorMapAccess.getInstance().containsKey(name))
            throw new IllegalStateException("Doctor not added as there already "
                    + "is a doctor with the name " + name);

        String response = IOAccess.getInstance().readString("Is the doctor a surgeon? (yes or no)");
        IOAccess.getInstance().outputString("Entered: " + response);

        Doctor d;
        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y')
            d = new Surgeon(name);
        else
            d = new Doctor(name);

        // check to make sure the doctor name doesn't already exist
        Doctor sameNumberDoctor = DoctorMapAccess.getInstance().put(name, d);
        if (sameNumberDoctor != null)
        {
            DoctorMapAccess.getInstance().put(name, sameNumberDoctor); // put the original doctor back
            throw new IllegalStateException("Name in the doctor dictionary even though "
                    + "containsKey failed.  Name "  + name + " not entered.");
        }
    }

    /**
     * Assign a doctor to take care of a patient.
     */
    public void assignDoctorToPatient()
    {
        IOAccess.getInstance().outputString("Assigning a new Doctor-Patient Association...");
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
        else
        {
            p.addDoctor(d);
            d.addPatient(p);
        }
    }

    /**
     * Assign a patient to a specific bed.
     */
    public void assignBed()
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

    /**
     * Drop the association between a doctor and a patient.
     */
    public void dropAssociation()
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

    /**
     * Displays the system state
     */
    public void systemState()
    {
        IOAccess.getInstance().outputString(this.toString());
    }

    /**
     * Return a string representation of the HospitalSystemA5Q4
     * @return a string representation of the HospitalSystemA5Q4
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
        LinkedList<Integer> availableBedList = WardAccess.getInstance().availableBeds();

        IOAccess.getInstance().outputString("\nThe following beds are available:");
        for (Integer bedLabel: availableBedList)
            IOAccess.getInstance().outputString("bed " + bedLabel);
    }


    /**
     * Release a patient from the ward.
     * Method is just a stub, needs to be implemented
     */
    public void releasePatient()
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

    /**
     * Run the hospital system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int task = -1;
        HospitalSystemA5Q4 sys;

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
                sys = new HospitalSystemA5Q4();
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
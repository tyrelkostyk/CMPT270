/*
 * CMPT 270
 * Assignment Five
 * Question One
 *
 * HospitalSystemA5Q2.java
 *
 * Tyrel Kostyk
 * 11216033
 * TCK290
 *
 * November 20 2020
 */
 
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 * A simple hospital system with only one ward. Patients and doctors can be created,
 * and patients assigned to a doctor and/or placed in a bed of the ward.
 */
public class HospitalSystemA5Q2
{
    /** 
    One ConsoleIO for all methods 
    */
    private static ConsoleIO io = new ConsoleIO();

    /**
     * The keyed dictionary of all patients.
     */
    private Map<String, Patient> patients;

    /**
     * The keyed dictionary of all doctors.
     */
    private Map<String, Doctor> doctors;

    /**
     * The ward to be handled.
     */
    private Ward ward;

    /**
     * Initialize an instance of the hospital ward
     * relies on user-input to get the relavent information
     */
    public HospitalSystemA5Q2() {

        patients = new TreeMap<String, Patient>();
        doctors = new TreeMap<String, Doctor>();

        // get the ward information
        io.outputString("Getting Ward information...");
        String name = io.readString("Enter the name of the Ward: ");
        io.outputString("Entered: " + name);
        int firstBedNum = io.readInt("Enter the integer label of the first bed: ");
        io.outputString("Entered: " + firstBedNum);

        int lastBedNum =  io.readInt("Enter the integer label of the last bed: ");
        io.outputString("Entered: " + lastBedNum);

        ward = new Ward(name, firstBedNum, lastBedNum);
    }

    /**
     * Read the information for a new patient and then add the patient
     * to the dictionary of all patients.
     */
    public void addPatient()
    {
        io.outputString("Adding Patient to Ward...");
        String name = io.readString("Enter the name of the patient: ");
        io.outputString("Entered: " + name);

        String healthNum = io.readString("Enter the health number of the patient: ");
        io.outputString("Entered: " + healthNum);

        if (patients.containsKey(healthNum))
        {
            throw new  IllegalStateException("Patient with the health number " + healthNum + " already exsists");
        }

        Patient p = new Patient(name, healthNum);
        Patient result = patients.put(healthNum, p);

        // checking to make sure the the key was unique
        if (result != null)
        {
            patients.put(healthNum, result);  // put the original patient back
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
        io.outputString("Adding Doctor to Ward...");
        String name = io.readString("Enter the name of the doctor: ");
        io.outputString("Entered: " + name);
        if (doctors.containsKey(name))
            throw new IllegalStateException("Doctor not added as there already "
                    + "is a doctor with the name " + name);

        String response = io.readString("Is the doctor a surgeon? (yes or no)");
        io.outputString("Entered: " + response);

        Doctor d;
        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y')
            d = new Surgeon(name);
        else
            d = new Doctor(name);

        // check to make sure the doctor name doesn't already exist
        Doctor sameNumberDoctor = doctors.put(name, d);
        if (sameNumberDoctor != null)
        {
            doctors.put(name, sameNumberDoctor); // put the original doctor back
            throw new IllegalStateException("Name in the doctor dictionary even though "
                    + "containsKey failed.  Name "  + name + " not entered.");
        }
    }

    /**
     * Assign a doctor to take care of a patient.
     */
    public void assignDoctorToPatient()
    {
        io.outputString("Assigning a new Doctor-Patient Association...");
        String healthNumber = io.readString("Enter the health number of the patient: ");

        Patient p = patients.get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        io.outputString("Getting Doctor information...");
        String name = io.readString("Enter the name of the doctor: ");

        Doctor d = doctors.get(name);
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
        io.outputString("Assigning a Patient to a Bed...");
        String healthNumber = io.readString("Enter the health number of the patient: ");

        Patient p = patients.get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        if (p.getBedLabel() != -1)
            throw new IllegalStateException(" Patient " + p
                    + " is already in a bed so cannot be assigned a new bed");

        int bedNum = io.readInt("Enter the bed number for the patient: ");

        if (bedNum < ward.getMinBedLabel() || bedNum > ward.getMaxBedLabel())
            throw new IllegalArgumentException("Bed label " + bedNum + " is not valid, as "
                    + "the value must be between " + ward.getMinBedLabel()
                    + " and " + ward.getMaxBedLabel());

        p.setBedLabel(bedNum);
        ward.assignPatientToBed(p, bedNum);
    }

    /**
     * Drop the association between a doctor and a patient.
     */
    public void dropAssociation()
    {
        io.outputString("Dropping a new Doctor-Patient Association...");
        io.outputString("Getting Patient information...");
        String healthNumber = io.readString("Enter the health number of the patient: ");

        Patient p = patients.get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        io.outputString("Getting Doctor information...");
        String name = io.readString("Enter the name of the doctor: ");

        Doctor d = doctors.get(name);
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
        io.outputString(this.toString());
    }

    /**
     * Return a string representation of the HospitalSystemA5Q2
     * @return a string representation of the HospitalSystemA5Q2
     */
    public String toString() {
        String result = "\nThe patients in the system are \n";
        Collection<Patient> patientsColl = patients.values();
        for (Patient p: patientsColl)
            result = result + p;
        result = result + "\nThe doctors in the system are \n";
        Collection<Doctor> doctorsColl = doctors.values();
        for (Doctor d: doctorsColl)
            result = result + d;
        result = result + "\nThe ward is " + ward;
        return result;
    }

    /**
     * Display the empty beds for the ward.
     */
    public void displayEmptyBeds()
    {
        LinkedList<Integer> availableBedList = ward.availableBeds();

        io.outputString("\nThe following beds are available:");
        for (Integer bedLabel: availableBedList)
            io.outputString("bed " + bedLabel);
    }


    /**
     * Release a patient from the ward.
     * Method is just a stub, needs to be implemented
     */
    public void releasePatient()
    {
        io.outputString("Releasing a Patient from a Bed...");
        String healthNumber = io.readString("Enter the health number of the patient: ");

        Patient p = patients.get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        int bedNum = p.getBedLabel();
        if (bedNum == -1)
            throw new IllegalStateException(" Patient " + p
                    + " is currently not in a bed, so they cannot be released from one");

        p.setBedLabel(-1);
        ward.freeBed(bedNum);
    }

    /**
     * Run the hospital system.
     * @param args not used
     */
    public static void main(String[] args)
    {
        int task = -1;
        HospitalSystemA5Q2 sys;

        io.outputString("Initializing the system...");
        
        while (true) {
            // keep trying until the user enters the data correctly
            try {
                sys = new HospitalSystemA5Q2();
                break;
            }
            catch (RuntimeException e) {
                io.outputString(e.getMessage());
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
                io.outputString("\nOptions:");
                task = io.readChoice(options);

                io.outputString("\n");

                if      (task == 0) sys.systemState();
                else if (task == 1) sys.addPatient();
                else if (task == 2) sys.addDoctor();
                else if (task == 3) sys.assignDoctorToPatient();
                else if (task == 4) sys.displayEmptyBeds();
                else if (task == 5) sys.assignBed();
                else if (task == 6) sys.releasePatient();
                else if (task == 7) sys.dropAssociation();
                else if (task == 8) sys.systemState();
                else io.outputString("Invalid option, try again.");
            } 
            catch (RuntimeException e) {
                // No matter what  exception is thrown, this catches it
                // Dealing with it means discarding whatever went wrong 
                // and starting the loop over.  Easy for the programmer,
                // tedious for the user.
                io.outputString(e.getMessage());
            }
        }
    }
}
/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 4, Question 5
 */

import java.util.*;


/**
 * A model of a Doctor.
 */
public class HospitalSystem {

	/**
	 * The ward contained within this Hospital System.
	 */
	private Ward ward;

	/**
	 * A collection of patients identified by their health card number.
	 */
	private Map<String, Patient> patients;

	/**
	 * A collection of doctors identified by their name.
	 */
	private Map<String, Doctor> doctors;

	/**
	 * The constructor for the HositalSystem.
	 * @param wardName the name to assign to the new ward
	 * @param firstBedLabel the label of the first bed
	 * @param lastBedLabel the label of the last bed
	 */
	public HospitalSystem( String wardName, int firstBedLabel, int lastBedLabel )
	{
		this.ward = new Ward( wardName, firstBedLabel, lastBedLabel );
		this.patients = new HashMap<String, Patient>();
		this.doctors = new HashMap<String, Doctor>();
	}

	/**
	 * Adds a patient into the hospital system.
	 * @param patientName the name of the patient.
	 * @param patientHealthNumber the patient's health card number.
	 */
	public void addPatient( String patientName, String patientHealthNumber )
	{
		Patient newPatient = new Patient( patientName, patientHealthNumber );
		patients.put( patientHealthNumber, newPatient );
	}

	/**
	 * Adds a doctor into the hospital system.
	 * @param doctorName the name of the doctor.
	 */
	public void addDoctor( String doctorName )
	{
		Doctor newDoctor = new Doctor( doctorName );
		doctors.put( doctorName, newDoctor );
	}

	/**
	 * Creates an associate between a patient and a doctor.
	 * @param doctorName the name of the doctor.
	 * @param patientName the name of the patient.
	 */
	public void assignDoctorToPatient( String doctorName, String patientName )
	{
		Doctor doc = this.doctors.get( doctorName );
		Patient pat = this.patients.get( patientName );

		doc.addPatient( pat );
		pat.addDoctor( doc );
	}

	/**
	 * Assigns a bed to a patient within the Hospital.
	 * @param patientName the name of the patient.
	 */
	public void assignBed( String patientName )
	{
		// grab the first available bed label
		ArrayList<Integer> beds = this.ward.availableBeds();
		int bed = beds.get(0);

		// identify the patient
		Patient patient = this.patients.get( patientName );

		// assign the patient to the bed
		this.ward.assignPatientToBed( patient, bed );
	}

	/**
	 * Destroys an associate between a patient and a doctor.
	 * @param doctorName the name of the doctor.
	 * @param patientName the name of the patient.
	 */
	public void dropAssociation( String doctorName, String patientName )
	{
		Patient patient = this.patients.get( patientName );
		Doctor doctor = this.doctors.get( doctorName );

		patient.removeDoctor( doctorName );
		doctor.removePatient( patientName );
	}

	/**
	 * Returns the state of the HospitalSystem as a String.
	 */
	public String systemState()
	{
		return this.toString();
	}

	/**
	 * Returns the state of the HospitalSystem as a String.
	 */
	public String toString()
	{
		// grab the string representation of the ward
		String wardString = "";
		if (ward != null) {
			wardString = wardString.toString();
		}

		// grab the string representation of the doctors
		String docString = "";
		if ( this.doctors.size() > 0 ) {
			docString = "\nDoctors:";
			Set<String> docKeySet = this.doctors.keySet();
			for ( String name : docKeySet ) {
				docString += this.doctors.get(name).toString();
			}
		}

		// grab the string representation of the patients
		String patientString = "";
		if (this.patients.size() > 0) {
			patientString = "\nPatients:";
			Set<String> patKeySet = this.patients.keySet();
			for ( String name : patKeySet ) {
				patientString += this.patients.get(name).toString();
			}
		}

		return super.toString() + wardString + docString + patientString;
	}


	public static void main( String[] args )
	{

	}
}

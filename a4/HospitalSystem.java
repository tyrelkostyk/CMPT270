/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 4, Question 5
 */

import java.util.*;


public class HospitalSystem {

	private Ward ward;

	private Map<String, Patient> patients;

	private Map<String, Doctor> doctors;

	public HospitalSystem( String wardName, int firstBedLabel, int lastBedLabel )
	{
		this.ward = new Ward( wardName, firstBedLabel, lastBedLabel );
		this.patients = new HashMap<String, Patient>();
		this.doctors = new HashMap<String, Doctor>();
	}

	public void addPatient( patientName, patientHealthNumber )
	{
		Patient newPatient = new Patient( patientName, patientHealthNumber );
		patients.put( patientHealthNumber, newPatient );
	}

	public void addDoctor( doctorName )
	{
		Doctor newDoctor = new Doctor( doctorName );
		doctors.put( doctorName, newDoctor );
	}

	public void assignDoctorToPatient( String doctorName, String patientName )
	{
		Doctor doc = this.doctors.get( doctorName );
		this.patients.put( doctorName, doc );
	}

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

	public void dropAssociation( String doctorName, String patientName )
	{
		Patient patient = this.patients.get( patientName );
		Doctor doctor = this.doctors.get( doctorName );

		patient.removeDoctor( doctor );
		doctor.removePatient( patient );
	}

	public String systemState()
	{
		return this.toString();
	}

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
			docString = "\nDoctors:"
			for ( Doctor doc : this.doctors ) {
				docString += doc.toString();
			}
		}

		// grab the string representation of the patients
		String patientString = "";
		if (this.patients.size() > 0) {
			patientString = "\nPatients:";
			for ( Patient pat : this.patients ) {
				patientString += pat.toString();
			}
		}

		return super.toString() + wardString + docString + patientString;
	}



	public static void main( String[] args )
	{

	}
}

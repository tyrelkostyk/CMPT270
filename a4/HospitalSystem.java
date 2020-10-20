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

	public addPatient( patientName, patientHealthNumber )
	{
		Patient newPatient = new Patient( patientName, patientHealthNumber );
		patients.put( patientHealthNumber, newPatient );
	}

	public addDoctor( doctorName )
	{
		Patient newDoctor = new Doctor( doctorName );
		patients.put( doctorName, newDoctor );
	}

	public assignDoctorToPatient(  )



	public static void main( String[] args )
	{

	}
}

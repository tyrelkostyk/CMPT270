/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 4, Question 2
 */

import java.util.*;


/**
 * A model of a Doctor.
 */
public class Doctor extends BasicDoctor
{
	/**
	 * A list of all of the Doctor's patients.
	 */
	private ArrayList<Patient> patients;

	/**
	 * Constructor that initializes a Doctor model.
	 */
	public Doctor( String name )
	{
		super( name );
		this.patients = new ArrayList<Patient>();
	}

	/**
	 * Add a Patient to the list of this Doctor's patients.
	 * @param p the Patient to be added.
	 */
	public void addPatient( Patient p )
	{
		this.patients.add( p );
	}

	/**
	 * Remove a Patient from the Doctor's list.
	 * @param healthNum the health card number of the Patient to remove.
	 */
	public void removePatient( String healthNum )
	{
		for ( Patient pat : this.patients ) {
			if ( pat.getHealthNumber().equals( healthNum ) ) {
				this.patients.remove( pat );
				return;
			}
		}
	}

	/**
	 * Confirm if a Patient has been assigned to this Doctor.
	 * @param healthNum the health card number of the Patient to check for.
	 */
	public boolean hasPatient( String healthNum )
	{
		for ( Patient pat : this.patients ) {
			if ( pat.getHealthNumber().equals( healthNum ) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return a pretty String representation of the Doctor's state.
	 * @return a String representing the Doctor object.
	 */
	public String toString()
	{
		String patientString = "";
		if (this.patients.size() > 0) {
			patientString = "\nPatients:";
			for ( Patient pat : this.patients ) {
				patientString += pat.toString();
			}
		}
		return super.toString() + patientString;
	}

	/**
	 * Test the Doctor's attributes and methods.
	 * @param args unused input arguments.
	 */
	public static void main( String[] args )
	{
		// keep track of the number of errors encountered
		int errorCount = 0;

		// instantiate our Doctor to test with
		Doctor testDoctor = new Doctor( "Abe Lincoln" );

		// TEST: addPatient() and hasPatient()
		String testPat1Name = "Tim";
		String testPat1Num = "123";
		Patient testPat1 = new Patient( testPat1Name, testPat1Num );
		testDoctor.addPatient( testPat1 );
		if (! testDoctor.hasPatient( testPat1Num ) ) {
			errorCount++;
			System.out.println("\nError: hasPatient(testPat1Num) returned false after calling addPatient(testPat1)");
		}

		// TEST: addPatient() and hasPatient() again, and removePatient()
		String testPat2Name = "Tam";
		String testPat2Num = "456";
		Patient testPat2 = new Patient( testPat2Name, testPat2Num );
		testDoctor.addPatient( testPat2 );
		if (! testDoctor.hasPatient( testPat2Num ) ) {
			errorCount++;
			System.out.println("\nError: hasPatient(testPat2Num) returned false after calling addPatient(testPat2)");
		}
		testDoctor.removePatient( testPat2Num );
		if ( testDoctor.hasPatient( testPat2Num ) ) {
			errorCount++;
			System.out.println("\nError: hasPatient(testPat2Num) returned true after calling removePatient(testPat2Num)");
		}

		// TEST: toString()
		String expected = "\nName: Abe Lincoln\n\nPatients:\nName: Tim\nHealth card number: 123\n";
		if(! testDoctor.toString().equals(expected) ) {
			errorCount++;
            System.out.println("toString() failed");
        }

		if ( errorCount > 0 ) {
			System.out.println("\nErrors found: " + errorCount);
		}
	}
}

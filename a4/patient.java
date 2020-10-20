/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 4, Question 1
 */

import java.util.*;


/**
 * A model of a Patient who is a Person.
 */
public class Patient extends Person
{
	/**
	 * A label for the bed that the Patient is assigned to.
	 */
	private int bedLabel;

	/**
	 * A list of all of the Patient's doctors.
	 */
	private ArrayList<BasicDoctor> doctors;

	/**
	 * Constructor that initializes a Patient model.
	 */
	public Patient( String patientName, String patientHealthNumber )
	{
		super( patientName, patientHealthNumber );
		this.doctors = new ArrayList<BasicDoctor>();
		this.bedLabel = -1;
	}

	/**
	 * Return the bad label that this patient has been assigned to.
	 * @return int label of the bed.
	 */
	public int getBedLabel()
	{
		return this.bedLabel;
	}

	/**
	 * Set the label of the bed that this patient has been assigned.
	 * @param bedLabel the int label of the bed.
	 */
	public void setBedLabel( int bedLabel )
	{
		this.bedLabel = bedLabel;
	}

	/**
	 * Add a doctor to the list of this Patient's doctors.
	 * @param d the BasicDoctor object to be added.
	 */
	public void addDoctor( BasicDoctor d )
	{
		this.doctors.add( d );
	}

	/**
	 * Remove a doctor from the Patients list.
	 * @param name the name of the doctor to remove.
	 */
	public void removeDoctor( String name )
	{
		for ( BasicDoctor doc : this.doctors ) {
			if ( doc.getName().equals( name ) ) {
				this.doctors.remove( doc );
				return;
			}
		}
	}

	/**
	 * Confirm if a doctor has been assigned to this Patient.
	 * @param name the name of the doctor to check for.
	 */
	public boolean hasDoctor( String name )
	{
		for ( BasicDoctor doc : this.doctors ) {
			if ( doc.getName().equals( name ) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return a pretty String representation of the Patient's state.
	 * @return a String representing the Patient object.
	 */
	public String toString()
	{
		String bedString = "";
		if ( this.bedLabel > 0 ) {
			bedString = "\nBed Label: " + this.bedLabel + "\n";
		}

		String docString = "";
		if (this.doctors.size() > 0) {
			docString = "\nDoctors:";
			for ( BasicDoctor doc : this.doctors ) {
				docString += doc.toString();
			}
		}
		return super.toString() + bedString + docString;
	}

	/**
	 * Test the Patient's attributes and methods.
	 * @param args unused input arguments.
	 */
	public static void main( String[] args )
	{
		// keep track of the number of errors encountered
		int errorCount = 0;

		// instantiate our Patient to test with
		Patient testPatient = new Patient( "Papa John", "306955474" );

		// TEST: bed label default value and getBedLabel()
		if ( testPatient.getBedLabel() != -1 ) {
			errorCount++;
			System.out.println("\nError: getBedLabel() didn't return -1 after instantiation");
		}

		// TEST: setBedLabel()
		int expectedBedLabel = 25;
		testPatient.setBedLabel( expectedBedLabel );
		if ( testPatient.getBedLabel() != expectedBedLabel ) {
			errorCount++;
			System.out.println("\nError: getBedLabel() didn't return 25 after calling getBedLabel(25)");
		}

		// TEST: addDoctor() and hasDoctor()
		String testDoc1Name = "Tom";
		BasicDoctor testDoc1 = new BasicDoctor( testDoc1Name );
		testPatient.addDoctor( testDoc1 );
		if (! testPatient.hasDoctor( testDoc1Name ) ) {
			errorCount++;
			System.out.println("\nError: hasDoctor(testDoc1Name) returned false after calling addDoctor(testDoc1Name)");
		}

		// TEST: addDoctor() and hasDoctor() again, and removeDoctor()
		String testDoc2Name = "Jerry";
		BasicDoctor testDoc2 = new BasicDoctor( testDoc2Name );
		testPatient.addDoctor( testDoc2 );
		if (! testPatient.hasDoctor( testDoc2Name ) ) {
			errorCount++;
			System.out.println("\nError: hasDoctor(testDoc2Name) returned false after calling addDoctor(testDoc2Name)");
		}
		testPatient.removeDoctor( testDoc1Name );
		if ( testPatient.hasDoctor( testDoc1Name ) ) {
			errorCount++;
			System.out.println("\nError: hasDoctor(testDoc1Name) returned true after calling removeDoctor(testDoc1Name)");
		}

		// TEST: toString()
		String expected = "\nName: Papa John\nHealth card number: 306955474\n\nBed Label: 25\n\nDoctors:\nName: Jerry\n";
		if(! testPatient.toString().equals(expected) ) {
			errorCount++;
            System.out.println("toString() failed");
        }

		if ( errorCount > 0 ) {
			System.out.println("\nErrors found: " + errorCount);
		}
	}
}

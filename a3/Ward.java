/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 3, Question 3
 */

public class Ward
{
	/* Attributes */

	/**
	 * the wards's full (space-separated) name
	 */
	private String wardName;

	/**
	 * the label of the ward's first bed
	 */
	private int firstBedLabel;

	/**
	 * the label of the ward's last bed
	 */
	private int lastBedLabel;

	/**
	 * the total number of beds in the ward
	 */
	private int totalBedCount;

	/**
	 * the People within the Ward
	 */
	private Person[] patients;

	/* Constructors */

	/**
	 * Construct a Ward object with a name and first/last bed labels.
	 * @param name full (space-separated) name of the Ward
	 * @param firstLabel integer label of first bed in the Ward
	 * @param lastLabel integer label of last bed in the Ward
	 */
	Ward( String name, int firstLabel, int lastLabel )
	{
		this.wardName = name;
		this.firstBedLabel = firstLabel;
		this.lastBedLabel = lastLabel;
		this.totalBedCount = lastBedLabel - firstBedLabel + 1;
		this.patients = new Person[this.totalBedCount];
	}

	/* Public Methods */

	/**
	 * Represent the Ward object in a pretty human-readable format
	 * @return A String of all of the information contained in the Ward object
	 */
	public String toString()
	{
		return "Ward Name: " + this.wardName +
			 "\nFirst Bed Label: " + this.firstBedLabel +
			 "\nLast Bed Label: " + this.lastBedLabel;
	}

	/**
	 * Get the name of the Ward
	 * @return The name of the Ward as a String
	 */
	public String getWardName()
	{
		return this.wardName;
	}

	/**
	 * Get the label of the first bed
	 * @return The label of the first bed as an int
	 */
	public int getFirstBedLabel()
	{
		return this.firstBedLabel;
	}

	/**
	 * Get the label of the last bed
	 * @return The label of the last bed as an int
	 */
	public int getLastBedLabel()
	{
		return this.lastBedLabel;
	}

	public boolean isBedOccupied( int bedLabel )
	{
		int localIndex = convertBedLabelToIndex( bedLabel );
		if ( this.patients[localIndex] == null )
			return false;
		return true;
	}

	/**
	 * Get the person situated at a specific bed label
	 * @param bedLabel the bed label to get a Person from
	 * @return the Person at the bed. null if bed is empty
	 */
	public Person getPersonAtBed( int bedLabel )
	{
		int localIndex = convertBedLabelToIndex( bedLabel );
		if ( isBedOccupied( bedLabel ) )
			return this.patients[localIndex];
		else
			return null;
	}

	/**
	 * Assign the person at a specific bed label if it's empty
	 * @param patient the Person to assign to the bed
	 * @param bedLabel the bed label to get a Person from
	 * @return true if the Person could be assigned, false otherwise
	 */
	public boolean assignPersonToBed( Person patient, int bedLabel )
	{
		int localIndex = convertBedLabelToIndex( bedLabel );
		if ( isBedOccupied( bedLabel ) ) {
			return false;
		} else {
			this.patients[localIndex] = patient;
			return true;
		}
	}

	/* Private Methods */

	/**
	 * Get the local index of a bed based on its label
	 * @return The local index
	 */
	private int convertBedLabelToIndex( int bedLabel )
	{
		return bedLabel - this.firstBedLabel;
	}

	/**
	 * Get the integer label of a bed based on its local index
	 * @return The local index
	 */
	private int convertIndexToBedLabel( int bedIndex )
	{
		return bedIndex + this.firstBedLabel;
	}

	/* Main */

	/**
	 * Test the Ward class. Output only if errors are detected.
	 * @param args user input; unused
	 */
	static public void main( String[] args )
	{
		// track detected errors
		int errorCount = 0;

		// TEST: Ward with parametrized ( name, firstLabel, lastLabel ) constructor
		Ward testWard_constuctor = new Ward( "Emergency Ward", 0, 100 );
		if ( !( testWard_constuctor.wardName.equals("Emergency Ward") )
				|| ( testWard_constuctor.isBedOccupied(0) )
				|| ( testWard_constuctor.isBedOccupied(100) ) ) {
			System.out.println("TEST [constructor] FAILED");
			errorCount++;
		}

		// TEST: Ward getWardName Method
		Ward testWard_getWardName = new Ward( "Emergency Ward", 26, 75 );
		if ( !( testWard_getWardName.getWardName().equals("Emergency Ward") ) ) {
			System.out.println("TEST [getWardName] FAILED");
			errorCount++;
		}

		// TEST: Ward getFirstBedLabel Method
		Ward testWard_getFirstBedLabel = new Ward( "Fake Ward", 30, 60 );
		if ( !( testWard_getFirstBedLabel.getFirstBedLabel() == 30 ) ) {
			System.out.println("TEST [getFirstBedLabel] FAILED");
			errorCount++;
		}

		// TEST: Ward getLastBedLabel Method
		Ward testWard_getLastBedLabel = new Ward( "Fake Ward", 30, 60 );
		if ( !( testWard_getLastBedLabel.getLastBedLabel() == 60 ) ) {
			System.out.println("TEST [getLastBedLabel] FAILED");
			errorCount++;
		}

		// TEST: Ward isBedOccupied Method
		Ward testWard_isBedOccupied = new Ward( "Fake Ward", 50, 60 );
		if ( !( testWard_isBedOccupied.isBedOccupied( 55 ) == false ) ) {
			System.out.println("TEST [isBedOccupied] FAILED");
			errorCount++;
		}

		// TEST: Ward getPersonAtBed Method
		Ward testWard_getPersonAtBed = new Ward( "Fake Ward", 50, 60 );
		if ( !( testWard_getPersonAtBed.getPersonAtBed( 55 ) == null ) ) {
			System.out.println("TEST [getPersonAtBed] FAILED");
			errorCount++;
		}

		// TEST: Ward assignPersonToBed Method
		Ward testWard_assignPersonToBed = new Ward( "Fake Ward", 100, 200 );
		Person testPerson_assignPersonToBed = new Person( "Tyrel Kostyk", "123456789" );
		if ( !( testWard_assignPersonToBed.assignPersonToBed( testPerson_assignPersonToBed, 100 ) == true ) ) {
			System.out.println("TEST [assignPersonToBed] FAILED");
			errorCount++;
		}

		// TEST: integration test; assignPersonToBed, isBedOccupied, getPersonAtBed
		Ward testWard_assignAndCheck = new Ward( "Big Ward", 1, 2000 );
		Person testPerson_assignAndCheck = new Person( "Tyrel Kostyk", "123456789" );
		// check if bed is empty
		if ( !( testWard_assignAndCheck.isBedOccupied( 1000 ) == false ) ) {
			System.out.println("TEST [assignAndCheck] FAILED");
			errorCount++;
		}
		// assign person to bed
		if ( !( testWard_assignAndCheck.assignPersonToBed( testPerson_assignAndCheck, 1000 ) == true ) ) {
			System.out.println("TEST [assignAndCheck] FAILED");
			errorCount++;
		}
		// check if bed is empty again
		if ( !( testWard_assignAndCheck.isBedOccupied( 1000 ) == true ) ) {
			System.out.println("TEST [assignAndCheck] FAILED");
			errorCount++;
		}
		// get Person from the bed
		if ( !( testWard_assignAndCheck.getPersonAtBed( 1000 ) == testPerson_assignAndCheck ) ) {
			System.out.println("TEST [assignAndCheck] FAILED");
			errorCount++;
		}

		if ( errorCount > 0 ) {
			System.out.println("Ward class Test Failed. Errors Detected: " + errorCount);
		}
	}
}

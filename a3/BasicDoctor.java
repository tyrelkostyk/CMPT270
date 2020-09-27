/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 3, Question 1
 */

public class BasicDoctor
{
	/* Attributes */

	// the BasicDoctor object's full (space-separated) name
	private String fullName;

	/* Constructors */

	/**
	 * Construct BasicDoctor object with no given name.
	 */
	BasicDoctor ()
	{
		this.fullName = "NAME MISSING";
	}

	/**
	 * Construct BasicDoctor object with a given name.
	 * @param name full (space-separated) of the BasicDoctor object
	 */
	BasicDoctor ( String name )
	{
		this.fullName = name;
	}

	/* Methods */

	/**
	 * Represent the BasicDoctor class in a pretty human-readable format
	 * @return The full name of the BasicDoctor object
	 */
	public String toString()
	{
		return "Full Name: " + fullName;
	}

	/**
	 * Set the fullName attribute of the BasicDoctor object
	 * @param newName [description]
	 */
	void setName( String newName )
	{
		this.fullName = newName;
	}

	/**
	 * Get the fullName attribute of the BasicDoctor object
	 * @return the fullName attribute of the BasicDoctor object
	 */
	String getName()
	{
		return this.fullName;
	}

	/**
	 * Test the BasicDoctor class. Output only if errors are detected.
	 * @param args user input; unused
	 */
	static public void main( String[] args )
	{
		int errorCount = 0;

		// TEST 01: test BasicDoctor with default constructor
		BasicDoctor doctorOne = new BasicDoctor();
		if ( !( doctorOne.fullName.equals("NAME MISSING")) ) {
			System.out.println("TEST 01 [default constructor] FAILED");
			errorCount++;
		}

		// TEST 02: test BasicDoctor with parametrized ( String name ) constructor
		BasicDoctor doctorTwo = new BasicDoctor( "Tyler Semantiuk" );
		if ( !( doctorTwo.fullName.equals("Tyler Semantiuk")) ) {
			System.out.println("TEST 02 [parametrized constructor] FAILED");
			errorCount++;
		}

		// TEST 03: test BasicDoctor setName mutator
		BasicDoctor doctorThree = new BasicDoctor( "John Smith" );
		doctorThree.setName( "Jacob Bourne" );
		if ( !( doctorThree.fullName.equals("Jacob Bourne")) ) {
			System.out.println("TEST 03 [setName mutator] FAILED");
			errorCount++;
		}

		// TEST 04: test BasicDoctor getName accessor
		BasicDoctor doctorFour = new BasicDoctor( "William Schnieder" );
		String docFourName = doctorFour.getName();
		if ( !( docFourName.equals("William Schnieder")) ) {
			System.out.println("TEST 04 [getName accessor] FAILED");
			errorCount++;
		}

		// TEST 05: test BasicDoctor toString method
		BasicDoctor doctorFive = new BasicDoctor( "David Beckingham" );
		if ( doctorFive.toString().equals("Full Name: David Beckingham\n") ) {
			System.out.println("TEST 05 [toString method] FAILED");
			System.out.println(doctorFive);
			errorCount++;
		}

		if ( errorCount > 0 ) {
			System.out.println("BasicDoctor Test Failed. Errors Detected: " + errorCount);
		}

	}
}

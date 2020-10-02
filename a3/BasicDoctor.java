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

	/**
	 * the doctor's full (space-separated) name
	 */
	private String fullName;

	/* Constructors */

	/**
	 * Construct BasicDoctor object with a given name.
	 * @param name full (space-separated) name of the doctor
	 */
	BasicDoctor( String name )
	{
		this.fullName = name;
	}

	/* Methods */

	/**
	 * Represent the BasicDoctor object in a pretty human-readable format
	 * @return A String of all of the information contained in the BasicDoctor object
	 */
	public String toString()
	{
		return "Full Name: " + this.fullName;
	}

	/**
	 * Set the fullName attribute of the BasicDoctor object
	 * @param newName the new full (space separated) name of the BasicDoctor object
	 */
	public void setName( String newName )
	{
		this.fullName = newName;
	}

	/**
	 * Get the fullName attribute of the BasicDoctor object
	 * @return the fullName attribute of the BasicDoctor object
	 */
	public String getName()
	{
		return this.fullName;
	}

	/**
	 * Test the BasicDoctor class. Output only if errors are detected.
	 * @param args user input; unused
	 */
	static public void main( String[] args )
	{
		// track detected errors
		int errorCount = 0;

		// TEST: test BasicDoctor with parametrized ( String name ) constructor
		BasicDoctor testBasicDoctor_Constuctor = new BasicDoctor( "Tyler Semantiuk" );
		if ( !( testBasicDoctor_Constuctor.fullName.equals("Tyler Semantiuk")) ) {
			System.out.println("TEST [parametrized constructor] FAILED");
			errorCount++;
		}

		// TEST: test BasicDoctor setName mutator
		BasicDoctor testBasicDoctor_setName = new BasicDoctor( "John Smith" );
		testBasicDoctor_setName.setName( "Jacob Bourne" );
		if ( !( testBasicDoctor_setName.fullName.equals("Jacob Bourne")) ) {
			System.out.println("TEST [setName mutator] FAILED");
			errorCount++;
		}

		// TEST: test BasicDoctor getName accessor
		BasicDoctor testBasicDoctor_getName = new BasicDoctor( "William Schnieder" );
		if ( !( testBasicDoctor_getName.getName().equals("William Schnieder")) ) {
			System.out.println("TEST [getName accessor] FAILED");
			errorCount++;
		}

		// TEST: test BasicDoctor toString method
		BasicDoctor testBasicDoctor_toString = new BasicDoctor( "David Beckingham" );
		if ( !( testBasicDoctor_toString.toString().equals("Full Name: David Beckingham")) ) {
			System.out.println("TEST [toString method] FAILED");
			errorCount++;
		}

		if ( errorCount > 0 ) {
			System.out.println("BasicDoctor Test Failed. Errors Detected: " + errorCount);
		}

	}
}

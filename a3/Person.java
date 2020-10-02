/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 3, Question 2
 */

public class Person
{
	/* Attributes */

	/**
	 * the person's full (space-separated) name
	 */
	private String fullName;

	/**
	 * the person's health card number (no spaces)
	 */
	private String healthCardNumber;

	/* Constructors */

	/**
	 * Construct a Person object with a given name and health card number.
	 * @param name full (space-separated) name of the Person
	 * @param healthCardNum The 9 digit (no spaces) health card number of the Person
	 */
	Person( String name, String healthCardNum )
	{
		this.fullName = name;
		this.healthCardNumber = healthCardNum;
	}

	/* Methods */

	/**
	 * Represent the Person object in a pretty human-readable format
	 * @return A String of all of the information contained in the Person object
	 */
	public String toString()
	{
		return "Full Name: " + this.fullName +
			 "\nHealth Card Number: " + this.healthCardNumber;
	}

	/**
	 * Set the fullName attribute of the Person object
	 * @param newName the new full (space separated) name of the Person object
	 */
	public void setName( String newName )
	{
		this.fullName = newName;
	}

	/**
	 * Get the full name of the person
	 * @return the fullName attribute of the Person object
	 */
	public String getName()
	{
		return this.fullName;
	}

	/**
	 * Get the health card number of the person
	 * @return the fullName attribute of the Person object
	 */
	public String getHealthCardNumber()
	{
		return this.healthCardNumber;
	}

	/**
	 * Test the Person class. Output only if errors are detected.
	 * @param args user input; unused
	 */
	static public void main( String[] args )
	{
		// track detected errors
		int errorCount = 0;

		// TEST: Person with parametrized ( name, healthCardNum ) constructor
		Person testPerson_Constuctor = new Person( "Tyler Semantiuk", "000111222" );
		if ( !( testPerson_Constuctor.fullName.equals("Tyler Semantiuk"))
				|| !( testPerson_Constuctor.healthCardNumber.equals("000111222")) ) {
			System.out.println("TEST [constructor] FAILED");
			errorCount++;
		}

		// TEST: Person setName mutator
		Person testPerson_setName = new Person( "Sarah Jones", "123456789" );
		testPerson_setName.setName( "Jacob Bourne" );
		if ( !( testPerson_setName.fullName.equals("Jacob Bourne")) ) {
			System.out.println("TEST [setName mutator] FAILED");
			errorCount++;
		}

		// TEST: Person getName accessor
		Person testPerson_getName = new Person( "William Schnieder", "123456789" );
		if ( !( testPerson_getName.getName().equals("William Schnieder")) ) {
			System.out.println("TEST [getName accessor] FAILED");
			errorCount++;
		}

		// TEST: Person getHealthCardNumber accessor
		Person testPerson_getHealthCardNumber = new Person( "Bethany Schnieder", "123456789" );
		if ( !( testPerson_getHealthCardNumber.getHealthCardNumber().equals("123456789")) ) {
			System.out.println("TEST [getHealthCardNumber accessor] FAILED");
			errorCount++;
		}

		// TEST: Person toString method
		Person testPerson_toString = new Person( "David Beckingham", "123456789" );
		if ( !( testPerson_toString.toString().equals("Full Name: David Beckingham\nHealth Card Number: 123456789")) ) {
			System.out.println("TEST [toString method] FAILED");
			errorCount++;
		}

		if ( errorCount > 0 ) {
			System.out.println("Person class Test Failed. Errors Detected: " + errorCount);
		}

	}
}

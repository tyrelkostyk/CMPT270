/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 4, Question 3
 */

import java.util.*;


/**
 * A model of a Surgeon.
 */
public class Surgeon extends Doctor
{
	/**
	 * Constructor that initializes a Surgeon model.
	 */
	public Surgeon( String name )
	{
		super( name );
	}

	/**
	 * Return a pretty String representation of the Surgeon's state.
	 * @return a String representing the Surgeon object.
	 */
	public String toString()
	{
		return "\nSurgeon:" + super.toString();
	}

	/**
	 * Test the Surgeon's attributes and methods.
	 * @param args unused input arguments.
	 */
	public static void main( String[] args )
	{
		// keep track of the number of errors encountered
		int errorCount = 0;

		// instantiate our Surgeon to test with
		Surgeon testSurgeon = new Surgeon( "John F Kennedy" );

		// TEST: toString() (and constructor)
		String expected = "\nSurgeon:\nName: John F Kennedy\n";
		if(! testSurgeon.toString().equals(expected) ) {
			errorCount++;
            System.out.println("toString() failed");
        }

		if ( errorCount > 0 ) {
			System.out.println("\nErrors found: " + errorCount);
		}
	}

}

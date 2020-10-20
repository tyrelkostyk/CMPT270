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
		this.name = patientName;
		this.healthNum = patientHealthNumber;
		this.doctors = new ArrayList<BasicDoctor>();
		this.bedLabel = -1;
	}

	public int getBedLabel()
	{
		return this.bedLabel;
	}

	public void setBedLabel( int bedLabel )
	{
		this.bedLabel = bedLabel;
	}

	public void addDoctor( BasicDoctor d )
	{
		this.doctors.add( d );
	}

	public void removeDoctor( String name )
	{
		for ( BasicDoctor doc : this.doctors ) {
			if ( doc.getName().equals( name ) ) {
				this.doctors.remove( doc );
				return;
			}
		}
	}

	public boolean hasDoctor( String name )
	{
		for ( BasicDoctor doc : this.doctors ) {
			if ( doc.getName().equals( name ) ) {
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		String bedString = "";
		if ( this.bedLabel > 0 ) {
			bedString = "\nBed Label: " + this.bedLabel;
		}
		return super.toString + bedString;
	}

	public static void main( String[] args )
	{
		Patient testPatient = new Patient( "Ty Kostyk", "123456789" );
		testPatient.setBedLabel( "25" );
	}
}

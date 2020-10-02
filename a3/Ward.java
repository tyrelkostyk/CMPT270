/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 3, Question 3
 */

import Person.Class;

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
	 * the People within the Ward
	 */
	private People[] patients;

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
		if ( this.patients[localIndex] == 0 )
			return false;
		return true;
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
	 * Test the Person class. Output only if errors are detected.
	 * @param args user input; unused
	 */
	static public void main( String[] args )
	{

	}
}

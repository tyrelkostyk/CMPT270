/**
 * Tyrel Kostyk
 * tck290
 * 11216033
 *
 * CMPT 270
 * Assignment 2, Question 1
 */

import java.util.Scanner;


/**
 * Displays (to console ) the amount of space in GB and percentage of
 * space that major file types occupy on the hard drive as well as the
 * amount of space free / available for use.
 *
 * @param	capacity		Capacity of the hard drive in GB
 * @param	media			Amount of GB occupied by multimedia files on hard drive
 * @param	documents		Amount of GB occupied by document files on hard drive
 * @param	applications	Amount of GB occupied by applications on hard drive
 */
public class a2q1
{
	static public void print_disk_quota( double capacity, double applications, double documents, double media )
	{
		/* calculate percentage of space occupied by certain file types */

		// percentage of hard drive space occupied by multimedia files
		double media_percent = ( media / capacity ) * 100.0;

		// percentage of hard drive space occupied by document files
		double documents_percent = ( documents / capacity ) * 100.0;

		// percentage of hard drive space occupied by applications
		double applications_percent = ( applications / capacity ) * 100.0;

		// percentage of hard drive space available
		double free_percent = ( ( capacity - ( media + documents + applications ) )
			/ capacity ) * 100.0;

		System.out.println("You have " + free_percent + "% of " + capacity + " GB free.");
		System.out.println(applications_percent + "% of hard drive space (" + applications + " GB) is occupied by applications.");
		System.out.println(documents_percent + "% of hard drive space (" + documents + " GB) is occupied by documents.");
		System.out.println(media_percent + "% of hard drive space (" + media + " GB) is occupied by multimedia files.");
	}

	/**
	 * Calculate the time required by Zeno’s drive to travel a given distance
	 *
	 * @param	dist	The distance to travel in meters
	 * @return			The number of minutes to travel dist meters
	 */
	static public int spaceTime( double dist )
	{
		if ( dist <= 1.0 )
			return 1;
		else
			return 1 + spaceTime( dist / 2.0 );
	}

	static public void introductions( String greeting )
	{
		System.out.println( greeting );

		Scanner in = new Scanner( System.in );

		String fname, lname;
		System.out.print("Please enter your first name: ");
		fname = in.next();
		System.out.print("Please enter your last name: ");
		lname = in.next();

		System.out.println("Hello, " + fname.substring(1) + lname.charAt( 0 ) + "ay " + lname.substring(1) + fname.charAt( 0 ) + "ay");
		return;
	}

	static public void main( String[] args )
	{
		// test a) functionality
		print_disk_quota( 2048.0, 321.0, 46.0, 899.0 );

		// test b) functionality
		System.out.println("Zeno's drive requires " + spaceTime( 384000000.0 ) + " minutes to travel 384000000.0 meters");

		// test c) functionality
		introductions("Welcome to tuxworld!");
	}
}

/*
Tyrel Kostyk
tck290
11216033

CMPT270
Assignment 2, Question 1
 */

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
	static public void print_disk_quota( int capacity, int media, int documents, int applications )
	{
		/* calculate percentage of space occupied by certain file types */

		// percentage of hard drive space occupied by multimedia files
		double media_percent = ( (double)media / (double)capacity ) * 100.0;

		// percentage of hard drive space occupied by document files
		double documents_percent = ( (double)documents / (double)capacity ) * 100.0;

		// percentage of hard drive space occupied by applications
		double applications_percent = ( (double)applications / (double)capacity ) * 100.0;

		// percentage of hard drive space available
		double free_percent = ( (double)( capacity - ( media + documents + applications ) )
			/ (double)capacity ) * 100.0;

	}
}

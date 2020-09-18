/*
Tyrel Kostyk
tck290
11216033

CMPT270
Assignment 1, Question 3
*/

import java.lang.Math;
import java.util.Scanner;

public class a1q3
{
    public static void main( String[] args )
	{
		// ask for the initial height
		Scanner in = new Scanner( System.in );
		System.out.print("Starting height: ");
		int height = in.nextInt();
		// ensure height is positive
		if (height < 0) {
			System.out.println("Error: Input must be positive");
			return;
		}

		int maxHeight = height;

		// initiate loop variables
		int jumps = 0;
		int streak = 1;
		int maxStreak = 1;
		boolean increasing = false;

		// loop until height is back to 1
		while ( height != 1 ) {
			// increment jump counter
			jumps++;

			// if even, cut height in half
			if ( ( height % 2 ) == 0 ) {
				height = height / 2;
				// increase or reset streak
				if ( increasing == false ) {
					streak++;
				} else {
					increasing = false;
					streak = 1;
				}

			// if odd, triple height and add one
			} else {
				height = ( 3 * height ) + 1;
				// increase or reset streak
				if ( increasing == true ) {
					streak++;
				} else {
					increasing = true;
					streak = 1;
				}
			}

			// update max values
			maxStreak = Math.max( streak, maxStreak );
			maxHeight = Math.max( height, maxHeight );
		}

		// output results of jump
		System.out.println("Number of jumps: " + jumps);
		System.out.println("Maximum Height: " + maxHeight);
		System.out.println("Maximum Streaks: " + maxStreak);
	}
}

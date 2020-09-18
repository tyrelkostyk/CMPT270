/*
  CMPT 270 Course material
  Copyright (c) 2020
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to a person
  not registered in CMPT 270, constitutes Academic Misconduct, according
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis:
     Starting file for Assignment 1 Question 2
 */

 /*
 Tyrel Kostyk
 tck290
 11216033

 CMPT270
 Assignment 1, Question 1
  */

import java.util.Scanner;

public class a1q2
{
    // some constants to make the program easier to understand
    final static int ROCK = 1;
    final static int PAPER = 2;
    final static int SCISSORS = 3;
    final static int LIZARD = 4;
    final static int SPOCK = 5;


    public static void main( String[] args )
	{
        // ask for the moves
        int player1, player2;
        Scanner in = new Scanner( System.in );

        System.out.print("Enter move for player 1: ");
        player1 = in.nextInt();
        System.out.println("Player 1 chose: " + player1);

        System.out.print("Enter move for player 2: ");
        player2 = in.nextInt();
        System.out.println("Player 2 chose: " + player2);

        /* Determine the outcome */

		// check if player1 won
		if ( ( player1 == SCISSORS && player2 == PAPER ) ||
				( player1 == SCISSORS && player2 == LIZARD ) ||
				( player1 == PAPER && player2 == ROCK ) ||
				( player1 == PAPER && player2 == SPOCK ) ||
				( player1 == ROCK && player2 == LIZARD ) ||
				( player1 == ROCK && player2 == SCISSORS ) ||
				( player1 == LIZARD && player2 == SPOCK ) ||
				( player1 == LIZARD && player2 == PAPER ) ||
				( player1 == SPOCK && player2 == SCISSORS ) ||
				( player1 == SPOCK && player2 == ROCK ) )
		{
			System.out.println("Player1 won!");
		}

		// check for a draw
		else if ( player1 == player2 )
		{
			System.out.println("Draw!");
		}

		// otherwise, player2 won
		else
		{
			System.out.println("Player2 won!");
		}
    }
}

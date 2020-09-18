/*
Tyrel Kostyk
tck290
11216033

CMPT270
Assignment 1, Question 1
 */

public class a1q1
{
	public static void main( String[] args )
	{
		// student's full name
		String studentFullName = "Reptilious McFictitious";


		/* Calculate the grades from the exercises */

		// total weight of the exercises
		double exerciseWeight = 0.20;

		// exercise one
		double excerciseOneGrade = 100.0;
		// exercise two
		double excerciseTwoGrade = 50.0;
		// exercise three
		double excerciseThreeGrade = 50.0;
		// exercise four
		double excerciseFourGrade = 50.0;
		// exercise five
		double excerciseFiveGrade = 50.0;
		// exercise six
		double excerciseSixGrade = 50.0;
		// exercise seven
		double excerciseSevenGrade = 50.0;
		// exercise eight
		double excerciseEightGrade = 50.0;
		// exercise nine
		double excerciseNineGrade = 50.0;
		// exercise ten
		double excerciseTenGrade = 50.0;

		// calculate total grade contribution from exercises
		double exerciseGradeContribution = ( exerciseWeight * ( (
			excerciseOneGrade +
			excerciseTwoGrade +
			excerciseThreeGrade +
			excerciseFourGrade +
			excerciseFiveGrade +
			excerciseSixGrade +
			excerciseSevenGrade +
			excerciseEightGrade +
			excerciseNineGrade +
			excerciseTenGrade ) / 10.0 ) );


		/* Calculate the grades from the assignments */

		// total weight of the assignments
		double assignmentWeight = 0.35;

		// assignment one
		int assignmentOneScore = 33;
		int assignmentOneTotal = 33;
		double assignmentOneGrade = 100.0 * ( (double)assignmentOneScore / (double)assignmentOneTotal );

		// assignment two
		int assignmentTwoScore = 20;
		int assignmentTwoTotal = 40;
		double assignmentTwoGrade = 100.0 * ( (double)assignmentTwoScore /  (double)assignmentTwoTotal );

		// assignment three
		int assignmentThreeScore = 20;
		int assignmentThreeTotal = 40;
		double assignmentThreeGrade = 100.0 * ( (double)assignmentThreeScore / (double)assignmentThreeTotal );

		// assignment four
		int assignmentFourScore = 20;
		int assignmentFourTotal = 40;
		double assignmentFourGrade = 100.0 * ( (double)assignmentFourScore / (double)assignmentFourTotal );

		// assignment five
		int assignmentFiveScore = 20;
		int assignmentFiveTotal = 40;
		double assignmentFiveGrade = 100.0 * ( (double)assignmentFiveScore / (double)assignmentFiveTotal );

		// assignment six
		int assignmentSixScore = 20;
		int assignmentSixTotal = 40;
		double assignmentSixGrade = 100.0 * ( (double)assignmentSixScore / (double)assignmentSixTotal );

		// assignment seven
		int assignmentSevenScore = 20;
		int assignmentSevenTotal = 40;
		double assignmentSevenGrade = 100.0 * ( (double)assignmentSevenScore / (double)assignmentSevenTotal );

		// calculate total grade contribution from assignments
		double assignmentGradeContribution = ( assignmentWeight * ( (
			assignmentOneGrade +
			assignmentTwoGrade +
			assignmentThreeGrade +
			assignmentFourGrade +
			assignmentFiveGrade +
			assignmentSixGrade +
			assignmentSevenGrade ) / 7.0 ) );


		/* Calculate the grades from the midterm exam */

		// total weight of the midterm exam
		double midtermExamWeight = 0.20;
		// midterm exam grade
		double midtermExamGrade = 100.0;
		// calculate total grade contribution from the midterm exam
		double midtermExamGradeContribution = ( midtermExamWeight * midtermExamGrade );


		/* Calculate the grades from the final exam */

		// total weight of the final exam
		double finalExamWeight = 0.25;
		// final exam grade
		double finalExamGrade = 100.0;
		// calculate total grade contribution from the final exam
		double finalExamGradeContribution = ( finalExamWeight * finalExamGrade );


		/* Calculate the final grade as an integer */
		int cmpt270FinalGrade = (int)( exerciseGradeContribution +
			assignmentGradeContribution +
			midtermExamGradeContribution +
			finalExamGradeContribution );

		/* Print out the final grade */
		System.out.println(studentFullName + "'s Final Grade for CMPT 270: " + cmpt270FinalGrade + "%");
	}
}

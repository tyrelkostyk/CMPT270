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
		String studentFullName = "Reptilious McFictitious";

		/* Calculate the grades from the exercises */
		double exerciseWeight = 0.20;

		double excerciseOneGrade = 100.0;
		double excerciseTwoGrade = 50.0;
		double excerciseThreeGrade = 50.0;
		double excerciseFourGrade = 50.0;
		double excerciseFiveGrade = 50.0;
		double excerciseSixGrade = 50.0;
		double excerciseSevenGrade = 50.0;
		double excerciseEightGrade = 50.0;
		double excerciseNineGrade = 50.0;
		double excerciseTenGrade = 50.0;

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
		double assignmentWeight = 0.35;

		int assignmentOneScore = 33;
		int assignmentOneTotal = 33;
		double assignmentOneGrade = 100.0 * ( (double)assignmentOneScore / (double)assignmentOneTotal );

		int assignmentTwoScore = 20;
		int assignmentTwoTotal = 40;
		double assignmentTwoGrade = 100.0 * ( (double)assignmentTwoScore /  (double)assignmentTwoTotal );

		int assignmentThreeScore = 20;
		int assignmentThreeTotal = 40;
		double assignmentThreeGrade = 100.0 * ( (double)assignmentThreeScore / (double)assignmentThreeTotal );

		int assignmentFourScore = 20;
		int assignmentFourTotal = 40;
		double assignmentFourGrade = 100.0 * ( (double)assignmentFourScore / (double)assignmentFourTotal );

		int assignmentFiveScore = 20;
		int assignmentFiveTotal = 40;
		double assignmentFiveGrade = 100.0 * ( (double)assignmentFiveScore / (double)assignmentFiveTotal );

		int assignmentSixScore = 20;
		int assignmentSixTotal = 40;
		double assignmentSixGrade = 100.0 * ( (double)assignmentSixScore / (double)assignmentSixTotal );

		int assignmentSevenScore = 20;
		int assignmentSevenTotal = 40;
		double assignmentSevenGrade = 100.0 * ( (double)assignmentSevenScore / (double)assignmentSevenTotal );

		double assignmentGradeContribution = ( assignmentWeight * ( (
			assignmentOneGrade +
			assignmentTwoGrade +
			assignmentThreeGrade +
			assignmentFourGrade +
			assignmentFiveGrade +
			assignmentSixGrade +
			assignmentSevenGrade ) / 7.0 ) );


		/* Calculate the grades from the midterm exam */
		double midtermExamWeight = 0.20;
		double midtermExamGrade = 100.0;
		double midtermExamGradeContribution = ( midtermExamWeight * midtermExamGrade );


		/* Calculate the grades from the final exam */
		double finalExamWeight = 0.25;
		double finalExamGrade = 100.0;
		double finalExamGradeContribution = ( finalExamWeight * finalExamGrade );


		/* Calculate the final grade as a percentage */
		int cmpt270FinalGrade = (int)( exerciseGradeContribution +
			assignmentGradeContribution +
			midtermExamGradeContribution +
			finalExamGradeContribution );

		System.out.println(studentFullName + "'s Final Grade for CMPT 270: " + cmpt270FinalGrade + "%");
	}
}

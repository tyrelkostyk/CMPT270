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
     Starter File for Assignment 4
 */

import java.util.*;


/**
 * A ward of a hospital with a specified number of beds with consecutive labels.
 */
public class Ward
{
    /**
     * The name of this ward.
     */
    private String name;

    /**
     * The (external) label of the first bed of the ward.
     */
    private int minBedLabel;

    /**
     * An array to represent the beds of the ward.  Each bed is empty (null)
     * or else has a Patient in it.
     */
    private Patient[] beds;

    /**
     * Initialize the ward with the name given, and with beds those labels are
     * the consecutive integers from minBedLabel to maxBedLabel.
     * @param wName    the name of the ward
     * @param wMinBedLabel the label of the first bed in the ward
     * @param wMaxBedLabel the label of the last bed in the ward
     * @precond wName != null && !wName.equals("") && wMinBedLabel >= 0 && wMaxBedLabel >= wMinBedLabel
     */
    public Ward(String wName, int wMinBedLabel, int wMaxBedLabel)
    {
        if (wName == null || wName.equals(""))
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + wName);
        if (wMinBedLabel < 0 || wMaxBedLabel < wMinBedLabel)
            throw new IllegalArgumentException("The bed labels " + wMinBedLabel + " and " + wMaxBedLabel
                    + " are invalid as they cannot be negative, and must have at least one bed.");

        name = wName;
        minBedLabel = wMinBedLabel;
        beds = new Patient[wMaxBedLabel - wMinBedLabel + 1];
    }

    /**
     * Return the name of this ward.
     * @return  the name of this ward
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the smallest label for a bed on the ward.
     * @return  the smallest Label for a bed on the ward
     */
    public int getMinBedLabel()
    {
        return minBedLabel;
    }

    /**
     * Return the largest label for a bed on the ward.
     * @return  the largest label for a bed on the ward
     */
    public int getMaxBedLabel()
    {
        return minBedLabel + beds.length - 1;
    }

    /**
     * Return the internal/array index of the bed corresponding to the external label.
     * @param bedLabel the label of a bed from the external/user perspective
     * @precond isValidLabel(bedLabel)
     * @return the internal/array index of the bed corresponding to the external label
     */
    private int externalToInternalIndex(int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the ward.");

        return bedLabel - minBedLabel;
    }

    /**
     * Return the external/user label of the bed corresponding to the internal index.
     * @param arrayIndex the index of a location in the beds array
     * @precond 0 <= arrayIndex < beds.length
     * @return the external/user label of the bed corresponding to the internal index
     */
    private int internalToExternalLabel(int arrayIndex)
    {
        if (arrayIndex < 0 || arrayIndex >= beds.length)
            throw new IllegalArgumentException("The value " + arrayIndex +
                    " is not a valid index for an array of length " + beds.length + ".");

        return arrayIndex + minBedLabel;
    }

    /**
     * Is the specified bed occupied?
     * @param bedLabel  the label of the bed to be tested for being occupied
     * @precond isValidLabel(bedLabel)
     * @return  is the specified bed occupied?
     */
    public boolean isOccupied(int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the ward.");

        return beds[externalToInternalIndex(bedLabel)] != null;
    }

    /**
     * Return the patient in the specified bed.
     * @param bedLabel  the label of the bed that has the patient to be retrieved
     * @precond isValidLabel(bedLabel) && isOccupied(bedLabel)
     * @return  the patient in the specified bed
     */
    public Patient getPatient(int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the ward.");

        if (! isOccupied(bedLabel))
            throw new IllegalStateException("Bed " + bedLabel + " is not currently occupied"
                    + " so cannot get its patient");
        return beds[externalToInternalIndex(bedLabel)];
    }

    /**
     * Assign the specified patient to the specified bed.
     * @param p  the patient to be assigned a bed
     * @param bedLabel  the label of the bed that the patient is to be assigned
     * @precond  isValidLabel(bedLabel) && !isOccupied(bedLabel)
     */
    public void assignPatientToBed(Patient p, int bedLabel)
    {
        if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the ward.");

        if (isOccupied(bedLabel))
            throw new IllegalStateException("Bed " + bedLabel + " is currently occupied by "
                    + beds[externalToInternalIndex(bedLabel)]
                    + " so cannot be assigned to another patient");

        beds[externalToInternalIndex(bedLabel)] = p;
    }

	/**
     * Return a list of available bed labels.
     * @return ArrayList<Integer> of bed labels.
     */
	public ArrayList<Integer> availableBeds()
	{
		ArrayList<Integer> availableBeds = new ArrayList<Integer>();
		int maxBedLabel = this.getMaxBedLabel();
		for ( int label = minBedLabel; label<=maxBedLabel; label++ ) {
			if ( this.isOccupied( label ) ) {
				availableBeds.add( label );
			}
		}
		return availableBeds;
	}

	/**
     * Remove a patient from a bed.
	 * @param bedLabel  the label of the bed that the patient is to be assigned
     */
	public void freeBed( int bedLabel )
	{
		if (! isValidLabel(bedLabel))
            throw new IllegalArgumentException("The value " + bedLabel
                    + " is not a valid label for a bed in the ward.");

		this.beds[bedLabel] = null;
	}

    /**
     * Return a String representation of the properties of the ward.
     * @return a String representation of the properties of the ward
     */
    public String toString()
    {
        String result = "\nWard " + name + " with capacity " + beds.length
                + " has the following patients: ";
        for (int i = 0; i < beds.length; i++)
        {
            result = result + "\nbed " + internalToExternalLabel(i) + ": ";
            if (beds[i] != null)
                result = result + beds[i].getName();
        }
        return result + "\n";
    }


    /**
     * Is bedLabel a valid external label for a bed?
     * @param bedLabel  an int to be tested to determined whether it is a valid label
     *             for a bed (from the external/user perspective)
     * @return  is bedLabel a valid external label for a bed?
     *
     * This is a helper method for testing pre-conditions students were not required to implement it
     */
    public boolean isValidLabel(int bedLabel)
    {
        return bedLabel >= minBedLabel && bedLabel <= minBedLabel + beds.length - 1;
    }


    /**
     * A method to test the class.
     * @param args  not used
     */
    public static void main(String[] args)
    {
        int numErrors = 0;

        // testing all the methods with one instance of a Ward
        Ward w = new Ward("surgery", 200, 210);

        if(!w.getName().equals("surgery")) {
            System.out.println("The constructor or getName failed.");
            numErrors++;
        }

        if(w.getMinBedLabel() != 200) {
            System.out.println("The constructor or getMinBedLabel failed.");
            numErrors++;
        }

        if(w.getMaxBedLabel() != 210) {
            System.out.println("The constructor or getMaxBedLabel failed.");
            numErrors++;
        }


        if(!w.isValidLabel(200) || !w.isValidLabel(201)
                || !w.isValidLabel(210) || !w.isValidLabel(209)
                ||  w.isValidLabel(199)
                ||  w.isValidLabel(211)) {
            System.out.println("isValidLabel failed.");
            numErrors++;
        }

        if(w.internalToExternalLabel(w.externalToInternalIndex(200)) != 200
                || w.internalToExternalLabel(w.externalToInternalIndex(210)) != 210
                || w.internalToExternalLabel(w.externalToInternalIndex(205)) != 205) {
            System.out.println("internalToExternalLabel failed.");
            numErrors++;
        }

        if(w.externalToInternalIndex(w.internalToExternalLabel(0)) != 0
                || w.externalToInternalIndex(w.internalToExternalLabel(w.beds.length-1)) != w.beds.length-1
                || w.externalToInternalIndex(w.internalToExternalLabel(w.beds.length/2)) != w.beds.length/2) {
            System.out.println("externalToInternalIndex failed.");
            numErrors++;
        }

        if (w.externalToInternalIndex(200) != 0) {
            System.out.println("Minimum external label was not converted to 0.");
            numErrors++;
        }
        if (w.externalToInternalIndex(210) != w.beds.length-1) {
            System.out.println("Maximum external label was not converted "
                    + "to last location of the array.");
            numErrors++;
        }
        if (w.internalToExternalLabel(0) != 200) {
            System.out.println("Minimum internal index was not converted to first bed label.");
            numErrors++;
        }
        if (w.internalToExternalLabel(w.beds.length-1) != 210) {
            System.out.println("Maximum internal index was not converted "
                    + "to last bed label.");
            numErrors++;
        }

        if (w.isOccupied(205)) {
            System.out.println("Function isOccupied incorrectly returns that bed 205 is occupied.");
            numErrors++;
        }

        Patient p = new Patient("Pete", "123456");
        w.assignPatientToBed(p, 205);
        if (! w.isOccupied(205)) {
            System.out.println("assignPatientToBed() or isOccupied() failed: isOccupied incorrectly returns that bed 205 is not occupied.");
            numErrors++;
        }
        if (w.getPatient(205) != p) {
            System.out.println("getPatient() or isOccupied() failed: Patient Pete should be in bed 205, but " + w.getPatient(205) + " is.");
            numErrors++;
        }
        if (! w.getPatient(205).getName().equals("Pete")) {
            System.out.println("getPatient() or isOccupied() failed: Pete should be in bed 205, but " + w.getPatient(205) + " is.");
            numErrors++;
        }


        String expected = "\nWard surgery with capacity 11 has the following patients: \n" +
                "bed 200: \n" +
                "bed 201: \n" +
                "bed 202: \n" +
                "bed 203: \n" +
                "bed 204: \n" +
                "bed 205: Pete\n" +
                "bed 206: \n" +
                "bed 207: \n" +
                "bed 208: \n" +
                "bed 209: \n" +
                "bed 210: \n";
        if(!w.toString().equals(expected)) {
            System.out.println("Error in toString() method. Expected: " + expected + "But returned: " + w);
            numErrors++;
        }


        // retest all the methods on a second instance of the class
        w = new Ward("ER", 1, 3);

        if(!w.getName().equals("ER")) {
            System.out.println("The constructor or getName failed.");
            numErrors++;
        }

        if(w.getMinBedLabel() != 1) {
            System.out.println("The constructor or getMinBedLabel failed.");
            numErrors++;
        }

        if(w.getMaxBedLabel() != 3) {
            System.out.println("The constructor or getMaxBedLabel failed.");
            numErrors++;
        }


        if(!w.isValidLabel(1) || !w.isValidLabel(2)
                || !w.isValidLabel(3)
                ||  w.isValidLabel(0)
                ||  w.isValidLabel(4)) {
            System.out.println("isValidLabel failed.");
            numErrors++;
        }

        if(w.internalToExternalLabel(w.externalToInternalIndex(1)) != 1
                || w.internalToExternalLabel(w.externalToInternalIndex(2)) != 2
                || w.internalToExternalLabel(w.externalToInternalIndex(3)) != 3) {
            System.out.println("internalToExternalLabel failed.");
            numErrors++;
        }

        if(w.externalToInternalIndex(w.internalToExternalLabel(0)) != 0
                || w.externalToInternalIndex(w.internalToExternalLabel(w.beds.length-1)) != w.beds.length-1
                || w.externalToInternalIndex(w.internalToExternalLabel(w.beds.length/2)) != w.beds.length/2) {
            System.out.println("externalToInternalIndex failed.");
            numErrors++;
        }

        if (w.externalToInternalIndex(1) != 0) {
            System.out.println("Minimum external label was not converted to 0.");
            numErrors++;
        }
        if (w.externalToInternalIndex(3) != w.beds.length-1) {
            System.out.println("Maximum external label was not converted "
                    + "to last location of the array.");
            numErrors++;
        }
        if (w.internalToExternalLabel(0) != 1) {
            System.out.println("Minimum internal index was not converted to first bed label.");
            numErrors++;
        }
        if (w.internalToExternalLabel(w.beds.length-1) != 3) {
            System.out.println("Maximum internal index was not converted "
                    + "to last bed label.");
            numErrors++;
        }

        if (w.isOccupied(2)) {
            System.out.println("Function isOccupied incorrectly returns that bed 2 is occupied.");
            numErrors++;
        }

        p = new Patient("Dan", "789456");
        w.assignPatientToBed(p, 1);
        if (! w.isOccupied(1)) {
            System.out.println("assignPatientToBed() or isOccupied() failed: isOccupied incorrectly returns that bed 1 is not occupied.");
            numErrors++;
        }
        if (w.getPatient(1) != p) {
            System.out.println("getPatient() or isOccupied() failed: Patient Dan should be in bed 1, but " + w.getPatient(1) + " is.");
            numErrors++;
        }

        System.out.println("The number of errors found is " + numErrors);
    }
}

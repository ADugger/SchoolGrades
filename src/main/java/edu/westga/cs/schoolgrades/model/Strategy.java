package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Interface for a compositegrade strategy to calculate a grade
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public interface Strategy {

	/**
	 * Method by which a grade will be calculated from an ArrayList of grades
	 * @param grades the list of grades to perform calculations on
	 */
	public double calculateGrade(ArrayList<Double> grades);
}

package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * CompositeGrade class to store a list of grades values and strategy for calculating a grade value from the list
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class CompositeGrade {

	private ArrayList<Double> listOfGrades;
	
	/**
	 * Constructor to initialize the grade value list	 
	 */
	public CompositeGrade() {
		listOfGrades = new ArrayList<Double>();
	}
	
	/**
	 * Method to return a clone of the arraylist of grades or null if arraylist is empty 
	 * @return null or an arraylist of grades as double values
	 */
	public ArrayList<Double> getListOfGrades() {
		if (this.listOfGrades.isEmpty()) {
			return null;
		} else {
			return (ArrayList<Double>) this.listOfGrades.clone();
		}
	}
}

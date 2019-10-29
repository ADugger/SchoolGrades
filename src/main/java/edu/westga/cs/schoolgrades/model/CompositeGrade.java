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
	
	/**
	 * Method to add a provided grade to list of grades to create the composite grade collection
	 * @param newGrade the grade to add to the list
	 * @requires newGrade >= 0
	 */
	public void addGrade(double newGrade) {
		if (newGrade < 0) {
			throw new IllegalArgumentException("A grade must have a value of at least 0 to be added.");
		}
		this.listOfGrades.add(newGrade);
	}
	
	/**
	 * Method to remove the grade at a particular index
	 * @param index the index of the grade to remove
	 */
	public void removeGradeByIndex(int index) {
		if (this.listOfGrades.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("The arraylist is already empty so there is nothing to remove.");
		}
		if (index < 0 || index > this.listOfGrades.size() - 1) {
			throw new ArrayIndexOutOfBoundsException("The index provided is out of bounds of the grades arraylist.");
		}
		this.listOfGrades.remove(index);
	}
}

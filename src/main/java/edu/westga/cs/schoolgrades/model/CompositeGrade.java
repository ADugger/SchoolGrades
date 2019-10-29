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

	private Strategy strategy;
	private ArrayList<Double> listOfGrades;
	
	/**
	 * Constructor to initialize the grade value list and set the default strategy to avggrade strategy	 
	 */
	public CompositeGrade() {
		this.listOfGrades = new ArrayList<Double>();
		this.strategy = new AvgGrades();
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
	
	/**
	 * Method to remove the first entry of a particular grade
	 * @param value the grade to seek within the array
	 * @requires the grade must exist within the array or an exception is thrown
	 */
	public void removeGradeByValue(double value) {
		boolean foundValue = false;
		int index;
		
		for (index = 0; index < this.listOfGrades.size(); index++) {
			if (this.listOfGrades.get(index) == value) {
				foundValue = true;
				break;
			}
		}
		
		if (!foundValue) {
			throw new IllegalArgumentException("The grade attempted to remove was not found within the array.");
		} else {
			this.listOfGrades.remove(index);
		}		
	}
	
	/**
	 * Method that utilizes the set strategy's calculateGrade method to determine the grade value
	 * @return double a value that represents the calculated grade value
	 * @requires at least one grade must exist in the arraylist of grades
	 */
	public double getValue() {
		if (this.listOfGrades.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("The arraylist is empty so there is nothing to calculate.");
		}
		return this.strategy.calculateGrade(this.listOfGrades);
	}
}

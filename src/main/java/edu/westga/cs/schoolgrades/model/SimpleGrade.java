package edu.westga.cs.schoolgrades.model;

/**
 * A simple grade item that is just a numerical value.
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class SimpleGrade implements Grade {

	private double value;
	
	/**
	 * Constructor to create the grade with the initially passed value.
	 * 
	 * @param theGrade the double value representing the grade initial value
	 */
	public SimpleGrade (double theGrade) {
		this.value = theGrade;
	}
	
	/**
	 * Required method to implement Grade interface, returns the value of the grade
	 * @return double value representing grade
	 */
	public double getValue() {
		return this.value;
	}
}

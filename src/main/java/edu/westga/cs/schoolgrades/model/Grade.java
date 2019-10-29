package edu.westga.cs.schoolgrades.model;

/**
 * 
 * Interface grades will implement that guarantees method to retrieve grade value
 * 
 * @version 10/29/2019 
 * @author Alan Dugger
 *
 */
public interface Grade {
	
	/**
	 * Required method that returns the value of the grade
	 * @return a double representing the grade value
	 */
	public double getValue();
}

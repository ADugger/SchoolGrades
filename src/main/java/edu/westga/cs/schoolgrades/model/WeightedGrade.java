/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

/**
 * A grade object that also stores a weight value for the grade
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class WeightedGrade implements Grade {

	private double value;
	private double weight;
	
	/**
	 * Constructor to initialize the grade value and initally set the default weight to 1.0
	 * @param theGrade the unweighted grade value
	 */
	public WeightedGrade(double theGrade) {
		if (theGrade < 0) {
			throw new IllegalArgumentException("Initial grade should be 0 or greater.");
		}
		this.value = theGrade;
		this.weight = 1.0;
	}
	
	/**
	 * Returns the currently set weight value for the grade
	 * @return double representing the weight value
	 */
	public double getWeight() {
		return this.weight;
	}
	
	/**
	 * Required for impelmenting Grade interface, returns value of grade
	 */
	public double getValue() {
		return 0;
	}
	
}

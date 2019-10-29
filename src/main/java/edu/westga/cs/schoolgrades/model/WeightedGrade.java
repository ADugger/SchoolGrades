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
	 * Overloaded constructor to initialize the grade value and set the weight to a provided weight
	 * @param theGrade the unweighted grade value
	 * @param weight the desired default weight value
	 */
	public WeightedGrade(double theGrade, double weight) {
		if (theGrade < 0) {
			throw new IllegalArgumentException("Initial grade should be 0 or greater.");
		}
		if (weight < 0 || weight > 1.0) {
			throw new IllegalArgumentException("Weight for grade should be between 0 and 1.0.");
		}
		this.value = theGrade;
		this.weight = weight;
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

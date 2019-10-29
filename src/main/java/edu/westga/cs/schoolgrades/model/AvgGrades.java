package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * A strategy by which calculating grades is performed by averaging the grade values
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 */
public class AvgGrades implements Strategy {
	
	/**
	 * Required method to implement strategy, returns an average value of all grades
	 * @return double the value representing the calculated grade
	 */
	public double calculateGrade(ArrayList<Double> grades) {
		if (grades.isEmpty()) {
			return 0;
		} else {
			double totalValue = 0;			
			for (int index = 0; index < grades.size(); index++) {
				totalValue += grades.get(index);				
			}
			return (double) (totalValue / grades.size());
		}
	}
}

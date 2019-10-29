package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * A strategy by which calculating grades is performed by summing the grade values
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 */
public class SumGrades implements Strategy {
	
	/**
	 * Required method to implement strategy, returns a summed value of all grades
	 * @return double the value representing the calculated grade
	 */
	public double calculateGrade(ArrayList<Double> grades) {
		if (grades.isEmpty()) {
			return 0;
		} else {
			int totalValue = 0;
			for (int index = 0; index < grades.size() - 1; index++) {
				totalValue += grades.get(index);
			}
			return totalValue;
		}
	}
}

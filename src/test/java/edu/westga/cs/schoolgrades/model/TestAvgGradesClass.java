package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Junit test cases to ensure avggrades strategy returns the appropriate values
 * 
 * @version 10/29/2010
 * @author Alan Dugger
 */
public class TestAvgGradesClass {

	/**
	 * Test case for calculating grade value for an empty arraylist
	 */
	@Test
	public void testEmptyArrayListAvgGrades() {
		AvgGrades testStrategy = new AvgGrades();
		ArrayList<Double> testArray = new ArrayList<Double>();		
		assertEquals(0, testStrategy.calculateGrade(testArray));
	}
	
	/**
	 * Test case for calculating grade value for an arraylist with a single entry
	 */
	@Test
	public void testEmptyArrayListAvgGradesSingleEntryArray() {
		AvgGrades testStrategy = new AvgGrades();
		ArrayList<Double> testArray = new ArrayList<Double>();	
		testArray.add(95.5);		
		assertEquals(95.5, testStrategy.calculateGrade(testArray), 0.01);
	}

	/**
	 * Test case for calculating grade value for an arraylist with multiple entries
	 */
	@Test
	public void testEmptyArrayListAvgGradesMultipleEntriesArray() {
		AvgGrades testStrategy = new AvgGrades();
		ArrayList<Double> testArray = new ArrayList<Double>();	
		testArray.add(95.0);
		testArray.add(90.0);
		testArray.add(100.0);
		testArray.add(95.0);
		testArray.add(90.0);
		testArray.add(100.0);
		assertEquals(95.0, testStrategy.calculateGrade(testArray), 0.01);
	}
}

package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Junit test cases to ensure sumgrades strategy returns the appropriate values
 * @version 10/29/2010
 * @author Alan Dugger
 *
 */
public class TestSumGradesClass {

	/**
	 * Test case for calculating grade value for an empty arraylist
	 */
	@Test
	public void testEmptyArrayListSummedGrades() {
		SumGrades testStrategy = new SumGrades();
		ArrayList<Double> testArray = new ArrayList<Double>();		
		assertEquals(0, testStrategy.calculateGrade(testArray));
	}
	
	/**
	 * Test case for calculating grade value for an arraylist with a single entry
	 */
	@Test
	public void testEmptyArrayListSummedGradesSingleEntryArray() {
		SumGrades testStrategy = new SumGrades();
		ArrayList<Double> testArray = new ArrayList<Double>();	
		testArray.add(39.25);		
		assertEquals(39.25, testStrategy.calculateGrade(testArray), 0.01);
	}

	/**
	 * Test case for calculating grade value for an arraylist with multiple entries
	 */
	@Test
	public void testEmptyArrayListSummedGradesMultipleEntriesArray() {
		SumGrades testStrategy = new SumGrades();
		ArrayList<Double> testArray = new ArrayList<Double>();	
		testArray.add(10.0);
		testArray.add(15.0);
		testArray.add(25.0);
		testArray.add(25.0);
		testArray.add(25.0);
		assertEquals(100, testStrategy.calculateGrade(testArray), 0.01);
	}
}

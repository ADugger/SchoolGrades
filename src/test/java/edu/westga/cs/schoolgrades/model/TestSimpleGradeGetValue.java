package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for getting SimpleGrade values.
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestSimpleGradeGetValue {

	/**
	 * Test case when attempting to initialize a grade below 0
	 */
	@Test
	void testSimpleGradeBelowZero() {		
		assertThrows(IllegalArgumentException.class, () -> {new SimpleGrade(-10);});
	}
	
	/**
	 * Test case when attempting to retrieve a grade without decimal value
	 */
	@Test
	void testSimpleGradeGetWholeNumberGrade() {		
		SimpleGrade testGrade = new SimpleGrade(99);
		assertEquals(99, testGrade.getValue());				
	}
	
	/**
	 * Test case when attempting to retrieve a grade with a decimal value
	 */
	@Test
	void testSimpleGradeGetDecimalGrade() {		
		SimpleGrade testGrade = new SimpleGrade(93.7);
		assertEquals(93.7, testGrade.getValue());
	}
	
	/**
	 * Test case when attempting to retrieve a grade of 0
	 */
	@Test
	void testSimpleGradeGetGradeOfZero() {		
		SimpleGrade testGrade = new SimpleGrade(0);
		assertEquals(0, testGrade.getValue());
	}
}

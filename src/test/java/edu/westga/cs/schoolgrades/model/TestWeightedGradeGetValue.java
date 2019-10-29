package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Junit test cases for getting a weighted value for a weightedgrade
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestWeightedGradeGetValue {

	/**
	 * Test case for a grade that has no weightvalue set (using default weight of 1.0)
	 */
	@Test
	public void testGetValueWhenDefaultWeightUsed() {
		WeightedGrade testGrade = new WeightedGrade(88.3);
		assertEquals(88.3, testGrade.getValue(), .01);
	}
	
	/**
	 * Test case for a grade that has no weightvalue set initially then after it's changed
	 */
	@Test
	public void testGetValueWhenDefaultWeightUsedThenChanged() {
		WeightedGrade testGrade = new WeightedGrade(82.0);
		assertEquals(82, testGrade.getValue(), .01);
		testGrade.setWeight(0.5);
		assertEquals(41, testGrade.getValue(), .01);
	}
	
	/**
	 * Test case for a grade that has an initial weightvalue set
	 */
	@Test
	public void testGetValueWhenInitialValueSetAtConstructor() {
		WeightedGrade testGrade = new WeightedGrade(100.0, .33);
		assertEquals(33.0, testGrade.getValue(), .01);		
	}

}

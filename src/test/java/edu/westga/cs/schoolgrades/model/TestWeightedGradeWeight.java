package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Junit test cases for the weightedgrade weight data field
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestWeightedGradeWeight {

	/**
	 * Test case to get value of weight default value
	 */
	@Test
	public void testGetDefaultWeightValue() {
		WeightedGrade testGrade = new WeightedGrade(99.0);
		assertEquals(1.0, testGrade.getWeight());
	}

}

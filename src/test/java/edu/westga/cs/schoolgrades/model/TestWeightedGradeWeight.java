package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		assertEquals(1.0, testGrade.getWeight(), .01);
	}
	
	/**
	 * Test case to set the value of a weight that starts at default value
	 */
	@Test
	public void testSettWeightOverDefaultValue() {
		WeightedGrade testGrade = new WeightedGrade(82.0);		
		assertEquals(1.0, testGrade.getWeight(), .01);
		testGrade.setWeight(.75);
		assertEquals(.75, testGrade.getWeight(), .01);
	}
	
	/**
	 * Test case for attempting to set the value of a weight that starts at default value to an invalid value
	 */
	@Test
	public void testSettingWeightOverDefaultValueIncorrectly() {
		WeightedGrade testGrade = new WeightedGrade(100);		
		assertEquals(1.0, testGrade.getWeight(), .01);		
		assertThrows(IllegalArgumentException.class, () -> {testGrade.setWeight(-0.75);});		
	}
}

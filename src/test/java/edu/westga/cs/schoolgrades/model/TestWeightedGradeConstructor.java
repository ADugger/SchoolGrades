package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Junit test cases for the WeightedGrade constructor
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestWeightedGradeConstructor {

	/**
	 * Test case for constructing a weightedgrade below 0
	 */
	@Test
	public void testWeightedGradeAttemptBelowZeroGrade() {
		assertThrows(IllegalArgumentException.class, () -> {new WeightedGrade(-15);});
	}
	
	/**
	 * Test case for constructing a weightedgrade below 0 weight a valid weight value
	 */
	@Test
	public void testWeightedGradeAttemptBelowZeroGradeWithValidWeight() {
		assertThrows(IllegalArgumentException.class, () -> {new WeightedGrade(-15, .5);});
	}
	
	/**
	 * Test case for constructing a valid weightedgrade but with a weight value below 0
	 */
	@Test
	public void testWeightedGradeAttemptBelowZeroWeight() {
		assertThrows(IllegalArgumentException.class, () -> {new WeightedGrade(95.0, -0.5);});
	}
	
	/**
	 * Test case for constructing a valid weightedgrade
	 */
	@Test
	public void testValidWeightedGradeWithoutWeight() {
		WeightedGrade testGrade = new WeightedGrade(87.5);
		assertEquals(87.5, testGrade.getValue());
		assertEquals(1.0, testGrade.getWeight());
	}
	
	/**
	 * Test case for constructing a valid weightedgrade with weight provided
	 */
	@Test
	public void testValidWeightedGradeWithWeight() {
		WeightedGrade testGrade = new WeightedGrade(100.0, .25);
		assertEquals(25.0, testGrade.getValue());
		assertEquals(0.25, testGrade.getWeight());
	}
}

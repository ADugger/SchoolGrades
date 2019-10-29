package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

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
}

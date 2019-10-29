package edu.westga.cs.schoolgrades.model;

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

	@Test
	void testSimpleGradeBelowZero() {		
		assertThrows(IllegalArgumentException.class, () -> {SimpleGrade testGrade = new SimpleGrade(-10);});
	}

}

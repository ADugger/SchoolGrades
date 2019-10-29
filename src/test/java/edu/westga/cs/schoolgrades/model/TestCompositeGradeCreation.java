package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for creation of a compositegrade object
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestCompositeGradeCreation {

	/**
	 * Test a newly created composite grade object throws null if arraylist is requested since it's empty
	 */
	@Test
	public void testGetListOfGradesofEmptyList() {
		CompositeGrade testGrade = new CompositeGrade();
		assertEquals(null, testGrade.getListOfGrades());
	}

}

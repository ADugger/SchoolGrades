package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

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
	
	/**
	 * Test to ensure only valid grades above zero can be added to composite grade
	 */
	@Test
	public void testAddBelowZeroGradeToListOfGrades() {
		CompositeGrade testGrade = new CompositeGrade();
		assertThrows(IllegalArgumentException.class, () -> {testGrade.addGrade(-10);});
	}
	
	/**
	 * Test a newly created composite grade object with a single value added
	 */
	@Test
	public void testGetListOfGradesWithSingleEntry() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(99.5);
		ArrayList<Double> retrievedGrades = testGrade.getListOfGrades();
		assertEquals(1, retrievedGrades.size());
		assertEquals(99.5, retrievedGrades.get(0));
	}
	
	/**
	 * Test a newly created composite grade object with a multiple different values added
	 */
	@Test
	public void testGetListOfGradesWithMultipleUniqueEntries() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(99.5);
		testGrade.addGrade(85.0);
		testGrade.addGrade(88.9);
		ArrayList<Double> retrievedGrades = testGrade.getListOfGrades();
		assertEquals(3, retrievedGrades.size());
		assertEquals(99.5, retrievedGrades.get(0));
		assertEquals(85.0, retrievedGrades.get(1));
		assertEquals(88.9, retrievedGrades.get(2));
	}
	
	/**
	 * Test a newly created composite grade object with a multiple values added some of which are duplicates
	 */
	@Test
	public void testGetListOfGradesWithMultipleUniqueDuplicatedEntries() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(0);
		testGrade.addGrade(81.0);
		testGrade.addGrade(81.9);
		testGrade.addGrade(0);
		testGrade.addGrade(81.9);
		testGrade.addGrade(99.5);
		ArrayList<Double> retrievedGrades = testGrade.getListOfGrades();
		assertEquals(6, retrievedGrades.size());
		assertEquals(0, retrievedGrades.get(0));
		assertEquals(81.0, retrievedGrades.get(1));
		assertEquals(81.9, retrievedGrades.get(2));
		assertEquals(0, retrievedGrades.get(3));
		assertEquals(81.9, retrievedGrades.get(4));
		assertEquals(99.5, retrievedGrades.get(5));
	}

}

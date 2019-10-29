package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for the compositegrade class getValue method which uses strategies to calculate the grade
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestCompositeGradeGetValue {

	/**
	 * Junit test case for calling getValue on a newly initialized CompositeGrade
	 */
	@Test
	public void testGetValueWithDefaultEmptyArrayAndDefaultStrategy() {
		CompositeGrade testGrade = new CompositeGrade();
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {testGrade.getValue();});
	}
	
	/**
	 * Junit test case for calling getValue on compositegrade with single entry and default strategy selected
	 */
	@Test
	public void testGetValueWithDefaultStrategySingleEntry() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(93.5);
		assertEquals(93.5, testGrade.getValue(), 0.01);
	}
	
	/**
	 * Junit test case for calling getValue on compositegrade with multiple entries and default strategy selected
	 */
	@Test
	public void testGetValueWithDefaultStrategyMultipleEntries() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(99);
		testGrade.addGrade(96);
		testGrade.addGrade(93);
		testGrade.addGrade(90);
		testGrade.addGrade(87);
		assertEquals(93.0, testGrade.getValue(), 0.01);
	}
}

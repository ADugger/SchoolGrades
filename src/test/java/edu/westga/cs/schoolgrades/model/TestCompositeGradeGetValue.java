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
	
	/**
	 * Junit test case for calling getValue on compositegrade with single entry after changing to new strategy
	 */
	@Test
	public void testGetValueWithSetStrategySingleEntry() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(13.5);
		testGrade.setStrategy(new SumGrades());
		assertEquals(13.5, testGrade.getValue(), 0.01);
	}
	
	/**
	 * Junit test case for calling getValue on compositegrade with multiple entries after changing to new strategy
	 */
	@Test
	public void testGetValueWithSetStrategyMultipleEntries() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(13.5);
		testGrade.addGrade(15.0);
		testGrade.setStrategy(new SumGrades());
		assertEquals(28.5, testGrade.getValue(), 0.01);
	}
	
	/**
	 * Junit test case for calling getValue on compositegrade with multiple entries using default strategy, then changing and using
	 * new strategy provided
	 */
	@Test
	public void testGetValueWithBothStrategiesMultipleEntries() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(10.0);
		testGrade.addGrade(20.0);
		testGrade.addGrade(30.0);		
		assertEquals(20.0, testGrade.getValue(), 0.01);
		testGrade.setStrategy(new SumGrades());
		assertEquals(60.0, testGrade.getValue(), 0.01);
	}
}

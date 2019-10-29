package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for removing grades from the list
 * 
 * @version 10/29/2019
 * @author Alan Dugger
 *
 */
public class TestCompositeGradesRemoveGrades {

	/**
	 * Test case for trying to remove index 0 from an arraylist that is already empty
	 */
	@Test
	public void testRemovingGradeByIndexOnEmptyList() {
		CompositeGrade testGrade = new CompositeGrade();
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {testGrade.removeGradeByIndex(0);});
	}
	
	/**
	 * Test case for trying to remove index below 0 from an arraylist
	 */
	@Test
	public void testRemovingGradeByNegativeIndexValue() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(100.0);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {testGrade.removeGradeByIndex(-2);});
	}
	
	/**
	 * Test case for trying to remove index 2 from an arraylist with only 2 elements
	 */
	@Test
	public void testRemovingGradeByIndexTooLargeForArray() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(100.0);
		testGrade.addGrade(100.0);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {testGrade.removeGradeByIndex(2);});
	}
	
	/**
	 * Test case for trying to remove index 1 from an arraylist with 3 elements 
	 */
	@Test
	public void testRemovingGradeByIndexMiddleIndex() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(98.0);
		testGrade.addGrade(99.0);
		testGrade.addGrade(100.0);
		testGrade.removeGradeByIndex(1);
		assertEquals(2, testGrade.getListOfGrades().size());
		assertEquals(98.0, testGrade.getListOfGrades().get(0));
		assertEquals(100.0, testGrade.getListOfGrades().get(1));
	}
	
	/**
	 * Test case for trying to remove index 2 from end of the arraylist with 3 elements 
	 */
	@Test
	public void testRemovingGradeByIndexLastIndex() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(98.0);
		testGrade.addGrade(99.0);
		testGrade.addGrade(100.0);
		testGrade.removeGradeByIndex(2);
		assertEquals(2, testGrade.getListOfGrades().size());
		assertEquals(98.0, testGrade.getListOfGrades().get(0));
		assertEquals(99.0, testGrade.getListOfGrades().get(1));
	}
	
	/**
	 * Test case for trying to remove index 0 from start of the arraylist with 3 elements 
	 */
	@Test
	public void testRemovingGradeByIndexBeginningIndex() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(98.0);
		testGrade.addGrade(99.0);
		testGrade.addGrade(100.0);
		testGrade.removeGradeByIndex(0);
		assertEquals(2, testGrade.getListOfGrades().size());
		assertEquals(99.0, testGrade.getListOfGrades().get(0));
		assertEquals(100.0, testGrade.getListOfGrades().get(1));
	}

}

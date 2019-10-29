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
	
	/**
	 * Test case for trying to remove a grade that doesn't exist within the arraylist
	 */
	@Test
	public void testRemovingGradeByValueGradeDoesntExist() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(98.0);
		testGrade.addGrade(99.0);
		testGrade.addGrade(100.0);
		assertThrows(IllegalArgumentException.class, () -> {testGrade.removeGradeByValue(75.2);});
	}
	
	/**
	 * Test case to remove a grade from array list when only 1 entry of the provided value exists
	 */
	@Test
	public void testRemovingGradeByValueSingleEntryOfValue() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(75.0);
		testGrade.addGrade(87.0);
		testGrade.addGrade(84.0);
		testGrade.addGrade(97.0);
		assertEquals(4, testGrade.getListOfGrades().size());
		assertEquals(84.0, testGrade.getListOfGrades().get(2));
		testGrade.removeGradeByValue(84);
		assertEquals(3, testGrade.getListOfGrades().size());
		assertEquals(97.0, testGrade.getListOfGrades().get(2));
	}
	
	/**
	 * Test case to remove a grade from array list when only multiple entries exist and the first is in the middle
	 */
	@Test
	public void testRemovingGradeByValueMultipleEntriesFirstInMiddle() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(75.0);
		testGrade.addGrade(87.0);
		testGrade.addGrade(84.0);
		testGrade.addGrade(87.0);
		testGrade.addGrade(97.0);
		assertEquals(5, testGrade.getListOfGrades().size());
		assertEquals(87.0, testGrade.getListOfGrades().get(1));
		testGrade.removeGradeByValue(87);
		assertEquals(4, testGrade.getListOfGrades().size());
		assertEquals(84.0, testGrade.getListOfGrades().get(1));
	}
	
	/**
	 * Test case to remove a grade from array list when only multiple entries exist and the first is index 0
	 */
	@Test
	public void testRemovingGradeByValueMultipleEntriesFirstIndexZero() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(87.0);
		testGrade.addGrade(75.0);
		testGrade.addGrade(87.0);
		testGrade.addGrade(84.0);
		testGrade.addGrade(97.0);
		assertEquals(5, testGrade.getListOfGrades().size());
		assertEquals(87.0, testGrade.getListOfGrades().get(0));
		testGrade.removeGradeByValue(87);
		assertEquals(4, testGrade.getListOfGrades().size());
		assertEquals(75.0, testGrade.getListOfGrades().get(0));
	}
	
	/**
	 * Test case to remove a grade from array list when only 1 entry of the provided value exists and it's the last entry
	 */
	@Test
	public void testRemovingGradeByValueSingleEntryOfValueAtEndOfList() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.addGrade(75.0);
		testGrade.addGrade(87.0);
		testGrade.addGrade(84.0);
		testGrade.addGrade(97.0);
		assertEquals(4, testGrade.getListOfGrades().size());
		assertEquals(97.0, testGrade.getListOfGrades().get(3));
		testGrade.removeGradeByValue(97);
		assertEquals(3, testGrade.getListOfGrades().size());
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {testGrade.removeGradeByIndex(3);});
		
	}
}

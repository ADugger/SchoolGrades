package edu.westga.cs.schoolgrades.model;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockChildStrategy;
	
	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	private ArrayList<Grade> listOfGrades;
	private ArrayList<Grade> listWithoutLowest;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(Grade.class);
		mockGrade1 = mock(Grade.class);
		mockGrade2 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		when(mockGrade1.getValue()).thenReturn(20.00);
		when(mockGrade2.getValue()).thenReturn(30.00);
		
		listOfGrades = new ArrayList<Grade>();	
		listWithoutLowest = new ArrayList<Grade>();
		
		mockChildStrategy = mock(GradeCalculationStrategy.class);				
		dropLowestStrategy = new DropLowestStrategy(mockChildStrategy);
		
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		dropLowestStrategy.calculate(listOfGrades);		
		verify(mockChildStrategy).calculate(listWithoutLowest);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		listOfGrades.add(mockGrade0);
		listWithoutLowest.add(mockGrade0);		
		dropLowestStrategy.calculate(listOfGrades);		
		verify(mockChildStrategy).calculate(listWithoutLowest);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		listOfGrades.add(mockGrade0);
		listOfGrades.add(mockGrade1);
		listOfGrades.add(mockGrade2);
		listWithoutLowest.add(mockGrade1);
		listWithoutLowest.add(mockGrade2);
		dropLowestStrategy.calculate(listOfGrades);		
		verify(mockChildStrategy).calculate(listWithoutLowest);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		listOfGrades.add(mockGrade1);
		listOfGrades.add(mockGrade2);
		listOfGrades.add(mockGrade0);
		dropLowestStrategy.calculate(listOfGrades);
		listWithoutLowest.add(mockGrade1);
		listWithoutLowest.add(mockGrade2);
		verify(mockChildStrategy).calculate(listWithoutLowest);
		
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		listOfGrades.add(mockGrade1);
		listOfGrades.add(mockGrade0);
		listOfGrades.add(mockGrade2);
		listWithoutLowest.add(mockGrade1);
		listWithoutLowest.add(mockGrade2);
		dropLowestStrategy.calculate(listOfGrades);
		verify(mockChildStrategy).calculate(listWithoutLowest);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		listOfGrades.add(mockGrade1);
		listOfGrades.add(mockGrade0);
		listOfGrades.add(mockGrade2);
		listOfGrades.add(mockGrade0);
		listWithoutLowest.add(mockGrade1);			
		listWithoutLowest.add(mockGrade2);
		listWithoutLowest.add(mockGrade0);
		dropLowestStrategy.calculate(listOfGrades);
		verify(mockChildStrategy).calculate(listWithoutLowest);
	}
}

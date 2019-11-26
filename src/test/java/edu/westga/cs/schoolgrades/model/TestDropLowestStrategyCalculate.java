package edu.westga.cs.schoolgrades.model;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockChildStrategy;
	
	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	private List<Grade> mockedList;
	private List<Grade> mockedListWithoutLowest;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(Grade.class);
		mockGrade1 = mock(Grade.class);
		mockGrade2 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		when(mockGrade1.getValue()).thenReturn(20.00);
		when(mockGrade2.getValue()).thenReturn(30.00);
		
		mockedList = mock(List.class);		
		mockedListWithoutLowest = mock(List.class);
		
		mockChildStrategy = mock(SumOfGradesStrategy.class);				
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
		dropLowestStrategy.calculate(mockedList);		
		verify(mockChildStrategy).calculate(mockedListWithoutLowest);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		mockedList.add(mockGrade0);
		mockedListWithoutLowest.add(mockGrade0);		
		dropLowestStrategy.calculate(mockedList);		
		verify(mockChildStrategy).calculate(mockedListWithoutLowest);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		mockedList.add(mockGrade0);
		mockedList.add(mockGrade1);
		mockedList.add(mockGrade2);
		mockedListWithoutLowest.add(mockGrade1);
		mockedListWithoutLowest.add(mockGrade2);
		dropLowestStrategy.calculate(mockedList);		
		verify(mockChildStrategy).calculate(mockedListWithoutLowest);
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		mockedList.add(mockGrade1);
		mockedList.add(mockGrade2);
		mockedList.add(mockGrade0);
		dropLowestStrategy.calculate(mockedList);
		mockedListWithoutLowest.add(mockGrade1);
		mockedListWithoutLowest.add(mockGrade2);
		verify(mockChildStrategy).calculate(mockedListWithoutLowest);
		
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		mockedList.add(mockGrade1);
		mockedList.add(mockGrade0);
		mockedList.add(mockGrade2);
		mockedListWithoutLowest.add(mockGrade1);
		mockedListWithoutLowest.add(mockGrade2);
		dropLowestStrategy.calculate(mockedList);
		verify(mockChildStrategy).calculate(mockedListWithoutLowest);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		mockedList.add(mockGrade1);
		mockedList.add(mockGrade0);
		mockedList.add(mockGrade2);
		mockedList.add(mockGrade0);		
		mockedListWithoutLowest.add(mockGrade0);
		mockedListWithoutLowest.add(mockGrade1);
		mockedListWithoutLowest.add(mockGrade2);
		dropLowestStrategy.calculate(mockedList);
		verify(mockChildStrategy).calculate(mockedListWithoutLowest);
	}
}

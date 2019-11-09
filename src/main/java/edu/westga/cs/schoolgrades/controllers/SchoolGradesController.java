package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * Class to control the FXML GUI for the School Grades project and inject FXML references
 * 
 * @author Alan Dugger
 * @version 11/09/2019
 */ 
public class SchoolGradesController {
	
	private ObservableList<SimpleGrade> quizGrades;
	private ObservableList<SimpleGrade> homeworkGrades;
	private ObservableList<SimpleGrade> examGrades;
	private DoubleProperty quizSubtotal;
	private DoubleProperty homeworkSubtotal;
	private DoubleProperty examSubtotal;
	private DoubleProperty finalTotal;
	private final double QUIZ_WEIGHT = 0.2;
	private final double HOMEWORK_WEIGHT = 0.3;
	private final double EXAM_WEIGHT = 0.5;
	
	@FXML
	private ListView<SimpleGrade> lvQuiz;
	@FXML
	private ListView<SimpleGrade> lvHomework;
	@FXML
	private ListView<SimpleGrade> lvExam;
	
	@FXML
	private TextField txtQuizSubtotal;
	@FXML
	private TextField txtHomeworkSubtotal;
	@FXML
	private TextField txtExamSubtotal;
	@FXML
	private TextField txtFinalGrade;
	
	@FXML
	private Button btnRecalculate;
	
	@FXML
	private MenuItem mitemNewQuiz;
	@FXML
	private MenuItem mitemNewHomework;
	@FXML
	private MenuItem mitemNewExam;
	
	/**
	 * Constructor method to allow controller instantiation and initialization variables
	 */
	public SchoolGradesController() {	
		this.quizGrades = FXCollections.observableArrayList();			
		this.homeworkGrades = FXCollections.observableArrayList();
		this.examGrades = FXCollections.observableArrayList();
		this.quizSubtotal = new SimpleDoubleProperty(0);
		this.homeworkSubtotal = new SimpleDoubleProperty(0);
		this.examSubtotal = new SimpleDoubleProperty(0);
		this.finalTotal = new SimpleDoubleProperty(0);
	}
	
	/**
	 * FXML initialization of GUI components
	 */
	@FXML
	private void initialize() {
		this.txtQuizSubtotal.textProperty().bind(this.quizSubtotal.asString());
		this.txtHomeworkSubtotal.textProperty().bind(this.homeworkSubtotal.asString());
		this.txtExamSubtotal.textProperty().bind(this.examSubtotal.asString());
		this.txtFinalGrade.textProperty().bind(this.finalTotal.asString());
		this.listviewQuizSetup();
		this.listviewHomeworkSetup();	
		this.listviewExamSetup();	
	}	
	
	/**
	 * Menu item action handler for the new quiz menu item
	 * @param event the click event
	 */
	@FXML
	private void handleNewQuizClick(ActionEvent event) {
		this.quizGrades.add(new SimpleGrade(0.0));
	}
	
	/**
	 * Menu item action handler for the new homework menu item
	 * @param event the click event
	 */
	@FXML
	private void handleNewHomeworkClick(ActionEvent event) {
		this.homeworkGrades.add(new SimpleGrade(0.0));
	}
	
	/**
	 * Menu item action handler for the new exam menu item
	 * @param event the click event
	 */
	@FXML
	private void handleNewExamClick(ActionEvent event) {
		this.examGrades.add(new SimpleGrade(0.0));
	}
	
	/**
	 * Helper method to setup the listview and cell factory for the quiz item list
	 */
	private void listviewQuizSetup() {
		this.lvQuiz.setItems(this.quizGrades);
		this.lvQuiz.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);	
		this.lvQuiz.setEditable(true);
		this.lvQuiz.setCellFactory(new Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>>() {
			@Override
			public ListCell<SimpleGrade> call(ListView<SimpleGrade> theCall) {
				 TextFieldListCell<SimpleGrade> oneCell = new TextFieldListCell<SimpleGrade>();						 
				 oneCell.setConverter(new StringConverter<SimpleGrade>() {
					 public String toString(SimpleGrade theGrade) {
						 if (theGrade == null) {
							 return "";
						 }						 
						 return String.format("%.2f", theGrade.getValue());
					 }
					 
					 public SimpleGrade fromString(String theCellString) {
						 try {
							 double convertedValue = Double.parseDouble(theCellString);
							 SimpleGrade convertedGrade = new SimpleGrade(convertedValue);
							 return convertedGrade;
						 } catch (NumberFormatException nfe) {							
							throw new IllegalArgumentException("There was a problem with the number you entered.");							
						 }						
					 }
				 });
				 oneCell.setAccessibleText(oneCell.getText());
				 return oneCell;
			}			
		});		
	}
	
	/**
	 * Helper method to setup the listview and cell factory for the homework item list
	 */
	private void listviewHomeworkSetup() {
		this.lvHomework.setItems(this.homeworkGrades);
		this.lvHomework.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);	
		this.lvHomework.setEditable(true);
		this.lvHomework.setCellFactory(new Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>>() {
			@Override
			public ListCell<SimpleGrade> call(ListView<SimpleGrade> theCall) {
				 TextFieldListCell<SimpleGrade> oneCell = new TextFieldListCell<SimpleGrade>();				 
				 oneCell.setConverter(new StringConverter<SimpleGrade>() {
					 public String toString(SimpleGrade theGrade) {
						 if (theGrade == null) {
							 return "";
						 }
						 
						 return String.format("%.2f", theGrade.getValue());
					 }
					 
					 public SimpleGrade fromString(String theCellString) {
						 try {
							 double convertedValue = Double.parseDouble(theCellString);
							 SimpleGrade convertedGrade = new SimpleGrade(convertedValue);
							 return convertedGrade;
						 } catch (NumberFormatException nfe) {							
							throw new IllegalArgumentException("There was a problem with the number you entered.");							
						 }						
					 }
				 });
				 oneCell.setAccessibleText(oneCell.getText());
				 return oneCell;
			}			
		});		
	}
	
	/**
	 * Helper method to setup the listview and cell factory for the exam item list
	 */
	private void listviewExamSetup() {
		this.lvExam.setItems(this.examGrades);
		this.lvExam.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);	
		this.lvExam.setEditable(true);
		this.lvExam.setCellFactory(new Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>>() {
			@Override
			public ListCell<SimpleGrade> call(ListView<SimpleGrade> theCall) {
				 TextFieldListCell<SimpleGrade> oneCell = new TextFieldListCell<SimpleGrade>();				 
				 oneCell.setConverter(new StringConverter<SimpleGrade>() {
					 public String toString(SimpleGrade theGrade) {
						 if (theGrade == null) {
							 return "";
						 }
						 
						 return String.format("%.2f", theGrade.getValue());
					 }
					 
					 public SimpleGrade fromString(String theCellString) {
						 try {
							 double convertedValue = Double.parseDouble(theCellString);
							 SimpleGrade convertedGrade = new SimpleGrade(convertedValue);
							 return convertedGrade;
						 } catch (NumberFormatException nfe) {							
							throw new IllegalArgumentException("There was a problem with the number you entered.");							
						 }						
					 }
				 });
				 oneCell.setAccessibleText(oneCell.getText());
				 return oneCell;
			}			
		});		
	}
	
	/**
	 * Method to handle the recalculate button functionality
	 * @param event the click event
	 */
	@FXML
	private void handleRecalculateClick(ActionEvent event) {
		this.calculateSubtotals();
		this.calculateFinalGrade();
	}
	
	/**
	 * Helper method to calculate and set the subtotal values of the grades
	 */
	private void calculateSubtotals() {
		SumOfGradesStrategy sumOfQuizGrades = new SumOfGradesStrategy();
		DropLowestStrategy sumOfHomeworkGrades = new DropLowestStrategy(new AverageOfGradesStrategy());
		AverageOfGradesStrategy sumOfExamGrades = new AverageOfGradesStrategy();
		
		CompositeGrade compositeQuizGrades = new CompositeGrade(sumOfQuizGrades);
		CompositeGrade compositeHomeworkGrades = new CompositeGrade(sumOfHomeworkGrades);
		CompositeGrade compositeExamGrades = new CompositeGrade(sumOfExamGrades);
		
		compositeQuizGrades.addAll(this.quizGrades);
		compositeHomeworkGrades.addAll(this.homeworkGrades);
		compositeExamGrades.addAll(this.examGrades);
		
		this.quizSubtotal.set(compositeQuizGrades.getValue());
		this.homeworkSubtotal.set(compositeHomeworkGrades.getValue());
		this.examSubtotal.set(compositeExamGrades.getValue());
	}
	
	/**
	 * Helper method to calculate the final grade based on weighted values for subtotalled grades
	 */
	private void calculateFinalGrade() {
		SumOfGradesStrategy sumofAllGrades = new SumOfGradesStrategy();
		
		CompositeGrade compositeTotalAllGrades = new CompositeGrade(sumofAllGrades);
		
		WeightedGrade weightedQuizSubtotal = new WeightedGrade((Grade) new SimpleGrade(this.quizSubtotal.get()), this.QUIZ_WEIGHT);
		WeightedGrade weightedHomeworkSubtotal = new WeightedGrade((Grade) new SimpleGrade(this.homeworkSubtotal.get()), this.HOMEWORK_WEIGHT);
		WeightedGrade weightedExamSubtotal = new WeightedGrade((Grade) new SimpleGrade(this.examSubtotal.get()), this.EXAM_WEIGHT);
			
		compositeTotalAllGrades.add(weightedQuizSubtotal);
		compositeTotalAllGrades.add(weightedHomeworkSubtotal);
		compositeTotalAllGrades.add(weightedExamSubtotal);
		
		this.finalTotal.set(compositeTotalAllGrades.getValue());
	}
}

package edu.westga.cs.schoolgrades.controllers;

import java.util.List;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	}	
	
	@FXML
	private void handleNewQuizClick(ActionEvent event) {
		this.quizGrades.add(new SimpleGrade(0.0));
	}
	
	private void listviewQuizSetup() {
		this.lvQuiz.setItems(this.quizGrades);
		this.lvQuiz.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);		
		this.lvQuiz.setCellFactory(new Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>>() {
			@Override
			public ListCell<SimpleGrade> call(ListView<SimpleGrade> theCall) {
				 TextFieldListCell<SimpleGrade> oneCell = new TextFieldListCell<SimpleGrade>();
				 oneCell.setConverter(new StringConverter<SimpleGrade>() {
					 public String toString(SimpleGrade theGrade) {
						 return String.format("%.2f", theGrade.getValue());
					 }
					 
					 public SimpleGrade fromString(String theCellString) {
						 try {
							 double convertedValue = Double.parseDouble(theCellString);
							 SimpleGrade convertedGrade = new SimpleGrade(convertedValue);
							 return convertedGrade;
						 } catch (NumberFormatException nfe) {
							Alert errorAlert = new Alert(AlertType.ERROR);
							errorAlert.setTitle("Not A Number");
							errorAlert.setContentText("There was an error the number you entered for the grade." +nfe.getMessage());
							errorAlert.showAndWait();
						 }
						return null;
					 }
				 });
				 oneCell.setEditable(true);
				 return oneCell;
			}			
		});		
	}
}

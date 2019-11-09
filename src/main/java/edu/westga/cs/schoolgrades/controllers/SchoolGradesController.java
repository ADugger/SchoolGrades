package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;

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
	private IntegerProperty quizSubtotal = new SimpleIntegerProperty(0);
	private IntegerProperty homeworkSubtotal = new SimpleIntegerProperty(0);
	private IntegerProperty examSubtotal = new SimpleIntegerProperty(0);
	private IntegerProperty finalTotal = new SimpleIntegerProperty(0);
	
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
	 * Constructor method to allow controller instantiation and initialization of observable lists
	 */
	public SchoolGradesController() {	
		this.quizGrades = FXCollections.observableArrayList();			
		this.homeworkGrades = FXCollections.observableArrayList();
		this.examGrades = FXCollections.observableArrayList();
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
		this.mitemNewQuiz.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SchoolGradesController.this.quizGrades.add(new SimpleGrade(0.0));				
			}
		});
	}	
	
	private void listviewQuizSetup() {
		this.lvQuiz.setItems(this.quizGrades);
		this.lvQuiz.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);		
		this.lvQuiz.setCellFactory(new Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>>() {
			@Override
			public ListCell<SimpleGrade> call(ListView<SimpleGrade> theCall) {
				 TextFieldListCell<SimpleGrade> oneCell = new TextFieldListCell<SimpleGrade>() {
					 @Override
					 public void updateItem(SimpleGrade theGrade, boolean empty) {
						super.updateItem(theGrade, empty);
						if (!empty) {
							setText(String.valueOf(theGrade.getValue()));
						}
				 	}
				 };
				 oneCell.setEditable(true);
				 return oneCell;
			}			
		});		
	}
}

package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.Grade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * Class to control the FXML GUI for the School Grades project and inject FXML references
 * 
 * @author Alan Dugger
 * @version 11/09/2019
 */ 
public class SchoolGradesController {
	
	@FXML
	private ListView<Grade> lvQuiz;
	@FXML
	private ListView<Grade> lvHomework;
	@FXML
	private ListView<Grade> lvExam;
	
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
}

package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXML;

public class ResetPasswordController implements Initializable{
	
	@FXML public TextArea answ;
	@FXML public TextField use;
	@FXML public TextField pass1;
	@FXML public TextField pass2;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private ComboBox securityQuestion;
	
	public void initialize(URL url, ResourceBundle rb) {
		
		String selec1 = "option";
		String selec2 = "option2";
		
		//updates security question ComboBox as start with options of selec1 and selec2
		//We need to pull security questions from sql and place them into selec1 and selec2
		
		securityQuestion.getItems().addAll(selec1, selec2);

	}
	
	
	public void switchToSplashScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToMainPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void handleResetPassword(ActionEvent event){
		String sqlAnswer;
		String sqlUserName;
		String sqlSecurityQuestion;
		String password1;
		String password2;
		
		boolean login;
		
		//enter sql customer values into corresponding variables
		
		password1 = pass1.getText();
		password2 = pass2.getText();
		
		sqlAnswer = "";
		sqlUserName = "";
		sqlSecurityQuestion = "";
		login = false;
		
	/*	if(sqlSecurityQuestion.equals(securityQuestion.getValue().toString()) &&
				sqlUserName.equals(use.getText()) && sqlAnswer.equals(answ.getText()) && 
				password1.equals(password2)) {
					
			// put password1 into sql;
			login = true;		
		}
		
		*/
		
		if(login) {
			try {
				switchToMainPage(event);
			} catch(IOException ex){
				System.out.println("shux");
			}
		} /*else {
			try {
				switchToSplashScreen(event);
			} catch(IOException ex){
				System.out.println("shux");
			}
		} I'm not sure we want this else statement */
	}
	
	
	public void handleExit(ActionEvent event){
		boolean login;
		
		login = true;
		
		if(login) {
			try {
				switchToMainPage(event);
			} catch(IOException ex){
				System.out.println("shux");
			}
		} else {
			try {
				switchToSplashScreen(event);
			} catch(IOException ex){
				System.out.println("shux");
			}
		}
	}
	

	
	

}

package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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



public class LogInContoller {
	private Stage stage;
	private Scene scene;
	private Parent root; 
	

	public TextField TextFieldUser1;
	public TextField TextFieldPassword1;
	
	

	
	public void switchToMainPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToRegistration(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSecurityQuestions(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//handles what happens with login should get string from text field checks database if correct
	
	public void handleLoginClickPopup(ActionEvent event) {
		boolean login;
		String user = TextFieldUser1.getText();
		String pass = TextFieldPassword1.getText();
		
		// We are going to need sql query for username and password
		
		String sqlUserNamer;
		String sqlPassword;
		
		sqlUserNamer = "";
		sqlPassword = "";
		
		login = false;
		
		if(user.equals(sqlUserNamer) && pass.equals(sqlPassword)) {
			login = true;
		}
		
		System.out.println(user);
		
		
		if(login) {
			try{
				switchToMainPage(event);
			} catch(IOException ex) {
				System.out.println("OOF");
			}
		} else{
			// relaunch window close stage
			//close program
			
		}
		
		
	}
	
	public void handleRegisterClick(ActionEvent event) {
		try{
			switchToRegistration(event);
		} catch(IOException ex){
			System.out.println("Shux");
		}
	}
	
	
	public void handleForgotPasswordClick(ActionEvent event) {
		try{
			switchToSecurityQuestions(event);
		} catch(IOException ex){
			System.out.println("Shux");
		}
	}
	
	
	
	
	
	
}

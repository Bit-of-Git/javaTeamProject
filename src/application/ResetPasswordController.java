package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.stage.Modality;
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
	
	
	@FXML private ComboBox securityQuestion;
	
	public void initialize(URL url, ResourceBundle rb) {
		
		String selec1 = "option";
		String selec2 = "option2";
		
		//updates security question ComboBox as start with options of selec1 and selec2
		//We need to pull security questions from sql and place them into selec1 and selec2
		
		securityQuestion.getItems().addAll(selec1, selec2);

	}
	
	
	
	public void handleResetPassword(ActionEvent event){
		String sqlAnswer;
		String sqlUserName;
		String sqlSecurityQuestion;
		String password1;
		String password2;
		

		
		//enter sql customer values into corresponding variables
		
		password1 = pass1.getText();
		password2 = pass2.getText();
		
		sqlAnswer = "a";
		sqlUserName = "a";
		sqlSecurityQuestion = "option";

		
		if(securityQuestion.getSelectionModel().isEmpty() == true || use.getText().isEmpty() == true || answ.getText().isEmpty() == true) {
			try {
				FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("SecurityQuestionWrongAnswer.fxml"));
				Parent root2 = (Parent) fxmlLoader2.load();
				Stage stage2 = new Stage();
				stage2.setScene(new Scene(root2)); 
				stage2.setResizable(false);
				stage2.initModality(Modality.APPLICATION_MODAL);
				stage2.show();
			} catch(IOException ex) {
				System.out.print("Shux");
			}
		} else if(sqlSecurityQuestion.equals(securityQuestion.getValue().toString()) &&
				sqlUserName.equals(use.getText()) && sqlAnswer.equals(answ.getText()) && 
				password1.equals(password2)) {
			
			// put password1 into sql;
			Stage stage;
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.close();		

		
		} else {
			try {
				FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("SecurityQuestionWrongAnswer.fxml"));
				Parent root2 = (Parent) fxmlLoader2.load();
				Stage stage2 = new Stage();
				stage2.setScene(new Scene(root2)); 
				stage2.setResizable(false);
				stage2.initModality(Modality.APPLICATION_MODAL);
				stage2.show();
			} catch(IOException ex) {
				System.out.print("Shux");
			}
		}
	}
		
	
	
	public void handleExit(ActionEvent event){
		Stage stage;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	

	
	

}

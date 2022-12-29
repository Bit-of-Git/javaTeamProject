package application;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AdminRegistrationContoller {
	
	private RegistrationController fXMLregistrationController;
	@FXML private TextField adminPassword;

	public void setFXMLRegistrationController(RegistrationController registrationController) {
	    this.fXMLregistrationController = registrationController;
	}

	public void addAdmin(ActionEvent e) throws IOException {
		
		fXMLregistrationController.initData(true);//You are passing to the currently loaded controller
	}
	
	
	public void closeProgram(ActionEvent event) {
		if(adminPassword.getText().equals("12345")) {
			 try{
				 addAdmin(event);
			 } catch(IOException ex) {
				 System.out.print("Shux");
			 }
		}
		Stage stage;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}

}

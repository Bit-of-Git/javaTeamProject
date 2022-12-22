package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ErrorController {
	
	public void closeProgram(ActionEvent event) {
		Stage stage;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}

}

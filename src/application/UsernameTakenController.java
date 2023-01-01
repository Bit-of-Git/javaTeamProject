package application;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class UsernameTakenController {
	public void closeProgram(ActionEvent event) {
		Stage stage;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}

}

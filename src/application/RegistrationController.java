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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;



public class RegistrationController implements Initializable{
	

	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML public TextField user;
	@FXML public TextField pass;
	@FXML public TextField first;
	@FXML public TextField last;
	@FXML public TextField adress;
	@FXML public TextField state;
	@FXML public TextField email;
	@FXML public TextField answer;
	@FXML public TextField answer2;
	@FXML public TextField zip;
	@FXML public TextField ssn;
	
	@FXML private ComboBox securityQuestion = new ComboBox();
	@FXML private ComboBox securityQuestion2 = new ComboBox();
	
	private boolean admin = false;
	
	public void initialize(URL url, ResourceBundle rb) {
		String selec1 = "option";
		String selec2 = "option"; 
		String selec3 = "option";
		String selec4 = "option"; 
		String selec5 = "option";
		
		//selec 1 I'm making mandatory since it makes coding easier

		
		securityQuestion.getItems().addAll(selec1);
		securityQuestion2.getItems().addAll(selec2, selec3, selec4, selec5);
	}
	
	
	public void switchToSplashScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	//method for Back to Main button
	public void backToMainHandler(ActionEvent event) {
		
		try{
			switchToSplashScreen(event);
		} catch(IOException ex) {
				System.out.println("Shux");
		}

	}
	

	
	//method for the submit registration button
	public void registrationHandler(ActionEvent event) {
		
		if(true) {
			
				try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
				 
				 Connection con = DriverManager.getConnection(conURL); 
					 //code 
				PreparedStatement stmt = con.prepareStatement("INSERT INTO Customers(CusUserName, CusPassword, CusFirstName, CusLastName, CusAddress, CusZip, CusState, CusEmail, CusQuestion, CusAnswer, CusSSN) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
					 
				stmt.setString(1, user.getText());
				stmt.setString(2, pass.getText());
				stmt.setString(3, first.getText());
				stmt.setString(4, last.getText());
				stmt.setString(5, adress.getText());
				stmt.setString(6, zip.getText());
				stmt.setString(7, state.getText());
				stmt.setString(8, email.getText());
				stmt.setString(9, securityQuestion.getPromptText());
				stmt.setString(10, answer.getText());
				stmt.setString(11, ssn.getText());
		
				stmt.execute();
				
				
				
				} catch (Exception e) {
					System.out.println("oof");
				}
			//return all of these elements to sql database
			/*
			 * (String)securityQuestion.getValue()
			 * (String)securityQuestion2.getValue()
			 * user.getText();
			 * pass.getText();
			 * first.getText();
			 * last.getText();
			 * adress.getText();
			 * state.getText();
			 * email.getText();
			 * answer.getText();
			 * answer2.getText();
			 * zip.getText()
			 * ssn.getText();
			 */
			backToMainHandler(event);
			System.out.println(admin);
		}
		
	}
	
	public void switchToAdminLogin(ActionEvent event) {
		try {
			switchToAdmin(event);
			
		} catch(Exception e) {
			System.out.println("Shux");
		}

	}
	
	private void switchToAdmin(ActionEvent event) throws IOException {
	    FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("AdminRegistration.fxml"));
	    Parent parent = fXMLLoader.load();
	    AdminRegistrationContoller controller = fXMLLoader.getController();
	    controller.setFXMLRegistrationController(this); // Pass this controller to NewCustomerController
	    Stage stage = new Stage();
	    Scene scene = new Scene(parent);
	    stage.setScene(scene);
	    stage.show();
	}

    
	
	public void initData(boolean adm){
		admin = adm;
		System.out.println(admin);
	}
}

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
import java.sql.*;

public class SplashScreneControler extends LogInContoller implements Initializable{
	
	ImageView image1;

	
	public Button login;
	public Button register;
	public TextField TextFieldUser;
	public TextField TextFieldPassword;
	

	private boolean admin;
	private String user;
	private String pass;
	
	public void initialize(URL location, ResourceBundle resources) {
		//Image im1 = new Image("Main_image.png");
		//image1.setImage(im1);
	}
	
	

	
	public void switchToSplashScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToLogIn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToMainPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent parent3 = loader.load();
        
        //access the controller and call a method
        MainController controller = loader.getController();
        controller.initData(user, admin);
        
        Scene scene3 = new Scene(parent3);
        

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene3);
        window.show();
	}

	public void switchToRegistration(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSecurityQuestions(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void handleLoginClick(ActionEvent event) {
		boolean login = false;
		user = TextFieldUser.getText();
		pass = TextFieldPassword.getText();
		ObservableList<String> custU = FXCollections.observableArrayList("");
		ObservableList<String> custP = FXCollections.observableArrayList("");
		ObservableList<String> clogU = FXCollections.observableArrayList(user);
		ObservableList<String> clogP = FXCollections.observableArrayList(pass);
		//String custU;
		//String custP;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Connection con = DriverManager.getConnection(conURL);
			Statement st = con.createStatement();
			String SQL = "SELECT * FROM Customers";
			ResultSet rs = st.executeQuery(SQL);
			
			while (rs.next()) {
				custU.addAll(new String(rs.getObject(2).toString()));
				custP.addAll(new String(rs.getObject(3).toString()));
				
				
				
				if (custU.containsAll(clogU) && custP.containsAll(clogP)) {
					System.out.println("login SUCCESS");
					login = true;
					custUser = rs.getObject(2).toString();
					break;
				}
			}
		
			
			
		} catch (Exception ex) {
			System.out.println("oof");
			
		}
		//we need sql username and password if equals can login
		
		//String sqlUserName = "abc";
		//String sqlPassword = "1234";
		
		
		admin = false;
		
		
		
		if(login) {
			try{
				switchToMainPage(event);
			} catch(IOException ex) {
				System.out.println("OOF");
			}
		} else{
			
			try{
				switchToLogIn(event);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
			
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));	
			//root = loader.load();
		}	
	}
	
	public void handlePasswordReset(ActionEvent event) {
		try{
			switchToRegistration(event);
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	
	
	

	

}

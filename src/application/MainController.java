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

public class MainController implements Initializable{

	//no sql is needed here
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String customerUser;
	private boolean admin;
	
	
	
	public void initData(String customer, boolean admin1) {
		customerUser = customer;
		admin = admin1;
		System.out.println(admin);
	}
	
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
	
	public void switchToSplashScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSecurityQuestions(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("ResetPassword.fxml"));
		Parent root2 = (Parent) fxmlLoader2.load();
		Stage stage2 = new Stage();
		stage2.setScene(new Scene(root2)); 
		stage2.setResizable(false);
		stage2.initModality(Modality.APPLICATION_MODAL);
		stage2.show();
	}
	
	public void switchToAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Account.fxml"));
        Parent parent3 = loader.load();
        
        //access the controller and call a method
        AccountController controller = loader.getController();
        controller.initData(customerUser, admin);
        
        Scene scene3 = new Scene(parent3);
        

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene3);
        window.show();
	}
	
	public void switchToBooked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Booking.fxml"));
        Parent parent3 = loader.load();
        
        //access the controller and call a method
        BookingController controller = loader.getController();
        controller.initData(customerUser, admin);
        
        Scene scene3 = new Scene(parent3);
        

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene3);
        window.show();
	}
	
	
	public void handleAvailableFlight(ActionEvent event) {
		try{
			switchToSplashScreen(event);
		} catch(IOException ex){
			System.out.println("Shux");
		}
	}
	
	public void handleSignOut(ActionEvent event) {
		try{
			switchToSplashScreen(event);
		} catch(IOException ex){
			System.out.println("Shux");
		}
	}
	
	public void handlePasswordReset(ActionEvent event) {
		try{
			switchToSecurityQuestions(event);
		} catch(IOException ex){
			System.out.println("Shux");
		}
	}
	
	


}

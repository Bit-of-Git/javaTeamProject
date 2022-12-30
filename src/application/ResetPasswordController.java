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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import java.sql.*;
import Commons.Customer;


public class ResetPasswordController extends LogInContoller implements Initializable{
	
	@FXML public TextArea answ;
	@FXML public TextField use;
	@FXML public TextField pass1;
	@FXML public TextField pass2;
	public String sqlAnswer;
	public String sqlUserName;
	public String sqlSecurityQuestion;
	public String password1;
	public String password2;
	public String selec1 = "option";
	
	@FXML private ComboBox securityQuestion;
	
	public void initialize(URL url, ResourceBundle rb) {
		String o1 = "";
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		Connection con = DriverManager.getConnection(conURL);
		Statement st = con.createStatement();
		String SQL = "SELECT * FROM Customers";
		ResultSet rs = st.executeQuery(SQL);
		
		try {
		
		String selec2 = "option2";
		
		//updates security question ComboBox as start with options of selec1 and selec2
		//We need to pull security questions from sql and place them into selec1 and selec2
		
		
		String user = getUser();
		
		
		while (rs.next()) {
			String dataName = o1.valueOf(rs.getObject(2).toString());
			
			if(dataName.equals(user)) {
			selec1 = o1.valueOf(rs.getObject(10).toString());
			}
		}
		
		securityQuestion.getItems().addAll(selec1, selec2);
		} catch (Exception ex) {
			System.out.println("oof");
		} finally {
			st.close();
		}
		}catch(Exception ex) {
			System.out.println("oof2");
		}
	}
	
	
	
	public void handleResetPassword(ActionEvent event){
		
		String o1 = "";
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		Connection con = DriverManager.getConnection(conURL);
		Statement st = con.createStatement();
		String SQL = "SELECT * FROM Customers";
		ResultSet rs = st.executeQuery(SQL);
		
		try {
		
		//enter sql customer values into corresponding variables
		
		password1 = pass1.getText();
		password2 = pass2.getText();
		String user = getUser();
		
		
		while (rs.next()) {
			String dataName = o1.valueOf(rs.getObject(2).toString());
			
			if(dataName.equals(user)) {
			sqlAnswer = o1.valueOf(rs.getObject(11).toString());
			}
		}
		
		
		} catch (Exception ex) {
			System.out.println("oof");
		}
		
		
		
		sqlUserName = getUser();
		sqlSecurityQuestion = selec1;
		
		
		

		
		
		
		//use some kind of loop to check if the entered username security question and answer equal any of the entries in the database
		
		
		//for

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
			String sql = "UPDATE Customers SET CusPassword = ? where CusUsername = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pass1.getText());
			ps.setString(2, sqlUserName);
			ps.execute();
			
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
			}finally {
				st.close();
			}
		}
		}catch(Exception ex) {
			System.out.println("oof");
		}
	}
		
	
	
	public void handleExit(ActionEvent event){
		Stage stage;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	

	
	

}

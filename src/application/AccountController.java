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
import javafx.fxml.FXML;


public class AccountController implements Initializable{
	@FXML private TableView<Flight> tableView;
	@FXML private TableColumn<Flight, Integer> flightIDColumn;
	@FXML private TableColumn<Flight, Integer> flightNumColumn;
	@FXML private TableColumn<Flight, Integer> capacityColumn;
	@FXML private TableColumn<Flight, Integer> costColumn;
	@FXML private TableColumn<Flight, String> dayColumn;
	@FXML private TableColumn<Flight, String> toColumn;
	@FXML private TableColumn<Flight, String> fromColumn;
	@FXML private TableColumn<Flight, String> arriveTimeColumn;
	@FXML private TableColumn<Flight, String> leavingTimeColumn;
	
	@FXML private ComboBox flightSelections;
	@FXML private ComboBox adminSelections;
	
	@FXML private TextField location;
	@FXML private TextField destination;
	@FXML private TextField flightIDSearch;
	
	public void initialize(URL url, ResourceBundle rb) {
		flightIDColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("flightID"));
		flightNumColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("flightNum"));
		capacityColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("capacity"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("cost"));
		dayColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("day"));
		toColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("to"));
		fromColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("from"));
		arriveTimeColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("arriveTime"));
		leavingTimeColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("leavingTime"));
		
		tableView.setItems(getFlights());
		
		// needs to display applicable flight numbers shown to what was initialized on screen
		
		int numEntries = 3;
		int[] lst = new int[numEntries];
		
		for(int i = 0; i < numEntries; i++) {
			flightSelections.getItems().add(lst[i]);
		}
		
		//check for whether admin or not
		boolean admin = true;
		
		if(admin) {
			
			String selec1 = "Book";
			String selec2 = "Add";
			String selec3 = "Delete";
			
			adminSelections.getItems().addAll(selec1, selec2, selec3);
			
		} else {
			String selec1 = "Book";
			adminSelections.getItems().addAll(selec1);
		}
		
		
	}
	
	public ObservableList<Flight> getFlights(){
		//int numRows;
		
		//numRows = length of SQL query for initial data
		
		//use loop to add values use sql query in loop to set vars
		/*
		for(int i = 0, i < numRows, i++) {
			ObservableList<Flight> flights = FXCollections.observableArrayList();
			flights.add(new flights(flightIDVar, toVar, fromVar, arriveTimeVar, leavingTimeVar))
		}
		*/
		
		Integer flightIDVar = 1;
		Integer flightNumVar = 1;
		Integer capacityVar = 1;
		Integer costVar = 1;
		String dayVar = "4/25/2022";
		String toVar = "Atlanta";
		String fromVar = "Chicago";
		String arriveTimeVar = "4:00 PM";
		String leavingTimeVar = "2:00 PM";
		//Delete below and use for loop in tandem with sql query
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		flights.add(new Flight(flightIDVar, flightNumVar, capacityVar, costVar, dayVar, toVar, fromVar, arriveTimeVar, leavingTimeVar));
		
		return flights;
	}
	
	/*public ObservableList<Flight> select(EventAction event){
		
	}
	
	public void submit(ActionEvent event){
		if(adminSelections.getValue().equals("Book")) {
			
		}
		
		if(adminSelections.getValue().equals("Add")) {
			
		}
		
		if(adminSelections.getValue().equals("Delete")) {
			
		}
	} */
}
 
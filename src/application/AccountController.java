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
import java.util.ArrayList;



public class AccountController implements Initializable{
	@FXML private TableView<Flight> tableView;
	@FXML private TableColumn<Flight, Integer> flightIDColumn;
	@FXML private TableColumn<Flight, Integer> flightNumColumn;
	@FXML private TableColumn<Flight, Integer> capacityColumn;
	@FXML private TableColumn<Flight, Double> costColumn;
	@FXML private TableColumn<Flight, String> dayColumn;
	@FXML private TableColumn<Flight, String> toColumn;
	@FXML private TableColumn<Flight, String> fromColumn;
	@FXML private TableColumn<Flight, String> arriveTimeColumn;
	@FXML private TableColumn<Flight, String> leavingTimeColumn;
	
	@FXML private ComboBox<String> adminSelections;
	
	@FXML private TextField location;
	@FXML private TextField destination;
	@FXML private TextField flightIDSearch;
	
	
	@FXML private TextField toText;
	@FXML private TextField fromText;
	@FXML private TextField departureText;
	@FXML private TextField arrivalText;
	@FXML private TextField dayText;
	@FXML private TextField flightIDText;
	@FXML private TextField flightNumText;
	@FXML private TextField capacityText;
	@FXML private TextField costText;
	
	
	public void initialize(URL url, ResourceBundle rb) {
		flightIDColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("flightID"));
		flightNumColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("flightNum"));
		capacityColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer> ("capacity"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Flight, Double> ("cost"));
		dayColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("day"));
		toColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("to"));
		fromColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("from"));
		arriveTimeColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("arriveTime"));
		leavingTimeColumn.setCellValueFactory(new PropertyValueFactory<Flight, String> ("leavingTime"));
		
		tableView.setItems(getFlights());
		
		//We need the customer ID, check for whether admin or not
		int customerIDFromSQL = (int) (Math.random() * 2);
		boolean admin = false; 
		
		if(customerIDFromSQL == 0) {
			admin = true;
		}
		
		
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
		int numRows;
		
		
		numRows = 10;
		//numRows = length of SQL query for initial data
		
		//use loop to add values use sql query in loop to set vars
		/*
		for(int i = 0, i < numRows, i++) {
			ObservableList<Flight> flights = FXCollections.observableArrayList();
			flights.add(new flights(flightIDVar, toVar, fromVar, arriveTimeVar, leavingTimeVar))
		}
		*/

		
		int flightIDVar = 1;
		int flightNumVar = 1;
		int capacityVar = 1;
		double costVar = 1;
		String dayVar = "4/25/2022";
		String toVar = "Atlanta";
		String fromVar = "Chicago";
		String arriveTimeVar = "4:00 PM";
		String leavingTimeVar = "2:00 PM";
		//Delete below and use for loop in tandem with sql query
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
		return flights;
	}
	
	public void search(ActionEvent event) {
		//need numm flights
		//need all flight data. Make into matrix
		
		int numFlights;
		numFlights = 10;
		
		
		//get all dta entries from sql place all entries in folloing variables and usd place in observable list using below function
		// iterate with wiht loop
		/*
				int flightIDVar
				int flightNumVar
				int capacityVar
				double costVar
				String dayVar
				String toVar
				String fromVar
				String arriveTimeVar
				String leavingTimeVar
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
		 */
		
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		ObservableList<Flight> flights1 = FXCollections.observableArrayList();
		boolean boo1 = false;

		
		for(int i = 0; i < numFlights; i++) {
			if(i == 0){
				int rand;
				int flightIDVar = i;
				int flightNumVar = (int)(Math.random() + 1) * 1000;
				int capacityVar = 0;
				double costVar = 100;
				String dayVar = "4/25/2022";
				String toVar = "Atlanta";
				String fromVar = "Chicago";
				String arriveTimeVar = "4:00 PM";
				String leavingTimeVar = "2:00 PM";
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
			} else if(i<7) {
				int rand;
				int flightIDVar = i;
				int flightNumVar = (int)(Math.random() + 1) * 1000;
				int capacityVar = 15 * (int)(Math.random() + 0);
				double costVar = 100;
				String dayVar = "4/25/2022";
				String toVar = "Atlanta";
				String fromVar = "Chicago";
				String arriveTimeVar = "4:00 PM";
				String leavingTimeVar = "2:00 PM";
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
			} else {
				int flightIDVar = i;
				int flightNumVar = 1;
				int capacityVar = 1;
				double costVar = 1;
				String dayVar = "4/25/2022";
				String toVar = "New York";
				String fromVar = "Boston";
				String arriveTimeVar = "4:00 PM";
				String leavingTimeVar = "2:00 PM";
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
			}
		}
		//loop over the selected rows
        for (Flight flight: flights) {
        	boolean boo = true;
        	
        	int flightIDVar = -1;
        	
        	
	        try{
	        	flightIDVar = Integer.parseInt(flightIDText.getText());
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
        	
        		
        	if(location.getText().trim().isEmpty() || destination.getText().trim().isEmpty() || flightIDSearch.getText().trim().isEmpty()) {
        		boo1 = true;
        	} 
        	if(flight.getFlightID() == flightIDVar && flight.getTo() == location.getText() && destination.getText() == flight.getFrom()) {
        		
        	} else {
        		boo = false;
        	}
        	
        	if(boo1) {
        		
        	} else {
        		if(boo) {
        			flights1.add(flight);
        		} else {
        			
        		}
        	}
		}
        
        if(boo1) {
        	
        } else {
        	tableView.setItems(flights1);
        }
        
	}
	public void submit(ActionEvent event){
		if(adminSelections.getValue().equals("Book")) {
		        ObservableList<Flight> selectedRows, allFlights;
		        allFlights = tableView.getItems();
		        
		        //this gives us the rows that were selected
		        selectedRows = tableView.getSelectionModel().getSelectedItems();
		        
		        //loop over the selected rows
		        for (Flight flight: selectedRows)
		        {

		        	if(flight.getCapacity() == 0) {
		        		try{
		        			switchToError(event);
		        		} catch(IOException ex) {
		        			
		        		}
		        	} else if(false) {
		        		
		        		//get all flight ids run a loop and see if the flight ID is equal to any of those in the query may use below line
		        		// if(!flight.getFlightID().equals(sql query))
		        		
		        	} else {
		        	
			        	System.out.println("Booking made");
			        	//use following getters to create a row in SQL returning got values
			        	// remember cost is a double type treat accordingly
			        	
			        	/*
			        	flight.getFlightID()
			        	flight.getFlightNum()
			        	flight.getCapacity()
			        	flight.getCost()
			        	flight.getArriveTime()
			        	flight.getTo()
			        	flight.getFrom()
			        	flight.getDay()
						*/
		        	}

		        }
		    }
		    
		    
		
		
		if(adminSelections.getValue().equals("Add")) {
			{
					
				int flightIDVar;
				int flightNumVar;
				int capacityVar;
				double costVar;
				String dayVar;
				String toVar;
				String fromVar;
				String arriveTimeVar;
				String leavingTimeVar;
				
				flightIDVar = 0;
				flightNumVar = 0;
				capacityVar = 0;
				costVar = 0;
				
		       
		        try{
		        	flightIDVar = Integer.parseInt(flightIDText.getText());
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		        
		        try{
		        	flightNumVar = Integer.parseInt(flightNumText.getText());
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		        
		        try{
		        	capacityVar = Integer.parseInt(capacityText.getText());
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		        
		        try{
		        	costVar = Integer.parseInt(costText.getText());
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		        
		        
				toVar =  toText.getText();
				fromVar = fromText.getText();
				leavingTimeVar = departureText.getText();
				arriveTimeVar =  arrivalText.getText();
				dayVar = dayText.getText();
				
				
		        if(leavingTimeVar !="" && arriveTimeVar !="" && toVar !="" && fromVar !="" && dayVar !="" && flightIDVar !=0 && flightNumVar !=0 && capacityVar !=0 && costVar!=0) {
			        Flight newFlight = new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar);
			        tableView.getItems().add(newFlight);

		        }

		    }
		}
		
		if(adminSelections.getValue().equals("Delete")) {
		    {
		        ObservableList<Flight> selectedRows, allFlights;
		        allFlights = tableView.getItems();
		        
		        //this gives us the rows that were selected
		        selectedRows = tableView.getSelectionModel().getSelectedItems();
		        
		        //loop over the selected rows and remove the Person objects from the table
		        for (Flight flight: selectedRows)
		        {
		        	allFlights.remove(flight);
		        }
		    }
		    
		    
		}
	} 

	
	public void switchToSplashScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToMainPage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root); 
		stage.setScene(scene);
		stage.show();
	}
	
	public void handleSignOut(ActionEvent event){
		try {
			switchToSplashScreen(event);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void handleBackToMain(ActionEvent event){
		try {
			switchToMainPage(event);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void switchToError(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
 
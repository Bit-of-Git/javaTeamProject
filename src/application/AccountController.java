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
import java.lang.reflect.Array;

import javafx.scene.Node;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.scene.control.TitledPane;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import java.time.format.DateTimeFormatter;




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
	@FXML private DatePicker datePicker;
	@FXML private TextField departureTime;
	
	
	@FXML private TextField toText;
	@FXML private TextField fromText;
	@FXML private TextField departureText;
	@FXML private TextField arrivalText;
	@FXML private TextField dayText;
	@FXML private TextField flightIDText;
	@FXML private TextField flightNumText;
	@FXML private TextField capacityText;
	@FXML private TextField costText;
	@FXML private TitledPane title;
	@FXML private Label labe1;
	
	

	private String customerUser;
	private boolean admin;
	
	
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
		
		
	}
	
	public ObservableList<Flight> getFlights(){
		//int numRows;
		
		
		//numRows = 10;
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Connection con = DriverManager.getConnection(conURL);
			Statement st = con.createStatement();
			String SQL = "SELECT * FROM flightinfo";
			ResultSet rs = st.executeQuery(SQL);
			
			
			while(rs.next()) {
				flights.add(new Flight(rs.getObject(6).toString(), rs.getObject(7).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(), 
						rs.getObject(3).toString(), rs.getInt(1), rs.getInt(2), 
						rs.getInt(9), rs.getDouble(10)));
			}

			
			
			} catch (Exception e) {
				System.out.println("oof");
			}
			return flights;
		//numRows = length of SQL query for initial data
		
		//use loop to add values use sql query in loop to set vars
		/*
		for(int i = 0, i < numRows, i++) {
			ObservableList<Flight> flights = FXCollections.observableArrayList();
			flights.add(new flights(flightIDVar, toVar, fromVar, arriveTimeVar, leavingTimeVar))
		}
		*/

		
	/*	int flightIDVar = 1;
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
		return flights;*/
	}
	
	public void search(ActionEvent event) {
		//need numm flights
		//need all flight data. Make into matrix
		
		//MM-dd-yyyy this is what date picker gives back
		
		int flightIDVar;
		int flightNumVar;
		int capacityVar;
		ArrayList<Integer> counter = new ArrayList<>();
		int counter1;
		double costVar;
		String dayVar;
		String toVar;
		String fromVar;
		String arriveTimeVar;
		String leavingTimeVar;
		int numFlights;
		boolean start = true;
		numFlights = 10;
		LocalDate date; 
		String formattedDate;
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Connection con = DriverManager.getConnection(conURL);
			Statement st = con.createStatement();
			String SQL = "SELECT * FROM flightinfo";
			ResultSet rs = st.executeQuery(SQL);
			
			
			while(rs.next()) {
				flights.add(new Flight(rs.getObject(6).toString(), rs.getObject(7).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(), 
						rs.getObject(3).toString(), rs.getInt(1), rs.getInt(2), 
						rs.getInt(9), rs.getDouble(10)));
			}
			
			} catch (Exception e) {
				System.out.println("oof");
			}
		
		
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
		
		//ObservableList<Flight> flights = FXCollections.observableArrayList();
		ArrayList<Flight> flights0 = new ArrayList<>();
		ObservableList<Flight> flights1 = FXCollections.observableArrayList();
		boolean locationBoolean = true;
		boolean destinationBoolean = true;
		boolean departureTimeBoolean = true;
		boolean dateBoolean = true;
		boolean idSearchBoolean = true;
		
		/*for(int i = 0; i < numFlights; i++) {
			if(i == 0){
				flightIDVar = i;
				flightNumVar = (int)(Math.random() + 1) * 1000;
				capacityVar = 0;
				costVar = 100;
				dayVar = "03-05-2023";
				toVar = "Atlanta";
				fromVar = "Chicago";
				arriveTimeVar = "16:00";
				leavingTimeVar = "14:00";
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
			} else if(i<7) {
				flightIDVar = i;
				flightNumVar = (int)(Math.random() + 1) * 1000;
				capacityVar = 15 * (int)(Math.random() + 0);
				costVar = 100;
				dayVar = "03-05-2023";
				toVar = "Atlanta";
				fromVar = "Chicago";
				arriveTimeVar = "16:00";
				leavingTimeVar = "14:00";
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
			} else {
				flightIDVar = i;
				flightNumVar = 1;
				capacityVar = 1;
				costVar = 1;
				dayVar = "03-05-2023";
				toVar = "New York";
				fromVar = "Boston";
				arriveTimeVar = "16:00";
				leavingTimeVar = "14:00";
				flights.add(new Flight(leavingTimeVar, arriveTimeVar, toVar, fromVar, dayVar, flightIDVar, flightNumVar, capacityVar, costVar));
			}
		}*/
		
    	if(location.getText().isEmpty()) {
    		locationBoolean = false;
    	} else {
    		if(start) {
                for (Flight flight: flights) {
                	if(location.getText().equalsIgnoreCase(flight.getFrom())) { 
                		flights0.add(flight);
                	} 
        		}
                start = false;
    		} else {
    			counter.clear();
        		counter1 = 0;
                for (Flight flight: flights0) {
                	if(location.getText().equalsIgnoreCase(flight.getFrom())) { 
                		
                	} else {
                		counter.add(counter1);
                	}
                	counter1 = counter1 + 1;
        		}
                
                for(int i = counter.size() - 1; i >= 0; i--) {
                	flights0.remove(counter.get(i).intValue());
                }
    		}

    	}
    	
    	if(destination.getText().isEmpty()) {
    		destinationBoolean = false;
    	} else {
    		if(start) {
                for (Flight flight: flights) {
                	if(destination.getText().equalsIgnoreCase(flight.getTo())) { 
                		flights0.add(flight);
                	} 
        		}
                start = false;
    		} else {
    			counter.clear();
        		counter1 = 0;
                for (Flight flight: flights0) {
                	if(destination.getText().equalsIgnoreCase(flight.getTo())) { 

                	} else {
                		counter.add(counter1);
                	}
                	counter1 = counter1 + 1;
        		}
                
                for(int i = counter.size() - 1; i >= 0; i--) {
                	flights0.remove(counter.get(i).intValue());
                }
    		}

    	}
    	
    	if(datePicker.getValue() == null) {
    		dateBoolean = false;
    	} else {
			date = datePicker.getValue();
			formattedDate = date.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
    		if(start) {
                for (Flight flight: flights) {
                	if(formattedDate.toString().replace("-", " ").equalsIgnoreCase(flight.getDay().replace(",", "").replace(".", ""))) { 
                		flights0.add(flight);
                	} 
        		}
                start = false;
    		} else {
    			counter.clear();
    			counter1 = 0;
                for (Flight flight: flights0) {
                	
                	if(formattedDate.toString().replace("-", " ").equalsIgnoreCase(flight.getDay().replace(",", "").replace(".", ""))) { 

                	} else {
                		counter.add(counter1);
                	}
                	counter1 = counter1 + 1;
        		}
                
                for(int i = counter.size() - 1; i >= 0; i--) {
                	flights0.remove(counter.get(i).intValue());
                }
    		}

    	}
    	
    	if(departureTime.getText().isEmpty()) {
    		departureTimeBoolean = false;
    	} else {
    		if(start) {
                for (Flight flight: flights) {
                	if(departureTime.getText().equalsIgnoreCase(flight.getLeavingTime())) { 
                		flights0.add(flight);
                	} 
        		}
                start = false;
    		} else {
    			counter.clear();
    			counter1 = 0;
                for (Flight flight: flights0) {
                	if(departureTime.getText().equalsIgnoreCase(flight.getLeavingTime())) { 

                	} else {
                		counter.add(counter1);
                	}
                	counter1 = counter1 + 1;
        		}
                
                for(int i = counter.size() - 1; i >= 0; i--) {
                	flights0.remove(counter.get(i).intValue());
                }
    		}

    	}
    	
    	if(flightIDSearch.getText().isEmpty()) {
    		idSearchBoolean = false;
    	} else {
    		if(start) {
                for (Flight flight: flights) {
                	flightIDVar = -1;
                    
        	        try{
        	        	flightIDVar = Integer.parseInt(flightIDSearch.getText());
                    	if(flight.getFlightID() == flightIDVar) { 
                    		flights0.add(flight);
                    	} 
        	        }
        	        catch (NumberFormatException ex){
        	            ex.printStackTrace();
        	        }


        		}
                start = false;
    		} else {
    			counter.clear();
    			counter1 = 0;
                for (Flight flight: flights0) {
                	flightIDVar = -1;
                    
        	        try{
        	        	flightIDVar = Integer.parseInt(flightIDSearch.getText());
                    	if(flight.getFlightID() == flightIDVar) { 

                    	} else {
                    		counter.add(counter1);
                    	}
                    	counter1 = counter1 + 1;
        	        }
        	        catch (NumberFormatException ex){
        	            ex.printStackTrace();
        	        }
        	        

        		}
                
                for(int i = counter.size() - 1; i >= 0; i--) {
                	flights0.remove(counter.get(i).intValue());
                }
    		}

    	}
    	
    	
    	
		
        if(locationBoolean || idSearchBoolean || departureTimeBoolean || dateBoolean || destinationBoolean) {
        	for(Flight flight: flights0) {
        		flights1.add(flight);
        	}
        	tableView.setItems(flights1);
        } 
        
        
	}
	
	
	
	public void submit(ActionEvent event){
		if(adminSelections.getValue().equals("Book")) {
		        ObservableList<Flight> selectedRows, allFlights;
		        allFlights = tableView.getItems();
		        
		        //this gives us the rows that were selected
		        selectedRows = tableView.getSelectionModel().getSelectedItems();
		        
		        
		        String date = "";
		        ObservableList<String> cflightU = FXCollections.observableArrayList();
				ObservableList<Flight> finalFlights = FXCollections.observableArrayList();
				ObservableList<Flight> flights = FXCollections.observableArrayList();
				ObservableList<String> fID = FXCollections.observableArrayList();
		        
		        try {
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
				Connection con = DriverManager.getConnection(conURL);
				Statement st1 = con.createStatement();
				
				
				
				
				
				String SQL2 = "SELECT * from FlightInfo JOIN Booking on FlightInfo.flightID = Booking.FlightID";
				ResultSet rs2 = st1.executeQuery(SQL2);
				
				
				while(rs2.next()) {
					cflightU.add(new String(rs2.getObject(13).toString()));
					
 					if(cflightU.contains(customerUser)) {
						finalFlights.add(new Flight(rs2.getObject(6).toString(), rs2.getObject(7).toString(), rs2.getObject(4).toString(), rs2.getObject(5).toString(), 
								rs2.getObject(3).toString(), rs2.getInt(1), rs2.getInt(2), 
								rs2.getInt(9), rs2.getDouble(10)));
						fID.add(new String(rs2.getObject(1).toString()));
						
						
					}
					flights.clear();
					cflightU.clear();
				}	
				
		        //loop over the selected rows
		        for (Flight flight: selectedRows)
		        {
		        	int ID = flight.getFlightID();
		        	String IDr;
		        	IDr = Integer.toString(ID);
		        	
		        	
		        	
		        	
		        	
		        	if(flight.getCapacity() == 0) {
		        		try{
		        			switchToError(event);
		        		} catch(IOException ex) {
		        			
		        		}
		        	} else if(fID.contains(IDr)) {
		        		
		        		
		        		//get all flight ids run a loop and see if the flight ID is equal to any of those in the query may use below line
		        		// if(!flight.getFlightID().equals(sql query))
		        		
		        		
		        		
		        		switchToOverlap(event);
		        		
		        	} else {
		        	
		        		switchToFlightBooked(event);
		        		try {
		    				
		    				
		    					 //code 
		    				PreparedStatement stmt = con.prepareStatement("INSERT INTO Booking(BookID, flightID, Username) VALUES (?,?,?)");
		    				
		    				Statement st = con.createStatement();
		    				String SQL = "SELECT * FROM Booking";
		    				ResultSet rs = st.executeQuery(SQL);
		    				ObservableList<String> BookID = FXCollections.observableArrayList("");
		    				while(rs.next()) {
		    					BookID.addAll(new String(rs.getObject(1).toString()));
		    				}
		    				
		    				int x = BookID.size();
		    				int count = x;
		    				
		    				String c = String.valueOf(count);
		    				
		    				stmt.setString(1, c);
		    				stmt.setInt(2, flight.getFlightID());
		    				stmt.setString(3, customerUser);
		    				
		    				stmt.execute();
		    				
		    				
		    				
		    				} catch (Exception e) {
		    					System.out.println("oof");
		    					System.out.println(e);
		    				}
		    			
		    		}
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
			        	flight.getDay()*/
						
		        		
		        	}

		        }catch(Exception e) {
		        	
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
		        	costVar = Double.parseDouble(costText.getText());
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

	public void initData(String customer, boolean admin1) {
		customerUser = customer;
		admin = admin1;
		//System.out.println(admin);
		
		//We need the customer ID, check for whether admin or not

		if(admin) {
			String selec1 = "Book";
			String selec2 = "Add";
			String selec3 = "Delete";
			
			adminSelections.getItems().addAll(selec1, selec2, selec3);
			
		} else {
			String selec1 = "Book";
			adminSelections.getItems().addAll(selec1);
	
			toText.setVisible(false);
			fromText.setVisible(false);
			departureText.setVisible(false);
			arrivalText.setVisible(false);
			dayText.setVisible(false);
			flightIDText.setVisible(false);
			flightNumText.setVisible(false);
			capacityText.setVisible(false);
			costText.setVisible(false);
			title.setVisible(false);
			
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent parent3 = loader.load();
        
        //access the controller and call a method
        MainController controller = loader.getController();
        controller.initData(customerUser, admin);
        
        Scene scene3 = new Scene(parent3);
        

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene3);
        window.show();
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
		try {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Error.fxml"));
			Parent root1 = (Parent) fxmlLoader1.load();
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(root1)); 
			stage1.setResizable(false);
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
			
		} catch(Exception e) {
			System.out.println("Shux");
		}
	}
	
	public void switchToFlightBooked(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("FlightBooked.fxml"));
			Parent root1 = (Parent) fxmlLoader1.load();
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(root1)); 
			stage1.setResizable(false);
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
			
		} catch(Exception e) {
			System.out.println("Shux");
		}

	}
	
	public void switchToOverlap(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Overlap.fxml"));
			Parent root1 = (Parent) fxmlLoader1.load();
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(root1)); 
			stage1.setResizable(false);
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
			
		} catch(Exception e) {
			System.out.println("Shux");
		}

	}
}
 
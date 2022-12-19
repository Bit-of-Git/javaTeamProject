package Database;

public class statements {
	/* this doesnt actually return anything, these are just the statements to be used for the gui/other codes. 
	needs to be imported into other code to work properly!!
	sorted by use type commented before use
	Database names are Admin, CBooking, Customers, FlightInfo, UpdateFlight, Abooking
	
	currently a wip
	*/

	//select

	
	public static final String getCustomerSecurityQ = "Select CusQuestion from Customers where CusUsername = '?'";
	public static final String getAdminSecurityQ = "Select AdmQuestionfrom from Admin where AdmUsername = '?'";
	
	public static final String getCustomerSecurityA = "Select CusAnswer from Customers where CusUsername = '?'";
	public static final String getAdminSecurityA = "Select AdmAnswer from Admin where AdmUsername = '?'";
	
	public static final String GetCustomerPassword = "Select CusPassword from Customers where CusUsername = '?'";
	public static final String GetAdminPassword = "Select AdmPassword from Admin where AdmUsername = '?'";
	
	//insert
	public static final String BookCustomerFlight = "Insert into CBooking(BookingID, flightID, CusUsername) Values (%d,%d,'%s');";
	
	public static final String BookAdminFlight = "Insert into ABooking(BookingID, flightID, AdmUsername) Values (%d,%d,'%s');";
	
	public static final String UserRegistration = "Insert into Customers (CusSSN,CusUsername, CusPassword,CusFirstName, CusLastName, CusAddress, CusZip, CusState,CusEmail, CusQuestion, CusAnswer)"
			+ " VALUES (?, '?', '?', '?','?','?', ?,'?', '?','?','?');";
	
	public static final String addFlight = "Insert into FlightInfo (FlightID, FlightNumber,flightDate, Destination, Departure,Takeoff, Arrival, totalseats, seatsAvailable, price)"
			+ " VALUES (%d,'%s', '%s', '%s', '%s', '%s', '%s', %d, %d, %d);"; // this one may need to be worked on and may not work
	
	
	//search
	
	public static final String RecoverCustomer = "Select CusPassword from Customers where CusUsername = '?' AND CusAnswer = '?';";
	public static final String RecoverAdmin = "Select AdmPassword from Admin where AdmUsername = '?' AND AdmAnswer = '?';";
	
	public static final String showAllFlights = "Select * from flightInfo";
	
	//update
	public static final String updateFlight = "Update dbo.FlightInfo \n"
			+ "SET FlightNumber='%s',flightDate='%s',Destination='%s',Departure='%s',Takeoff='%s',Arrival='%s',totalseats=%d,seatsAvailable=%d,price=%d \n"
			+ "WHERE FlightID=%d;";
	
	//delete
	
	public static final String deleteFlight = "Delete from dbo.FlightInfo where FlightID=%d;"; //flightID is pk, will delete entire row
	public static final String deleteAdminBooking = "Delete from dbo.ABooking where BookingID=%d;"; //pk, will delete entire row
	public static final String deleteCustomerBooking = "Delete from dbo.CBooking where BookingID=%d;"; //pk, will delete entire row		

	
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//this gets prices from the database
public class querytest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		 String user = "pleasework@idiashroud";
		 String pass = "GSUCIS3270!";
		 ResultSet resultSet = null; // the results you want
		 try (
			 Connection con = DriverManager.getConnection(conURL, user, pass);
			 Statement statement = con.createStatement();){ //creates statement
			 String selectSQL = "Select * from dbo.flightInfo"; //sql statement
			 resultSet = statement.executeQuery(selectSQL);
			 while (resultSet.next()) {
				 //System.out.println("FlightID | flightNumber "); this prints it for each result, put above while
				 System.out.println(resultSet.getString(1) + "|" + resultSet.getString(2));//prints results
			 }
			 
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
	} 
}

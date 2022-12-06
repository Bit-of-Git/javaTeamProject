package Commons;
import java.sql.*;
public class queries {
	public static void viewTable(Connection con) throws SQLException {
	    String query = "select Takeoff, Arrival, Destination, Departure, flightDate, flightID, flightNum, totalseats,"
	    		+ "Price";
	    try (Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	        String leavingTime = rs.getString("Takeoff");
	        String arriveTime = rs.getString("Arrival");
	        String to = rs.getString("Destination");
	        String from = rs.getString("Departure");
	        String day = rs.getString("flightDate");
	        int flightID = rs.getInt("flightID");
	        int flightNum = rs.getInt("flightNum");
	        int capacity = rs.getInt("totalseats");
	        float cost = rs.getFloat("Price");
	       System.out.println(leavingTime + ", " + arriveTime + ", " + to +
	                           ", " + from + ", " + day + flightID + ", " + flightNum + ", " + capacity + ", " + ", " + cost);
	      }
	    } catch (SQLException e) {
	      System.out.println(e);
	    }
	  }
}



//leavingTime, arriveTime, to, from, day, flightID, flightNum, capacity, cost
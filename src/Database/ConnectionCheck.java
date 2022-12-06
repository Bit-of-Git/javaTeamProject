package Database;
import java.sql.*;
import java.util.ArrayList;
 
//checks against the database for passwords & usernames and flights

public class ConnectionCheck {
	public static Connection getConnection() throws Exception{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/3306","root","root");
		return connection;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

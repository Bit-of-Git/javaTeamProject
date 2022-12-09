package Database;
import java.sql.*;
public class ConnectionCheck {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		 String user = "pleasework@idiashroud";
		 String pass = "GSUCIS3270!";
		 try (Connection con = DriverManager.getConnection(conURL, user, pass);){	 
			 //code 
			 System.out.println("yay! I'm connected!");
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
	} 
}

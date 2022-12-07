package Database;

import java.sql.*;

public class connectionv2 {
	public connectionv2() throws Exception, SQLException{
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 String conURL = "jdbc:sqlserver://idiashroud.database.windows.net:1433;database=Project;user=pleasework@idiashroud;password=GSUCIS3270!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		 String user = "pleasework@idiashrout";
		 String pass = "GSUCIS3270!";
		 Connection con = null;
		 try {
			 con = DriverManager.getConnection(conURL, user, pass);
			 System.out.print("aaa");
		 } catch (Exception e)
		 { System.out.print("Failed to connect");}
	}
}

package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtility  {
	public static DBConnectionUtility dbConn = null;
	public static Connection connection =null;
	public synchronized static DBConnectionUtility getInstance() throws SQLException {
		if(dbConn == null) {
			dbConn = new DBConnectionUtility();
		}
		return dbConn;
	}
	public  Connection getConnection() throws SQLException {
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewOnlineBusBooking","root","Avasanth@11");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
		
	}
	

}

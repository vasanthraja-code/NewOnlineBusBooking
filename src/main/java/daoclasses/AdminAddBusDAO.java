package daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import utility.DBConnectionUtility;

public class AdminAddBusDAO {
	public boolean addBusDetails(String bus_name,String route_from,String route_to,String departure_time,String arrival_time,int total_seats,int available_seats){
		String query="insert into Bus(bus_name,route_from,route_to,departure_time,arrival_time,total_seats,available_seats) values(?,?,?,?,?,?,?)";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        try {
            // Parse the string to LocalTime
            LocalTime localTime = LocalTime.parse(departure_time, formatter);
            LocalTime localTime1=LocalTime.parse(arrival_time,formatter);
            // Convert LocalTime to SQL Time
            Time sqlTime = Time.valueOf(localTime);
            Time sqlTime1=Time.valueOf(localTime1);
            System.out.println("SQL Time: " + sqlTime);
            Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, bus_name);
			ps.setString(2, route_from);
			ps.setString(3, route_to);
			ps.setTime(4, sqlTime);
			ps.setTime(5, sqlTime1);
			ps.setInt(6,total_seats);
			ps.setInt(7, available_seats);
        
			int rows=ps.executeUpdate();
			if(rows>0) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (DateTimeParseException e) {
            System.out.println("Error parsing time string: " + e.getMessage());
        }
        return false;
		
	}

}

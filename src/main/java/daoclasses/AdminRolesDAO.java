package daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utility.DBConnectionUtility;

public class AdminRolesDAO {
	public boolean addBus() {
		String sql="insert into Bus(bus_name,route_from,route_to,departure_time,arrival_time,total_seats,available_seats)values(?,?,?,?,?,?,?);
				//"TranzKing Travels","Tenkasi","Chennai","2024-05-16 19:40:00","2024-05-17 7:40:00",36,36
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, sql);
			
		}
	}
	
	

}

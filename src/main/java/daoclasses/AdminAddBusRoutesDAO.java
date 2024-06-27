package daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.JSONArray;

import utility.DBConnectionUtility;

public class AdminAddBusRoutesDAO {
	public boolean addBus(int route_id,String json,int bus_id) {
		String query="insert into routes(route_id,routes,bus_id)values(?,?,?)";
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, route_id);
			ps.setString(2, json);
			ps.setInt(3, bus_id);
			int rows=ps.executeUpdate();
			if(rows>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

	
}

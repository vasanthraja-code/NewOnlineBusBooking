package daoclasses;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utility.DBConnectionUtility;

public class ReservationDAO {
	
	public JSONObject searchBuses(String from,String to,String date) {
		String sql="SELECT * FROM Reservation WHERE journey_from=? AND journey_to=? AND journey_date=?";
		JSONObject jsonObj=new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, from);
			ps.setString(2, to);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(date);
            Date sqlDate = new Date(parsedDate.getTime());
            System.out.println("SQL Date: " + sqlDate);
            ps.setDate(3, sqlDate);
	        
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				JSONObject json=new JSONObject();
				json.put("reservation_id", rs.getInt("reservation_id"));
				json.put("journey_from", rs.getString("journey_from"));
				json.put("journey_to", rs.getString("journey_to"));
				json.put("reserved_date",rs.getString("reserved_date"));
				json.put("journey_date", rs.getString("journey_date"));
				json.put("fare", rs.getInt("fare"));
				jsonArray.put(json);	
			}
			
			jsonObj.put("status", true);
			jsonObj.put("data", jsonArray);
			
		} catch (Exception e) {
			try {
				jsonObj.put("status", false);
			} catch (JSONException e1) {
			
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return jsonObj;
		
	}
}

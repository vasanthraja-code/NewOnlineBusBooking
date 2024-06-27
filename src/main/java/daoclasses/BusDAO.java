package daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utility.DBConnectionUtility;

public class BusDAO {
	
		JSONArray jsonArray=new JSONArray();
		JSONObject json=new JSONObject();
		/*public void insertBusEntries(String bus_name,String route_from,String route_to) {
			String query="insert into eachBusTrips(trip_id,bus_id,available_seats,departure_time,arrival_time,journey_date)values(?,?,?,?,?,?)";
			try {
				Connection con=DBConnectionUtility.getInstance().getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				ps.setDate(1, date);
				ps.setInt(2, bus_id);
				int rows=ps.executeUpdate();
				System.out.println(rows +" rows affected");
				
			}
			catch(Exception e){
				e.printStackTrace();
				
			}	
			
		}*/
		public JSONObject showBuses(String from,String to,String date) {
			String sql="Select * from Bus where route_from=? and route_to=? and journey_date=?";
			
			LocalDate providedDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
			LocalDate currentDate=LocalDate.now();
			LocalDate maxDate = currentDate.plusDays(30);
			System.out.println(providedDate.isAfter(currentDate));
			System.out.println(providedDate.isAfter(maxDate));
			if(providedDate.isAfter(currentDate)&& !(providedDate.isAfter(maxDate))) {
				java.sql.Date sqlDate = java.sql.Date.valueOf(providedDate);
				
				try {
					Connection con = DBConnectionUtility.getInstance().getConnection();
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,from);
					ps.setString(2,to);
					ps.setDate(3,sqlDate);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						JSONObject jsonObj=new JSONObject();
						jsonObj.put("bus_id", rs.getInt("bus_id"));
						//insertDate(sqlDate,rs.getInt("bus_id"));
						jsonObj.put("bus_name", rs.getString("bus_name"));
						jsonObj.put("route_from", rs.getString("route_from"));
						jsonObj.put("route_to",rs.getString("route_to"));
						jsonObj.put("departure_date_time", rs.getTime("departure_time"));
						jsonObj.put("arrival_date_time", rs.getTime("arrival_time"));
						jsonObj.put("total_seats", rs.getInt("total_seats"));
						jsonObj.put("available_seats", rs.getInt("available_seats"));
						jsonObj.put("journey_date", rs.getDate("journey_date"));
						jsonArray.put(jsonObj);
					}
					json.put("status", true);
					json.put("data", jsonArray);
					
				} catch (Exception e) {
					try {
						json.put("status", false);
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("Please Enter the Valid Date, Bus Not Available");
			}
			
			return json;
			
			
			
		}
		
		
		
	
}

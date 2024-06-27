package daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBConnectionUtility;

public class AdminLogInDAO {
	public boolean adminLogin(String email,String password) {
		String sql="select * from AdminLogin where email=? and passcode=?";
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}

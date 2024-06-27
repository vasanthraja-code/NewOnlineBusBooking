package daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dtoclasses.SignUpDTO;
import utility.DBConnectionUtility;

public class SignUpDAO {
	
	public  boolean signUp(String username,String email,String phone,String password) {
		String sql="insert into userDetails(user_name,email,phone_number,passcode) values(?,?,?,?)";
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3,phone);
			ps.setString(4,password);
			int rows=ps.executeUpdate();
			System.out.println("rows"+rows);
			if(rows>0) {
				SignUpDTO obj=new SignUpDTO(username,email,phone,password);
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public void getDetails() {
		String sql="Select * from userDetails";
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				String name=rs.getString("user_name");
				String email=rs.getString("email");
				String phone=rs.getString("phone_number");
				String password=rs.getString("passcode");
				SignUpDTO obj=new SignUpDTO(name,email,phone,password);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int alreadyUser(String email,String phone) {
		String sql="select * from userDetails where email=? and phone_number=? ";
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2, phone);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}

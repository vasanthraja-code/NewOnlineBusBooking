package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBConnectionUtility;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		int type=2;
		System.out.println(phone.equals("9999999999"));
		System.out.println(password.equals("admin@123"));
		if(phone.equals("9999999999") && password.equals("admin@123")) {
			type=1;
			
		}
		
		try {
			Connection con = DBConnectionUtility.getInstance().getConnection();
			String sql="select * from userDetails where phone_number=? and passcode=? and role_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,phone);
			ps.setString(2,password);
			ps.setInt(3, type);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String getPhone=rs.getString(4);
				String getPassword=rs.getString(5);
				int get_role_id=rs.getInt(6);
				System.out.println(getPhone+" "+getPassword);
				if(phone.equals(getPhone) && password.equals(getPassword) && get_role_id == 2 ) {
					PrintWriter out=response.getWriter();
					out.println("success");
					break;
				}
				else if(phone.equals(getPhone) && password.equals(getPassword) && get_role_id == 1) {
					PrintWriter out=response.getWriter();
					out.println("admin");
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
		

}

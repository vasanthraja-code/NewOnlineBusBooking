package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBConnectionUtility;

/**
 * Servlet implementation class PassengerServlet
 */
@WebServlet("/PassengerServlet")
public class PassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String sql="insert into Passengers(passenger_name,gender,age,phone_number)values(?,?,?,?)";
		try {
			Connection con=DBConnectionUtility.getInstance().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setInt(3,age);
			ps.setString(4,phone);
			int rows=ps.executeUpdate();
			PrintWriter out=response.getWriter();
			out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

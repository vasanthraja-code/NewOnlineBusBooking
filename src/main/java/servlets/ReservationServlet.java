package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import daoclasses.ReservationDAO;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String date=request.getParameter("date");
		ReservationDAO obj=new ReservationDAO();
		JSONObject json=obj.searchBuses(from, to, date);
		PrintWriter out=response.getWriter();
		out.println(json);	
		
	}

}

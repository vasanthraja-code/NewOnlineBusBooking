package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoclasses.AdminAddBusDAO;

/**
 * Servlet implementation class AdminAddBusServlet
 */
@WebServlet("/AdminAddBusServlet")
public class AdminAddBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bus_name=request.getParameter("bus_name");
		String route_from=request.getParameter("route_from");
		String route_to=request.getParameter("route_to");
		String departure_time=request.getParameter("departure_time");
		String arrival_time=request.getParameter("arrival_time");
		int total_seats=Integer.parseInt(request.getParameter("total_seats"));
		int available_seats=Integer.parseInt(request.getParameter("available_seats"));
		AdminAddBusDAO obj=new AdminAddBusDAO();
		if(obj.addBusDetails(bus_name, route_from, route_to, departure_time, arrival_time, total_seats, available_seats)) {
			PrintWriter out=response.getWriter();
			out.println("success");
		}
	}

}

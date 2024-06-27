package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import daoclasses.AdminAddBusRoutesDAO;

/**
 * Servlet implementation class AdminBusRoutesServlet
 */
@WebServlet("/AdminBusRoutesServlet")
public class AdminBusRoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int route_id=Integer.parseInt(request.getParameter("route_id"));
		int bus_id=Integer.parseInt(request.getParameter("bus_id"));
		String str=request.getParameter("json");
		System.out.println(str);
		AdminAddBusRoutesDAO obj=new AdminAddBusRoutesDAO();
		if(obj.addBus(route_id,str,bus_id)) {
			PrintWriter out=response.getWriter();
			out.println("Success");
		}
	}

}

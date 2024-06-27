package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoclasses.SignUpDAO;
import dtoclasses.SignUpDTO;
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		System.out.println(username+" "+email+" "+phone+" "+password);
		SignUpDAO obj=new SignUpDAO();
		PrintWriter out=resp.getWriter();
		if(obj.alreadyUser(email, phone) == 1) {
			out.print("alreadyUser");
		}
		else if(obj.signUp(username, email, phone, password)){
			out.print("success");	
		}
			
		
		
		
			
	}

}

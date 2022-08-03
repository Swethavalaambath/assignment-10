package bank;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			
		
			Connection con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/geeksforgeeks","root","root");

			PreparedStatement ps = con.prepareStatement
						("insert into gfglogin values(?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			int i = ps.executeUpdate();
			
			if(i > 0) {
				out.println("You are successfully registered at geeksforgeeks");
			}
		
		}
		catch(Exception se) {
			se.printStackTrace();
		}
	
	}
}


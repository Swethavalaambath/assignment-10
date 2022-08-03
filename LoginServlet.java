package bank;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet{
		private static final long serialversionUid=1L;
		public void init() {System.out.println("from servlet init..");}
		public void dopost(HttpServletRequest request,HttpServletResponse response) throws IOException{
			String username=request.getParameter("username");
			String Password=request.getParameter("password");
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			PreparedStatement pstmt=conn.prepareStatement("Select * from usertable where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, Password);
			ResultSet rs=pstmt.executeQuery();
			if( rs.next()){System.out.println("welcome"+username);
			}
			else {System.out.println("enter right credentials");
			}
			
			}catch (SQLException e)
			{e.printStackTrace();}
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("HI..<br/>");
			out.println("username:"+username+"<br/>");
			out.println("password:"+Password);
		}
	}
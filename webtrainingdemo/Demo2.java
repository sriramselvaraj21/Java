package webtrainingdemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login servlet called");

		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//System.out.println(username);
		//System.out.println(password);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");
			
			
			String query = "select * from user_info where uname = ?";
			PreparedStatement stmt =con.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				//System.out.println(rs.getString(3));
				int flag = rs.getInt(3);
				if(flag == 0) {
					System.out.println("asdass");
					String updatequery = "update user_info set flag = ? where uname = ?";
					PreparedStatement updatestmt = con.prepareStatement(updatequery);
					updatestmt.setInt(1, 1);
					updatestmt.setString(2, username);
					int i = updatestmt.executeUpdate();
					if (i > 0) {
						System.out.println("updated successfully");
						response.sendRedirect("http://localhost:8080/web/welcome.html");
					}
				}else if(flag == 1) {
					response.sendRedirect("http://localhost:8080/web/alreadyloggedin.html");
				}	
			
			}else {
				response.sendRedirect("http://localhost:8080/web/Registration.html");

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

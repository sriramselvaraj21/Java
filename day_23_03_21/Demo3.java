package day_23_03_21;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Demo3
 */
public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("registration servlet called");

		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String flag = "0";
		// System.out.println(username);
		// System.out.println(password);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");

			String query = "insert into user_info values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, flag);

			int i = stmt.executeUpdate();
			if (i > 0) {
				System.out.println("registered successfully");
				response.sendRedirect("http://localhost:8080/web/Login.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

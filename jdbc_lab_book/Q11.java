package jdbc_lab_book;

import java.sql.*;
import java.util.Enumeration;

public class Q11 {
	public static void main(String st1[]) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "<password>");

		Enumeration e = DriverManager.getDrivers();
		System.out.println("time taken for login " + DriverManager.getLoginTimeout());
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}

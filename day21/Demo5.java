package day21;

import java.sql.*;

public class Demo5 {
	public static void main(String[] args) throws Exception {
		// Step 1: Load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish a connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");

		System.out.println("Connection: " + conn);

		CallableStatement cs = conn.prepareCall("{call procedure(?,?)}");

		int userId = 3;
		cs.setInt(1, userId);

		cs.registerOutParameter(2, Types.VARCHAR);

		cs.execute();

		System.out.println("username of " + userId + " is " + cs.getString(2));
	}
}

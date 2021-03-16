package day21;

import java.sql.*;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		// Step 1: Load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish a connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");

		System.out.println("Connection: " + conn);

		// Step 3: Create a statement
		Statement statement = conn.createStatement();

		// Step 4: Write SQL query
		String stmt = "select * from users;";

		// Step 5: Read and process result set
		ResultSet rs = statement.executeQuery(stmt);

		ResultSetMetaData rsMeta = rs.getMetaData();
		int columns = rsMeta.getColumnCount();

		for (int i = 1; i <= columns; i++) {
			System.out.print(rsMeta.getColumnName(i) + "\t");
		}
		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
	}
}

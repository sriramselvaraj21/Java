package day21;

import java.sql.*;

import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		// Step 1: Load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish a connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");

		System.out.println("Connection: " + conn);

		// Step 3: Write SQL query
		String query = "select * from users where userId = ? and username = ?;";

		// Step 4: Create a prepared statement -> dynamic
		PreparedStatement preparedStatement = conn.prepareStatement(query);

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter userId: ");
			int userId = sc.nextInt();
			System.out.print("Enter username: ");
			String username = sc.next();

			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, username);

			// Step 5: Read and process result set
			ResultSet rs = preparedStatement.executeQuery();

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
			sc.close();
		}
	}
}

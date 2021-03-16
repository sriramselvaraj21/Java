package jdbc_lab_book;

import java.sql.*;

public class Q3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "<password>");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from users");
			ResultSetMetaData rsmd = rs.getMetaData();
			int noOfColumns = rsmd.getColumnCount();
			for (int i = 1; i <= noOfColumns; i++) {
				String c = rsmd.getColumnName(i);
				String c1 = rsmd.getColumnTypeName(i);
				String c2 = rsmd.getColumnLabel(i);// gets the designated column title for printout. if it is not given,
													// it gives column name.
				System.out.println("columne name " + c + " type name " + c1 + " label " + c2);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package jdbc_lab_book;

import java.sql.*;

public class Q9 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "<password>");

			String query = "select * from users where uid=?";
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, 3);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				System.out.print(rs.getInt(1) + "\t"); // the columns starts from 1
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString("upass") + "\t");
				System.out.print(rs.getInt("flag") + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

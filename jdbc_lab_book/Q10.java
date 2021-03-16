package jdbc_lab_book;

import java.sql.*;

public class Q10 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "<password>");

			String query = "insert into users values (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, 4);
			st.setString(2, "arun");
			st.setString(3, "wolf");
			st.setInt(4, 0);

			st.execute();
			ResultSet rs2 = st.executeQuery("select * from users");

			while (rs2.next()) {
				System.out.print(rs2.getInt(1) + "\t"); // the columns starts from 1
				System.out.print(rs2.getString(2) + "\t");
				System.out.print(rs2.getString("upass") + "\t");
				System.out.print(rs2.getInt("flag") + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

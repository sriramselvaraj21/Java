package jdbc_lab_book;

import java.sql.*;

public class Q8 {
	public static void main(String str[]) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/coda3", "root", "<password>");
			Statement st = con.createStatement();
			st.executeUpdate("update  sam set name='iniah' where age=31");
			st.executeUpdate("update  sam set name='uhdap' where age=41");
			ResultSet rs = st.executeQuery("select * from sam");
			System.out.println("name " + "\t\t age");
			while (rs.next()) {
				String e1 = rs.getString(1);
				int e = rs.getInt(2);
				System.out.println("name = " + e1 + "\t age = " + e);
			}
			st.close();
			con.close();
			System.out.println("records successfully  updatedd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

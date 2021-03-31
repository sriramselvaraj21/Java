package shoppingapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersInfoDAOImpl implements UsersInfoDAO {

	public static UsersInfoDAOImpl getUserInfoDAOImpl() {
		return new UsersInfoDAOImpl();
	}

	@Override
	public UsersInfoDTO getUserInfoDTO(int id) {
		try {
			UsersInfoDTO usersInfoDTO = new UsersInfoDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users_info where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usersInfoDTO.setCustomerNumber(0);
				usersInfoDTO.setCustomerUsername(rs.getString(2));
				usersInfoDTO.setCustomerPassword(rs.getString(3));
				usersInfoDTO.setCustomerFlag(rs.getInt(4));
			}
			return usersInfoDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UsersInfoDTO usersInfoDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertUser(UsersInfoDTO usersInfoDTO) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into users_info (customer_no,username,c_password,flag) values (?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, usersInfoDTO.getCustomerUsername());
			ps.setString(3, usersInfoDTO.getCustomerPassword());
			ps.setInt(4, usersInfoDTO.getCustomerFlag());
			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public UsersInfoDTO getUserByName(String username, String password) {
		UsersInfoDTO usersInfoDTO = null;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users_info where username=? and c_password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			usersInfoDTO = new UsersInfoDTO();
			if (rs.next()) {
				usersInfoDTO.setCustomerNumber(0);
				usersInfoDTO.setCustomerUsername(rs.getString(2));
				usersInfoDTO.setCustomerPassword(rs.getString(3));
				usersInfoDTO.setCustomerFlag(rs.getInt(4));
				return usersInfoDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public int updateUserFlag(String username, String password, int flag) {
		try {
			System.out.println("update user flag method called");
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update users_info set flag = ? where username = ? and c_password = ?");
			ps.setInt(1, flag);
			ps.setString(2, username);
			ps.setString(3, password);
			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			return 0;
		}
	}

}

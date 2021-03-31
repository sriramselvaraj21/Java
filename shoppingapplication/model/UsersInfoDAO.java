package shoppingapplication.model;

public interface UsersInfoDAO {
	public UsersInfoDTO getUserInfoDTO(int id);
	public int deleteUser(int id);
	public int updateUser(UsersInfoDTO userDTO);
	public int insertUser(UsersInfoDTO userDTO);
	public UsersInfoDTO getUserByName(String uname,String password);
}

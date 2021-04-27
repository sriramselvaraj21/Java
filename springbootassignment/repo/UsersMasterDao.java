package com.daomodel;

import java.util.List;

import com.model.UsersMasterDto;

public interface UsersMasterDao {
	public boolean insertUsersDetails(UsersMasterDto UsersDetails);
	public boolean updateUsersDetails(UsersMasterDto UsersDetails);
	public boolean deleteUsersDetails(int userId);
	public UsersMasterDto findUserByName(String userName,String password);
	public UsersMasterDto findUserById(int  userId);
	public List<UsersMasterDto> getAllUsersDetails();
}

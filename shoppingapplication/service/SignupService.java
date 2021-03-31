package shoppingapplication.service;

import model.UsersInfoDAOImpl;
import model.UsersInfoDTO;

public class SignupService {
	private static SignupService signupServiceInstance = null;

	public static SignupService getSignupService() {
		if (signupServiceInstance == null) {
			signupServiceInstance = new SignupService();
		}
		return signupServiceInstance;
	}

	public void insertUserInfo(String username, String password) {
		UsersInfoDAOImpl usersInfoDAO = UsersInfoDAOImpl.getUserInfoDAOImpl();
		UsersInfoDTO userInfoDTO = new UsersInfoDTO();
		userInfoDTO.setCustomerNumber(0);
		userInfoDTO.setCustomerUsername(username);
		userInfoDTO.setCustomerPassword(password);
		userInfoDTO.setCustomerFlag(0);
		usersInfoDAO.insertUser(userInfoDTO);
	}
}

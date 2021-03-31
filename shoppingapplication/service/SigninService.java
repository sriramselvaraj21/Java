package shoppingapplication.service;

import model.UsersInfoDAOImpl;
import model.UsersInfoDTO;

public class SigninService {
	public SigninService() {
	}

	private static SigninService loginServiceInstance = null;

	public static SigninService getSigninService() {
		if (loginServiceInstance == null) {
			loginServiceInstance = new SigninService();
		}
		return loginServiceInstance;
	}

	public boolean checkExistingUser(String name, String password) {
		UsersInfoDAOImpl usersInfoDAO = UsersInfoDAOImpl.getUserInfoDAOImpl();
		UsersInfoDTO usersInfoDTO = usersInfoDAO.getUserByName(name, password);
		if (usersInfoDTO == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkAlreadyLogged(String name, String password) {
		System.out.println("checkisonline");
		UsersInfoDAOImpl usersInfoDAO = UsersInfoDAOImpl.getUserInfoDAOImpl();
		UsersInfoDTO usersInfoDTO = usersInfoDAO.getUserByName(name, password);
		if (usersInfoDTO.getCustomerFlag() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void updateFlag(String username, String password, int flag) {
		System.out.println("login service called update flaggg called");
		UsersInfoDAOImpl usersInfoDAO = UsersInfoDAOImpl.getUserInfoDAOImpl();
		usersInfoDAO.updateUserFlag(username, password, flag);
	}
}

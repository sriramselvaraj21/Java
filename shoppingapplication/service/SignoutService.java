package shoppingapplication.service;



import model.UsersInfoDAOImpl;

public class SignoutService {
	private static SignoutService signoutServiceInstance = null;

	public static SignoutService getSignoutService() {
		if (signoutServiceInstance == null) {
			signoutServiceInstance = new SignoutService();
		}
		return signoutServiceInstance;
	}

	public SignoutService() {
		// TODO Auto-generated constructor stub
	}

	public void updateFlag(String username, String password, int flag) {
		System.out.println("signout service update flag called");
		UsersInfoDAOImpl usersInfoDAO = UsersInfoDAOImpl.getUserInfoDAOImpl();
		usersInfoDAO.updateUserFlag(username, password, flag);
		
	}
}

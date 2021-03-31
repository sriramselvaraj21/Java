package shoppingapplication.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SigninService;

public class SigninAction extends Action {
	public SigninAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = null;
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		SigninService loginService = SigninService.getSigninService();

		if (loginService.checkExistingUser(username, password)) {
			if (!loginService.checkAlreadyLogged(username, password)) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				loginService.updateFlag(username, password, 1);
				result = "signin.success";
			} else {
				result = "signin.already";
			}
		} else {
			result = "signin.failure";
		}
		return result;
	}

}

package shoppingapplication.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SignupService;

public class SignupAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		SignupService registerService = SignupService.getSignupService();

		registerService.insertUserInfo(username, password);
		session.setAttribute("name", username);
		session.setAttribute("password", password);

		return "signup.success";
	}

}

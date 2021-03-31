package shoppingapplication.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SignoutService;

public class SignoutAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Signout Action called");
		String result = null;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		System.out.println(username + "   " + password);
		SignoutService service = SignoutService.getSignoutService();
		service.updateFlag(username, password, 0);

		result = "signout.success";
		return result;
	}

}

package shoppingapplication.model;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.SignoutService;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created....");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destroyed...");
		HttpSession session = se.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		if (username != null) {
			SignoutService service = SignoutService.getSignoutService();
			service.updateFlag(username, password, 0);
		}
	}

}

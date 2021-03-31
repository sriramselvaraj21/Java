package shoppingapplication.model;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LanguageAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String language = request.getParameter("language");

		ResourceBundle rb = ResourceBundle.getBundle("model.Dictionary", new Locale(language));

		HttpSession session = request.getSession();

		session.setAttribute("rb", rb);
		
		return "language.selected";
	}
}

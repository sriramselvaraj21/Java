package shoppingapplication.contoller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestProcessor rp = new RequestProcessor();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String file = config.getInitParameter("config");
		String path = config.getServletContext().getRealPath(file);
		config.getServletContext().setAttribute("path", path);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Action Servlet called GET method");
		rp.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Action Servlet called Post method");
		doGet(request, response);
	}

}

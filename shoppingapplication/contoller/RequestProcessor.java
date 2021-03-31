package shoppingapplication.contoller;

import java.io.FileInputStream;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor {
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext application = request.getServletContext();

			System.out.println("Request Processor called");

//			System.out.println("username" + request.getParameter("username"));
//			System.out.println("password" + request.getParameter("password"));
//			
			String path = (String) application.getAttribute("path");
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			String formname = request.getParameter("formname");
			if (formname == null) {
				System.out.println("form name is null");
			} else {
				System.out.println("form name : " + request.getParameter("formname"));
				String className = prop.getProperty(formname);
				System.out.println("Where to go : " + className);
				model.Action action = (model.Action) Class.forName(className).getConstructor().newInstance();
				String result = action.execute(request, response);
				String page = prop.getProperty(result);
				System.out.println("class name : " + className + " page : " + page);
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

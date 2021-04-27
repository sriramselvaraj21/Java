package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	public LoginService ls;

	@RequestMapping(value="authenticate",method = RequestMethod.POST)
	public String getForm(HttpServletRequest request) {
		String username=(String)request.getParameter("uname");
		String password=(String)request.getParameter("upass");
		HttpSession session=request.getSession();
		if(ls.checkUser(username, password)) {
			if(ls.checkFlag(username, password)==1) {
				return "Busy";
			}else {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("id", ls.getUserId(username, password));
				ls.updateFlag(username, password, 1);
				return "Welcome1";
			}
		}else {
			return "Register";
		}
	}
	
}

package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.LoginService;

@Controller
@RequestMapping("logout")
public class LogoutController {
	@Autowired
	private LoginService ls;
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("username");
		String upass=(String)session.getAttribute("password");
		String flag=(String)session.getAttribute("adminFlag");
		ls.updateFlag(uname, upass, 0);
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("id");
		session.invalidate();
		if(flag!=null) {
			return "AdminLogin";
		}else {
			return "index";
		}
		
	}
}

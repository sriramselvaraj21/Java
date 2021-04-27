package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.service.LoginService;

@Controller
@RequestMapping("adminlogin")
public class AdminLoginController {
	@Autowired
	private LoginService ls;
	@RequestMapping(value="authenticate",method=RequestMethod.POST)
	public ModelAndView authenticate(ModelAndView mandv,HttpServletRequest request) {
		String username=(String)request.getParameter("uname");
		String password=(String)request.getParameter("upass");
		String role=(String)request.getParameter("urole");
		HttpSession session=request.getSession();
		if(ls.checkUser(username, password)) {
			if(ls.checkFlag(username, password)==1) {
				mandv.setViewName("Busy");
				//return mandv;
			}else {
				if(role.equals("1")) {
					if(ls.checkAdmin(username, password)) {
						//admin page
						System.out.println("Admin----------"+ls.checkAdmin(username, password));
						mandv.setViewName("AdminDashboard");
						
					}else {
						//admin login page
						mandv.setViewName("AdminLogin");
					}
				}else {
					if(ls.checkManager(username, password)) {
						//manager page
						mandv.setViewName("ManagerDashboard");
					}else {
						mandv.setViewName("AdminLogin");
					}
				}
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("id", ls.getUserId(username, password));
				session.setAttribute("adminFlag","true");
				ls.updateFlag(username, password, 1);
				//return "Welcome1";	
				
			}
		}else {
			mandv.setViewName("AdminLogin");
		}
		
		return mandv;
	}
}

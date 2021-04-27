package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formbeans.RegisterBean;
import com.service.RegisterService;

@Controller
@Transactional
@RequestMapping("register")
public class RegisterController {
	@Autowired
	private RegisterService rs;
	
	@RequestMapping(value="adduser",method = RequestMethod.POST)
	public String addUser(HttpServletRequest request) {
		RegisterBean rb=new RegisterBean();
		rb.setUsername((String)request.getParameter("uname"));
		rb.setPassword((String) request.getParameter("upass")); 
		rb.setAddress( (String)request.getParameter("address"));
		rb.setEmail((String)request.getParameter("email"));  
		rb.setPhone((String)request.getParameter("phone")); 
		if(rs.addUserAndCustomer(rb)) {
			return "Login";
		}else {
			return "Register";
		}
	}
}

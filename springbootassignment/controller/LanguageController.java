package com.controller;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("language")
public class LanguageController {
	
	@RequestMapping("load")
	public String test(HttpServletRequest request) {
		String language=request.getParameter("language");
	ResourceBundle rb=ResourceBundle.getBundle("com.utils.languages.Dictionary",new Locale(language));
		HttpSession session=request.getSession();
		session.setAttribute("rb", rb);
		return "Login";
	}
}

package com.cms.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "controllerOfWeb")
public class HomeController {

	@GetMapping(value = "login.html")
	public ModelAndView loginPage()
	{
		ModelAndView mav= new ModelAndView("login");
		return mav;
	}
	@GetMapping(value = "register.html")
	public ModelAndView registerPage()
	{
		ModelAndView mav=new ModelAndView("register");
		return mav;
	}
	@GetMapping(value = "/logout.html")
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("login");
	}
}

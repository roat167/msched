package edu.mum.swe.msched.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.swe.msched.service.UserService;


@Controller
public class LoginController extends GenericController {
	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginForm(ModelMap model) {
		model.addAttribute("view","login");		
		return "dashboard";		
	}
	
	@RequestMapping(value="/loginSucess")
	public String loginSucess(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		return getView(model, "welcome");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logoutPage(Model model,HttpServletRequest request, HttpServletResponse response) {		 
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			setMessage(model, "Logged out successfully");
			return getView(model, "login");
	 }
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(Model model, String error, String logout) {
//		if (error != null)
//			model.addAttribute("error", "Your username and password is invalid.");
//
//		if (logout != null)
//			model.addAttribute("message", "You have been logged out successfully.");
//		
//		return "login";
//	}

}

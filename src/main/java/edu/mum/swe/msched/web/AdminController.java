package edu.mum.swe.msched.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController extends GenericController {
	
	@RequestMapping(value={"/dashboard"}, method = RequestMethod.GET)
	public String dashboard(Model model){
		return "adminDashboard";
		
	}
	

}

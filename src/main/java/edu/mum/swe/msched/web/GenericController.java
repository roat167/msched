package edu.mum.swe.msched.web;

import org.springframework.ui.Model;

public class GenericController {
	private static final String VIEW_ATTRIBUTE_NAME = "view";
	private static final String VIEW_DASHBOARD = "dashboard";
	private static final String VIEW_ATTRIBUTE_MSG = "message";	

	public String getView(Model model, String view) {
		model.addAttribute(VIEW_ATTRIBUTE_NAME, view);
		return VIEW_DASHBOARD;
	}

	public void setMessage(Model model, String message) {
		model.addAttribute(VIEW_ATTRIBUTE_MSG, message);
	}

}

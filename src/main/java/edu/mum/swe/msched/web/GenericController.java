package edu.mum.swe.msched.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

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
	
	public void setMessage(Model model, String message, String cssStyle) {
		model.addAttribute(VIEW_ATTRIBUTE_MSG, message);
		model.addAttribute("msgstyle", cssStyle);
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}

	public static String getCurrentUsername() {
		return ((Authentication)  SecurityContextHolder.getContext().getAuthentication()).getName();
	}
}

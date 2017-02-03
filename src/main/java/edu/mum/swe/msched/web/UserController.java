package edu.mum.swe.msched.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.swe.msched.domain.User;
import edu.mum.swe.msched.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController extends GenericController {
	private static final String ATTRIBUTE = "user";
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return getView(model, "welcome");
	}

	@RequestMapping(value = "/profile/contact", method = RequestMethod.GET)
	public String showProfile(Model model) {
		User user = userService.getCurrentUser();
		model.addAttribute(ATTRIBUTE, user);
		return getView(model, "profile/profileForm");
	}

	@RequestMapping(value = "/profile/contact", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute(ATTRIBUTE) @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return getView(model, "profile/profileForm");
		}
		userService.save(user);
		model.addAttribute(ATTRIBUTE, user);
		setMessage(model, "Save successfully");
		return getView(model, "profile/profileForm");
	}

}


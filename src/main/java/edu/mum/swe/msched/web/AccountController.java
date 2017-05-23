package edu.mum.swe.msched.web;

import javax.validation.Valid;

import edu.mum.swe.msched.domain.Account;
import edu.mum.swe.msched.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class AccountController extends GenericController {
	private static final String ATTRIBUTE = "user";
	@Autowired
	private AccountService userService;

	@RequestMapping(value = { "/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		return getView(model, "welcome");
	}

	@RequestMapping(value = "/profile/contact", method = RequestMethod.GET)
	public String showProfile(Model model) {
		Account account = userService.getCurrentUser();
		model.addAttribute(ATTRIBUTE, account);
		return getView(model, "profile/profileForm");
	}

	@RequestMapping(value = "/profile/contact", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute(ATTRIBUTE) @Valid Account account, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return getView(model, "profile/profileForm");
		}
		userService.save(account);
		model.addAttribute(ATTRIBUTE, account);
		setMessage(model, "Save successfully");
		return getView(model, "profile/profileForm");
	}
	
	@RequestMapping(value = "/aboutus" , method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return getView(model, "aboutUs");
	}

}


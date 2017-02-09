package edu.mum.swe.msched.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.service.EntryService;

@Controller
@RequestMapping(value = "/entry")
public class EntryController extends GenericController {
	private static final String MODEL_ATTRIBUTE = "entry";
	private static final String VIEW_LIST = "entry/entryList";
	private static final String VIEW_FORM = "entry/entryForm";

	@Autowired
	EntryService entryService;

	@RequestMapping(value = { "/list", "" }, method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("entries", entryService.getAllEntries());
		return getView(model, VIEW_LIST);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam long id, Model model) {
		Entry entry = entryService.findEntryById(id);
		model.addAttribute(MODEL_ATTRIBUTE, entry);
		return getView(model, VIEW_FORM);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Entry entry, Model model) {
		model.addAttribute("view", VIEW_FORM);
		return "dashboard";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute(MODEL_ATTRIBUTE) Entry entry, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return getView(model, VIEW_FORM);
		}
		entryService.updateEntry(entry);
		model.addAttribute("entry", entry);
		setMessage(model, "save successfully");
		return "redirect:/entry";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam long id, Model model) {
		setMessage(model, "Selected item deleted successfully");

		entryService.remove(id);

		model.addAttribute("id", id);
		model.addAttribute("entries", entryService.getAllEntries());
		return new ModelAndView(getView(model, VIEW_LIST), "command", new Entry());
	}

}

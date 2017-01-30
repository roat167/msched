package edu.mum.swe.msched.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	// private static Logger logger = LogManager.getLogger();
	private static final String MODEL_ATTRIBUTE = "entry";
	private static final String VIEW_LIST = "entry/entryList";
	private static final String VIEW_FORM = "entry/entryForm";

	@Autowired
	EntryService entryService;

	@RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("entries", entryService.getAllEntries());
		return getView(model, VIEW_LIST);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam long id, Model model) {
		Entry entry = entryService.findEntryById(id);
		model.addAttribute(MODEL_ATTRIBUTE, entry);
		return new ModelAndView(getView(model, VIEW_FORM), "command", entry);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Entry entry, Model model) {
		model.addAttribute("view", VIEW_FORM);
		return "dashboard";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@ModelAttribute(MODEL_ATTRIBUTE) Entry entry, Model model) {
		// logger.info("---entry Controller called for save");
		if (entry.getEntryId() == null) {
			entryService.save(entry);
		} else {
			entryService.updateEntry(entry);
		}

		model.addAttribute("entry", entry);
		setMessage(model, "entry save successfully");
		//return new ModelAndView(getView(model, VIEW_LIST), "command", entry);
		return "redirect:/entry";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam long id, Model model) {
		setMessage(model, "Selected entry deleted successfully");

		entryService.remove(id);

		model.addAttribute("id", id);
		model.addAttribute("entries", entryService.getAllEntries());
		return new ModelAndView(getView(model, VIEW_LIST), "command", new Entry());
	}

}

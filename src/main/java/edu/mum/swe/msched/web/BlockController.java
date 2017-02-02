package edu.mum.swe.msched.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.swe.msched.domain.Block;

import edu.mum.swe.msched.service.BlockService;

@Controller
@RequestMapping(value= "/block")
public class BlockController extends GenericController {
	private static final String MODEL_ATTRIBUTE = "block";
	private static final String VIEW_LIST = "block/blockList";
	private static final String VIEW_FORM = "block/blockForm";
	@Autowired
	BlockService blockService;

	@RequestMapping(value = { "/list", "" }, method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("blocks", blockService.getAllBlocks());
		return getView(model, VIEW_LIST);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam long id, Model model) {
		Block block = blockService.findByName(id);
		model.addAttribute(MODEL_ATTRIBUTE, block);
		return getView(model, VIEW_FORM);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Block block, Model model) {
		model.addAttribute("view", VIEW_FORM);
		return "dashboard";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute(MODEL_ATTRIBUTE) Block block, Model model) {
		System.out.println("calling add Post");
		blockService.saveBlock(block);
		model.addAttribute("block", block);
		setMessage(model, "save successfully");
		return "redirect:/block";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam long id, Model model) {
		setMessage(model, "Selected item deleted successfully");

		blockService.deleteBlock(id);

		model.addAttribute("id", id);
		model.addAttribute("courses",blockService.getAllBlocks());
		return new ModelAndView(getView(model, VIEW_LIST), "command", new Block());
	}

}

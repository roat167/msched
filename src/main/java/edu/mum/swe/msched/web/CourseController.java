package edu.mum.swe.msched.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.service.CourseService;

@Controller
@RequestMapping(value = "/course")
public class CourseController extends GenericController {

	private static final String MODEL_ATTRIBUTE = "course";
	private static final String VIEW_LIST = "course/courseList";
	private static final String VIEW_FORM = "course/courseForm";
	@Autowired
	CourseService courseService;

	@RequestMapping(value = { "/list", "" }, method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("courses", courseService.getAllCourses());
		return getView(model, VIEW_LIST);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam long id, Model model) {
		Course course = courseService.findByCourseId(id);
		model.addAttribute(MODEL_ATTRIBUTE, course);
		model.addAttribute("courses", courseService.getAllCourses());
		return getView(model, VIEW_FORM);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Course course, Model model) {
		model.addAttribute("view", VIEW_FORM);
		model.addAttribute("courses", courseService.getAllCourses());
		return "dashboard";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@ModelAttribute(MODEL_ATTRIBUTE) @Valid Course course, BindingResult result,Model model) {

		if (result.hasErrors()) {
			return getView(model, VIEW_FORM);
		}
		
		if (course.mEquals(courseService.findByCourseCode(course.getCourseCode()))) {
			setMessage(model, "Duplicate couse!");
			return getView(model, VIEW_FORM);
		}
		
		if (course.mEquals(courseService.findByCourseName(course.getCourseName()))) {
			setMessage(model, "Duplicate couse!");
			return getView(model, VIEW_FORM);			
		}
		
		if (course.getId() != null && course.mEquals(courseService.findByCourseId(course.getId()))) {
			setMessage(model, "Duplicate course!");
			return getView(model, VIEW_FORM);
		}
		
		System.out.println("calling add Post");
		courseService.updateCourse(course);
		model.addAttribute("course", course);
		setMessage(model, "save successfully");
		return "redirect:/course";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam long id, Model model) {
		setMessage(model, "Selected item deleted successfully");

		courseService.deleteCourse(id);

		model.addAttribute("id", id);
		model.addAttribute("courses", courseService.getAllCourses());
		return new ModelAndView(getView(model, VIEW_LIST), "command", new Course());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Course.class, "preReqiusite", new PropertiesEditor(){
			@Override
			public void setAsText(String id) throws IllegalArgumentException {
				Course pre = courseService.findByCourseId(Long.parseLong(id));
				setValue(pre);
			}
			@Override
			public String getAsText() {
			Course pre = (Course) getValue();
			if (pre == null) return null;
			return (pre.getId() == null) ? null : String.valueOf(pre.getId());
			}
		});
		
		
	}
	
}
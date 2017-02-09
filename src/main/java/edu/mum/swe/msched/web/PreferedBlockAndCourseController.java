package edu.mum.swe.msched.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.helper.PreferedBlockHelper;
import edu.mum.swe.msched.service.CourseService;
import edu.mum.swe.msched.service.FacultyService;

@Controller
@SessionAttributes("faculty")
public class PreferedBlockAndCourseController extends GenericController {
	
	private static final String MODEL_ATTRIBUTE = "faculty";
	private static final String VIEW_PREFER_BLOCK_COURSE = "faculty/preferedBlockCourseForm";

	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private CourseService courseService;

    @RequestMapping(value = "/faculty/perfered_block_course", method = RequestMethod.GET)
    public String getPreferedBlockAndCourse(Model model) {
        String facultyName = getCurrentUsername(); 
        System.out.println("User name " + facultyName);
        Faculty faculty = facultyService.findFacultyByUserName(facultyName);
        System.out.println("Faculty = " + faculty.toString());
        //System.out.println("Blocks = [ " + faculty.getPreferedBlocks().toString() + "]");
        model.addAttribute(MODEL_ATTRIBUTE, faculty);
        model.addAttribute("courseList",courseService.getAllCourses());        
        model.addAttribute("preferedBlockList", PreferedBlockHelper.getPreferedBlockList());        
        return getView(model, VIEW_PREFER_BLOCK_COURSE);
    }
    
    @RequestMapping(value = "/faculty/prefered_block_course/edit", method = RequestMethod.POST)
    public String addPreferedBlockAndCourse(@ModelAttribute(MODEL_ATTRIBUTE) Faculty faculty, Model model) {
        System.out.println("Save prefered block and course!!!");
        if (faculty != null && faculty.getFacultyId() != null) {
            faculty = facultyService.updateFaculty(faculty.getFacultyId(), faculty);
            
            //faculty.getCourses().forEach(System.out::print);
        }      
        model.addAttribute(MODEL_ATTRIBUTE, faculty);
        model.addAttribute("courseList",courseService.getAllCourses());        
        model.addAttribute("preferedBlockList", PreferedBlockHelper.getPreferedBlockList());        
        setMessage(model, "Preferred blocks and course have been saved successfully!");
        return getView(model, VIEW_PREFER_BLOCK_COURSE);
    }
	

}

package edu.mum.swe.msched.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.swe.msched.FacultyNotEnoughException;
import edu.mum.swe.msched.constants.Constants;
import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.domain.Schedule;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.enumeration.PREFERED_BLOCK;
import edu.mum.swe.msched.service.CourseService;
import edu.mum.swe.msched.service.EntryService;
import edu.mum.swe.msched.service.FacultyService;
import edu.mum.swe.msched.service.ScheduleService;

/**
 * Created by acer-usrpu on 1/30/2017.
 */

@Controller
public class ScheduleController extends GenericController {

    private Entry currentEntry;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
    Calendar cal = Calendar.getInstance();

    Model model;

    @Autowired
    private EntryService entryService;

    @Autowired
    private ScheduleService scheduleService;	

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/generate-schedule",method = RequestMethod.POST)
    public String createSchedule(@RequestParam long entryId, Model model ){
        this.model = model;
        this.currentEntry = entryService.findEntryById(entryId);
        currentEntry.getBlocks().clear();
        try {
            currentEntry.getBlocks().addAll(createBlock(currentEntry));
            Schedule schedule = new Schedule();
            schedule.setEntry(currentEntry);
            scheduleService.save(schedule);
        }catch (FacultyNotEnoughException e){
            model.addAttribute("schedules",scheduleService.findAllSchedule());
            model.addAttribute("entries",entryService.getAllEntries());
            return getView(model,"schedule/generate-schedule");
        }

        model.addAttribute("entry",currentEntry);
        model.addAttribute("blocks",currentEntry.getBlocks());
        model.addAttribute("message","created new schedule");
        return "redirect:/generate-schedule";
    }

    @RequestMapping(value = "/generate-schedule",method = RequestMethod.GET)
    public String showScheduleForm( Model model ){

        model.addAttribute("entries",entryService.getAllEntries());
        model.addAttribute("schedules",scheduleService.findAllSchedule());
        return getView(model,"schedule/generate-schedule");
    }


    public List<Block> createBlock(Entry entry) throws FacultyNotEnoughException {
        List<Block> blockList = new ArrayList<Block>();

        Date initDate = null;

        for (int i=1; i<= Constants.BLOCKS+1;i++){
            Block block = new Block();
            block.setEntry(entry);
            int month;
            if(initDate==null){
                Date entryDate = entry.getEntryDate();
                block.setStartDate(entryDate);
                this.cal.setTime(entryDate);
                 month = cal.get(Calendar.MONTH);

                block.setName(dateFormat.format(entry.getEntryDate()));
                cal.add(Calendar.DATE, Constants.NO_OF_DAYS_IN_BLOCK);
                block.setEndDate(cal.getTime());
                initDate = cal.getTime();
            }
            else{
                block.setStartDate(initDate);
                this.cal.setTime(initDate);
                 month = cal.get(Calendar.MONTH);
                cal.add(Calendar.DATE, Constants.NO_OF_DAYS_IN_BLOCK);
                block.setEndDate(cal.getTime());
                block.setName(dateFormat.format(initDate));
                initDate = cal.getTime();
            }
            this.createSection(block,month+1,i);
            blockList.add(block);

        }
        return blockList;
    }


    public Set<Section> createSection(Block block,int monthNo,int blockNo){
        Set<Section> sections = new HashSet<>();
        Section section = null;


        int totalStudents = block.getEntry().getFppStudentNum()+block.getEntry().getMppStudentNum()+ block.getEntry().getLocalStudentNum();

        int requiredSection = (int) Math.ceil((double)totalStudents/Constants.STUDENT_PER_SECTION);

        List<Faculty> availableFaculties = facultyService.findFacultyByPreferedBlock(PREFERED_BLOCK.values()[monthNo-1])	;
        System.out.println("block:"+blockNo+" month:"+monthNo+" reqBlo:"+requiredSection);
        System.out.println("students:"+totalStudents+",sections:"+requiredSection+"facul:"+availableFaculties);

        int totalAvialableFaculties = availableFaculties.size();
//        if(totalAvialableFaculties < requiredSection && blockNo <=1 )
//        {
//
//            String message;
//            if(totalAvialableFaculties<=0)
//                message = totalAvialableFaculties +" "+blockNo+ " "+requiredSection+" No faculties in the system for this entry, please add faculties <a href=\"/faculty/add\">here</a>";
//            else
//                message = "Not enough Faculties for the entry.<br> You have two options: <br> 1. add "+(requiredSection-totalAvialableFaculties)+" more availableFaculties<br> 2. increase no. of student per section to "+totalStudents/totalAvialableFaculties;
//            setMessage(model,message);
//            throw new FacultyNotEnoughException("Faculty Not Enough in: ScheduleController , createSection()");
//        }

        //if we want to put as unstaffed
        Random rd = new Random();
        List<Course> courses = courseService.getAllCourses();


        if(blockNo==1)
        {
            section = new Section();
            Course mppCourse = courseService.findByCourseCode(401);
            for(int k=0; k<(int)Math.ceil((double)block.getEntry().getMppStudentNum()/Constants.STUDENT_PER_SECTION);k++){
                section = new Section();
                section.setCourse(mppCourse);
                section.setBlock(block);
                block.getSections().add(section);
            }
                Course  fppCourse= courseService.findByCourseCode(390);
            for(int i=0; i<(int)Math.ceil((double)block.getEntry().getFppStudentNum()/Constants.STUDENT_PER_SECTION);i++){
                section = new Section();
                section.setCourse(fppCourse);
                section.setBlock(block);
                block.getSections().add(section);
            }

        }else {
            List<Faculty> fac = new ArrayList<>();
            for (int i = 1; i <= requiredSection; i++) {
                section = new Section();

                if (availableFaculties.size() > 0) {
                    int index = rd.nextInt(availableFaculties.size());
                    Faculty sectionFaculty = availableFaculties.get(index);

                    if (fac.contains(sectionFaculty))
                        section.setFaculty(null);
                    else
                        section.setFaculty(sectionFaculty);
                    fac.add(sectionFaculty);
                }
                int courseindex = rd.nextInt(courses.size());
                section.setCourse(courses.get(courseindex));
                System.out.println("    section:" + i + " " + section.toString());

                section.setBlock(block);
                block.getSections().add(section);
            }
        }

//        for (Faculty faculty:availableFaculties) {
//            section.setFaculty(faculty);
//
//            int index = rd.nextInt(faculty.getCourses().size());
//            section.setCourse(faculty.getCourses().get(index));
//
//        }




        return sections;
    }


    @RequestMapping(value = "/view-schedule")
    public String viewSchedule(@RequestParam Long entryId, Model model){

        Entry entry = entryService.findEntryById(entryId);

        model.addAttribute("entry",entry);
        model.addAttribute("blocks",entry.getBlocks());
        return getView(model,"schedule/show-schedule");
    }
}

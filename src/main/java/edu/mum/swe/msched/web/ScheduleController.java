package edu.mum.swe.msched.web;

import edu.mum.swe.msched.FacultyNotEnoughExecption;
import edu.mum.swe.msched.constants.Constants;
import edu.mum.swe.msched.domain.*;
import edu.mum.swe.msched.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.text.SimpleDateFormat;
import java.lang.Math;

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
    private BlockService blockService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private FacultyService facultyService;


    @RequestMapping(value = "/generate-schedule",method = RequestMethod.POST)
    public String createSchedule(@RequestParam long entryId,@RequestParam int totalBlocks, Model model ){
        this.model = model;
       //System.out.print(entryService.findEntryById(1L));
        this.currentEntry = entryService.findEntryById(entryId);
        currentEntry.getBlocks().clear();
        try {
            currentEntry.getBlocks().addAll(createBlock(currentEntry));
            entryService.save(currentEntry);
            Schedule schedule = new Schedule();
            schedule.setEntryId(entryId);
            scheduleService.save(schedule);
        }catch (FacultyNotEnoughExecption e){
            model.addAttribute("entries",entryService.getAllEntries());
            return getView(model,"schedule/generate-schedule");
        }
        currentEntry.getBlocks().addAll(createBlock(currentEntry));
        entryService.save(currentEntry);
        Schedule schedule = new Schedule();
        schedule.setEntryId(entryId);
        scheduleService.save(schedule);

        model.addAttribute("entry",currentEntry);
        model.addAttribute("blocks",currentEntry.getBlocks());

        return getView(model,"schedule/show-schedule");
    }

    @RequestMapping(value = "/generate-schedule",method = RequestMethod.GET)
    public String showScheduleForm( Model model ){

        model.addAttribute("entries",entryService.getAllEntries());
        return getView(model,"schedule/generate-schedule");
    }


    public List<Block> createBlock(Entry entry) throws FacultyNotEnoughExecption{
        List<Block> blockList = new ArrayList<Block>();

        Date initDate = null;

        for (int i=0; i<= Constants.BLOCKS;i++){
            Block block = new Block();
            block.setEntry(entry);
            if(initDate==null){
                Date entryDate = entry.getEntryDate();
                block.setStartDate(entryDate);
                this.cal.setTime(entryDate);

                cal.add(Calendar.DATE, Constants.NO_OF_DAYS_IN_BLOCK);
                block.setEndDate(cal.getTime());
                block.setName(dateFormat.format(entry.getEntryDate()));

                Set<Section> sections = this.createSection(block,i+1);
                block.setSections(sections);

                initDate = cal.getTime();
            }

            else{
                block.setStartDate(initDate);
                this.cal.setTime(initDate);

                cal.add(Calendar.DATE, Constants.NO_OF_DAYS_IN_BLOCK);
                block.setEndDate(cal.getTime());
                block.setName(dateFormat.format(initDate));
                Set<Section> sections = this.createSection(block,i+1);
                block.setSections(sections);
                initDate = cal.getTime();
            }
            blockList.add(block);


        }
        return blockList;
    }


    public Set<Section> createSection(Block block,int blockNo){
        Set<Section> sections = new HashSet<>();
        Section section = new Section();


        int totalStudents = block.getEntry().getFppStudentNum()+block.getEntry().getMppStudentNum()+ block.getEntry().getLocalStudentNum();

        int requiredSection = totalStudents/Constants.STUDENT_PER_SECTION;

        List<Faculty> availableFaculties = facultyService.findFacultyByPreferedBlock(blockNo);

        int totalAvialableFaculties = availableFaculties.size();
        if(totalAvialableFaculties < requiredSection )
        {
            String message;
            if(totalAvialableFaculties<=0)
                message = "No faculties in the system for this entry, please add faculties <a href=\"/faculty/add\">here</a>";
            else
                message = "Not enough Faculties for the entry.<br> You have two options: <br> 1. add "+(requiredSection-totalAvialableFaculties)+" more availableFaculties<br> 2. increase no. of student per section to "+totalStudents/totalAvialableFaculties;
            setMessage(model,message);
            throw new FacultyNotEnoughExecption("Faculty Not Enough in: ScheduleController , createSection()");
        }

        for (Faculty faculty:availableFaculties) {
            section.setFaculty(faculty);
            Random rd = new Random();
            int index = rd.nextInt(faculty.getCourses().size());
            section.setCourse(faculty.getCourses().get(index));

        }

        section.setBlock(block);
        return sections;
    }
}

package edu.mum.swe.msched.web;

import edu.mum.swe.msched.constants.Constants;
import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Schedule;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.service.BlockService;
import edu.mum.swe.msched.service.EntryService;
import edu.mum.swe.msched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Created by acer-usrpu on 1/30/2017.
 */

@Controller
public class ScheduleController {

    private Entry currentEntry;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
    Calendar cal = Calendar.getInstance();

    @Autowired
    private EntryService entryService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private BlockService blockService;


    @RequestMapping(value = "/save-schedule",method = RequestMethod.GET)
    public String createSchedule(@RequestParam long entryId, Model model ){
       //System.out.print(entryService.findEntryById(1L));
        this.currentEntry = entryService.findEntryById(entryId);
        currentEntry.getBlocks().clear();
        currentEntry.getBlocks().addAll(createBlock(currentEntry));
        entryService.save(currentEntry);
        Schedule schedule = new Schedule();
        schedule.setEntryId(entryId);
        scheduleService.save(schedule);

        model.addAttribute("blocks",currentEntry.getBlocks());
        return "schedule/show-schedule";
    }

    @RequestMapping(value = "/generate-schedule",method = RequestMethod.GET)
    public String showScheduleForm( Model model ){

        model.addAttribute("entries",entryService.getAllEntries());
        return "schedule/generate-schedule";
    }


    public List<Block> createBlock(Entry entry){
        List<Block> blockList = new ArrayList<Block>();

        Date initDate = null;
        for (int i=0; i<= Constants.BLOCKS;i++){
            Block block = new Block();
            if(initDate==null){
                Date entryDate = entry.getEntryDate();
                block.setStartDate(entryDate);
                this.cal.setTime(entryDate);

                cal.add(Calendar.DATE, Constants.NO_OF_DAYS_IN_BLOCK);
                block.setEndDate(cal.getTime());
                block.setName(dateFormat.format(entry.getEntryDate()));

                initDate = cal.getTime();
            }

            else{
                block.setStartDate(initDate);
                this.cal.setTime(initDate);

                cal.add(Calendar.DATE, Constants.NO_OF_DAYS_IN_BLOCK);
                block.setEndDate(cal.getTime());
                block.setName(dateFormat.format(initDate));

                initDate = cal.getTime();
            }
            block.setEntry(entry);
            blockList.add(block);




        }
        return blockList;
    }


    public Section createSection(Block block){
        return new Section();
    }


}

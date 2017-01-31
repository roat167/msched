package edu.mum.swe.msched.web;

import edu.mum.swe.msched.constants.Constants;
import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Created by acer-usrpu on 1/30/2017.
 */

@Controller
public class ScheduleController {

    private Entry currentEntry;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
    Calendar cal = Calendar.getInstance();

    @Autowired
    private EntryService entryService;


    @RequestMapping(value = "/generate-schedule")
    public String createSchedule(Long entryId){
        this.currentEntry = entryService.findEntryById(entryId);
        currentEntry.getBlocks().clear();
        currentEntry.getBlocks().addAll(createBlock(currentEntry));
        entryService.save(currentEntry);


        return "success";
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
                block.setName(dateFormat.format(entry.getEntryDate()));

                initDate = cal.getTime();
            }


            blockList.add(block);




        }
        return blockList;
    }


    public Section createSection(Block block){
        return new Section();
    }


}

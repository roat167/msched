package edu.mum.swe.msched.service.impl;

import edu.mum.swe.msched.dao.ScheduleDao;
import edu.mum.swe.msched.domain.Schedule;
import edu.mum.swe.msched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by acer-usrpu on 2/2/2017.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public void updateSchedule(Schedule schedule){ scheduleDao.save(schedule);}

    @Override
    public Schedule findScheduleByEntryId(Long entryId){return scheduleDao.findOneByEntryId(entryId);}

    @Override
    public Schedule save(Schedule schedule){return scheduleDao.saveAndFlush(schedule);}

    @Override
    public void remove(Long scheduleId){ scheduleDao.delete(scheduleId);}
}

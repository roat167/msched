package edu.mum.swe.msched.service.impl;

import edu.mum.swe.msched.dao.ScheduleDao;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Schedule;
import edu.mum.swe.msched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer-usrpu on 2/2/2017.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public List<Schedule> findAllSchedule() {
        return scheduleDao.findAll();
    }

    @Override
    public void updateSchedule(Schedule schedule){ scheduleDao.save(schedule);}

    @Override
    public Schedule findScheduleByEntry(Entry entry){return scheduleDao.findOneByEntry(entry);}

    @Override
    public Schedule save(Schedule schedule){return scheduleDao.saveAndFlush(schedule);}

    @Override
    public void remove(Long scheduleId){ scheduleDao.delete(scheduleId);}
}

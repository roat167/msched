package edu.mum.swe.msched.service;

import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Schedule;

import java.util.List;

/**
 * Created by acer-usrpu on 2/2/2017.
 */
public interface ScheduleService {
    void updateSchedule(Schedule schedule);
    Schedule findScheduleByEntry(Entry entry);
    Schedule save(Schedule schedule);
    void remove(Long scheduleId);
    List<Schedule> findAllSchedule();
}

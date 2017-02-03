package edu.mum.swe.msched.service;

import edu.mum.swe.msched.domain.Schedule;

/**
 * Created by acer-usrpu on 2/2/2017.
 */
public interface ScheduleService {
    void updateSchedule(Schedule schedule);
    Schedule findScheduleByEntryId(Long entryId);
    Schedule save(Schedule schedule);
    void remove(Long scheduleId);
}

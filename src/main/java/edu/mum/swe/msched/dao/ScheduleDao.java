package edu.mum.swe.msched.dao;

import edu.mum.swe.msched.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by acer-usrpu on 2/2/2017.
 */

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Long> {
    Schedule findOneByEntryId(Long entryId);
}

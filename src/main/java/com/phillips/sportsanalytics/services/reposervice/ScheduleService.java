package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.model.Schedule;
import com.phillips.sportsanalytics.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule findSchedule(Long year) {
        return scheduleRepository.findById(year.toString()).orElse(null);
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
}

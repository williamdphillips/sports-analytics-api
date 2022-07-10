package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.model.Schedule;
import com.phillips.sportsanalytics.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule findSchedule(Long year) {
        return scheduleRepository.findById(year.toString()).block();
    }

    public Mono<Schedule> saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
}

package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.PlayByPlayRepository;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayByPlayService {
    @Autowired
    private PlayByPlayRepository playByPlayRepository;

    public PlayByPlayResponse findPBPByEventId(String eventId) {
        ArrayList<PlayByPlayResponse> pbps = new ArrayList<>();
        playByPlayRepository.findByEventId(eventId).forEach(pbps::add);
        if(pbps.size() == 1)
            return pbps.get(0);
        else if(pbps.isEmpty())
            return null;
        else{
            System.out.println("WARNING: More than one pbp exists for event id " + eventId);
            return pbps.get(0);
        }
    }

    public PlayByPlayResponse savePBP(PlayByPlayResponse pbp){
        return playByPlayRepository.save(pbp);
    }
}

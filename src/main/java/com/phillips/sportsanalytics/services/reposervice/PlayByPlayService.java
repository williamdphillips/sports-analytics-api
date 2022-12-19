package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.PlayByPlayRepository;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PlayByPlayService {
    @Autowired
    private PlayByPlayRepository playByPlayRepository;
    private static final Map<String, PlayByPlayResponse> inMemoryPlayByPlays = new HashMap<>();

    public PlayByPlayResponse findPBPByEventId(String eventId) {
        ArrayList<PlayByPlayResponse> pbps = new ArrayList<>();
        PlayByPlayResponse playByPlayResponse = inMemoryPlayByPlays.get(eventId);
        if(playByPlayResponse == null){
            playByPlayRepository.findByEventId(eventId).toStream().forEach(pbps::add);
        }else return playByPlayResponse;

        if(pbps.size() == 1) {
            return pbps.get(0);
        }
        else if(pbps.isEmpty())
            return null;
        else{
            System.out.println("WARNING: More than one pbp exists for event id " + eventId);
            return pbps.get(0);
        }
    }

    /**
     * Saves play by play to in-memory collection
     * @param playByPlayResponse playByPlayResponse to save
     */
    public void savePlayByPlay(PlayByPlayResponse playByPlayResponse){
        String eventId = playByPlayResponse.getEventId();
        inMemoryPlayByPlays.put(eventId, playByPlayResponse);
    }

    public void savePlayByPlaysToRepo(){
        inMemoryPlayByPlays.values().forEach(pbp -> playByPlayRepository.save(pbp).block());
    }
}

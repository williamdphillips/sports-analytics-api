package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.OddsRepository;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class OddsService {
    @Autowired
    private OddsRepository oddsRepository;
    private static final Map<String, OddsResponse> inMemoryOdds = new HashMap<>();

    public OddsResponse findOddsByEventId(String eventId) {
        ArrayList<OddsResponse> odds = new ArrayList<>();
        OddsResponse oddsResponse = inMemoryOdds.get(eventId);
        if(oddsResponse == null){
            oddsRepository.findByEventId(eventId).toStream().forEach(odds::add);
        }else return oddsResponse;

        if(odds.size() == 1) {
            return odds.get(0);
        }
        else if(odds.isEmpty())
            return null;
        else{
            System.out.println("WARNING: More than one odds exists for event id " + eventId);
            return odds.get(0);
        }
    }

    /**
     * Saves odds to in-memory collection
     * @param oddsResponse oddsResponse to save
     */
    public void saveOdds(OddsResponse oddsResponse){
        String eventId = oddsResponse.getEventId();
        inMemoryOdds.put(eventId, oddsResponse);
    }

    public void saveOddsToRepo(){
        inMemoryOdds.values().forEach(odds -> oddsRepository.save(odds).block());
    }
}

package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.OddsRepository;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class OddsService {
    @Autowired
    private OddsRepository oddsRepository;

    public OddsResponse findOddsByEventId(String eventId) {
        ArrayList<OddsResponse> odds = new ArrayList<>();
        oddsRepository.findByEventId(eventId).toStream().forEach(odds::add);
        if(odds.size() == 1)
            return odds.get(0);
        else if(odds.isEmpty())
            return null;
        else{
            System.out.println("WARNING: More than one odds exists for event id " + eventId);
            return odds.get(0);
        }
    }

    public Mono<OddsResponse> saveOdds(OddsResponse oddsResponse){
        return oddsRepository.save(oddsResponse);
    }
}

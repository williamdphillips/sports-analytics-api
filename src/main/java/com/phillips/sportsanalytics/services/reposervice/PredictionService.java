package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.PredictionRepository;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PredictionService {
    @Autowired
    private PredictionRepository predictionRepository;

    public PredictionResponse findPredictionByEventId(String eventId) {
        ArrayList<PredictionResponse> predictions = new ArrayList<>();
        predictionRepository.findByEventId(eventId).forEach(predictions::add);
        if(predictions.size() == 1)
            return predictions.get(0);
        else if(predictions.isEmpty())
            return null;
        else{
            System.out.println("WARNING: More than one prediction exists for event id " + eventId);
            return predictions.get(0);
        }
    }

    public PredictionResponse savePrediction(PredictionResponse predictionResponse){
        return predictionRepository.save(predictionResponse);
    }
}

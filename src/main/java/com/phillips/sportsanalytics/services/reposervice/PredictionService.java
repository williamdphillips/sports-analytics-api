package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.PredictionRepository;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PredictionService {
    @Autowired
    private PredictionRepository predictionRepository;
    private static final Map<String, PredictionResponse> inMemoryPredictions = new HashMap<>();

    public PredictionResponse findPredictionByEventId(String eventId) {
        ArrayList<PredictionResponse> predictions = new ArrayList<>();
        PredictionResponse predictionResponse = inMemoryPredictions.get(eventId);
        if(predictionResponse == null){
            predictionRepository.findByEventId(eventId).toStream().forEach(predictions::add);
        }else return predictionResponse;

        if(predictions.size() == 1) {
            return predictions.get(0);
        }
        else if(predictions.isEmpty())
            return null;
        else{
            System.out.println("WARNING: More than one prediction exists for event id " + eventId);
            return predictions.get(0);
        }
    }

    /**
     * Saves prediction to in-memory collection
     * @param predictionResponse prediction to save
     */
    public void savePrediction(PredictionResponse predictionResponse){
        String eventId = predictionResponse.getEventId();
        inMemoryPredictions.put(eventId, predictionResponse);
    }

    public void savePredictionsToRepo(){
        inMemoryPredictions.values().forEach(p -> predictionRepository.save(p).block());
    }
}

package com.phillips.sportsanalytics.response.playbyplay;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Data
@Container(containerName = "NFL_PlayByPlay")
public class PlayByPlayResponse {
    @Id
    public String eventId;
    public Boxscore boxscore;
    public Format format;
    public GameInfo gameInfo;
    public Drives drives;
    public ArrayList<Leader> leaders;
    public ArrayList<Object> broadcasts;
    public Predictor predictor;
    public ArrayList<Pickcenter> pickcenter;
    public ArrayList<AgainstTheSpread> againstTheSpread;
    public ArrayList<Object> odds;
    public ArrayList<Winprobability> winprobability;
    public Header header;
    public ArrayList<ScoringPlay> scoringPlays;
    public News news;
    public Article article;
    public ArrayList<Video> videos;
    public Standings standings;
}

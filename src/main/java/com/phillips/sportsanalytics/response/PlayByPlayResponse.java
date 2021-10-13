package com.phillips.sportsanalytics.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class PlayByPlayResponse {
    public final Boxscore boxscore;
    public final GameInfo gameInfo;
    public final Drives drives;
    public final Leader leaders[];
    public final Broadcast broadcasts[];
    public final Predictor predictor;
    public final Pickcenter pickcenter[];
    public final AgainstTheSpread againstTheSpread[];
    public final Odd odds[];
    public final Winprobability winprobability[];
    public final Header header;
    public final ScoringPlay scoringPlays[];
    public final Video videos[];
    public final News news;
    public final Standings standings;

    @JsonCreator
    public PlayByPlayResponse(@JsonProperty("boxscore") Boxscore boxscore, @JsonProperty("gameInfo") GameInfo gameInfo, @JsonProperty("drives") Drives drives, @JsonProperty("leaders") Leader[] leaders, @JsonProperty("broadcasts") Broadcast[] broadcasts, @JsonProperty("predictor") Predictor predictor, @JsonProperty("pickcenter") Pickcenter[] pickcenter, @JsonProperty("againstTheSpread") AgainstTheSpread[] againstTheSpread, @JsonProperty("odds") Odd[] odds, @JsonProperty("winprobability") Winprobability[] winprobability, @JsonProperty("header") Header header, @JsonProperty("scoringPlays") ScoringPlay[] scoringPlays, @JsonProperty("videos") Video[] videos, @JsonProperty("news") News news, @JsonProperty("standings") Standings standings){
        this.boxscore = boxscore;
        this.gameInfo = gameInfo;
        this.drives = drives;
        this.leaders = leaders;
        this.broadcasts = broadcasts;
        this.predictor = predictor;
        this.pickcenter = pickcenter;
        this.againstTheSpread = againstTheSpread;
        this.odds = odds;
        this.winprobability = winprobability;
        this.header = header;
        this.scoringPlays = scoringPlays;
        this.videos = videos;
        this.news = news;
        this.standings = standings;
    }

    public static final class Boxscore {
        public final Team teams[];
        public final Player players[];

        @JsonCreator
        public Boxscore(@JsonProperty("teams") Team[] teams, @JsonProperty("players") Player[] players){
            this.teams = teams;
            this.players = players;
        }

        public static final class Team {
            public final SubTeam team;
            public final Statistic statistics[];

            @JsonCreator
            public Team(@JsonProperty("team") SubTeam team, @JsonProperty("statistics") Statistic[] statistics){
                this.team = team;
                this.statistics = statistics;
            }

            public static final class SubTeam {
                public final String id;
                public final String uid;
                public final String slug;
                public final String location;
                public final String name;
                public final String abbreviation;
                public final String displayName;
                public final String shortDisplayName;
                public final String color;
                public final String alternateColor;
                public final String logo;

                @JsonCreator
                public SubTeam(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("slug") String slug, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("logo") String logo){
                    this.id = id;
                    this.uid = uid;
                    this.slug = slug;
                    this.location = location;
                    this.name = name;
                    this.abbreviation = abbreviation;
                    this.displayName = displayName;
                    this.shortDisplayName = shortDisplayName;
                    this.color = color;
                    this.alternateColor = alternateColor;
                    this.logo = logo;
                }
            }

            public static final class Statistic {
                public final String name;
                public final String displayValue;
                public final String label;

                @JsonCreator
                public Statistic(@JsonProperty("name") String name, @JsonProperty("displayValue") String displayValue, @JsonProperty("label") String label){
                    this.name = name;
                    this.displayValue = displayValue;
                    this.label = label;
                }
            }
        }

        public static final class Player {
            public final Team team;
            public final Statistic statistics[];

            @JsonCreator
            public Player(@JsonProperty("team") Team team, @JsonProperty("statistics") Statistic[] statistics){
                this.team = team;
                this.statistics = statistics;
            }

            public static final class Team {
                public final String id;
                public final String uid;
                public final String slug;
                public final String location;
                public final String name;
                public final String abbreviation;
                public final String displayName;
                public final String shortDisplayName;
                public final String color;
                public final String alternateColor;
                public final String logo;

                @JsonCreator
                public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("slug") String slug, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("logo") String logo){
                    this.id = id;
                    this.uid = uid;
                    this.slug = slug;
                    this.location = location;
                    this.name = name;
                    this.abbreviation = abbreviation;
                    this.displayName = displayName;
                    this.shortDisplayName = shortDisplayName;
                    this.color = color;
                    this.alternateColor = alternateColor;
                    this.logo = logo;
                }
            }

            public static final class Statistic {
                public final String name;
                public final String text;
                public final String[] labels;
                public final String[] descriptions;
                public final Athlete athletes[];
                public final String[] totals;

                @JsonCreator
                public Statistic(@JsonProperty("name") String name, @JsonProperty("text") String text, @JsonProperty("labels") String[] labels, @JsonProperty("descriptions") String[] descriptions, @JsonProperty("athletes") Athlete[] athletes, @JsonProperty("totals") String[] totals){
                    this.name = name;
                    this.text = text;
                    this.labels = labels;
                    this.descriptions = descriptions;
                    this.athletes = athletes;
                    this.totals = totals;
                }

                public static final class Athlete {
                    public final SubAthlete athlete;
                    public final String[] stats;

                    @JsonCreator
                    public Athlete(@JsonProperty("athlete") SubAthlete athlete, @JsonProperty("stats") String[] stats){
                        this.athlete = athlete;
                        this.stats = stats;
                    }

                    public static final class SubAthlete {
                        public final String id;
                        public final String uid;
                        public final String guid;
                        public final String firstName;
                        public final String lastName;
                        public final String displayName;
                        public final Link links[];

                        @JsonCreator
                        public SubAthlete(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("displayName") String displayName, @JsonProperty("links") Link[] links){
                            this.id = id;
                            this.uid = uid;
                            this.guid = guid;
                            this.firstName = firstName;
                            this.lastName = lastName;
                            this.displayName = displayName;
                            this.links = links;
                        }

                        public static final class Link {
                            public final String href;
                            public final String text;

                            @JsonCreator
                            public Link(@JsonProperty("href") String href, @JsonProperty("text") String text){
                                this.href = href;
                                this.text = text;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class GameInfo {
        public final Venue venue;

        @JsonCreator
        public GameInfo(@JsonProperty("venue") Venue venue){
            this.venue = venue;
        }

        public static final class Venue {
            public final String id;
            public final String fullName;
            public final Address address;
            public final long capacity;
            public final boolean grass;
            public final Image images[];

            @JsonCreator
            public Venue(@JsonProperty("id") String id, @JsonProperty("fullName") String fullName, @JsonProperty("address") Address address, @JsonProperty("capacity") long capacity, @JsonProperty("grass") boolean grass, @JsonProperty("images") Image[] images){
                this.id = id;
                this.fullName = fullName;
                this.address = address;
                this.capacity = capacity;
                this.grass = grass;
                this.images = images;
            }

            public static final class Address {
                public final String city;

                @JsonCreator
                public Address(@JsonProperty("city") String city){
                    this.city = city;
                }
            }

            public static final class Image {

                @JsonCreator
                public Image(){
                }
            }
        }
    }

    public static final class Drives {
        public final Current current;
        public final Previou previous[];

        @JsonCreator
        public Drives(@JsonProperty("current") Current current, @JsonProperty("previous") Previou[] previous){
            this.current = current;
            this.previous = previous;
        }

        public static final class Current {
            public final String id;
            public final String description;
            public final Team team;
            public final Start start;
            public final End end;
            public final TimeElapsed timeElapsed;
            public final long yards;
            public final boolean isScore;
            public final long offensivePlays;
            public final String result;
            public final String shortDisplayResult;
            public final String displayResult;
            public final Play plays[];

            @JsonCreator
            public Current(@JsonProperty("id") String id, @JsonProperty("description") String description, @JsonProperty("team") Team team, @JsonProperty("start") Start start, @JsonProperty("end") End end, @JsonProperty("timeElapsed") TimeElapsed timeElapsed, @JsonProperty("yards") long yards, @JsonProperty("isScore") boolean isScore, @JsonProperty("offensivePlays") long offensivePlays, @JsonProperty("result") String result, @JsonProperty("shortDisplayResult") String shortDisplayResult, @JsonProperty("displayResult") String displayResult, @JsonProperty("plays") Play[] plays){
                this.id = id;
                this.description = description;
                this.team = team;
                this.start = start;
                this.end = end;
                this.timeElapsed = timeElapsed;
                this.yards = yards;
                this.isScore = isScore;
                this.offensivePlays = offensivePlays;
                this.result = result;
                this.shortDisplayResult = shortDisplayResult;
                this.displayResult = displayResult;
                this.plays = plays;
            }

            public static final class Team {
                public final String name;
                public final String abbreviation;
                public final String displayName;
                public final String shortDisplayName;
                public final Logo logos[];

                @JsonCreator
                public Team(@JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("logos") Logo[] logos){
                    this.name = name;
                    this.abbreviation = abbreviation;
                    this.displayName = displayName;
                    this.shortDisplayName = shortDisplayName;
                    this.logos = logos;
                }

                public static final class Logo {
                    public final String href;
                    public final long width;
                    public final long height;
                    public final String alt;
                    public final String[] rel;
                    public final String lastUpdated;

                    @JsonCreator
                    public Logo(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("alt") String alt, @JsonProperty("rel") String[] rel, @JsonProperty("lastUpdated") String lastUpdated){
                        this.href = href;
                        this.width = width;
                        this.height = height;
                        this.alt = alt;
                        this.rel = rel;
                        this.lastUpdated = lastUpdated;
                    }
                }
            }

            public static final class Start {
                public final Period period;
                public final Clock clock;
                public final long yardLine;
                public final String text;

                @JsonCreator
                public Start(@JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("yardLine") long yardLine, @JsonProperty("text") String text){
                    this.period = period;
                    this.clock = clock;
                    this.yardLine = yardLine;
                    this.text = text;
                }

                public static final class Period {
                    public final String type;
                    public final long number;

                    @JsonCreator
                    public Period(@JsonProperty("type") String type, @JsonProperty("number") long number){
                        this.type = type;
                        this.number = number;
                    }
                }

                public static final class Clock {
                    public final String displayValue;

                    @JsonCreator
                    public Clock(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }
            }

            public static final class End {
                public final Period period;
                public final Clock clock;
                public final long yardLine;
                public final String text;

                @JsonCreator
                public End(@JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("yardLine") long yardLine, @JsonProperty("text") String text){
                    this.period = period;
                    this.clock = clock;
                    this.yardLine = yardLine;
                    this.text = text;
                }

                public static final class Period {
                    public final String type;
                    public final long number;

                    @JsonCreator
                    public Period(@JsonProperty("type") String type, @JsonProperty("number") long number){
                        this.type = type;
                        this.number = number;
                    }
                }

                public static final class Clock {
                    public final String displayValue;

                    @JsonCreator
                    public Clock(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }
            }

            public static final class TimeElapsed {
                public final String displayValue;

                @JsonCreator
                public TimeElapsed(@JsonProperty("displayValue") String displayValue){
                    this.displayValue = displayValue;
                }
            }

            public static final class Play {
                public final String id;
                public final String sequenceNumber;
                public final Type type;
                public final String text;
                public final long awayScore;
                public final long homeScore;
                public final Period period;
                public final Clock clock;
                public final boolean scoringPlay;
                public final boolean priority;
                public final String modified;
                public final String wallclock;
                public final Start start;
                public final End end;
                public final long statYardage;
                public final Long scoreValue;
                public final Participant participants[];

                @JsonCreator
                public Play(@JsonProperty("id") String id, @JsonProperty("sequenceNumber") String sequenceNumber, @JsonProperty("type") Type type, @JsonProperty("text") String text, @JsonProperty("awayScore") long awayScore, @JsonProperty("homeScore") long homeScore, @JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("scoringPlay") boolean scoringPlay, @JsonProperty("priority") boolean priority, @JsonProperty("modified") String modified, @JsonProperty("wallclock") String wallclock, @JsonProperty("start") Start start, @JsonProperty("end") End end, @JsonProperty("statYardage") long statYardage, @JsonProperty(value="scoreValue", required=false) Long scoreValue, @JsonProperty("participants") Participant[] participants){
                    this.id = id;
                    this.sequenceNumber = sequenceNumber;
                    this.type = type;
                    this.text = text;
                    this.awayScore = awayScore;
                    this.homeScore = homeScore;
                    this.period = period;
                    this.clock = clock;
                    this.scoringPlay = scoringPlay;
                    this.priority = priority;
                    this.modified = modified;
                    this.wallclock = wallclock;
                    this.start = start;
                    this.end = end;
                    this.statYardage = statYardage;
                    this.scoreValue = scoreValue;
                    this.participants = participants;
                }

                public static final class Type {
                    public final String id;
                    public final String text;
                    public final String abbreviation;

                    @JsonCreator
                    public Type(@JsonProperty("id") String id, @JsonProperty("text") String text, @JsonProperty("abbreviation") String abbreviation){
                        this.id = id;
                        this.text = text;
                        this.abbreviation = abbreviation;
                    }
                }

                public static final class Period {
                    public final long number;

                    @JsonCreator
                    public Period(@JsonProperty("number") long number){
                        this.number = number;
                    }
                }

                public static final class Clock {
                    public final String displayValue;

                    @JsonCreator
                    public Clock(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }

                public static final class Start {
                    public final long down;
                    public final long distance;
                    public final long yardLine;
                    public final long yardsToEndzone;
                    public final String downDistanceText;
                    public final String shortDownDistanceText;
                    public final String possessionText;
                    public final Team team;

                    @JsonCreator
                    public Start(@JsonProperty("down") long down, @JsonProperty("distance") long distance, @JsonProperty("yardLine") long yardLine, @JsonProperty("yardsToEndzone") long yardsToEndzone, @JsonProperty("downDistanceText") String downDistanceText, @JsonProperty("shortDownDistanceText") String shortDownDistanceText, @JsonProperty("possessionText") String possessionText, @JsonProperty("team") Team team){
                        this.down = down;
                        this.distance = distance;
                        this.yardLine = yardLine;
                        this.yardsToEndzone = yardsToEndzone;
                        this.downDistanceText = downDistanceText;
                        this.shortDownDistanceText = shortDownDistanceText;
                        this.possessionText = possessionText;
                        this.team = team;
                    }

                    public static final class Team {
                        public final String id;

                        @JsonCreator
                        public Team(@JsonProperty("id") String id){
                            this.id = id;
                        }
                    }
                }

                public static final class End {
                    public final long down;
                    public final long distance;
                    public final long yardLine;
                    public final long yardsToEndzone;
                    public final String downDistanceText;
                    public final String shortDownDistanceText;
                    public final String possessionText;
                    public final Team team;

                    @JsonCreator
                    public End(@JsonProperty("down") long down, @JsonProperty("distance") long distance, @JsonProperty("yardLine") long yardLine, @JsonProperty("yardsToEndzone") long yardsToEndzone, @JsonProperty("downDistanceText") String downDistanceText, @JsonProperty("shortDownDistanceText") String shortDownDistanceText, @JsonProperty("possessionText") String possessionText, @JsonProperty("team") Team team){
                        this.down = down;
                        this.distance = distance;
                        this.yardLine = yardLine;
                        this.yardsToEndzone = yardsToEndzone;
                        this.downDistanceText = downDistanceText;
                        this.shortDownDistanceText = shortDownDistanceText;
                        this.possessionText = possessionText;
                        this.team = team;
                    }

                    public static final class Team {
                        public final String id;

                        @JsonCreator
                        public Team(@JsonProperty("id") String id){
                            this.id = id;
                        }
                    }
                }

                public static final class Participant {
                    public final Athlete athlete;
                    public final Stat stats[];
                    public final String type;

                    @JsonCreator
                    public Participant(@JsonProperty("athlete") Athlete athlete, @JsonProperty("stats") Stat[] stats, @JsonProperty("type") String type){
                        this.athlete = athlete;
                        this.stats = stats;
                        this.type = type;
                    }

                    public static final class Athlete {
                        public final String id;
                        public final String uid;
                        public final String guid;
                        public final String lastName;
                        public final String fullName;
                        public final String displayName;
                        public final String shortName;
                        public final Link links[];
                        public final Headshot headshot;
                        public final String jersey;
                        public final Position position;
                        public final Team team;

                        @JsonCreator
                        public Athlete(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("lastName") String lastName, @JsonProperty("fullName") String fullName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("links") Link[] links, @JsonProperty("headshot") Headshot headshot, @JsonProperty("jersey") String jersey, @JsonProperty("position") Position position, @JsonProperty("team") Team team){
                            this.id = id;
                            this.uid = uid;
                            this.guid = guid;
                            this.lastName = lastName;
                            this.fullName = fullName;
                            this.displayName = displayName;
                            this.shortName = shortName;
                            this.links = links;
                            this.headshot = headshot;
                            this.jersey = jersey;
                            this.position = position;
                            this.team = team;
                        }

                        public static final class Link {
                            public final String[] rel;
                            public final String href;
                            public final String text;

                            @JsonCreator
                            public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text){
                                this.rel = rel;
                                this.href = href;
                                this.text = text;
                            }
                        }

                        public static final class Headshot {
                            public final String href;
                            public final String alt;

                            @JsonCreator
                            public Headshot(@JsonProperty("href") String href, @JsonProperty("alt") String alt){
                                this.href = href;
                                this.alt = alt;
                            }
                        }

                        public static final class Position {
                            public final String name;
                            public final String displayName;
                            public final String abbreviation;

                            @JsonCreator
                            public Position(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation){
                                this.name = name;
                                this.displayName = displayName;
                                this.abbreviation = abbreviation;
                            }
                        }

                        public static final class Team {
                            public final String abbreviation;

                            @JsonCreator
                            public Team(@JsonProperty("abbreviation") String abbreviation){
                                this.abbreviation = abbreviation;
                            }
                        }
                    }

                    public static final class Stat {
                        public final String name;
                        public final String displayValue;

                        @JsonCreator
                        public Stat(@JsonProperty("name") String name, @JsonProperty("displayValue") String displayValue){
                            this.name = name;
                            this.displayValue = displayValue;
                        }
                    }
                }
            }
        }

        public static final class Previou {
            public final String id;
            public final String description;
            public final Team team;
            public final Start start;
            public final End end;
            public final TimeElapsed timeElapsed;
            public final long yards;
            public final boolean isScore;
            public final long offensivePlays;
            public final String result;
            public final String shortDisplayResult;
            public final String displayResult;
            public final Play plays[];

            @JsonCreator
            public Previou(@JsonProperty("id") String id, @JsonProperty("description") String description, @JsonProperty("team") Team team, @JsonProperty("start") Start start, @JsonProperty("end") End end, @JsonProperty("timeElapsed") TimeElapsed timeElapsed, @JsonProperty("yards") long yards, @JsonProperty("isScore") boolean isScore, @JsonProperty("offensivePlays") long offensivePlays, @JsonProperty("result") String result, @JsonProperty("shortDisplayResult") String shortDisplayResult, @JsonProperty("displayResult") String displayResult, @JsonProperty("plays") Play[] plays){
                this.id = id;
                this.description = description;
                this.team = team;
                this.start = start;
                this.end = end;
                this.timeElapsed = timeElapsed;
                this.yards = yards;
                this.isScore = isScore;
                this.offensivePlays = offensivePlays;
                this.result = result;
                this.shortDisplayResult = shortDisplayResult;
                this.displayResult = displayResult;
                this.plays = plays;
            }

            public static final class Team {
                public final String name;
                public final String abbreviation;
                public final String displayName;
                public final String shortDisplayName;
                public final Logo logos[];

                @JsonCreator
                public Team(@JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("logos") Logo[] logos){
                    this.name = name;
                    this.abbreviation = abbreviation;
                    this.displayName = displayName;
                    this.shortDisplayName = shortDisplayName;
                    this.logos = logos;
                }

                public static final class Logo {
                    public final String href;
                    public final long width;
                    public final long height;
                    public final String alt;
                    public final String[] rel;
                    public final String lastUpdated;

                    @JsonCreator
                    public Logo(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("alt") String alt, @JsonProperty("rel") String[] rel, @JsonProperty("lastUpdated") String lastUpdated){
                        this.href = href;
                        this.width = width;
                        this.height = height;
                        this.alt = alt;
                        this.rel = rel;
                        this.lastUpdated = lastUpdated;
                    }
                }
            }

            public static final class Start {
                public final Period period;
                public final Clock clock;
                public final long yardLine;
                public final String text;

                @JsonCreator
                public Start(@JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("yardLine") long yardLine, @JsonProperty("text") String text){
                    this.period = period;
                    this.clock = clock;
                    this.yardLine = yardLine;
                    this.text = text;
                }

                public static final class Period {
                    public final String type;
                    public final long number;

                    @JsonCreator
                    public Period(@JsonProperty("type") String type, @JsonProperty("number") long number){
                        this.type = type;
                        this.number = number;
                    }
                }

                public static final class Clock {
                    public final String displayValue;

                    @JsonCreator
                    public Clock(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }
            }

            public static final class End {
                public final Period period;
                public final Clock clock;
                public final long yardLine;
                public final String text;

                @JsonCreator
                public End(@JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("yardLine") long yardLine, @JsonProperty("text") String text){
                    this.period = period;
                    this.clock = clock;
                    this.yardLine = yardLine;
                    this.text = text;
                }

                public static final class Period {
                    public final String type;
                    public final long number;

                    @JsonCreator
                    public Period(@JsonProperty("type") String type, @JsonProperty("number") long number){
                        this.type = type;
                        this.number = number;
                    }
                }

                public static final class Clock {
                    public final String displayValue;

                    @JsonCreator
                    public Clock(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }
            }

            public static final class TimeElapsed {
                public final String displayValue;

                @JsonCreator
                public TimeElapsed(@JsonProperty("displayValue") String displayValue){
                    this.displayValue = displayValue;
                }
            }

            public static final class Play {
                public final String id;
                public final String sequenceNumber;
                public final Type type;
                public final String text;
                public final long awayScore;
                public final long homeScore;
                public final Period period;
                public final Clock clock;
                public final boolean scoringPlay;
                public final boolean priority;
                public final String modified;
                public final String wallclock;
                public final Start start;
                public final End end;
                public final long statYardage;

                @JsonCreator
                public Play(@JsonProperty("id") String id, @JsonProperty("sequenceNumber") String sequenceNumber, @JsonProperty("type") Type type, @JsonProperty("text") String text, @JsonProperty("awayScore") long awayScore, @JsonProperty("homeScore") long homeScore, @JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("scoringPlay") boolean scoringPlay, @JsonProperty("priority") boolean priority, @JsonProperty("modified") String modified, @JsonProperty("wallclock") String wallclock, @JsonProperty("start") Start start, @JsonProperty("end") End end, @JsonProperty("statYardage") long statYardage){
                    this.id = id;
                    this.sequenceNumber = sequenceNumber;
                    this.type = type;
                    this.text = text;
                    this.awayScore = awayScore;
                    this.homeScore = homeScore;
                    this.period = period;
                    this.clock = clock;
                    this.scoringPlay = scoringPlay;
                    this.priority = priority;
                    this.modified = modified;
                    this.wallclock = wallclock;
                    this.start = start;
                    this.end = end;
                    this.statYardage = statYardage;
                }

                public static final class Type {
                    public final String id;
                    public final String text;
                    public final String abbreviation;

                    @JsonCreator
                    public Type(@JsonProperty("id") String id, @JsonProperty("text") String text, @JsonProperty("abbreviation") String abbreviation){
                        this.id = id;
                        this.text = text;
                        this.abbreviation = abbreviation;
                    }
                }

                public static final class Period {
                    public final long number;

                    @JsonCreator
                    public Period(@JsonProperty("number") long number){
                        this.number = number;
                    }
                }

                public static final class Clock {
                    public final String displayValue;

                    @JsonCreator
                    public Clock(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }

                public static final class Start {
                    public final long down;
                    public final long distance;
                    public final long yardLine;
                    public final long yardsToEndzone;
                    public final String downDistanceText;
                    public final String shortDownDistanceText;
                    public final String possessionText;
                    public final Team team;

                    @JsonCreator
                    public Start(@JsonProperty("down") long down, @JsonProperty("distance") long distance, @JsonProperty("yardLine") long yardLine, @JsonProperty("yardsToEndzone") long yardsToEndzone, @JsonProperty("downDistanceText") String downDistanceText, @JsonProperty("shortDownDistanceText") String shortDownDistanceText, @JsonProperty("possessionText") String possessionText, @JsonProperty("team") Team team){
                        this.down = down;
                        this.distance = distance;
                        this.yardLine = yardLine;
                        this.yardsToEndzone = yardsToEndzone;
                        this.downDistanceText = downDistanceText;
                        this.shortDownDistanceText = shortDownDistanceText;
                        this.possessionText = possessionText;
                        this.team = team;
                    }

                    public static final class Team {
                        public final String id;

                        @JsonCreator
                        public Team(@JsonProperty("id") String id){
                            this.id = id;
                        }
                    }
                }

                public static final class End {
                    public final long down;
                    public final long distance;
                    public final long yardLine;
                    public final long yardsToEndzone;
                    public final String downDistanceText;
                    public final String shortDownDistanceText;
                    public final String possessionText;
                    public final Team team;

                    @JsonCreator
                    public End(@JsonProperty("down") long down, @JsonProperty("distance") long distance, @JsonProperty("yardLine") long yardLine, @JsonProperty("yardsToEndzone") long yardsToEndzone, @JsonProperty("downDistanceText") String downDistanceText, @JsonProperty("shortDownDistanceText") String shortDownDistanceText, @JsonProperty("possessionText") String possessionText, @JsonProperty("team") Team team){
                        this.down = down;
                        this.distance = distance;
                        this.yardLine = yardLine;
                        this.yardsToEndzone = yardsToEndzone;
                        this.downDistanceText = downDistanceText;
                        this.shortDownDistanceText = shortDownDistanceText;
                        this.possessionText = possessionText;
                        this.team = team;
                    }

                    public static final class Team {
                        public final String id;

                        @JsonCreator
                        public Team(@JsonProperty("id") String id){
                            this.id = id;
                        }
                    }
                }
            }
        }
    }

    public static final class Leader {
        public final Team team;
        public final SubLeader leaders[];

        @JsonCreator
        public Leader(@JsonProperty("team") Team team, @JsonProperty("leaders") SubLeader[] leaders){
            this.team = team;
            this.leaders = leaders;
        }

        public static final class Team {
            public final String id;
            public final String uid;
            public final String displayName;
            public final String abbreviation;
            public final Link links[];
            public final String logo;

            @JsonCreator
            public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("links") Link[] links, @JsonProperty("logo") String logo){
                this.id = id;
                this.uid = uid;
                this.displayName = displayName;
                this.abbreviation = abbreviation;
                this.links = links;
                this.logo = logo;
            }

            public static final class Link {
                public final String href;
                public final String text;

                @JsonCreator
                public Link(@JsonProperty("href") String href, @JsonProperty("text") String text){
                    this.href = href;
                    this.text = text;
                }
            }
        }

        public static final class SubLeader {
            public final String name;
            public final String displayName;
            public final SubSubLeader leaders[];

            @JsonCreator
            public SubLeader(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("leaders") SubSubLeader[] leaders){
                this.name = name;
                this.displayName = displayName;
                this.leaders = leaders;
            }

            public static final class SubSubLeader {
                public final String displayValue;
                public final Athlete athlete;

                @JsonCreator
                public SubSubLeader(@JsonProperty("displayValue") String displayValue, @JsonProperty("athlete") Athlete athlete){
                    this.displayValue = displayValue;
                    this.athlete = athlete;
                }

                public static final class Athlete {
                    public final String id;
                    public final String uid;
                    public final String guid;
                    public final String lastName;
                    public final String fullName;
                    public final String displayName;
                    public final String shortName;
                    public final Link links[];
                    public final Headshot headshot;
                    public final String jersey;
                    public final Position position;
                    public final Team team;

                    @JsonCreator
                    public Athlete(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("lastName") String lastName, @JsonProperty("fullName") String fullName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("links") Link[] links, @JsonProperty("headshot") Headshot headshot, @JsonProperty("jersey") String jersey, @JsonProperty("position") Position position, @JsonProperty("team") Team team){
                        this.id = id;
                        this.uid = uid;
                        this.guid = guid;
                        this.lastName = lastName;
                        this.fullName = fullName;
                        this.displayName = displayName;
                        this.shortName = shortName;
                        this.links = links;
                        this.headshot = headshot;
                        this.jersey = jersey;
                        this.position = position;
                        this.team = team;
                    }

                    public static final class Link {
                        public final String[] rel;
                        public final String href;
                        public final String text;

                        @JsonCreator
                        public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text){
                            this.rel = rel;
                            this.href = href;
                            this.text = text;
                        }
                    }

                    public static final class Headshot {
                        public final String href;
                        public final String alt;

                        @JsonCreator
                        public Headshot(@JsonProperty("href") String href, @JsonProperty("alt") String alt){
                            this.href = href;
                            this.alt = alt;
                        }
                    }

                    public static final class Position {
                        public final String abbreviation;

                        @JsonCreator
                        public Position(@JsonProperty("abbreviation") String abbreviation){
                            this.abbreviation = abbreviation;
                        }
                    }

                    public static final class Team {
                        public final String $ref;

                        @JsonCreator
                        public Team(@JsonProperty("$ref") String $ref){
                            this.$ref = $ref;
                        }
                    }
                }
            }
        }
    }

    public static final class Broadcast {

        @JsonCreator
        public Broadcast(){
        }
    }

    public static final class Predictor {
        public final String header;
        public final HomeTeam homeTeam;
        public final AwayTeam awayTeam;

        @JsonCreator
        public Predictor(@JsonProperty("header") String header, @JsonProperty("homeTeam") HomeTeam homeTeam, @JsonProperty("awayTeam") AwayTeam awayTeam){
            this.header = header;
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
        }

        public static final class HomeTeam {
            public final String id;
            public final String gameProjection;
            public final String teamChanceLoss;
            public final String teamChanceTie;

            @JsonCreator
            public HomeTeam(@JsonProperty("id") String id, @JsonProperty("gameProjection") String gameProjection, @JsonProperty("teamChanceLoss") String teamChanceLoss, @JsonProperty("teamChanceTie") String teamChanceTie){
                this.id = id;
                this.gameProjection = gameProjection;
                this.teamChanceLoss = teamChanceLoss;
                this.teamChanceTie = teamChanceTie;
            }
        }

        public static final class AwayTeam {
            public final String id;
            public final String gameProjection;
            public final String teamChanceLoss;
            public final String teamChanceTie;

            @JsonCreator
            public AwayTeam(@JsonProperty("id") String id, @JsonProperty("gameProjection") String gameProjection, @JsonProperty("teamChanceLoss") String teamChanceLoss, @JsonProperty("teamChanceTie") String teamChanceTie){
                this.id = id;
                this.gameProjection = gameProjection;
                this.teamChanceLoss = teamChanceLoss;
                this.teamChanceTie = teamChanceTie;
            }
        }
    }

    public static final class Pickcenter {
        public final Provider provider;
        public final String details;
        public final double overUnder;
        public final long spread;
        public final AwayTeamOdds awayTeamOdds;
        public final HomeTeamOdds homeTeamOdds;
        public final Link links[];

        @JsonCreator
        public Pickcenter(@JsonProperty("provider") Provider provider, @JsonProperty("details") String details, @JsonProperty("overUnder") double overUnder, @JsonProperty("spread") long spread, @JsonProperty("awayTeamOdds") AwayTeamOdds awayTeamOdds, @JsonProperty("homeTeamOdds") HomeTeamOdds homeTeamOdds, @JsonProperty("links") Link[] links){
            this.provider = provider;
            this.details = details;
            this.overUnder = overUnder;
            this.spread = spread;
            this.awayTeamOdds = awayTeamOdds;
            this.homeTeamOdds = homeTeamOdds;
            this.links = links;
        }

        public static final class Provider {
            public final String id;
            public final String name;
            public final long priority;

            @JsonCreator
            public Provider(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("priority") long priority){
                this.id = id;
                this.name = name;
                this.priority = priority;
            }
        }

        public static final class AwayTeamOdds {
            public final double averageScore;
            public final boolean favorite;
            public final boolean underdog;
            public final long moneyLine;
            public final SpreadRecord spreadRecord;
            public final long spreadOdds;
            public final String teamId;

            @JsonCreator
            public AwayTeamOdds(@JsonProperty("averageScore") double averageScore, @JsonProperty("favorite") boolean favorite, @JsonProperty("underdog") boolean underdog, @JsonProperty("moneyLine") long moneyLine, @JsonProperty("spreadRecord") SpreadRecord spreadRecord, @JsonProperty("spreadOdds") long spreadOdds, @JsonProperty("teamId") String teamId){
                this.averageScore = averageScore;
                this.favorite = favorite;
                this.underdog = underdog;
                this.moneyLine = moneyLine;
                this.spreadRecord = spreadRecord;
                this.spreadOdds = spreadOdds;
                this.teamId = teamId;
            }

            public static final class SpreadRecord {
                public final long wins;
                public final long losses;
                public final long pushes;
                public final String summary;

                @JsonCreator
                public SpreadRecord(@JsonProperty("wins") long wins, @JsonProperty("losses") long losses, @JsonProperty("pushes") long pushes, @JsonProperty("summary") String summary){
                    this.wins = wins;
                    this.losses = losses;
                    this.pushes = pushes;
                    this.summary = summary;
                }
            }
        }

        public static final class HomeTeamOdds {
            public final double averageScore;
            public final boolean favorite;
            public final boolean underdog;
            public final long moneyLine;
            public final SpreadRecord spreadRecord;
            public final long spreadOdds;
            public final String teamId;

            @JsonCreator
            public HomeTeamOdds(@JsonProperty("averageScore") double averageScore, @JsonProperty("favorite") boolean favorite, @JsonProperty("underdog") boolean underdog, @JsonProperty("moneyLine") long moneyLine, @JsonProperty("spreadRecord") SpreadRecord spreadRecord, @JsonProperty("spreadOdds") long spreadOdds, @JsonProperty("teamId") String teamId){
                this.averageScore = averageScore;
                this.favorite = favorite;
                this.underdog = underdog;
                this.moneyLine = moneyLine;
                this.spreadRecord = spreadRecord;
                this.spreadOdds = spreadOdds;
                this.teamId = teamId;
            }

            public static final class SpreadRecord {
                public final long wins;
                public final long losses;
                public final long pushes;
                public final String summary;

                @JsonCreator
                public SpreadRecord(@JsonProperty("wins") long wins, @JsonProperty("losses") long losses, @JsonProperty("pushes") long pushes, @JsonProperty("summary") String summary){
                    this.wins = wins;
                    this.losses = losses;
                    this.pushes = pushes;
                    this.summary = summary;
                }
            }
        }

        public static final class Link {

            @JsonCreator
            public Link(){
            }
        }
    }

    public static final class AgainstTheSpread {
        public final Team team;
        public final Record records[];

        @JsonCreator
        public AgainstTheSpread(@JsonProperty("team") Team team, @JsonProperty("records") Record[] records){
            this.team = team;
            this.records = records;
        }

        public static final class Team {
            public final String id;
            public final String uid;
            public final String displayName;
            public final String abbreviation;
            public final Link links[];
            public final String logo;

            @JsonCreator
            public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("links") Link[] links, @JsonProperty("logo") String logo){
                this.id = id;
                this.uid = uid;
                this.displayName = displayName;
                this.abbreviation = abbreviation;
                this.links = links;
                this.logo = logo;
            }

            public static final class Link {
                public final String href;
                public final String text;

                @JsonCreator
                public Link(@JsonProperty("href") String href, @JsonProperty("text") String text){
                    this.href = href;
                    this.text = text;
                }
            }
        }

        public static final class Record {

            @JsonCreator
            public Record(){
            }
        }
    }

    public static final class Odd {
        public final Provider provider;
        public final BettingOdds bettingOdds;

        @JsonCreator
        public Odd(@JsonProperty("provider") Provider provider, @JsonProperty("bettingOdds") BettingOdds bettingOdds){
            this.provider = provider;
            this.bettingOdds = bettingOdds;
        }

        public static final class Provider {
            public final String id;
            public final String name;
            public final long priority;

            @JsonCreator
            public Provider(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("priority") long priority){
                this.id = id;
                this.name = name;
                this.priority = priority;
            }
        }

        public static final class BettingOdds {
            public final HomeTeam homeTeam;
            public final AwayTeam awayTeam;
            public final TeamOdds teamOdds;

            @JsonCreator
            public BettingOdds(@JsonProperty("homeTeam") HomeTeam homeTeam, @JsonProperty("awayTeam") AwayTeam awayTeam, @JsonProperty("teamOdds") TeamOdds teamOdds){
                this.homeTeam = homeTeam;
                this.awayTeam = awayTeam;
                this.teamOdds = teamOdds;
            }

            public static final class HomeTeam {
                public final String $ref;

                @JsonCreator
                public HomeTeam(@JsonProperty("$ref") String $ref){
                    this.$ref = $ref;
                }
            }

            public static final class AwayTeam {
                public final String $ref;

                @JsonCreator
                public AwayTeam(@JsonProperty("$ref") String $ref){
                    this.$ref = $ref;
                }
            }

            public static final class TeamOdds {
                public final PreMatchMoneyLineAway preMatchMoneyLineAway;
                public final PreMatchMoneyLineHome preMatchMoneyLineHome;
                public final PreMatchSpreadHandicapAway preMatchSpreadHandicapAway;
                public final PreMatchSpreadHome preMatchSpreadHome;
                public final PreMatchWinningMarginHome preMatchWinningMarginHome;
                public final PreMatchTotalOver preMatchTotalOver;
                public final PreMatchWinningMarginOther preMatchWinningMarginOther;
                public final PreMatchSpreadAway preMatchSpreadAway;
                public final PreMatchWinningMarginAway preMatchWinningMarginAway;
                public final PreMatchTotalUnder preMatchTotalUnder;
                public final PreMatchTotalHandicap preMatchTotalHandicap;
                public final PreMatchSpreadHandicapHome preMatchSpreadHandicapHome;

                @JsonCreator
                public TeamOdds(@JsonProperty("preMatchMoneyLineAway") PreMatchMoneyLineAway preMatchMoneyLineAway, @JsonProperty("preMatchMoneyLineHome") PreMatchMoneyLineHome preMatchMoneyLineHome, @JsonProperty("preMatchSpreadHandicapAway") PreMatchSpreadHandicapAway preMatchSpreadHandicapAway, @JsonProperty("preMatchSpreadHome") PreMatchSpreadHome preMatchSpreadHome, @JsonProperty("preMatchWinningMarginHome") PreMatchWinningMarginHome preMatchWinningMarginHome, @JsonProperty("preMatchTotalOver") PreMatchTotalOver preMatchTotalOver, @JsonProperty("preMatchWinningMarginOther") PreMatchWinningMarginOther preMatchWinningMarginOther, @JsonProperty("preMatchSpreadAway") PreMatchSpreadAway preMatchSpreadAway, @JsonProperty("preMatchWinningMarginAway") PreMatchWinningMarginAway preMatchWinningMarginAway, @JsonProperty("preMatchTotalUnder") PreMatchTotalUnder preMatchTotalUnder, @JsonProperty("preMatchTotalHandicap") PreMatchTotalHandicap preMatchTotalHandicap, @JsonProperty("preMatchSpreadHandicapHome") PreMatchSpreadHandicapHome preMatchSpreadHandicapHome){
                    this.preMatchMoneyLineAway = preMatchMoneyLineAway;
                    this.preMatchMoneyLineHome = preMatchMoneyLineHome;
                    this.preMatchSpreadHandicapAway = preMatchSpreadHandicapAway;
                    this.preMatchSpreadHome = preMatchSpreadHome;
                    this.preMatchWinningMarginHome = preMatchWinningMarginHome;
                    this.preMatchTotalOver = preMatchTotalOver;
                    this.preMatchWinningMarginOther = preMatchWinningMarginOther;
                    this.preMatchSpreadAway = preMatchSpreadAway;
                    this.preMatchWinningMarginAway = preMatchWinningMarginAway;
                    this.preMatchTotalUnder = preMatchTotalUnder;
                    this.preMatchTotalHandicap = preMatchTotalHandicap;
                    this.preMatchSpreadHandicapHome = preMatchSpreadHandicapHome;
                }

                public static final class PreMatchMoneyLineAway {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchMoneyLineAway(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchMoneyLineHome {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchMoneyLineHome(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchSpreadHandicapAway {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchSpreadHandicapAway(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchSpreadHome {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchSpreadHome(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchWinningMarginHome {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchWinningMarginHome(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchTotalOver {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchTotalOver(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchWinningMarginOther {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchWinningMarginOther(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchSpreadAway {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchSpreadAway(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchWinningMarginAway {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchWinningMarginAway(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchTotalUnder {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchTotalUnder(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchTotalHandicap {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchTotalHandicap(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }

                public static final class PreMatchSpreadHandicapHome {
                    public final String oddId;
                    public final String value;
                    public final String betSlipUrl;

                    @JsonCreator
                    public PreMatchSpreadHandicapHome(@JsonProperty("oddId") String oddId, @JsonProperty("value") String value, @JsonProperty("betSlipUrl") String betSlipUrl){
                        this.oddId = oddId;
                        this.value = value;
                        this.betSlipUrl = betSlipUrl;
                    }
                }
            }
        }
    }

    public static final class Winprobability {
        public final long tiePercentage;
        public final double homeWinPercentage;
        public final long secondsLeft;
        public final String playId;

        @JsonCreator
        public Winprobability(@JsonProperty("tiePercentage") long tiePercentage, @JsonProperty("homeWinPercentage") double homeWinPercentage, @JsonProperty("secondsLeft") long secondsLeft, @JsonProperty("playId") String playId){
            this.tiePercentage = tiePercentage;
            this.homeWinPercentage = homeWinPercentage;
            this.secondsLeft = secondsLeft;
            this.playId = playId;
        }
    }

    public static final class Header {
        public final String id;
        public final String uid;
        public final Season season;
        public final boolean timeValid;
        public final Competition competitions[];
        public final Link links[];
        public final long week;
        public final League league;

        @JsonCreator
        public Header(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("season") Season season, @JsonProperty("timeValid") boolean timeValid, @JsonProperty("competitions") Competition[] competitions, @JsonProperty("links") Link[] links, @JsonProperty("week") long week, @JsonProperty("league") League league){
            this.id = id;
            this.uid = uid;
            this.season = season;
            this.timeValid = timeValid;
            this.competitions = competitions;
            this.links = links;
            this.week = week;
            this.league = league;
        }

        public static final class Season {
            public final long year;
            public final long type;

            @JsonCreator
            public Season(@JsonProperty("year") long year, @JsonProperty("type") long type){
                this.year = year;
                this.type = type;
            }
        }

        public static final class Competition {
            public final String id;
            public final String uid;
            public final String date;
            public final boolean neutralSite;
            public final boolean conferenceCompetition;
            public final boolean boxscoreAvailable;
            public final boolean commentaryAvailable;
            public final boolean liveAvailable;
            public final boolean onWatchESPN;
            public final boolean recent;
            public final String boxscoreSource;
            public final String playByPlaySource;
            public final Competitor competitors[];
            public final Status status;
            public final Broadcast broadcasts[];

            @JsonCreator
            public Competition(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("date") String date, @JsonProperty("neutralSite") boolean neutralSite, @JsonProperty("conferenceCompetition") boolean conferenceCompetition, @JsonProperty("boxscoreAvailable") boolean boxscoreAvailable, @JsonProperty("commentaryAvailable") boolean commentaryAvailable, @JsonProperty("liveAvailable") boolean liveAvailable, @JsonProperty("onWatchESPN") boolean onWatchESPN, @JsonProperty("recent") boolean recent, @JsonProperty("boxscoreSource") String boxscoreSource, @JsonProperty("playByPlaySource") String playByPlaySource, @JsonProperty("competitors") Competitor[] competitors, @JsonProperty("status") Status status, @JsonProperty("broadcasts") Broadcast[] broadcasts){
                this.id = id;
                this.uid = uid;
                this.date = date;
                this.neutralSite = neutralSite;
                this.conferenceCompetition = conferenceCompetition;
                this.boxscoreAvailable = boxscoreAvailable;
                this.commentaryAvailable = commentaryAvailable;
                this.liveAvailable = liveAvailable;
                this.onWatchESPN = onWatchESPN;
                this.recent = recent;
                this.boxscoreSource = boxscoreSource;
                this.playByPlaySource = playByPlaySource;
                this.competitors = competitors;
                this.status = status;
                this.broadcasts = broadcasts;
            }

            public static final class Competitor {
                public final String id;
                public final String uid;
                public final long order;
                public final String homeAway;
                public final Team team;
                public final String score;
                public final Linescore linescores[];
                public final Record record[];
                public final long timeoutsUsed;
                public final boolean possession;

                @JsonCreator
                public Competitor(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("order") long order, @JsonProperty("homeAway") String homeAway, @JsonProperty("team") Team team, @JsonProperty("score") String score, @JsonProperty("linescores") Linescore[] linescores, @JsonProperty("record") Record[] record, @JsonProperty("timeoutsUsed") long timeoutsUsed, @JsonProperty("possession") boolean possession){
                    this.id = id;
                    this.uid = uid;
                    this.order = order;
                    this.homeAway = homeAway;
                    this.team = team;
                    this.score = score;
                    this.linescores = linescores;
                    this.record = record;
                    this.timeoutsUsed = timeoutsUsed;
                    this.possession = possession;
                }

                public static final class Team {
                    public final String id;
                    public final String uid;
                    public final String location;
                    public final String name;
                    public final String nickname;
                    public final String abbreviation;
                    public final String displayName;
                    public final String color;
                    public final String alternateColor;
                    public final Logo logos[];
                    public final Link links[];

                    @JsonCreator
                    public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("nickname") String nickname, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("logos") Logo[] logos, @JsonProperty("links") Link[] links){
                        this.id = id;
                        this.uid = uid;
                        this.location = location;
                        this.name = name;
                        this.nickname = nickname;
                        this.abbreviation = abbreviation;
                        this.displayName = displayName;
                        this.color = color;
                        this.alternateColor = alternateColor;
                        this.logos = logos;
                        this.links = links;
                    }

                    public static final class Logo {
                        public final String href;
                        public final long width;
                        public final long height;
                        public final String alt;
                        public final String[] rel;
                        public final String lastUpdated;

                        @JsonCreator
                        public Logo(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("alt") String alt, @JsonProperty("rel") String[] rel, @JsonProperty("lastUpdated") String lastUpdated){
                            this.href = href;
                            this.width = width;
                            this.height = height;
                            this.alt = alt;
                            this.rel = rel;
                            this.lastUpdated = lastUpdated;
                        }
                    }

                    public static final class Link {
                        public final String[] rel;
                        public final String href;
                        public final String text;

                        @JsonCreator
                        public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text){
                            this.rel = rel;
                            this.href = href;
                            this.text = text;
                        }
                    }
                }

                public static final class Linescore {
                    public final String displayValue;

                    @JsonCreator
                    public Linescore(@JsonProperty("displayValue") String displayValue){
                        this.displayValue = displayValue;
                    }
                }

                public static final class Record {
                    public final String type;
                    public final String summary;
                    public final String displayValue;

                    @JsonCreator
                    public Record(@JsonProperty("type") String type, @JsonProperty("summary") String summary, @JsonProperty("displayValue") String displayValue){
                        this.type = type;
                        this.summary = summary;
                        this.displayValue = displayValue;
                    }
                }
            }

            public static final class Status {
                public final String displayClock;
                public final long period;
                public final Type type;

                @JsonCreator
                public Status(@JsonProperty("displayClock") String displayClock, @JsonProperty("period") long period, @JsonProperty("type") Type type){
                    this.displayClock = displayClock;
                    this.period = period;
                    this.type = type;
                }

                public static final class Type {
                    public final String id;
                    public final String name;
                    public final String state;
                    public final boolean completed;
                    public final String description;
                    public final String detail;
                    public final String shortDetail;

                    @JsonCreator
                    public Type(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("state") String state, @JsonProperty("completed") boolean completed, @JsonProperty("description") String description, @JsonProperty("detail") String detail, @JsonProperty("shortDetail") String shortDetail){
                        this.id = id;
                        this.name = name;
                        this.state = state;
                        this.completed = completed;
                        this.description = description;
                        this.detail = detail;
                        this.shortDetail = shortDetail;
                    }
                }
            }

            public static final class Broadcast {
                public final Type type;
                public final Market market;
                public final Media media;
                public final String lang;
                public final String region;

                @JsonCreator
                public Broadcast(@JsonProperty("type") Type type, @JsonProperty("market") Market market, @JsonProperty("media") Media media, @JsonProperty("lang") String lang, @JsonProperty("region") String region){
                    this.type = type;
                    this.market = market;
                    this.media = media;
                    this.lang = lang;
                    this.region = region;
                }

                public static final class Type {
                    public final String id;
                    public final String shortName;

                    @JsonCreator
                    public Type(@JsonProperty("id") String id, @JsonProperty("shortName") String shortName){
                        this.id = id;
                        this.shortName = shortName;
                    }
                }

                public static final class Market {
                    public final String id;
                    public final String type;

                    @JsonCreator
                    public Market(@JsonProperty("id") String id, @JsonProperty("type") String type){
                        this.id = id;
                        this.type = type;
                    }
                }

                public static final class Media {
                    public final String shortName;

                    @JsonCreator
                    public Media(@JsonProperty("shortName") String shortName){
                        this.shortName = shortName;
                    }
                }
            }
        }

        public static final class Link {
            public final String[] rel;
            public final String href;
            public final String text;
            public final String shortText;
            public final boolean isExternal;
            public final boolean isPremium;

            @JsonCreator
            public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text, @JsonProperty("shortText") String shortText, @JsonProperty("isExternal") boolean isExternal, @JsonProperty("isPremium") boolean isPremium){
                this.rel = rel;
                this.href = href;
                this.text = text;
                this.shortText = shortText;
                this.isExternal = isExternal;
                this.isPremium = isPremium;
            }
        }

        public static final class League {
            public final String id;
            public final String uid;
            public final String name;
            public final String abbreviation;
            public final String slug;
            public final boolean isTournament;
            public final Link links[];

            @JsonCreator
            public League(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("isTournament") boolean isTournament, @JsonProperty("links") Link[] links){
                this.id = id;
                this.uid = uid;
                this.name = name;
                this.abbreviation = abbreviation;
                this.slug = slug;
                this.isTournament = isTournament;
                this.links = links;
            }

            public static final class Link {
                public final String[] rel;
                public final String href;
                public final String text;

                @JsonCreator
                public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text){
                    this.rel = rel;
                    this.href = href;
                    this.text = text;
                }
            }
        }
    }

    public static final class ScoringPlay {
        public final String id;
        public final Type type;
        public final String text;
        public final long awayScore;
        public final long homeScore;
        public final Period period;
        public final Clock clock;
        public final Team team;
        public final ScoringType scoringType;

        @JsonCreator
        public ScoringPlay(@JsonProperty("id") String id, @JsonProperty("type") Type type, @JsonProperty("text") String text, @JsonProperty("awayScore") long awayScore, @JsonProperty("homeScore") long homeScore, @JsonProperty("period") Period period, @JsonProperty("clock") Clock clock, @JsonProperty("team") Team team, @JsonProperty("scoringType") ScoringType scoringType){
            this.id = id;
            this.type = type;
            this.text = text;
            this.awayScore = awayScore;
            this.homeScore = homeScore;
            this.period = period;
            this.clock = clock;
            this.team = team;
            this.scoringType = scoringType;
        }

        public static final class Type {
            public final String id;
            public final String text;
            public final String abbreviation;

            @JsonCreator
            public Type(@JsonProperty("id") String id, @JsonProperty("text") String text, @JsonProperty("abbreviation") String abbreviation){
                this.id = id;
                this.text = text;
                this.abbreviation = abbreviation;
            }
        }

        public static final class Period {
            public final long number;

            @JsonCreator
            public Period(@JsonProperty("number") long number){
                this.number = number;
            }
        }

        public static final class Clock {
            public final long value;
            public final String displayValue;

            @JsonCreator
            public Clock(@JsonProperty("value") long value, @JsonProperty("displayValue") String displayValue){
                this.value = value;
                this.displayValue = displayValue;
            }
        }

        public static final class Team {
            public final String id;
            public final String uid;
            public final String displayName;
            public final String abbreviation;
            public final Link links[];
            public final String logo;

            @JsonCreator
            public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("links") Link[] links, @JsonProperty("logo") String logo){
                this.id = id;
                this.uid = uid;
                this.displayName = displayName;
                this.abbreviation = abbreviation;
                this.links = links;
                this.logo = logo;
            }

            public static final class Link {
                public final String href;
                public final String text;

                @JsonCreator
                public Link(@JsonProperty("href") String href, @JsonProperty("text") String text){
                    this.href = href;
                    this.text = text;
                }
            }
        }

        public static final class ScoringType {
            public final String name;
            public final String displayName;
            public final String abbreviation;

            @JsonCreator
            public ScoringType(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation){
                this.name = name;
                this.displayName = displayName;
                this.abbreviation = abbreviation;
            }
        }
    }

    public static final class Video {

        @JsonCreator
        public Video(){
        }
    }

    public static final class News {
        public final String header;
        public final Link link;
        public final Article articles[];

        @JsonCreator
        public News(@JsonProperty("header") String header, @JsonProperty("link") Link link, @JsonProperty("articles") Article[] articles){
            this.header = header;
            this.link = link;
            this.articles = articles;
        }

        public static final class Link {
            public final String language;
            public final String[] rel;
            public final String href;
            public final String text;
            public final String shortText;
            public final boolean isExternal;
            public final boolean isPremium;

            @JsonCreator
            public Link(@JsonProperty("language") String language, @JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text, @JsonProperty("shortText") String shortText, @JsonProperty("isExternal") boolean isExternal, @JsonProperty("isPremium") boolean isPremium){
                this.language = language;
                this.rel = rel;
                this.href = href;
                this.text = text;
                this.shortText = shortText;
                this.isExternal = isExternal;
                this.isPremium = isPremium;
            }
        }

        public static final class Article {
            public final Image images[];
            public final String description;
            public final String published;
            public final String type;
            public final boolean premium;
            public final Links links;
            public final String lastModified;
            public final Category categories[];
            public final String headline;
            public final String byline;

            @JsonCreator
            public Article(@JsonProperty("images") Image[] images, @JsonProperty("description") String description, @JsonProperty("published") String published, @JsonProperty("type") String type, @JsonProperty("premium") boolean premium, @JsonProperty("links") Links links, @JsonProperty("lastModified") String lastModified, @JsonProperty("categories") Category[] categories, @JsonProperty("headline") String headline, @JsonProperty("byline") String byline){
                this.images = images;
                this.description = description;
                this.published = published;
                this.type = type;
                this.premium = premium;
                this.links = links;
                this.lastModified = lastModified;
                this.categories = categories;
                this.headline = headline;
                this.byline = byline;
            }

            public static final class Image {
                public final String name;
                public final long width;
                public final String alt;
                public final String caption;
                public final String url;
                public final long height;

                @JsonCreator
                public Image(@JsonProperty("name") String name, @JsonProperty("width") long width, @JsonProperty("alt") String alt, @JsonProperty("caption") String caption, @JsonProperty("url") String url, @JsonProperty("height") long height){
                    this.name = name;
                    this.width = width;
                    this.alt = alt;
                    this.caption = caption;
                    this.url = url;
                    this.height = height;
                }
            }

            public static final class Links {
                public final Api api;
                public final Web web;

                @JsonCreator
                public Links(@JsonProperty("api") Api api, @JsonProperty("web") Web web){
                    this.api = api;
                    this.web = web;
                }

                public static final class Api {
                    public final ApiNews news;
                    public final Self self;

                    @JsonCreator
                    public Api(@JsonProperty("news") ApiNews news, @JsonProperty("self") Self self){
                        this.news = news;
                        this.self = self;
                    }

                    public static final class ApiNews {
                        public final String href;

                        @JsonCreator
                        public ApiNews(@JsonProperty("href") String href){
                            this.href = href;
                        }
                    }

                    public static final class Self {
                        public final String href;

                        @JsonCreator
                        public Self(@JsonProperty("href") String href){
                            this.href = href;
                        }
                    }
                }

                public static final class Web {
                    public final String href;
                    public final Short _short;

                    @JsonCreator
                    public Web(@JsonProperty("href") String href, @JsonProperty("short") Short _short){
                        this.href = href;
                        this._short = _short;
                    }

                    public static final class Short {
                        public final String href;

                        @JsonCreator
                        public Short(@JsonProperty("href") String href){
                            this.href = href;
                        }
                    }
                }
            }

            public static final class Category {
                public final Long id;
                public final String description;
                public final String type;
                public final Long sportId;
                public final Long leagueId;
                public final League league;
                public final String uid;
                public final String createDate;
                public final Long athleteId;
                public final Athlete athlete;
                public final Long teamId;
                public final Team team;
                public final String guid;

                @JsonCreator
                public Category(@JsonProperty(value="id", required=false) Long id, @JsonProperty(value="description", required=false) String description, @JsonProperty("type") String type, @JsonProperty(value="sportId", required=false) Long sportId, @JsonProperty(value="leagueId", required=false) Long leagueId, @JsonProperty(value="league", required=false) League league, @JsonProperty(value="uid", required=false) String uid, @JsonProperty("createDate") String createDate, @JsonProperty(value="athleteId", required=false) Long athleteId, @JsonProperty(value="athlete", required=false) Athlete athlete, @JsonProperty(value="teamId", required=false) Long teamId, @JsonProperty(value="team", required=false) Team team, @JsonProperty(value="guid", required=false) String guid){
                    this.id = id;
                    this.description = description;
                    this.type = type;
                    this.sportId = sportId;
                    this.leagueId = leagueId;
                    this.league = league;
                    this.uid = uid;
                    this.createDate = createDate;
                    this.athleteId = athleteId;
                    this.athlete = athlete;
                    this.teamId = teamId;
                    this.team = team;
                    this.guid = guid;
                }

                public static final class League {
                    public final long id;
                    public final String description;
                    public final Links links;

                    @JsonCreator
                    public League(@JsonProperty("id") long id, @JsonProperty("description") String description, @JsonProperty("links") Links links){
                        this.id = id;
                        this.description = description;
                        this.links = links;
                    }

                    public static final class Links {
                        public final Api api;
                        public final Web web;
                        public final Mobile mobile;

                        @JsonCreator
                        public Links(@JsonProperty("api") Api api, @JsonProperty("web") Web web, @JsonProperty("mobile") Mobile mobile){
                            this.api = api;
                            this.web = web;
                            this.mobile = mobile;
                        }

                        public static final class Api {
                            public final Leagues leagues;

                            @JsonCreator
                            public Api(@JsonProperty("leagues") Leagues leagues){
                                this.leagues = leagues;
                            }

                            public static final class Leagues {
                                public final String href;

                                @JsonCreator
                                public Leagues(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }

                        public static final class Web {
                            public final Leagues leagues;

                            @JsonCreator
                            public Web(@JsonProperty("leagues") Leagues leagues){
                                this.leagues = leagues;
                            }

                            public static final class Leagues {
                                public final String href;

                                @JsonCreator
                                public Leagues(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }

                        public static final class Mobile {
                            public final Leagues leagues;

                            @JsonCreator
                            public Mobile(@JsonProperty("leagues") Leagues leagues){
                                this.leagues = leagues;
                            }

                            public static final class Leagues {
                                public final String href;

                                @JsonCreator
                                public Leagues(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }
                    }
                }

                public static final class Athlete {
                    public final long id;
                    public final String description;
                    public final Links links;

                    @JsonCreator
                    public Athlete(@JsonProperty("id") long id, @JsonProperty("description") String description, @JsonProperty("links") Links links){
                        this.id = id;
                        this.description = description;
                        this.links = links;
                    }

                    public static final class Links {
                        public final Api api;
                        public final Web web;
                        public final Mobile mobile;

                        @JsonCreator
                        public Links(@JsonProperty("api") Api api, @JsonProperty("web") Web web, @JsonProperty("mobile") Mobile mobile){
                            this.api = api;
                            this.web = web;
                            this.mobile = mobile;
                        }

                        public static final class Api {
                            public final Athletes athletes;

                            @JsonCreator
                            public Api(@JsonProperty("athletes") Athletes athletes){
                                this.athletes = athletes;
                            }

                            public static final class Athletes {
                                public final String href;

                                @JsonCreator
                                public Athletes(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }

                        public static final class Web {
                            public final Athletes athletes;

                            @JsonCreator
                            public Web(@JsonProperty("athletes") Athletes athletes){
                                this.athletes = athletes;
                            }

                            public static final class Athletes {
                                public final String href;

                                @JsonCreator
                                public Athletes(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }

                        public static final class Mobile {
                            public final Athletes athletes;

                            @JsonCreator
                            public Mobile(@JsonProperty("athletes") Athletes athletes){
                                this.athletes = athletes;
                            }

                            public static final class Athletes {
                                public final String href;

                                @JsonCreator
                                public Athletes(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }
                    }
                }

                public static final class Team {
                    public final long id;
                    public final String description;
                    public final Links links;

                    @JsonCreator
                    public Team(@JsonProperty("id") long id, @JsonProperty("description") String description, @JsonProperty("links") Links links){
                        this.id = id;
                        this.description = description;
                        this.links = links;
                    }

                    public static final class Links {
                        public final Api api;
                        public final Web web;
                        public final Mobile mobile;

                        @JsonCreator
                        public Links(@JsonProperty("api") Api api, @JsonProperty("web") Web web, @JsonProperty("mobile") Mobile mobile){
                            this.api = api;
                            this.web = web;
                            this.mobile = mobile;
                        }

                        public static final class Api {
                            public final Teams teams;

                            @JsonCreator
                            public Api(@JsonProperty("teams") Teams teams){
                                this.teams = teams;
                            }

                            public static final class Teams {
                                public final String href;

                                @JsonCreator
                                public Teams(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }

                        public static final class Web {
                            public final Teams teams;

                            @JsonCreator
                            public Web(@JsonProperty("teams") Teams teams){
                                this.teams = teams;
                            }

                            public static final class Teams {
                                public final String href;

                                @JsonCreator
                                public Teams(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }

                        public static final class Mobile {
                            public final Teams teams;

                            @JsonCreator
                            public Mobile(@JsonProperty("teams") Teams teams){
                                this.teams = teams;
                            }

                            public static final class Teams {
                                public final String href;

                                @JsonCreator
                                public Teams(@JsonProperty("href") String href){
                                    this.href = href;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class Standings {
        public final FullViewLink fullViewLink;
        public final Group groups[];

        @JsonCreator
        public Standings(@JsonProperty("fullViewLink") FullViewLink fullViewLink, @JsonProperty("groups") Group[] groups){
            this.fullViewLink = fullViewLink;
            this.groups = groups;
        }

        public static final class FullViewLink {
            public final String text;
            public final String href;

            @JsonCreator
            public FullViewLink(@JsonProperty("text") String text, @JsonProperty("href") String href){
                this.text = text;
                this.href = href;
            }
        }

        public static final class Group {
            public final GroupStandings standings;
            public final String header;
            public final String href;

            @JsonCreator
            public Group(@JsonProperty("standings") GroupStandings standings, @JsonProperty("header") String header, @JsonProperty("href") String href){
                this.standings = standings;
                this.header = header;
                this.href = href;
            }

            public static final class GroupStandings {
                public final Entry entries[];

                @JsonCreator
                public GroupStandings(@JsonProperty("entries") Entry[] entries){
                    this.entries = entries;
                }

                public static final class Entry {
                    public final String team;
                    public final String link;
                    public final String id;
                    public final String uid;
                    public final Stat stats[];
                    public final Logo logo[];

                    @JsonCreator
                    public Entry(@JsonProperty("team") String team, @JsonProperty("link") String link, @JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("stats") Stat[] stats, @JsonProperty("logo") Logo[] logo){
                        this.team = team;
                        this.link = link;
                        this.id = id;
                        this.uid = uid;
                        this.stats = stats;
                        this.logo = logo;
                    }

                    public static final class Stat {
                        public final String name;
                        public final String displayName;
                        public final String shortDisplayName;
                        public final String description;
                        public final String abbreviation;
                        public final String type;
                        public final Long value;
                        public final String displayValue;
                        public final String id;
                        public final String summary;

                        @JsonCreator
                        public Stat(@JsonProperty("name") String name, @JsonProperty(value="displayName", required=false) String displayName, @JsonProperty(value="shortDisplayName", required=false) String shortDisplayName, @JsonProperty(value="description", required=false) String description, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("type") String type, @JsonProperty(value="value", required=false) Long value, @JsonProperty("displayValue") String displayValue, @JsonProperty(value="id", required=false) String id, @JsonProperty(value="summary", required=false) String summary){
                            this.name = name;
                            this.displayName = displayName;
                            this.shortDisplayName = shortDisplayName;
                            this.description = description;
                            this.abbreviation = abbreviation;
                            this.type = type;
                            this.value = value;
                            this.displayValue = displayValue;
                            this.id = id;
                            this.summary = summary;
                        }
                    }

                    public static final class Logo {
                        public final String href;
                        public final long width;
                        public final long height;
                        public final String alt;
                        public final String[] rel;
                        public final String lastUpdated;

                        @JsonCreator
                        public Logo(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("alt") String alt, @JsonProperty("rel") String[] rel, @JsonProperty("lastUpdated") String lastUpdated){
                            this.href = href;
                            this.width = width;
                            this.height = height;
                            this.alt = alt;
                            this.rel = rel;
                            this.lastUpdated = lastUpdated;
                        }
                    }
                }
            }
        }
    }
}
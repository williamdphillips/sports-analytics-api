package com.phillips.sportsanalytics.response;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Container(containerName = "NFL_Scoreboards")
public final class ScoreboardResponse {
    public final String id;
    public final League leagues[];
    public final Season season;
    public final Week week;
    public final Event events[];

    @JsonCreator
    public ScoreboardResponse(@JsonProperty("leagues") League[] leagues, @JsonProperty("season") Season season, @JsonProperty("week") Week week, @JsonProperty("events") Event[] events){
        this.leagues = leagues;
        this.season = season;
        this.week = week;
        this.events = events;
        this.id = "Y" + season.year + "S" + season.type + "W" + week;
    }

    public static final class League {
        public final String id;
        public final String uid;
        public final String name;
        public final String abbreviation;
        public final String slug;
        public final Season season;
        public final String calendarType;
        public final boolean calendarIsWhitelist;
        public final String calendarStartDate;
        public final String calendarEndDate;
        public final Calendar calendar[];

        @JsonCreator
        public League(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("season") Season season, @JsonProperty("calendarType") String calendarType, @JsonProperty("calendarIsWhitelist") boolean calendarIsWhitelist, @JsonProperty("calendarStartDate") String calendarStartDate, @JsonProperty("calendarEndDate") String calendarEndDate, @JsonProperty("calendar") Calendar[] calendar){
            this.id = id;
            this.uid = uid;
            this.name = name;
            this.abbreviation = abbreviation;
            this.slug = slug;
            this.season = season;
            this.calendarType = calendarType;
            this.calendarIsWhitelist = calendarIsWhitelist;
            this.calendarStartDate = calendarStartDate;
            this.calendarEndDate = calendarEndDate;
            this.calendar = calendar;
        }

        public static final class Season {
            public final long year;
            public final String startDate;
            public final String endDate;
            public final Type type;

            @JsonCreator
            public Season(@JsonProperty("year") long year, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("type") Type type){
                this.year = year;
                this.startDate = startDate;
                this.endDate = endDate;
                this.type = type;
            }

            public static final class Type {
                public final String id;
                public final long type;
                public final String name;
                public final String abbreviation;

                @JsonCreator
                public Type(@JsonProperty("id") String id, @JsonProperty("type") long type, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation){
                    this.id = id;
                    this.type = type;
                    this.name = name;
                    this.abbreviation = abbreviation;
                }
            }
        }

        public static final class Calendar {
            public final String label;
            public final String value;
            public final String startDate;
            public final String endDate;
            public final Entry entries[];

            @JsonCreator
            public Calendar(@JsonProperty("label") String label, @JsonProperty("value") String value, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("entries") Entry[] entries){
                this.label = label;
                this.value = value;
                this.startDate = startDate;
                this.endDate = endDate;
                this.entries = entries;
            }

            public static final class Entry {
                public final String label;
                public final String alternateLabel;
                public final String detail;
                public final String value;
                public final String startDate;
                public final String endDate;

                @JsonCreator
                public Entry(@JsonProperty("label") String label, @JsonProperty("alternateLabel") String alternateLabel, @JsonProperty("detail") String detail, @JsonProperty("value") String value, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate){
                    this.label = label;
                    this.alternateLabel = alternateLabel;
                    this.detail = detail;
                    this.value = value;
                    this.startDate = startDate;
                    this.endDate = endDate;
                }
            }
        }
    }

    public static final class Season {
        public final long type;
        public final long year;

        @JsonCreator
        public Season(@JsonProperty("type") long type, @JsonProperty("year") long year){
            this.type = type;
            this.year = year;
        }
    }

    public static final class Week {
        public final long number;

        @JsonCreator
        public Week(@JsonProperty("number") long number){
            this.number = number;
        }
    }

    public static final class Event {
        public final String id;
        public final String uid;
        public final String date;
        public final String name;
        public final String shortName;
        public final Season season;
        public final Competition competitions[];
        public final Link links[];
        public final Status status;
        public final Weather weather;

        @JsonCreator
        public Event(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("date") String date, @JsonProperty("name") String name, @JsonProperty("shortName") String shortName, @JsonProperty("season") Season season, @JsonProperty("competitions") Competition[] competitions, @JsonProperty("links") Link[] links, @JsonProperty("status") Status status, @JsonProperty("weather") Weather weather){
            this.id = id;
            this.uid = uid;
            this.date = date;
            this.name = name;
            this.shortName = shortName;
            this.season = season;
            this.competitions = competitions;
            this.links = links;
            this.status = status;
            this.weather = weather;
        }

        public static final class Season {
            public final long year;
            public final long type;
            public final String slug;

            @JsonCreator
            public Season(@JsonProperty("year") long year, @JsonProperty("type") long type, @JsonProperty("slug") String slug){
                this.year = year;
                this.type = type;
                this.slug = slug;
            }
        }

        public static final class Competition {
            public final String id;
            public final String uid;
            public final String date;
            public final long attendance;
            public final Type type;
            public final boolean timeValid;
            public final boolean neutralSite;
            public final boolean conferenceCompetition;
            public final boolean recent;
            public final Venue venue;
            public final Competitor competitors[];
            public final Note notes[];
            public final Status status;
            public final Broadcast broadcasts[];
            public final Leader leaders[];
            public final Ticket tickets[];
            public final String startDate;
            public final GeoBroadcast geoBroadcasts[];
            public final Odd odds[];

            @JsonCreator
            public Competition(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("date") String date, @JsonProperty("attendance") long attendance, @JsonProperty("type") Type type, @JsonProperty("timeValid") boolean timeValid, @JsonProperty("neutralSite") boolean neutralSite, @JsonProperty("conferenceCompetition") boolean conferenceCompetition, @JsonProperty("recent") boolean recent, @JsonProperty("venue") Venue venue, @JsonProperty("competitors") Competitor[] competitors, @JsonProperty("notes") Note[] notes, @JsonProperty("status") Status status, @JsonProperty("broadcasts") Broadcast[] broadcasts, @JsonProperty("leaders") Leader[] leaders, @JsonProperty("tickets") Ticket[] tickets, @JsonProperty("startDate") String startDate, @JsonProperty("geoBroadcasts") GeoBroadcast[] geoBroadcasts, @JsonProperty("odds") Odd[] odds){
                this.id = id;
                this.uid = uid;
                this.date = date;
                this.attendance = attendance;
                this.type = type;
                this.timeValid = timeValid;
                this.neutralSite = neutralSite;
                this.conferenceCompetition = conferenceCompetition;
                this.recent = recent;
                this.venue = venue;
                this.competitors = competitors;
                this.notes = notes;
                this.status = status;
                this.broadcasts = broadcasts;
                this.leaders = leaders;
                this.tickets = tickets;
                this.startDate = startDate;
                this.geoBroadcasts = geoBroadcasts;
                this.odds = odds;
            }

            public static final class Type {
                public final String id;
                public final String abbreviation;

                @JsonCreator
                public Type(@JsonProperty("id") String id, @JsonProperty("abbreviation") String abbreviation){
                    this.id = id;
                    this.abbreviation = abbreviation;
                }
            }

            public static final class Venue {
                public final String id;
                public final String fullName;
                public final Address address;
                public final long capacity;
                public final boolean indoor;

                @JsonCreator
                public Venue(@JsonProperty("id") String id, @JsonProperty("fullName") String fullName, @JsonProperty("address") Address address, @JsonProperty("capacity") long capacity, @JsonProperty("indoor") boolean indoor){
                    this.id = id;
                    this.fullName = fullName;
                    this.address = address;
                    this.capacity = capacity;
                    this.indoor = indoor;
                }

                public static final class Address {
                    public final String city;
                    public final String state;

                    @JsonCreator
                    public Address(@JsonProperty("city") String city, @JsonProperty("state") String state){
                        this.city = city;
                        this.state = state;
                    }
                }
            }

            public static final class Competitor {
                public final String id;
                public final String uid;
                public final String type;
                public final long order;
                public final String homeAway;
                public final Team team;
                public final String score;
                public final Statistic statistics[];
                public final Record records[];
                public final Leader leaders[];
                public final Object[] linescores;

                @JsonCreator
                public Competitor(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("type") String type, @JsonProperty("order") long order, @JsonProperty("homeAway") String homeAway, @JsonProperty("team") Team team, @JsonProperty("score") String score, @JsonProperty("statistics") Statistic[] statistics, @JsonProperty("records") Record[] records, @JsonProperty("leaders") Leader[] leaders, @JsonProperty("linescores") Object[] linescores){
                    this.id = id;
                    this.uid = uid;
                    this.type = type;
                    this.order = order;
                    this.homeAway = homeAway;
                    this.team = team;
                    this.score = score;
                    this.statistics = statistics;
                    this.records = records;
                    this.leaders = leaders;
                    this.linescores = linescores;
                }

                public static final class Team {
                    public final String id;
                    public final String uid;
                    public final String location;
                    public final String name;
                    public final String abbreviation;
                    public final String displayName;
                    public final String shortDisplayName;
                    public final String color;
                    public final String alternateColor;
                    public final boolean isActive;
                    public final Venue venue;
                    public final Link links[];
                    public final String logo;

                    @JsonCreator
                    public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("isActive") boolean isActive, @JsonProperty("venue") Venue venue, @JsonProperty("links") Link[] links, @JsonProperty("logo") String logo){
                        this.id = id;
                        this.uid = uid;
                        this.location = location;
                        this.name = name;
                        this.abbreviation = abbreviation;
                        this.displayName = displayName;
                        this.shortDisplayName = shortDisplayName;
                        this.color = color;
                        this.alternateColor = alternateColor;
                        this.isActive = isActive;
                        this.venue = venue;
                        this.links = links;
                        this.logo = logo;
                    }

                    public static final class Venue {
                        public final String id;

                        @JsonCreator
                        public Venue(@JsonProperty("id") String id){
                            this.id = id;
                        }
                    }

                    public static final class Link {
                        public final String[] rel;
                        public final String href;
                        public final String text;
                        public final boolean isExternal;
                        public final boolean isPremium;

                        @JsonCreator
                        public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href, @JsonProperty("text") String text, @JsonProperty("isExternal") boolean isExternal, @JsonProperty("isPremium") boolean isPremium){
                            this.rel = rel;
                            this.href = href;
                            this.text = text;
                            this.isExternal = isExternal;
                            this.isPremium = isPremium;
                        }
                    }
                }

                public static final class Statistic {

                    @JsonCreator
                    public Statistic(){
                    }
                }

                public static final class Record {
                    public final String name;
                    public final String abbreviation;
                    public final String type;
                    public final String summary;

                    @JsonCreator
                    public Record(@JsonProperty("name") String name, @JsonProperty(value="abbreviation", required=false) String abbreviation, @JsonProperty("type") String type, @JsonProperty("summary") String summary){
                        this.name = name;
                        this.abbreviation = abbreviation;
                        this.type = type;
                        this.summary = summary;
                    }
                }

                public static final class Leader {
                    public final String name;
                    public final String displayName;
                    public final String shortDisplayName;
                    public final String abbreviation;
                    public final Leader leaders[];

                    @JsonCreator
                    public Leader(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaders") Leader[] leaders){
                        this.name = name;
                        this.displayName = displayName;
                        this.shortDisplayName = shortDisplayName;
                        this.abbreviation = abbreviation;
                        this.leaders = leaders;
                    }

                    public static final class SubLeader {
                        public final String displayValue;
                        public final long value;
                        public final Athlete athlete;
                        public final Team team;

                        @JsonCreator
                        public SubLeader(@JsonProperty("displayValue") String displayValue, @JsonProperty("value") long value, @JsonProperty("athlete") Athlete athlete, @JsonProperty("team") Team team){
                            this.displayValue = displayValue;
                            this.value = value;
                            this.athlete = athlete;
                            this.team = team;
                        }

                        public static final class Athlete {
                            public final String id;
                            public final String fullName;
                            public final String displayName;
                            public final String shortName;
                            public final Link links[];
                            public final String headshot;
                            public final String jersey;
                            public final Position position;
                            public final Team team;
                            public final boolean active;

                            @JsonCreator
                            public Athlete(@JsonProperty("id") String id, @JsonProperty("fullName") String fullName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("links") Link[] links, @JsonProperty("headshot") String headshot, @JsonProperty("jersey") String jersey, @JsonProperty("position") Position position, @JsonProperty("team") Team team, @JsonProperty("active") boolean active){
                                this.id = id;
                                this.fullName = fullName;
                                this.displayName = displayName;
                                this.shortName = shortName;
                                this.links = links;
                                this.headshot = headshot;
                                this.jersey = jersey;
                                this.position = position;
                                this.team = team;
                                this.active = active;
                            }

                            public static final class Link {
                                public final String[] rel;
                                public final String href;

                                @JsonCreator
                                public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href){
                                    this.rel = rel;
                                    this.href = href;
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
                                public final String id;

                                @JsonCreator
                                public Team(@JsonProperty("id") String id){
                                    this.id = id;
                                }
                            }
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

            public static final class Note {
                public String type;
                public String headline;
            }

            public static final class Status {
                public final long clock;
                public final String displayClock;
                public final long period;
                public final Type type;

                @JsonCreator
                public Status(@JsonProperty("clock") long clock, @JsonProperty("displayClock") String displayClock, @JsonProperty("period") long period, @JsonProperty("type") Type type){
                    this.clock = clock;
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
                public final String market;
                public final String[] names;

                @JsonCreator
                public Broadcast(@JsonProperty("market") String market, @JsonProperty("names") String[] names){
                    this.market = market;
                    this.names = names;
                }
            }

            public static final class Leader {
                public final String name;
                public final String displayName;
                public final String shortDisplayName;
                public final String abbreviation;
                public final Leader leaders[];

                @JsonCreator
                public Leader(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaders") Leader[] leaders){
                    this.name = name;
                    this.displayName = displayName;
                    this.shortDisplayName = shortDisplayName;
                    this.abbreviation = abbreviation;
                    this.leaders = leaders;
                }

                public static final class MyLeader {
                    public final String displayValue;
                    public final long value;
                    public final LeaderAthlete athlete;
                    public final Team team;

                    @JsonCreator
                    public MyLeader(@JsonProperty("displayValue") String displayValue, @JsonProperty("value") long value, @JsonProperty("athlete") LeaderAthlete athlete, @JsonProperty("team") Team team){
                        this.displayValue = displayValue;
                        this.value = value;
                        this.athlete = athlete;
                        this.team = team;
                    }

                    public static final class LeaderAthlete {
                        public final String id;
                        public final String fullName;
                        public final String displayName;
                        public final String shortName;
                        public final Link links[];
                        public final String headshot;
                        public final String jersey;
                        public final Position position;
                        public final Team team;
                        public final boolean active;

                        @JsonCreator
                        public LeaderAthlete(@JsonProperty("id") String id, @JsonProperty("fullName") String fullName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("links") Link[] links, @JsonProperty("headshot") String headshot, @JsonProperty("jersey") String jersey, @JsonProperty("position") Position position, @JsonProperty("team") Team team, @JsonProperty("active") boolean active){
                            this.id = id;
                            this.fullName = fullName;
                            this.displayName = displayName;
                            this.shortName = shortName;
                            this.links = links;
                            this.headshot = headshot;
                            this.jersey = jersey;
                            this.position = position;
                            this.team = team;
                            this.active = active;
                        }

                        public static final class Link {
                            public final String[] rel;
                            public final String href;

                            @JsonCreator
                            public Link(@JsonProperty("rel") String[] rel, @JsonProperty("href") String href){
                                this.rel = rel;
                                this.href = href;
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
                            public final String id;

                            @JsonCreator
                            public Team(@JsonProperty("id") String id){
                                this.id = id;
                            }
                        }
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

            public static final class Ticket {
                public final String summary;
                public final long numberAvailable;
                public final Link links[];

                @JsonCreator
                public Ticket(@JsonProperty("summary") String summary, @JsonProperty("numberAvailable") long numberAvailable, @JsonProperty("links") Link[] links){
                    this.summary = summary;
                    this.numberAvailable = numberAvailable;
                    this.links = links;
                }

                public static final class Link {
                    public final String href;

                    @JsonCreator
                    public Link(@JsonProperty("href") String href){
                        this.href = href;
                    }
                }
            }

            public static final class GeoBroadcast {
                public final Type type;
                public final Market market;
                public final Media media;
                public final String lang;
                public final String region;

                @JsonCreator
                public GeoBroadcast(@JsonProperty("type") Type type, @JsonProperty("market") Market market, @JsonProperty("media") Media media, @JsonProperty("lang") String lang, @JsonProperty("region") String region){
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

            public static final class Odd {
                public final Provider provider;
                public final String details;
                public final long overUnder;

                @JsonCreator
                public Odd(@JsonProperty("provider") Provider provider, @JsonProperty("details") String details, @JsonProperty("overUnder") long overUnder){
                    this.provider = provider;
                    this.details = details;
                    this.overUnder = overUnder;
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
            }
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

        public static final class Status {
            public final long clock;
            public final String displayClock;
            public final long period;
            public final Type type;

            @JsonCreator
            public Status(@JsonProperty("clock") long clock, @JsonProperty("displayClock") String displayClock, @JsonProperty("period") long period, @JsonProperty("type") Type type){
                this.clock = clock;
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

        public static final class Weather {
            public final String displayValue;
            public final long highTemperature;
            public final String conditionId;

            @JsonCreator
            public Weather(@JsonProperty("displayValue") String displayValue, @JsonProperty("highTemperature") long highTemperature, @JsonProperty("conditionId") String conditionId){
                this.displayValue = displayValue;
                this.highTemperature = highTemperature;
                this.conditionId = conditionId;
            }
        }
    }
}

package com.phillips.sportsanalytics.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class TeamResponse {
    public final Team team;

    @JsonCreator
    public TeamResponse(@JsonProperty("team") Team team){
        this.team = team;
    }

    public static final class Team {
        public final String id;
        public final String uid;
        public final String slug;
        public final String location;
        public final String name;
        public final String nickname;
        public final String abbreviation;
        public final String displayName;
        public final String shortDisplayName;
        public final String color;
        public final String alternateColor;
        public final boolean isActive;
        public final Logo logos[];
        public final Record record;
        public final Athlete athletes[];
        public final Groups groups;
        public final Link links[];
        public final NextEvent nextEvent[];
        public final String standingSummary;

        @JsonCreator
        public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("slug") String slug, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("nickname") String nickname, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("isActive") boolean isActive, @JsonProperty("logos") Logo[] logos, @JsonProperty("record") Record record, @JsonProperty("athletes") Athlete[] athletes, @JsonProperty("groups") Groups groups, @JsonProperty("links") Link[] links, @JsonProperty("nextEvent") NextEvent[] nextEvent, @JsonProperty("standingSummary") String standingSummary){
            this.id = id;
            this.uid = uid;
            this.slug = slug;
            this.location = location;
            this.name = name;
            this.nickname = nickname;
            this.abbreviation = abbreviation;
            this.displayName = displayName;
            this.shortDisplayName = shortDisplayName;
            this.color = color;
            this.alternateColor = alternateColor;
            this.isActive = isActive;
            this.logos = logos;
            this.record = record;
            this.athletes = athletes;
            this.groups = groups;
            this.links = links;
            this.nextEvent = nextEvent;
            this.standingSummary = standingSummary;
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

        public static final class Record {
            public final Item items[];

            @JsonCreator
            public Record(@JsonProperty("items") Item[] items){
                this.items = items;
            }

            public static final class Item {
                public final String type;
                public final String summary;
                public final Stat stats[];
                public final String description;

                @JsonCreator
                public Item(@JsonProperty("type") String type, @JsonProperty("summary") String summary, @JsonProperty("stats") Stat[] stats, @JsonProperty("description") String description){
                    this.type = type;
                    this.summary = summary;
                    this.stats = stats;
                    this.description = description;
                }

                public static final class Stat {
                    public final String name;
                    public final long value;

                    @JsonCreator
                    public Stat(@JsonProperty("name") String name, @JsonProperty("value") long value){
                        this.name = name;
                        this.value = value;
                    }
                }
            }
        }

        public static final class Athlete {
            public final String id;
            public final String uid;
            public final String guid;
            public final String type;
            public final AlternateIds alternateIds;
            public final String firstName;
            public final String lastName;
            public final String fullName;
            public final String displayName;
            public final String shortName;
            public final long weight;
            public final String displayWeight;
            public final long height;
            public final String displayHeight;
            public final long age;
            public final String dateOfBirth;
            public final Long debutYear;
            public final Link links[];
            public final BirthPlace birthPlace;
            public final College college;
            public final String slug;
            public final Headshot headshot;
            public final String jersey;
            public final Position position;
            public final Injury injuries[];
            public final boolean linked;
            public final Team teams[];
            public final Projections projections;
            public final Experience experience;
            public final CollegeAthlete collegeAthlete;
            public final boolean active;
            public final EventLog eventLog;
            public final Status status;
            public final Draft draft;
            public final Hand hand;

            @JsonCreator
            public Athlete(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("type") String type, @JsonProperty("alternateIds") AlternateIds alternateIds, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("fullName") String fullName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("weight") long weight, @JsonProperty("displayWeight") String displayWeight, @JsonProperty("height") long height, @JsonProperty("displayHeight") String displayHeight, @JsonProperty("age") long age, @JsonProperty("dateOfBirth") String dateOfBirth, @JsonProperty(value="debutYear", required=false) Long debutYear, @JsonProperty("links") Link[] links, @JsonProperty("birthPlace") BirthPlace birthPlace, @JsonProperty("college") College college, @JsonProperty("slug") String slug, @JsonProperty("headshot") Headshot headshot, @JsonProperty("jersey") String jersey, @JsonProperty("position") Position position, @JsonProperty("injuries") Injury[] injuries, @JsonProperty("linked") boolean linked, @JsonProperty("teams") Team[] teams, @JsonProperty("projections") Projections projections, @JsonProperty("experience") Experience experience, @JsonProperty("collegeAthlete") CollegeAthlete collegeAthlete, @JsonProperty("active") boolean active, @JsonProperty("eventLog") EventLog eventLog, @JsonProperty("status") Status status, @JsonProperty("draft") Draft draft, @JsonProperty("hand") Hand hand){
                this.id = id;
                this.uid = uid;
                this.guid = guid;
                this.type = type;
                this.alternateIds = alternateIds;
                this.firstName = firstName;
                this.lastName = lastName;
                this.fullName = fullName;
                this.displayName = displayName;
                this.shortName = shortName;
                this.weight = weight;
                this.displayWeight = displayWeight;
                this.height = height;
                this.displayHeight = displayHeight;
                this.age = age;
                this.dateOfBirth = dateOfBirth;
                this.debutYear = debutYear;
                this.links = links;
                this.birthPlace = birthPlace;
                this.college = college;
                this.slug = slug;
                this.headshot = headshot;
                this.jersey = jersey;
                this.position = position;
                this.injuries = injuries;
                this.linked = linked;
                this.teams = teams;
                this.projections = projections;
                this.experience = experience;
                this.collegeAthlete = collegeAthlete;
                this.active = active;
                this.eventLog = eventLog;
                this.status = status;
                this.draft = draft;
                this.hand = hand;
            }

            public static final class AlternateIds {
                public final String sdr;

                @JsonCreator
                public AlternateIds(@JsonProperty("sdr") String sdr){
                    this.sdr = sdr;
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

            public static final class BirthPlace {
                public final String city;
                public final String state;
                public final String country;

                @JsonCreator
                public BirthPlace(@JsonProperty("city") String city, @JsonProperty("state") String state, @JsonProperty("country") String country){
                    this.city = city;
                    this.state = state;
                    this.country = country;
                }
            }

            public static final class College {

                @JsonCreator
                public College(){
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
                public final String id;
                public final String name;
                public final String displayName;
                public final String abbreviation;
                public final boolean leaf;
                public final Parent parent;

                @JsonCreator
                public Position(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaf") boolean leaf, @JsonProperty("parent") Parent parent){
                    this.id = id;
                    this.name = name;
                    this.displayName = displayName;
                    this.abbreviation = abbreviation;
                    this.leaf = leaf;
                    this.parent = parent;
                }

                public static final class Parent {

                    @JsonCreator
                    public Parent(){
                    }
                }
            }

            public static final class Injury {

                @JsonCreator
                public Injury(){
                }
            }

            public static final class Projections {

                @JsonCreator
                public Projections(){
                }
            }

            public static final class Experience {
                public final long years;

                @JsonCreator
                public Experience(@JsonProperty("years") long years){
                    this.years = years;
                }
            }

            public static final class CollegeAthlete {

                @JsonCreator
                public CollegeAthlete(){
                }
            }

            public static final class EventLog {

                @JsonCreator
                public EventLog(){
                }
            }

            public static final class Status {
                public final String id;
                public final String name;
                public final String type;
                public final String abbreviation;

                @JsonCreator
                public Status(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("type") String type, @JsonProperty("abbreviation") String abbreviation){
                    this.id = id;
                    this.name = name;
                    this.type = type;
                    this.abbreviation = abbreviation;
                }
            }

            public static final class Draft {
                public final String displayText;
                public final long round;
                public final long year;
                public final long selection;

                @JsonCreator
                public Draft(@JsonProperty("displayText") String displayText, @JsonProperty("round") long round, @JsonProperty("year") long year, @JsonProperty("selection") long selection){
                    this.displayText = displayText;
                    this.round = round;
                    this.year = year;
                    this.selection = selection;
                }
            }

            public static final class Hand {
                public final String type;
                public final String abbreviation;
                public final String displayValue;

                @JsonCreator
                public Hand(@JsonProperty("type") String type, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayValue") String displayValue){
                    this.type = type;
                    this.abbreviation = abbreviation;
                    this.displayValue = displayValue;
                }
            }
        }

        public static final class Groups {
            public final String id;
            public final Parent parent;
            public final boolean isConference;

            @JsonCreator
            public Groups(@JsonProperty("id") String id, @JsonProperty("parent") Parent parent, @JsonProperty("isConference") boolean isConference){
                this.id = id;
                this.parent = parent;
                this.isConference = isConference;
            }

            public static final class Parent {
                public final String id;

                @JsonCreator
                public Parent(@JsonProperty("id") String id){
                    this.id = id;
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

        public static final class NextEvent {
            public final String id;
            public final String date;
            public final String name;
            public final String shortName;
            public final Season season;
            public final SeasonType seasonType;
            public final Week week;
            public final boolean timeValid;
            public final Competition competitions[];
            public final Link links[];

            @JsonCreator
            public NextEvent(@JsonProperty("id") String id, @JsonProperty("date") String date, @JsonProperty("name") String name, @JsonProperty("shortName") String shortName, @JsonProperty("season") Season season, @JsonProperty("seasonType") SeasonType seasonType, @JsonProperty("week") Week week, @JsonProperty("timeValid") boolean timeValid, @JsonProperty("competitions") Competition[] competitions, @JsonProperty("links") Link[] links){
                this.id = id;
                this.date = date;
                this.name = name;
                this.shortName = shortName;
                this.season = season;
                this.seasonType = seasonType;
                this.week = week;
                this.timeValid = timeValid;
                this.competitions = competitions;
                this.links = links;
            }

            public static final class Season {
                public final long year;
                public final String displayName;

                @JsonCreator
                public Season(@JsonProperty("year") long year, @JsonProperty("displayName") String displayName){
                    this.year = year;
                    this.displayName = displayName;
                }
            }

            public static final class SeasonType {
                public final String id;
                public final long type;
                public final String name;
                public final String abbreviation;

                @JsonCreator
                public SeasonType(@JsonProperty("id") String id, @JsonProperty("type") long type, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation){
                    this.id = id;
                    this.type = type;
                    this.name = name;
                    this.abbreviation = abbreviation;
                }
            }

            public static final class Week {
                public final long number;
                public final String text;

                @JsonCreator
                public Week(@JsonProperty("number") long number, @JsonProperty("text") String text){
                    this.number = number;
                    this.text = text;
                }
            }

            public static final class Competition {
                public final String id;
                public final String date;
                public final long attendance;
                public final Type type;
                public final boolean timeValid;
                public final boolean neutralSite;
                public final boolean boxscoreAvailable;
                public final boolean ticketsAvailable;
                public final Venue venue;
                public final Competitor competitors[];
                public final Note notes[];
                public final Broadcast broadcasts[];
                public final Status status;

                @JsonCreator
                public Competition(@JsonProperty("id") String id, @JsonProperty("date") String date, @JsonProperty("attendance") long attendance, @JsonProperty("type") Type type, @JsonProperty("timeValid") boolean timeValid, @JsonProperty("neutralSite") boolean neutralSite, @JsonProperty("boxscoreAvailable") boolean boxscoreAvailable, @JsonProperty("ticketsAvailable") boolean ticketsAvailable, @JsonProperty("venue") Venue venue, @JsonProperty("competitors") Competitor[] competitors, @JsonProperty("notes") Note[] notes, @JsonProperty("broadcasts") Broadcast[] broadcasts, @JsonProperty("status") Status status){
                    this.id = id;
                    this.date = date;
                    this.attendance = attendance;
                    this.type = type;
                    this.timeValid = timeValid;
                    this.neutralSite = neutralSite;
                    this.boxscoreAvailable = boxscoreAvailable;
                    this.ticketsAvailable = ticketsAvailable;
                    this.venue = venue;
                    this.competitors = competitors;
                    this.notes = notes;
                    this.broadcasts = broadcasts;
                    this.status = status;
                }

                public static final class Type {
                    public final String id;
                    public final String text;
                    public final String abbreviation;
                    public final String slug;
                    public final String type;

                    @JsonCreator
                    public Type(@JsonProperty("id") String id, @JsonProperty("text") String text, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("type") String type){
                        this.id = id;
                        this.text = text;
                        this.abbreviation = abbreviation;
                        this.slug = slug;
                        this.type = type;
                    }
                }

                public static final class Venue {
                    public final String fullName;
                    public final Address address;

                    @JsonCreator
                    public Venue(@JsonProperty("fullName") String fullName, @JsonProperty("address") Address address){
                        this.fullName = fullName;
                        this.address = address;
                    }

                    public static final class Address {
                        public final String city;
                        public final String state;
                        public final String zipCode;

                        @JsonCreator
                        public Address(@JsonProperty("city") String city, @JsonProperty("state") String state, @JsonProperty("zipCode") String zipCode){
                            this.city = city;
                            this.state = state;
                            this.zipCode = zipCode;
                        }
                    }
                }

                public static final class Competitor {
                    public final String id;
                    public final String type;
                    public final long order;
                    public final String homeAway;
                    public final CompetitorTeam team;
                    public final Leader leaders[];

                    @JsonCreator
                    public Competitor(@JsonProperty("id") String id, @JsonProperty("type") String type, @JsonProperty("order") long order, @JsonProperty("homeAway") String homeAway, @JsonProperty("team") CompetitorTeam team, @JsonProperty(value="leaders", required=false) Leader[] leaders){
                        this.id = id;
                        this.type = type;
                        this.order = order;
                        this.homeAway = homeAway;
                        this.team = team;
                        this.leaders = leaders;
                    }

                    public static final class CompetitorTeam {
                        public final String id;
                        public final String location;
                        public final String nickname;
                        public final String abbreviation;
                        public final String displayName;
                        public final String shortDisplayName;
                        public final Logo logos[];
                        public final Link links[];

                        @JsonCreator
                        public CompetitorTeam(@JsonProperty("id") String id, @JsonProperty("location") String location, @JsonProperty("nickname") String nickname, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("logos") Logo[] logos, @JsonProperty("links") Link[] links){
                            this.id = id;
                            this.location = location;
                            this.nickname = nickname;
                            this.abbreviation = abbreviation;
                            this.displayName = displayName;
                            this.shortDisplayName = shortDisplayName;
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

                    public static final class Leader {
                        public final String name;
                        public final String displayName;
                        public final String abbreviation;
                        public final SubLeader leaders[];

                        @JsonCreator
                        public Leader(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaders") SubLeader[] leaders){
                            this.name = name;
                            this.displayName = displayName;
                            this.abbreviation = abbreviation;
                            this.leaders = leaders;
                        }

                        public static final class SubLeader {
                            public final String displayValue;
                            public final long value;
                            public final Athlete athlete;

                            @JsonCreator
                            public SubLeader(@JsonProperty("displayValue") String displayValue, @JsonProperty("value") long value, @JsonProperty("athlete") Athlete athlete){
                                this.displayValue = displayValue;
                                this.value = value;
                                this.athlete = athlete;
                            }

                            public static final class Athlete {
                                public final String id;
                                public final String lastName;
                                public final String displayName;
                                public final String shortName;
                                public final Link links[];

                                @JsonCreator
                                public Athlete(@JsonProperty("id") String id, @JsonProperty("lastName") String lastName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("links") Link[] links){
                                    this.id = id;
                                    this.lastName = lastName;
                                    this.displayName = displayName;
                                    this.shortName = shortName;
                                    this.links = links;
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
                            }
                        }
                    }
                }

                public static final class Note {

                    @JsonCreator
                    public Note(){
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
        }
    }
}
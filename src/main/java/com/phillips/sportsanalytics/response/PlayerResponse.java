package com.phillips.sportsanalytics.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class PlayerResponse {
    public final Athlete athlete;
    public final Season season;
    public final League league;
    public final News news;
    public final PlayerSwitcher playerSwitcher;
    public final Quicklink quicklinks[];
    public final Link links[];

    @JsonCreator
    public PlayerResponse(@JsonProperty("athlete") Athlete athlete, @JsonProperty("season") Season season, @JsonProperty("league") League league, @JsonProperty("news") News news, @JsonProperty("playerSwitcher") PlayerSwitcher playerSwitcher, @JsonProperty("quicklinks") Quicklink[] quicklinks, @JsonProperty("links") Link[] links){
        this.athlete = athlete;
        this.season = season;
        this.league = league;
        this.news = news;
        this.playerSwitcher = playerSwitcher;
        this.quicklinks = quicklinks;
        this.links = links;
    }

    public static final class Athlete {
        public final String id;
        public final String uid;
        public final String guid;
        public final String type;
        public final String firstName;
        public final String lastName;
        public final String displayName;
        public final String fullName;
        public final long debutYear;
        public final String jersey;
        public final Link links[];
        public final College college;
        public final Position position;
        public final Team team;
        public final boolean active;
        public final Status status;
        public final StatsSummary statsSummary;
        public final String displayBirthPlace;
        public final String displayHeight;
        public final String displayWeight;
        public final String displayDOB;
        public final long age;
        public final String displayJersey;
        public final String displayExperience;

        @JsonCreator
        public Athlete(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("type") String type, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("displayName") String displayName, @JsonProperty("fullName") String fullName, @JsonProperty("debutYear") long debutYear, @JsonProperty("jersey") String jersey, @JsonProperty("links") Link[] links, @JsonProperty("college") College college, @JsonProperty("position") Position position, @JsonProperty("team") Team team, @JsonProperty("active") boolean active, @JsonProperty("status") Status status, @JsonProperty("statsSummary") StatsSummary statsSummary, @JsonProperty("displayBirthPlace") String displayBirthPlace, @JsonProperty("displayHeight") String displayHeight, @JsonProperty("displayWeight") String displayWeight, @JsonProperty("displayDOB") String displayDOB, @JsonProperty("age") long age, @JsonProperty("displayJersey") String displayJersey, @JsonProperty("displayExperience") String displayExperience){
            this.id = id;
            this.uid = uid;
            this.guid = guid;
            this.type = type;
            this.firstName = firstName;
            this.lastName = lastName;
            this.displayName = displayName;
            this.fullName = fullName;
            this.debutYear = debutYear;
            this.jersey = jersey;
            this.links = links;
            this.college = college;
            this.position = position;
            this.team = team;
            this.active = active;
            this.status = status;
            this.statsSummary = statsSummary;
            this.displayBirthPlace = displayBirthPlace;
            this.displayHeight = displayHeight;
            this.displayWeight = displayWeight;
            this.displayDOB = displayDOB;
            this.age = age;
            this.displayJersey = displayJersey;
            this.displayExperience = displayExperience;
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

        public static final class College {
            public final String id;
            public final String mascot;
            public final String name;
            public final String shortName;
            public final String abbrev;

            @JsonCreator
            public College(@JsonProperty("id") String id, @JsonProperty("mascot") String mascot, @JsonProperty("name") String name, @JsonProperty("shortName") String shortName, @JsonProperty("abbrev") String abbrev){
                this.id = id;
                this.mascot = mascot;
                this.name = name;
                this.shortName = shortName;
                this.abbrev = abbrev;
            }
        }

        public static final class Position {
            public final String id;
            public final String name;
            public final String displayName;
            public final String abbreviation;
            public final boolean leaf;
            public final Parent parent;
            public final String slug;

            @JsonCreator
            public Position(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaf") boolean leaf, @JsonProperty("parent") Parent parent, @JsonProperty("slug") String slug){
                this.id = id;
                this.name = name;
                this.displayName = displayName;
                this.abbreviation = abbreviation;
                this.leaf = leaf;
                this.parent = parent;
                this.slug = slug;
            }

            public static final class Parent {
                public final boolean leaf;

                @JsonCreator
                public Parent(@JsonProperty("leaf") boolean leaf){
                    this.leaf = leaf;
                }
            }
        }

        public static final class Team {
            public final String id;
            public final String uid;
            public final String guid;
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
            public final boolean isAllStar;
            public final Logo logos[];
            public final Link links[];
            public final Groups groups;
            public final Coaches coaches;
            public final Venue venue;
            public final Record record;
            public final AgainstTheSpreadRecords againstTheSpreadRecords;
            public final Ranks ranks;

            @JsonCreator
            public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("slug") String slug, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("nickname") String nickname, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("isActive") boolean isActive, @JsonProperty("isAllStar") boolean isAllStar, @JsonProperty("logos") Logo[] logos, @JsonProperty("links") Link[] links, @JsonProperty("groups") Groups groups, @JsonProperty("coaches") Coaches coaches, @JsonProperty("venue") Venue venue, @JsonProperty("record") Record record, @JsonProperty("againstTheSpreadRecords") AgainstTheSpreadRecords againstTheSpreadRecords, @JsonProperty("ranks") Ranks ranks){
                this.id = id;
                this.uid = uid;
                this.guid = guid;
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
                this.isAllStar = isAllStar;
                this.logos = logos;
                this.links = links;
                this.groups = groups;
                this.coaches = coaches;
                this.venue = venue;
                this.record = record;
                this.againstTheSpreadRecords = againstTheSpreadRecords;
                this.ranks = ranks;
            }

            public static final class Logo {
                public final String href;
                public final long width;
                public final long height;
                public final String[] rel;

                @JsonCreator
                public Logo(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("rel") String[] rel){
                    this.href = href;
                    this.width = width;
                    this.height = height;
                    this.rel = rel;
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

            public static final class Groups {
                public final String uid;
                public final String id;
                public final String name;
                public final String abbreviation;
                public final String slug;
                public final Season season;
                public final Parent parent;
                public final Standings standings;
                public final boolean isConference;
                public final Teams teams;

                @JsonCreator
                public Groups(@JsonProperty("uid") String uid, @JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("season") Season season, @JsonProperty("parent") Parent parent, @JsonProperty("standings") Standings standings, @JsonProperty("isConference") boolean isConference, @JsonProperty("teams") Teams teams){
                    this.uid = uid;
                    this.id = id;
                    this.name = name;
                    this.abbreviation = abbreviation;
                    this.slug = slug;
                    this.season = season;
                    this.parent = parent;
                    this.standings = standings;
                    this.isConference = isConference;
                    this.teams = teams;
                }

                public static final class Season {
                    public final long year;
                    public final String startDate;
                    public final String endDate;
                    public final Type type;
                    public final Types types;
                    public final String displayName;

                    @JsonCreator
                    public Season(@JsonProperty("year") long year, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("type") Type type, @JsonProperty("types") Types types, @JsonProperty("displayName") String displayName){
                        this.year = year;
                        this.startDate = startDate;
                        this.endDate = endDate;
                        this.type = type;
                        this.types = types;
                        this.displayName = displayName;
                    }

                    public static final class Type {
                        public final String id;
                        public final long type;
                        public final String name;
                        public final String abbreviation;
                        public final String slug;
                        public final String startDate;
                        public final String endDate;
                        public final boolean hasGroups;
                        public final boolean hasStandings;
                        public final boolean hasLegs;
                        public final Weeks weeks;
                        public final long year;

                        @JsonCreator
                        public Type(@JsonProperty("id") String id, @JsonProperty("type") long type, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("hasGroups") boolean hasGroups, @JsonProperty("hasStandings") boolean hasStandings, @JsonProperty("hasLegs") boolean hasLegs, @JsonProperty("weeks") Weeks weeks, @JsonProperty("year") long year){
                            this.id = id;
                            this.type = type;
                            this.name = name;
                            this.abbreviation = abbreviation;
                            this.slug = slug;
                            this.startDate = startDate;
                            this.endDate = endDate;
                            this.hasGroups = hasGroups;
                            this.hasStandings = hasStandings;
                            this.hasLegs = hasLegs;
                            this.weeks = weeks;
                            this.year = year;
                        }

                        public static final class Weeks {

                            @JsonCreator
                            public Weeks(){
                            }
                        }
                    }

                    public static final class Types {
                        public final long count;
                        public final long pageIndex;
                        public final long pageSize;
                        public final long pageCount;
                        public final Item items[];

                        @JsonCreator
                        public Types(@JsonProperty("count") long count, @JsonProperty("pageIndex") long pageIndex, @JsonProperty("pageSize") long pageSize, @JsonProperty("pageCount") long pageCount, @JsonProperty("items") Item[] items){
                            this.count = count;
                            this.pageIndex = pageIndex;
                            this.pageSize = pageSize;
                            this.pageCount = pageCount;
                            this.items = items;
                        }

                        public static final class Item {
                            public final String id;
                            public final long type;
                            public final String name;
                            public final String abbreviation;
                            public final String slug;
                            public final String startDate;
                            public final String endDate;
                            public final boolean hasGroups;
                            public final boolean hasStandings;
                            public final boolean hasLegs;
                            public final Weeks weeks;
                            public final long year;

                            @JsonCreator
                            public Item(@JsonProperty("id") String id, @JsonProperty("type") long type, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("hasGroups") boolean hasGroups, @JsonProperty("hasStandings") boolean hasStandings, @JsonProperty("hasLegs") boolean hasLegs, @JsonProperty("weeks") Weeks weeks, @JsonProperty("year") long year){
                                this.id = id;
                                this.type = type;
                                this.name = name;
                                this.abbreviation = abbreviation;
                                this.slug = slug;
                                this.startDate = startDate;
                                this.endDate = endDate;
                                this.hasGroups = hasGroups;
                                this.hasStandings = hasStandings;
                                this.hasLegs = hasLegs;
                                this.weeks = weeks;
                                this.year = year;
                            }

                            public static final class Weeks {

                                @JsonCreator
                                public Weeks(){
                                }
                            }
                        }
                    }
                }

                public static final class Parent {
                    public final String uid;
                    public final String id;
                    public final String name;
                    public final String abbreviation;
                    public final String slug;
                    public final Season season;
                    public final Parent parent;
                    public final Standings standings;
                    public final boolean isConference;
                    public final Teams teams;

                    @JsonCreator
                    public Parent(@JsonProperty("uid") String uid, @JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("season") Season season, @JsonProperty("parent") Parent parent, @JsonProperty("standings") Standings standings, @JsonProperty("isConference") boolean isConference, @JsonProperty("teams") Teams teams){
                        this.uid = uid;
                        this.id = id;
                        this.name = name;
                        this.abbreviation = abbreviation;
                        this.slug = slug;
                        this.season = season;
                        this.parent = parent;
                        this.standings = standings;
                        this.isConference = isConference;
                        this.teams = teams;
                    }

                    public static final class Season {

                        @JsonCreator
                        public Season(){
                        }
                    }

                    public static final class Standings {

                        @JsonCreator
                        public Standings(){
                        }
                    }

                    public static final class Teams {

                        @JsonCreator
                        public Teams(){
                        }
                    }
                }

                public static final class Standings {

                    @JsonCreator
                    public Standings(){
                    }
                }

                public static final class Teams {

                    @JsonCreator
                    public Teams(){
                    }
                }
            }

            public static final class Coaches {

                @JsonCreator
                public Coaches(){
                }
            }

            public static final class Venue {
                public final String id;
                public final String fullName;
                public final Address address;
                public final long capacity;
                public final boolean grass;
                public final boolean indoor;
                public final Image images[];

                @JsonCreator
                public Venue(@JsonProperty("id") String id, @JsonProperty("fullName") String fullName, @JsonProperty("address") Address address, @JsonProperty("capacity") long capacity, @JsonProperty("grass") boolean grass, @JsonProperty("indoor") boolean indoor, @JsonProperty("images") Image[] images){
                    this.id = id;
                    this.fullName = fullName;
                    this.address = address;
                    this.capacity = capacity;
                    this.grass = grass;
                    this.indoor = indoor;
                    this.images = images;
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

                public static final class Image {
                    public final String href;
                    public final long width;
                    public final long height;
                    public final String[] rel;

                    @JsonCreator
                    public Image(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("rel") String[] rel){
                        this.href = href;
                        this.width = width;
                        this.height = height;
                        this.rel = rel;
                    }
                }
            }

            public static final class Record {

                @JsonCreator
                public Record(){
                }
            }

            public static final class AgainstTheSpreadRecords {

                @JsonCreator
                public AgainstTheSpreadRecords(){
                }
            }

            public static final class Ranks {

                @JsonCreator
                public Ranks(){
                }
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

        public static final class StatsSummary {
            public final String displayName;
            public final Statistic statistics[];

            @JsonCreator
            public StatsSummary(@JsonProperty("displayName") String displayName, @JsonProperty("statistics") Statistic[] statistics){
                this.displayName = displayName;
                this.statistics = statistics;
            }

            public static final class Statistic {
                public final String name;
                public final String displayName;
                public final String shortDisplayName;
                public final String description;
                public final String abbreviation;
                public final long value;
                public final String displayValue;

                @JsonCreator
                public Statistic(@JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("description") String description, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("value") long value, @JsonProperty("displayValue") String displayValue){
                    this.name = name;
                    this.displayName = displayName;
                    this.shortDisplayName = shortDisplayName;
                    this.description = description;
                    this.abbreviation = abbreviation;
                    this.value = value;
                    this.displayValue = displayValue;
                }
            }
        }
    }

    public static final class Season {
        public final long year;
        public final String startDate;
        public final String endDate;
        public final Type type;
        public final Types types;
        public final String displayName;

        @JsonCreator
        public Season(@JsonProperty("year") long year, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("type") Type type, @JsonProperty("types") Types types, @JsonProperty("displayName") String displayName){
            this.year = year;
            this.startDate = startDate;
            this.endDate = endDate;
            this.type = type;
            this.types = types;
            this.displayName = displayName;
        }

        public static final class Type {
            public final String id;
            public final long type;
            public final String name;
            public final String abbreviation;
            public final String slug;
            public final String startDate;
            public final String endDate;
            public final boolean hasGroups;
            public final boolean hasStandings;
            public final boolean hasLegs;
            public final Week week;
            public final Weeks weeks;
            public final long year;

            @JsonCreator
            public Type(@JsonProperty("id") String id, @JsonProperty("type") long type, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("hasGroups") boolean hasGroups, @JsonProperty("hasStandings") boolean hasStandings, @JsonProperty("hasLegs") boolean hasLegs, @JsonProperty("week") Week week, @JsonProperty("weeks") Weeks weeks, @JsonProperty("year") long year){
                this.id = id;
                this.type = type;
                this.name = name;
                this.abbreviation = abbreviation;
                this.slug = slug;
                this.startDate = startDate;
                this.endDate = endDate;
                this.hasGroups = hasGroups;
                this.hasStandings = hasStandings;
                this.hasLegs = hasLegs;
                this.week = week;
                this.weeks = weeks;
                this.year = year;
            }

            public static final class Week {
                public final long number;
                public final String startDate;
                public final String endDate;
                public final String text;
                public final Qbr qbr;
                public final Talentpicks talentpicks;

                @JsonCreator
                public Week(@JsonProperty("number") long number, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("text") String text, @JsonProperty("qbr") Qbr qbr, @JsonProperty("talentpicks") Talentpicks talentpicks){
                    this.number = number;
                    this.startDate = startDate;
                    this.endDate = endDate;
                    this.text = text;
                    this.qbr = qbr;
                    this.talentpicks = talentpicks;
                }

                public static final class Qbr {

                    @JsonCreator
                    public Qbr(){
                    }
                }

                public static final class Talentpicks {

                    @JsonCreator
                    public Talentpicks(){
                    }
                }
            }

            public static final class Weeks {

                @JsonCreator
                public Weeks(){
                }
            }
        }

        public static final class Types {
            public final long count;
            public final long pageIndex;
            public final long pageSize;
            public final long pageCount;
            public final Item items[];

            @JsonCreator
            public Types(@JsonProperty("count") long count, @JsonProperty("pageIndex") long pageIndex, @JsonProperty("pageSize") long pageSize, @JsonProperty("pageCount") long pageCount, @JsonProperty("items") Item[] items){
                this.count = count;
                this.pageIndex = pageIndex;
                this.pageSize = pageSize;
                this.pageCount = pageCount;
                this.items = items;
            }

            public static final class Item {
                public final String id;
                public final long type;
                public final String name;
                public final String abbreviation;
                public final String slug;
                public final String startDate;
                public final String endDate;
                public final boolean hasGroups;
                public final boolean hasStandings;
                public final boolean hasLegs;
                public final Weeks weeks;
                public final long year;
                public final Week week;

                @JsonCreator
                public Item(@JsonProperty("id") String id, @JsonProperty("type") long type, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("slug") String slug, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("hasGroups") boolean hasGroups, @JsonProperty("hasStandings") boolean hasStandings, @JsonProperty("hasLegs") boolean hasLegs, @JsonProperty("weeks") Weeks weeks, @JsonProperty("year") long year, @JsonProperty(value="week", required=false) Week week){
                    this.id = id;
                    this.type = type;
                    this.name = name;
                    this.abbreviation = abbreviation;
                    this.slug = slug;
                    this.startDate = startDate;
                    this.endDate = endDate;
                    this.hasGroups = hasGroups;
                    this.hasStandings = hasStandings;
                    this.hasLegs = hasLegs;
                    this.weeks = weeks;
                    this.year = year;
                    this.week = week;
                }

                public static final class Weeks {

                    @JsonCreator
                    public Weeks(){
                    }
                }

                public static final class Week {
                    public final long number;
                    public final String startDate;
                    public final String endDate;
                    public final String text;
                    public final Qbr qbr;
                    public final Talentpicks talentpicks;

                    @JsonCreator
                    public Week(@JsonProperty("number") long number, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("text") String text, @JsonProperty("qbr") Qbr qbr, @JsonProperty("talentpicks") Talentpicks talentpicks){
                        this.number = number;
                        this.startDate = startDate;
                        this.endDate = endDate;
                        this.text = text;
                        this.qbr = qbr;
                        this.talentpicks = talentpicks;
                    }

                    public static final class Qbr {

                        @JsonCreator
                        public Qbr(){
                        }
                    }

                    public static final class Talentpicks {

                        @JsonCreator
                        public Talentpicks(){
                        }
                    }
                }
            }
        }
    }

    public static final class League {
        public final String id;
        public final String uid;
        public final String name;
        public final String abbreviation;
        public final Logo logos[];
        public final String shortName;

        @JsonCreator
        public League(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("logos") Logo[] logos, @JsonProperty("shortName") String shortName){
            this.id = id;
            this.uid = uid;
            this.name = name;
            this.abbreviation = abbreviation;
            this.logos = logos;
            this.shortName = shortName;
        }

        public static final class Logo {
            public final String href;
            public final long width;
            public final long height;
            public final String[] rel;

            @JsonCreator
            public Logo(@JsonProperty("href") String href, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("rel") String[] rel){
                this.href = href;
                this.width = width;
                this.height = height;
                this.rel = rel;
            }
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
            public final String headline;
            public final Links links;
            public final String description;
            public final Image images[];
            public final Category categories[];

            @JsonCreator
            public Article(@JsonProperty("headline") String headline, @JsonProperty("links") Links links, @JsonProperty("description") String description, @JsonProperty("images") Image[] images, @JsonProperty("categories") Category[] categories){
                this.headline = headline;
                this.links = links;
                this.description = description;
                this.images = images;
                this.categories = categories;
            }

            public static final class Links {
                public final Api api;
                public final Mobile mobile;
                public final Web web;

                @JsonCreator
                public Links(@JsonProperty("api") Api api, @JsonProperty("mobile") Mobile mobile, @JsonProperty("web") Web web){
                    this.api = api;
                    this.mobile = mobile;
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

                public static final class Mobile {
                    public final String href;

                    @JsonCreator
                    public Mobile(@JsonProperty("href") String href){
                        this.href = href;
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

            public static final class Image {
                public final String url;
                public final String credit;
                public final long width;
                public final long height;
                public final String alt;
                public final String caption;

                @JsonCreator
                public Image(@JsonProperty("url") String url, @JsonProperty("credit") String credit, @JsonProperty("width") long width, @JsonProperty("height") long height, @JsonProperty("alt") String alt, @JsonProperty("caption") String caption){
                    this.url = url;
                    this.credit = credit;
                    this.width = width;
                    this.height = height;
                    this.alt = alt;
                    this.caption = caption;
                }
            }

            public static final class Category {
                public final Long id;
                public final String uid;
                public final String description;
                public final String type;
                public final Long sportId;
                public final Long athleteId;
                public final Athlete athlete;
                public final Team team;
                public final Long leagueId;
                public final League league;

                @JsonCreator
                public Category(@JsonProperty(value="id", required=false) Long id, @JsonProperty(value="uid", required=false) String uid, @JsonProperty(value="description", required=false) String description, @JsonProperty("type") String type, @JsonProperty(value="sportId", required=false) Long sportId, @JsonProperty(value="athleteId", required=false) Long athleteId, @JsonProperty(value="athlete", required=false) Athlete athlete, @JsonProperty(value="team", required=false) Team team, @JsonProperty(value="leagueId", required=false) Long leagueId, @JsonProperty(value="league", required=false) League league){
                    this.id = id;
                    this.uid = uid;
                    this.description = description;
                    this.type = type;
                    this.sportId = sportId;
                    this.athleteId = athleteId;
                    this.athlete = athlete;
                    this.team = team;
                    this.leagueId = leagueId;
                    this.league = league;
                }

                public static final class Athlete {
                    public final long id;
                    public final Links links;

                    @JsonCreator
                    public Athlete(@JsonProperty("id") long id, @JsonProperty("links") Links links){
                        this.id = id;
                        this.links = links;
                    }

                    public static final class Links {
                        public final Web web;
                        public final Mobile mobile;
                        public final Api api;

                        @JsonCreator
                        public Links(@JsonProperty("web") Web web, @JsonProperty("mobile") Mobile mobile, @JsonProperty("api") Api api){
                            this.web = web;
                            this.mobile = mobile;
                            this.api = api;
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
                    }
                }

                public static final class Team {
                    public final long id;
                    public final Links links;

                    @JsonCreator
                    public Team(@JsonProperty("id") long id, @JsonProperty("links") Links links){
                        this.id = id;
                        this.links = links;
                    }

                    public static final class Links {
                        public final Web web;
                        public final Mobile mobile;
                        public final Api api;

                        @JsonCreator
                        public Links(@JsonProperty("web") Web web, @JsonProperty("mobile") Mobile mobile, @JsonProperty("api") Api api){
                            this.web = web;
                            this.mobile = mobile;
                            this.api = api;
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
                    }
                }

                public static final class League {
                    public final long id;
                    public final Links links;

                    @JsonCreator
                    public League(@JsonProperty("id") long id, @JsonProperty("links") Links links){
                        this.id = id;
                        this.links = links;
                    }

                    public static final class Links {
                        public final Web web;
                        public final Mobile mobile;
                        public final Api api;

                        @JsonCreator
                        public Links(@JsonProperty("web") Web web, @JsonProperty("mobile") Mobile mobile, @JsonProperty("api") Api api){
                            this.web = web;
                            this.mobile = mobile;
                            this.api = api;
                        }

                        public static final class Web {

                            @JsonCreator
                            public Web(){
                            }
                        }

                        public static final class Mobile {

                            @JsonCreator
                            public Mobile(){
                            }
                        }

                        public static final class Api {

                            @JsonCreator
                            public Api(){
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class PlayerSwitcher {
        public final Team team;
        public final Athlete athletes[];
        public final Link links[];
        public final Filter filters[];

        @JsonCreator
        public PlayerSwitcher(@JsonProperty("team") Team team, @JsonProperty("athletes") Athlete[] athletes, @JsonProperty("links") Link[] links, @JsonProperty("filters") Filter[] filters){
            this.team = team;
            this.athletes = athletes;
            this.links = links;
            this.filters = filters;
        }

        public static final class Team {
            public final String id;
            public final String uid;
            public final String slug;
            public final String location;
            public final String alternateLocation;
            public final String name;
            public final String abbreviation;
            public final String displayName;
            public final String shortDisplayName;
            public final String color;
            public final String alternateColor;
            public final String logo;
            public final Link links[];

            @JsonCreator
            public Team(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("slug") String slug, @JsonProperty("location") String location, @JsonProperty("alternateLocation") String alternateLocation, @JsonProperty("name") String name, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("displayName") String displayName, @JsonProperty("shortDisplayName") String shortDisplayName, @JsonProperty("color") String color, @JsonProperty("alternateColor") String alternateColor, @JsonProperty("logo") String logo, @JsonProperty("links") Link[] links){
                this.id = id;
                this.uid = uid;
                this.slug = slug;
                this.location = location;
                this.alternateLocation = alternateLocation;
                this.name = name;
                this.abbreviation = abbreviation;
                this.displayName = displayName;
                this.shortDisplayName = shortDisplayName;
                this.color = color;
                this.alternateColor = alternateColor;
                this.logo = logo;
                this.links = links;
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

        public static final class Athlete {
            public final String id;
            public final String uid;
            public final String guid;
            public final String displayName;
            public final String jersey;
            public final Link links[];
            public final Headshot headshot;
            public final Position position;
            public final String displayJersey;

            @JsonCreator
            public Athlete(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("displayName") String displayName, @JsonProperty("jersey") String jersey, @JsonProperty("links") Link[] links, @JsonProperty("headshot") Headshot headshot, @JsonProperty("position") Position position, @JsonProperty("displayJersey") String displayJersey){
                this.id = id;
                this.uid = uid;
                this.guid = guid;
                this.displayName = displayName;
                this.jersey = jersey;
                this.links = links;
                this.headshot = headshot;
                this.position = position;
                this.displayJersey = displayJersey;
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
                public final String slug;

                @JsonCreator
                public Position(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaf") boolean leaf, @JsonProperty("parent") Parent parent, @JsonProperty("slug") String slug){
                    this.id = id;
                    this.name = name;
                    this.displayName = displayName;
                    this.abbreviation = abbreviation;
                    this.leaf = leaf;
                    this.parent = parent;
                    this.slug = slug;
                }

                public static final class Parent {
                    public final boolean leaf;

                    @JsonCreator
                    public Parent(@JsonProperty("leaf") boolean leaf){
                        this.leaf = leaf;
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

        public static final class Filter {
            public final String displayName;
            public final String name;
            public final String value;
            public final Option options[];

            @JsonCreator
            public Filter(@JsonProperty("displayName") String displayName, @JsonProperty("name") String name, @JsonProperty("value") String value, @JsonProperty("options") Option[] options){
                this.displayName = displayName;
                this.name = name;
                this.value = value;
                this.options = options;
            }

            public static final class Option {
                public final String value;
                public final String displayValue;

                @JsonCreator
                public Option(@JsonProperty("value") String value, @JsonProperty("displayValue") String displayValue){
                    this.value = value;
                    this.displayValue = displayValue;
                }
            }
        }
    }

    public static final class Quicklink {
        public final String text;
        public final String title;
        public final Item items[];

        @JsonCreator
        public Quicklink(@JsonProperty("text") String text, @JsonProperty("title") String title, @JsonProperty("items") Item[] items){
            this.text = text;
            this.title = title;
            this.items = items;
        }

        public static final class Item {
            public final String title;
            public final Link links[];

            @JsonCreator
            public Item(@JsonProperty("title") String title, @JsonProperty("links") Link[] links){
                this.title = title;
                this.links = links;
            }

            public static final class Link {
                public final String href;
                public final String text;
                public final String shortText;
                public final boolean isExternal;
                public final boolean isPremium;
                public final Attributes attributes;

                @JsonCreator
                public Link(@JsonProperty("href") String href, @JsonProperty("text") String text, @JsonProperty("shortText") String shortText, @JsonProperty("isExternal") boolean isExternal, @JsonProperty("isPremium") boolean isPremium, @JsonProperty("attributes") Attributes attributes){
                    this.href = href;
                    this.text = text;
                    this.shortText = shortText;
                    this.isExternal = isExternal;
                    this.isPremium = isPremium;
                    this.attributes = attributes;
                }

                public static final class Attributes {
                    public final String icon;

                    @JsonCreator
                    public Attributes(@JsonProperty("icon") String icon){
                        this.icon = icon;
                    }
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
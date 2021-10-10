package com.phillips.sportsanalytics.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Roster {
    public final String timestamp;
    public final String status;
    public final Season season;
    public final Coach coach[];
    public final Athlete athletes[];
    public final Team team;

    @JsonCreator
    public Roster(@JsonProperty("timestamp") String timestamp, @JsonProperty("status") String status, @JsonProperty("season") Season season, @JsonProperty("coach") Coach[] coach, @JsonProperty("athletes") Athlete[] athletes, @JsonProperty("team") Team team){
        this.timestamp = timestamp;
        this.status = status;
        this.season = season;
        this.coach = coach;
        this.athletes = athletes;
        this.team = team;
    }

    public static final class Season {
        public final long year;
        public final long type;
        public final String name;

        @JsonCreator
        public Season(@JsonProperty("year") long year, @JsonProperty("type") long type, @JsonProperty("name") String name){
            this.year = year;
            this.type = type;
            this.name = name;
        }
    }

    public static final class Coach {
        public final String id;
        public final String firstName;
        public final String lastName;
        public final long experience;

        @JsonCreator
        public Coach(@JsonProperty("id") String id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("experience") long experience){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.experience = experience;
        }
    }

    public static final class Athlete {
        public final String position;
        public final Item items[];

        @JsonCreator
        public Athlete(@JsonProperty("position") String position, @JsonProperty("items") Item[] items){
            this.position = position;
            this.items = items;
        }

        public static final class Item {
            public final String id;
            public final String uid;
            public final String guid;
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
            public final Team teams[];
            public final Contract contracts[];
            public final Experience experience;
            public final Status status;
            public final Hand hand;

            @JsonCreator
            public Item(@JsonProperty("id") String id, @JsonProperty("uid") String uid, @JsonProperty("guid") String guid, @JsonProperty("alternateIds") AlternateIds alternateIds, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("fullName") String fullName, @JsonProperty("displayName") String displayName, @JsonProperty("shortName") String shortName, @JsonProperty("weight") long weight, @JsonProperty("displayWeight") String displayWeight, @JsonProperty("height") long height, @JsonProperty("displayHeight") String displayHeight, @JsonProperty("age") long age, @JsonProperty("dateOfBirth") String dateOfBirth, @JsonProperty(value="debutYear", required=false) Long debutYear, @JsonProperty("links") Link[] links, @JsonProperty("birthPlace") BirthPlace birthPlace, @JsonProperty("college") College college, @JsonProperty("slug") String slug, @JsonProperty("headshot") Headshot headshot, @JsonProperty("jersey") String jersey, @JsonProperty("position") Position position, @JsonProperty("injuries") Injury[] injuries, @JsonProperty("teams") Team[] teams, @JsonProperty("contracts") Contract[] contracts, @JsonProperty("experience") Experience experience, @JsonProperty("status") Status status, @JsonProperty("hand") Hand hand){
                this.id = id;
                this.uid = uid;
                this.guid = guid;
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
                this.teams = teams;
                this.contracts = contracts;
                this.experience = experience;
                this.status = status;
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
                    public final String id;
                    public final String name;
                    public final String displayName;
                    public final String abbreviation;
                    public final boolean leaf;

                    @JsonCreator
                    public Parent(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("leaf") boolean leaf){
                        this.id = id;
                        this.name = name;
                        this.displayName = displayName;
                        this.abbreviation = abbreviation;
                        this.leaf = leaf;
                    }
                }
            }

            public static final class Injury {
                public final String status;
                public final String date;

                @JsonCreator
                public Injury(@JsonProperty("status") String status, @JsonProperty("date") String date){
                    this.status = status;
                    this.date = date;
                }
            }

            public static final class Team {
                public final String $ref;

                @JsonCreator
                public Team(@JsonProperty("$ref") String $ref){
                    this.$ref = $ref;
                }
            }

            public static final class Contract {

                @JsonCreator
                public Contract(){
                }
            }

            public static final class Experience {
                public final long years;

                @JsonCreator
                public Experience(@JsonProperty("years") long years){
                    this.years = years;
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
    }

    public static final class Team {
        public final String id;
        public final String abbreviation;
        public final String location;
        public final String name;
        public final String displayName;
        public final String clubhouse;
        public final String color;
        public final String logo;
        public final String recordSummary;
        public final String seasonSummary;
        public final String standingSummary;
        public final Groups groups;

        @JsonCreator
        public Team(@JsonProperty("id") String id, @JsonProperty("abbreviation") String abbreviation, @JsonProperty("location") String location, @JsonProperty("name") String name, @JsonProperty("displayName") String displayName, @JsonProperty("clubhouse") String clubhouse, @JsonProperty("color") String color, @JsonProperty("logo") String logo, @JsonProperty("recordSummary") String recordSummary, @JsonProperty("seasonSummary") String seasonSummary, @JsonProperty("standingSummary") String standingSummary, @JsonProperty("groups") Groups groups){
            this.id = id;
            this.abbreviation = abbreviation;
            this.location = location;
            this.name = name;
            this.displayName = displayName;
            this.clubhouse = clubhouse;
            this.color = color;
            this.logo = logo;
            this.recordSummary = recordSummary;
            this.seasonSummary = seasonSummary;
            this.standingSummary = standingSummary;
            this.groups = groups;
        }

        public static final class Groups {
            public final String $ref;

            @JsonCreator
            public Groups(@JsonProperty("$ref") String $ref){
                this.$ref = $ref;
            }
        }
    }
}

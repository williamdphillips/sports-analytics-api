package com.phillips.sportsanalytics.constant;

public enum Team {
    ATLANTA_FALCONS("1", "Atlanta Falcons"),
    BUFFALO_BILLS("2", "Buffalo Bulls"),
    CHICAGO_BEARS("3", "Chicago Bears"),
    CINCINNATI_BENGALS("4", "Cincinnati Bengals"),
    CLEVELAND_BROWNS("5", "Cleveland Browns"),
    DALLAS_COWBOYS("6", "Dallas Cowboys"),
    DENVER_BRONCOS("7", "Denver Broncos"),
    DETROIT_LIONS("8", "Detroit Lions"),
    GREEN_BAY_PACKERS("9", "Green Bay Packers"),
    TENNESSEE_TITANS("10", "Tennessee Titans"),
    INDIANAPOLIS_COLTS("11", "Indianapolis Colts"),
    KANSAS_CITY_CHIEFS("12", "Kansas City Chiefs"),
    LAS_VEGAS_RAIDERS("13", "Las Vegas Raiders"),
    LOS_ANGELES_RAMS("14", "Los Angeles Rams"),
    MIAMI_DOLPHINS("15", "Miami Dolphins"),
    MINNESOTA_VIKINGS("16", "Minnesota Vikings"),
    NEW_ENGLAND_PATRIOTS("17", "New England Patriots"),
    NEW_ORLEANS_SAINTS("18", "New Orleans Saints"),
    NEW_YORK_GIANTS("19", "New York Giants"),
    NEW_YORK_JETS("20", "New York Jets"),
    PHILADELPHIA_EAGLES("21", "Philadelphia Eagles"),
    ARIZONA_CARDINALS("22", "Arizona Cardinals"),
    PITTSBURGH_STEELERS("23", "Pittsburgh Steelers"),
    LOS_ANGELES_CHARGERS("24", "Los Angeles Chargers"),
    SAN_FRANCISCO_49ERS("25", "San Francisco 49ers"),
    SEATTLE_SEAHAWKS("26", "Seattle Seahawks"),
    TAMPA_BAY_BUCCANEERS("27", "Tampa Bay Buccaneers"),
    WASHINGTON("28", "Washington"),
    CAROLINA_PANTHERS("29", "Carolina Panthers"),
    JACKSONVILLE_JAGUARS("30", "Jacksonville Jaguars"),
    AFC("31", "AFC"),
    NFC("32", "NFC"),
    BALTIMORE_RAVENS("33", "Baltimore Ravens"),
    HOUSTON_TEXANS("34", "Houston Texans");



    String id;
    String displayName;
    Team(String id, String displayName) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName(){
        return displayName;
    }
}

package com.phillips.sportsanalytics.constant;

public enum Team {
    ARIZONA_CARDINALS("22", "Arizona Cardinals", "ARI"),
    ATLANTA_FALCONS("1", "Atlanta Falcons", "ATL"),
    BALTIMORE_RAVENS("33", "Baltimore Ravens", "BAL"),
    BUFFALO_BILLS("2", "Buffalo Bulls", "BUF"),
    CAROLINA_PANTHERS("29", "Carolina Panthers", "CAR"),
    CHICAGO_BEARS("3", "Chicago Bears", "CHI"),
    CINCINNATI_BENGALS("4", "Cincinnati Bengals", "CIN"),
    CLEVELAND_BROWNS("5", "Cleveland Browns", "CLE"),
    DALLAS_COWBOYS("6", "Dallas Cowboys", "DAL"),
    DENVER_BRONCOS("7", "Denver Broncos", "DEN"),
    DETROIT_LIONS("8", "Detroit Lions", "DET"),
    GREEN_BAY_PACKERS("9", "Green Bay Packers", "GB"),
    HOUSTON_TEXANS("34", "Houston Texans", "HOU"),
    INDIANAPOLIS_COLTS("11", "Indianapolis Colts", "IND"),
    JACKSONVILLE_JAGUARS("30", "Jacksonville Jaguars", "JAX"),
    KANSAS_CITY_CHIEFS("12", "Kansas City Chiefs", "KC"),
    LAS_VEGAS_RAIDERS("13", "Las Vegas Raiders", "V"),
    LOS_ANGELES_CHARGERS("24", "Los Angeles Chargers", "LAC"),
    LOS_ANGELES_RAMS("14", "Los Angeles Rams", "LAR"),
    MIAMI_DOLPHINS("15", "Miami Dolphins", "MIA"),
    MINNESOTA_VIKINGS("16", "Minnesota Vikings", "MIN"),
    NEW_ENGLAND_PATRIOTS("17", "New England Patriots", "NE"),
    NEW_ORLEANS_SAINTS("18", "New Orleans Saints", "NO"),
    NEW_YORK_GIANTS("19", "New York Giants", "NYG"),
    NEW_YORK_JETS("20", "New York Jets", "NYJ"),
    PHILADELPHIA_EAGLES("21", "Philadelphia Eagles", "PHI"),
    PITTSBURGH_STEELERS("23", "Pittsburgh Steelers", "PIT"),
    SAN_FRANCISCO_49ERS("25", "San Francisco 49ers", "SF"),
    SEATTLE_SEAHAWKS("26", "Seattle Seahawks", "SEA"),
    TAMPA_BAY_BUCCANEERS("27", "Tampa Bay Buccaneers", "TB"),
    TENNESSEE_TITANS("10", "Tennessee Titans", "TEN"),
    WASHINGTON("28", "Washington Football Team", "WAS"),
    AFC("31", "AFC", "AFC"),
    NFC("32", "NFC", "NFC");



    String id;
    String displayName;
    String shortName;
    Team(String id, String displayName, String shortName) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName(){
        return displayName;
    }

    public String getShortName(){
        return shortName;
    }
}

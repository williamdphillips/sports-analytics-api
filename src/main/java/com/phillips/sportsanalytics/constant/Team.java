package com.phillips.sportsanalytics.constant;

public enum Team {
    ARIZONA_CARDINALS("22", "Arizona Cardinals", "Cardinals", "ARI"),
    ATLANTA_FALCONS("1", "Atlanta Falcons", "Falcons","ATL"),
    BALTIMORE_RAVENS("33", "Baltimore Ravens", "Ravens","BAL"),
    BUFFALO_BILLS("2", "Buffalo Bills", "Bills","BUF"),
    CAROLINA_PANTHERS("29", "Carolina Panthers", "Panthers","CAR"),
    CHICAGO_BEARS("3", "Chicago Bears", "Bears","CHI"),
    CINCINNATI_BENGALS("4", "Cincinnati Bengals", "Bengals","CIN"),
    CLEVELAND_BROWNS("5", "Cleveland Browns", "Browns","CLE"),
    DALLAS_COWBOYS("6", "Dallas Cowboys", "Cowboys","DAL"),
    DENVER_BRONCOS("7", "Denver Broncos", "Broncos","DEN"),
    DETROIT_LIONS("8", "Detroit Lions", "Lions","DET"),
    GREEN_BAY_PACKERS("9", "Green Bay Packers", "Packers","GB"),
    HOUSTON_TEXANS("34", "Houston Texans", "Texans","HOU"),
    INDIANAPOLIS_COLTS("11", "Indianapolis Colts", "Colts","IND"),
    JACKSONVILLE_JAGUARS("30", "Jacksonville Jaguars", "Jaguars","JAX"),
    KANSAS_CITY_CHIEFS("12", "Kansas City Chiefs", "Chiefs","KC"),
    LAS_VEGAS_RAIDERS("13", "Las Vegas Raiders", "Raiders","V"),
    LOS_ANGELES_CHARGERS("24", "Los Angeles Chargers", "Chargers","LAC"),
    LOS_ANGELES_RAMS("14", "Los Angeles Rams", "Rams","LAR"),
    MIAMI_DOLPHINS("15", "Miami Dolphins", "Dolphins","MIA"),
    MINNESOTA_VIKINGS("16", "Minnesota Vikings", "Vikings","MIN"),
    NEW_ENGLAND_PATRIOTS("17", "New England Patriots", "Patriots","NE"),
    NEW_ORLEANS_SAINTS("18", "New Orleans Saints", "Saints","NO"),
    NEW_YORK_GIANTS("19", "New York Giants", "Giants","NYG"),
    NEW_YORK_JETS("20", "New York Jets", "Jets","NYJ"),
    PHILADELPHIA_EAGLES("21", "Philadelphia Eagles", "Eagles","PHI"),
    PITTSBURGH_STEELERS("23", "Pittsburgh Steelers", "Steelers","PIT"),
    SAN_FRANCISCO_49ERS("25", "San Francisco 49ers", "49ers","SF"),
    SEATTLE_SEAHAWKS("26", "Seattle Seahawks", "Seahawks","SEA"),
    TAMPA_BAY_BUCCANEERS("27", "Tampa Bay Buccaneers", "Buccaneers","TB"),
    TENNESSEE_TITANS("10", "Tennessee Titans", "Titans","TEN"),
    WASHINGTON("28", "Washington Football Team", "Washington","WSH"),
    AFC("31", "AFC", "AFC","AFC"),
    NFC("32", "NFC", "NFC","NFC");



    String id;
    String displayName;
    String shortName;
    String abbrev;
    Team(String id, String displayName, String shortName, String abbrev) {
        this.id = id;
        this.displayName = displayName;
        this.shortName = shortName;
        this.abbrev = abbrev;
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

    public String getAbbrev() { return abbrev; }
}

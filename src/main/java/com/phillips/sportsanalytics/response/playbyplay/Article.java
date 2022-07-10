package com.phillips.sportsanalytics.response.playbyplay;

import java.util.ArrayList;
import java.util.Date;

public class Article{
    public ArrayList<Image> images;
    public String description;
    public Date published;
    public String type;
    public boolean premium;
    public Links links;
    public Date lastModified;
    public ArrayList<Category> categories;
    public String headline;
    public String byline;
}

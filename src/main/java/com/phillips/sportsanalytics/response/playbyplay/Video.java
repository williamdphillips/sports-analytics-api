package com.phillips.sportsanalytics.response.playbyplay;

import java.util.ArrayList;
import java.util.Date;

public class Video{
    public String source;
    public int id;
    public String headline;
    public String caption;
    public String description;
    public boolean premium;
    public Ad ad;
    public Tracking tracking;
    public String cerebroId;
    public Date lastModified;
    public Date originalPublishDate;
    public TimeRestrictions timeRestrictions;
    public DeviceRestrictions deviceRestrictions;
    public boolean syndicatable;
    public int duration;
    public ArrayList<Category> categories;
    public ArrayList<Object> keywords;
    public PosterImages posterImages;
    public ArrayList<Image> images;
    public String thumbnail;
    public Links links;
    public String title;
}

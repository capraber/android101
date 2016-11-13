package com.globant.android101.model;

import com.google.gson.annotations.SerializedName;

public class Item {

    private String site;

    private String id;

    @SerializedName("copy_right")
    private String copy_right;

    private String large_url;

    private String url;

    public String getSite ()
    {
        return site;
    }

    public void setSite (String site)
    {
        this.site = site;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCopy_right()
    {
        return copy_right;
    }

    public void setCopy_right(String copy_right)
    {
        this.copy_right = copy_right;
    }

    public String getLarge_url ()
    {
        return large_url;
    }

    public void setLarge_url (String large_url)
    {
        this.large_url = large_url;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [site = "+site+", id = "+id+", copy_right = "+ copy_right +", large_url = "+large_url+", url = "+url+"]";
    }
}

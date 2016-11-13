package com.globant.android101.model;

public class ItemList {
    private Item[] images;

    public Item[] getImages ()
    {
        return images;
    }

    public void setImages (Item[] images)
    {
        this.images = images;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [images = "+images+"]";
    }
}

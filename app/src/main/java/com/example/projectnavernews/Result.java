package com.example.projectnavernews;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    /**
     {
     "lastBuildDate": "Wed, 10 Mar 2021 17:21:22 +0900",
     "total": 73317,
     "start": 1,
     "display": 20,
     "items": [
     {
     "title": "",
     "originallink": "",
     "link": "",
     "description": "",
     "pubDate": ""
     },
     */

    @SerializedName("lastBuildDate")
    private String lastBuildDate;
    @SerializedName("total")
    private int total;
    @SerializedName("start")
    private int start;
    @SerializedName("display")
    private int display;
    @SerializedName("items")
    private List<Items> items = null;

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}

package com.example.projectnavernews;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("title")
    private String title;
    @SerializedName("originallink")
    private String originallink;
    @SerializedName("link")
    private String link;
    @SerializedName("description")
    private String description;
    @SerializedName("pubDate")
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginallink() {
        return originallink;
    }

    public void setOriginallink(String originallink) {
        this.originallink = originallink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}

package com.example.expandabletextview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Article {

    @SerializedName("publication_date")
    @Expose
    public String date;

    @SerializedName("abstract")
    @Expose
    public List<String> Abstract = null;

    @SerializedName("title_display")
    @Expose
    public String Title;

    @SerializedName("score")
    @Expose
    public float Score;

    public String getTitle() {
        return Title;
    }

    public List<String> getAbstract() {
        return Abstract;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAbstract(List<String> anAbstract) {
        Abstract = anAbstract;
    }

    public void setScore(float score) {
        Score = score;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getScore() {
        return Score;
    }

    public String getDate() {
        return date;
    }

    public Article(String title, List<String> anAbstract, float score, String date) {
        Title = title;
        Abstract = anAbstract;
        Score = score;
        this.date = date;
    }
    public Article()
    {
        Title="";
        Abstract=new ArrayList<>();
        Score= (float) 0.0;
        date="";
    }
}

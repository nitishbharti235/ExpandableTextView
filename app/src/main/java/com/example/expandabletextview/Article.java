package com.example.expandabletextview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Article {
    @SerializedName("author_display")
    @Expose
    public List<String> Authors=null;

    @SerializedName("article_type")
    @Expose
    public String ArticleType;

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

    public List<String> getAuthors() {
        return Authors;
    }

    public String getArticleType() {
        return ArticleType;
    }

    public float getScore() {
        return Score;
    }

    public String getDate() {
        return date;
    }

    public Article(List<String> Authors, String Atype ,String title, List<String> anAbstract, float score, String date) {
        Title = title;
        Abstract = anAbstract;
        Score = score;
        this.date = date;
        this.Authors = Authors;
        this.ArticleType=Atype;
    }
    public Article()
    {
        Title="";
        Abstract=new ArrayList<>();
        Score= (float) 0.0;
        date="";
        Authors = new ArrayList<>();
        ArticleType ="";
    }
}

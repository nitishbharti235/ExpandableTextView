package com.example.expandabletextview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Responses {
    @SerializedName("docs")
    @Expose
    public List<Article> docs = null;

    public List<Article> getDocs() {
        return docs;
    }

    public void setDocs(List<Article> docs) {
        this.docs = docs;
    }
}

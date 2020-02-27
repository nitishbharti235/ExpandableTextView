package com.example.expandabletextview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiReference {
    String Base="http://api.plos.org/";

    @GET("search?q=title:DNA")
    Call<InitialApiBody> getArticles();
}

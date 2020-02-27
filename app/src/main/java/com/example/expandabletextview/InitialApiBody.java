package com.example.expandabletextview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InitialApiBody {
    @SerializedName("response")
    @Expose
    public Responses response;

    public Responses getResponse() {
        return response;
    }

    public void setResponse(Responses response) {
        this.response = response;
    }
}

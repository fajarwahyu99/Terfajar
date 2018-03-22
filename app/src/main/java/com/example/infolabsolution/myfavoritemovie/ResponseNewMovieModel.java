
/*
 * Copyright (c) by Fajar Nugraha Wahyu 3/22/18 10:33 AM 2018.
 * Very Original All rights reserved
 */

package com.example.infolabsolution.myfavoritemovie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNewMovieModel {
    @SerializedName("results")
    private List<MovieConnection> results;

    public void setResults(List<MovieConnection> results) {
        this.results = results;
    }
    public List<MovieConnection> getResults() {
        return results;
    }

}

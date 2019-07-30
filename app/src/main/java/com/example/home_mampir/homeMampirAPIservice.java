package com.example.home_mampir;

import com.example.home_mampir.modelClass.statusNearby;
import com.example.home_mampir.modelClass.statusRecomendation;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface homeMampirAPIservice {
    String nearbyPlaceURL = "https://api.mampir.id/api/";
    String recomendationPlaceURL = "https://api.mampir.id/api/destination/15/";

    Retrofit nearbyPlaceClient = new Retrofit.Builder()
            .baseUrl(nearbyPlaceURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Retrofit recomendationPlaceClient = new Retrofit.Builder()
            .baseUrl(recomendationPlaceURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("destination")
    Call<statusNearby> getAllNearbyPlace(@Query("limit") int limit_number);

    @GET("recommendation")
    Call<statusRecomendation> getAllRecomendationPlace(@Query("limit") int limit_number);
}

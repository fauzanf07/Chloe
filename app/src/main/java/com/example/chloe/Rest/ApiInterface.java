package com.example.chloe.Rest;

import com.example.chloe.Model.GetPlants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("restapi.php")
    Call<GetPlants> getPlants(@Query("function") String function);
}

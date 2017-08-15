package com.sibich.my_keepsolid_internship_app.api;

import com.sibich.my_keepsolid_internship_app.models.TimesIndiaItem;

//import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

public interface ApiService {


    /*@GET("/v1/articles")
    Call<List<TimesIndiaItem>> getData(@Query("source") String source, @Query("sortBy")  String sortBy, @Query("apiKey") String apiKey);*/

    @GET("/v1/articles")
    Call<TimesIndiaItem> getData(@Query("source") String source, @Query("sortBy")  String sortBy, @Query("apiKey") String apiKey);

 //   @GET("/api/get")
 //   Call<List<TimesIndiaItem>> getData (@Query("site") String site, @Query("name") String resourceName, @Query("num") int count);
}

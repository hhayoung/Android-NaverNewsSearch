package com.example.projectnavernews.http;

import com.example.projectnavernews.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverNewsApi {
    public static final String API_URL = "https://openapi.naver.com/v1/search/";

    @GET("news.json")
    Call<Result> getItems(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Query("query") String query,
            @Query("display") int display,
            @Query("sort") String sort);
}

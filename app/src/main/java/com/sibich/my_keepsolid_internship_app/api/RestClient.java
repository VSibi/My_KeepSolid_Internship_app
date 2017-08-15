package com.sibich.my_keepsolid_internship_app.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient sInstance = new RestClient();

    private static ApiService apiService;
    private Retrofit retrofit;

    private final static String API_URL = "https://newsapi.org/";
  //  private final static String API_URL = "http://umorili.herokuapp.com/";

    private RestClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        apiService = retrofit.create(ApiService.class); //Создаем объект, при помощи которого будем выполнять запросы

    }

    public static RestClient getInstance() {
        return sInstance;
    }

    public ApiService getService() {
        return apiService;
    }

}

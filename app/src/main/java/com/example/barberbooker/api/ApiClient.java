package com.example.barberbooker.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient{
    private static final String BASE_URL="http://192.168.43.182:8080//barberBooker/";
    private static ApiClient apiClient;
    private static Retrofit reprofit;

    public ApiClient() {
       reprofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if(apiClient==null){
            apiClient=new ApiClient();
        }
        return apiClient;
    }

    public ApiInterface getApi(){
        return reprofit.create(ApiInterface.class);
    }
}

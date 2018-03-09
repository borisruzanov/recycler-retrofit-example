package com.borisruzanov.a20180308_borisruzanov_nycschools;

import android.app.Application;

import com.borisruzanov.a20180308_borisruzanov_nycschools.live.SchoolApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Boris on 3/8/2018.
 */

public class SchoolApp extends Application {

    Retrofit retrofit;
    private static SchoolApi schoolApi;

    @Override
    public void onCreate() {
        super.onCreate();
        createRetrofit();
        createApi();
    }

    public void createRetrofit(){
        retrofit =  new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void createApi(){
        schoolApi = retrofit.create(SchoolApi.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static SchoolApi getSchoolApi() {
        return schoolApi;
    }
}

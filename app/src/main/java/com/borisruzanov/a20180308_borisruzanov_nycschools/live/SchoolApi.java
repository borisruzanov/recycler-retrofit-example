package com.borisruzanov.a20180308_borisruzanov_nycschools.live;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Boris on 3/8/2018.
 */

public interface SchoolApi {

    @GET("resource/{path}")
    Call<List<School>> getData(@Path("path") String path);

}

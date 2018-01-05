package com.example.raulstriglio.livedataroompoc.network;

import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by raul.striglio on 26/12/17.
 */

public interface ApiService {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("users")
    Call<User> getUserById(@Query("id") Integer id);

    @POST("users")
    Call<User> postUser(@Body User user);
}

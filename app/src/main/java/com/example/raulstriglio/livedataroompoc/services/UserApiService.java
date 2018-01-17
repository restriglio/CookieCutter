package com.example.raulstriglio.livedataroompoc.services;

import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by raul.striglio on 26/12/17.
 */

public interface UserApiService {

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users")
    Observable<User> getUserById(@Query("id") Integer id);

    @POST("users")
    Observable<User> postUser(@Body User user);
}

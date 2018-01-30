package com.example.globant.livedataroompoc.posts.services;

import com.example.globant.livedataroompoc.db.entities.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by raul.striglio on 18/01/18.
 */

public interface PostApiService {

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("posts")
    Observable<List<Post>> getPosById(@Query("userId") String userId);

    @POST("posts")
    Observable<Post> addPost(@Body Post post);

}

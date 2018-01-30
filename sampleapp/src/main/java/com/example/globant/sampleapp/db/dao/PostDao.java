package com.example.globant.sampleapp.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.globant.sampleapp.db.entities.Post;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by raul.striglio on 18/01/18.
 *
 * This class will be used to define all the queries we will perform on our database.
 */


@Dao
public interface PostDao {

    @Query("select * from posts")
    LiveData<List<Post>> loadAllPosts();

    @Query("select * from posts where userId like :uid")
    List<Post> loadPostsByUser(String uid);

    @Insert(onConflict = IGNORE)
    void insertPost(Post post);

    @Insert
    void insertAll( List<Post> posts);

    @Update(onConflict = IGNORE)
    void updatePost(Post post);

    @Delete
    void deletePost(Post post);

    @Query("DELETE FROM posts")
    void deleteAllPost();

}

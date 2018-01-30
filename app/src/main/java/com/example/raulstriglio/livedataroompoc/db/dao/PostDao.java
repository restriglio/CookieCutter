package com.example.raulstriglio.livedataroompoc.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.raulstriglio.livedataroompoc.db.entities.Post;
import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by raul.striglio on 18/01/18.
 */


@Dao
public interface PostDao {

    @Query("select * from posts")
    LiveData<List<Post>> loadAllPosts();

    @Query("select * from posts where userId like :uid")
    List<Post> loadPostsByUser(String uid);

    @Query("select * from posts where id like :postId")
    Post loadPost(String postId);

    @Insert(onConflict = REPLACE)
    void insertPost(Post post);

    @Insert
    void insertAll( List<Post> posts);

    @Update(onConflict = REPLACE)
    void updatePost(Post post);

    @Delete
    void deletePost(Post post);

    @Query("DELETE FROM posts")
    void deleteAllPost();

}

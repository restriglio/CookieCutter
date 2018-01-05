package com.example.raulstriglio.livedataroompoc.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by raul.striglio on 03/11/17.
 */
@Dao
public interface UserDao {

    @Query("select * from users")
    LiveData<List<User>> loadAllUsers();

    @Query("select * from users where first_name like :text or userName like :text")
    List<User> findUserByString(String text);

    @Query("select * from users where first_name like :text or userName like :text")
    List<User> findUSerByStringNoLive(String text);

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Insert
    void insertAll(User... users);

    @Update(onConflict = IGNORE)
    void updateUser(User user);

    @Query("delete from users where first_name like :badName OR userName like :badName")
    int deleteUsersByName(String badName);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM users")
    void deleteAll();
}


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

    @Query("select * from user")
    LiveData<List<User>> loadAllUsers();

    @Query("select * from user where name = :firstName and lastName = :lastName")
    List<User> findByNameAndLastName(String firstName, String lastName);

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Update(onConflict = IGNORE)
    void updateUser(User user);

    @Query("delete from user where name like :badName OR lastName like :badName")
    int deleteUsersByName(String badName);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();
}


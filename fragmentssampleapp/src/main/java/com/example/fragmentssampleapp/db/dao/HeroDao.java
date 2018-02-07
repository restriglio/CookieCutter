package com.example.fragmentssampleapp.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fragmentssampleapp.db.entities.Hero;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by ciro.oyarzun on 05-Feb-18.
 */

@Dao
public interface HeroDao {

    @Query("select * from hero")
    LiveData<List<Hero>> loadAllHeros();

    @Query("select * from hero where id = :id")
    List<Hero> findById(int id);

    @Insert(onConflict = IGNORE)
    void insertHero(Hero hero);

    @Insert
    void insertAll(List<Hero> heroes);

    @Update(onConflict = IGNORE)
    void updateHero(Hero user);

    @Delete
    void deleteHero(Hero hero);

    @Query("DELETE FROM Hero")
    void deleteAll();
}

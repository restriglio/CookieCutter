package com.example.raulstriglio.livedataroompoc.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 27/11/17.
 */

public class UserRepository extends BaseRepository {

    AppDatabase mDb;
    private LiveData<List<User>> users;


    DatabaseInitializer databaseInitializer;
    private Context mContext;

    @Inject
    public UserRepository(Application application){

        mContext = application.getApplicationContext();
        createDb();

        if(mDb != null) {
            users = mDb.userModel().loadAllUsers();
        } else {
            users = null;
        }
    }

    public void addUser(String name, String lastName){
        User newUser = new User();
        newUser.name = name;
        newUser.lastName = lastName;
        mDb.userModel().insertUser(newUser);

        users = mDb.userModel().loadAllUsers();
    }

    public void createDb(){
        mDb = AppDatabase.getInMemoryDatabase(mContext);

        //TODO : change this to get information from server and develop offline first option
        this.databaseInitializer = new DatabaseInitializer();
        databaseInitializer.populateAsync(mDb);
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }
}

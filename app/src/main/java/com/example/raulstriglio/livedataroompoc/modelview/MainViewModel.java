package com.example.raulstriglio.livedataroompoc.modelview;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.db.entities.User;

import java.util.List;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainViewModel extends BaseViewModel {

    private LiveData<List<User>> users;
    private AppDatabase mDb;

    public MainViewModel(Application application) {
        super(application);
        createDb();

        if(mDb != null) {
            users = mDb.userModel().loadAllUsers();
        } else {
            users = null;
        }

    }

    public void addUser(){

        User newUser = new User();
        newUser.name = "Elsa";
        newUser.lastName = "Lamin";
        mDb.userModel().insertUser(newUser);

        users = mDb.userModel().loadAllUsers();
    }

    @Override
    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());

        //TODO : change this to get information from server and develop offline first option
        DatabaseInitializer.populateAsync(mDb);
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }
}

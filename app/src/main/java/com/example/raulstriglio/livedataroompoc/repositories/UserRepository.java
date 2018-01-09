package com.example.raulstriglio.livedataroompoc.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.services.ServiceItem;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 27/11/17.
 */

public class UserRepository extends BaseRepository {

    AppDatabase mDb;
    private LiveData<List<User>> mUsers;
    private MutableLiveData<List<User>> mFoundUsers;
    DatabaseInitializer databaseInitializer;
    private Context mContext;
    private boolean mRequestToServer = true;
    private ServiceItem mServiceItem;


    @Inject
    public UserRepository(Application application) {
        mContext = application.getApplicationContext();
        initLocalData();
    }

    public void initLocalData() {
        createDb();

        if (mDb != null) {
            mUsers = mDb.userModel().loadAllUsers();
        } else {
            mUsers = null;
        }
    }

    public void addUser(User user) {
        mDb.userModel().insertUser(user);
    }

    public void addUserList(List<User> userList){
        mDb.userModel().insertAll(userList);
        mUsers = mDb.userModel().loadAllUsers();
    }

    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(mContext);
        this.databaseInitializer = new DatabaseInitializer();

        /*
         The first time, it requests information to server
         */
        if(mRequestToServer){
            mServiceItem = new ServiceItem();
            mServiceItem.getUsers();
            mRequestToServer = false;
        } else {
            getmUsers();
        }
    }

    public MutableLiveData<List<User>> searchUser(String text) {
        if (mFoundUsers == null) {
            mFoundUsers = new MutableLiveData<>();
        }

        this.mFoundUsers.setValue(mDb.userModel().findUserByString(text));
        return this.mFoundUsers;
    }

    public MutableLiveData<List<User>> getFoundUsers() {

        if (mFoundUsers == null) {
            mFoundUsers = new MutableLiveData<>();
        }

        return mFoundUsers;
    }

    public LiveData<List<User>> getmUsers() {
        if (mUsers == null) {
            mUsers = new MutableLiveData<>();
        }
        return mUsers;
    }

}

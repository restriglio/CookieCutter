package com.example.raulstriglio.livedataroompoc.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.modelviewviewmodel.repository.BaseRepository;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.services.UserApiService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by raul.striglio on 27/11/17.
 */

@Singleton
public class UserRepository extends BaseRepository {

    AppDatabase mDb;
    DatabaseInitializer databaseInitializer;

    private Context mContext;

    private static boolean mRequestToServer;
    private UserApiService mClient;
    private CompositeDisposable disposable;

    private LiveData<List<User>> mUsersList = new MutableLiveData<>();
    private MutableLiveData<List<User>>  mFoundUsers = new MutableLiveData<>();


    @Inject
    public UserRepository(Application application, UserApiService client) {
        mContext = application.getApplicationContext();
        mClient = client;
        disposable = new CompositeDisposable();
        initLocalData();
    }

    public void initLocalData() {
        createDb();
        getUsersList();
    }

    public void addUser(User user) {
        mDb.userModel().insertUser(user);
    }

    public void addUserList(List<User> userList) {
        mDb.userModel().insertAll(userList);
        mUsersList = mDb.userModel().loadAllUsers();
    }

    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(mContext);
        this.databaseInitializer = new DatabaseInitializer();
        mUsersList = mDb.userModel().loadAllUsers();
    }

    public void requestUsersToServer() {
        mClient.getUsers().subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<User> users) {
                        addUserList(users);
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public MutableLiveData<List<User>> searchUser(String text) {
        if (mFoundUsers == null) {
            mFoundUsers = new MutableLiveData<>();
        }

        this.mFoundUsers.setValue(mDb.userModel().findUserByString(text));
        return this.mFoundUsers;
    }

    public MutableLiveData<List<User>> getFoundUsers() {
        return mFoundUsers;
    }

    public LiveData<List<User>> getUsersList() {
        return mUsersList;
    }

}

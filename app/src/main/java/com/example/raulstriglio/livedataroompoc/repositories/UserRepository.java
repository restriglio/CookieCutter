package com.example.raulstriglio.livedataroompoc.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.modelviewviewmodel.repository.UseCaseRepository;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.services.UserApiService;

import java.util.ArrayList;
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
public class UserRepository extends UseCaseRepository<User> {

    private AppDatabase mDataBase;
    private UserApiService mClient;
    private CompositeDisposable disposable;

    private MutableLiveData<List<User>> mFoundUsersList = new MutableLiveData<>();

    @Inject
    public UserRepository(Application context, UserApiService client) {
        super(context);
        mContext = context;
        mClient = client;
        disposable = new CompositeDisposable();
    }

    public void initLocalData() {
        mDataBase = AppDatabase.getInMemoryDatabase(mContext);
        setDataList(mDataBase.userModel().loadAllUsers());

        getDataList();
    }

    @Override
    public void addData(User user) {
        mDataBase.userModel().insertUser(user);
    }

    @Override
    public void addDataList(List<User> dataList) {
        mDataBase.userModel().insertAll(dataList);
        setDataList(mDataBase.userModel().loadAllUsers());
    }

    @Override
    public void requestDataToServer() {
        mClient.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<User> users) {
                        addDataList(users);
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


    public LiveData<List<User>> searchUser(String text) {

        mFoundUsersList.setValue(mDataBase.userModel().findUserByString(text));
        return getFoundUsersList();
    }

    public MutableLiveData<List<User>> getFoundUsersList() {
        return mFoundUsersList;
    }

    public void setFoundUsersList(MutableLiveData<List<User>> mFoundUsersList) {
        this.mFoundUsersList = mFoundUsersList;
    }

    public void deleteFoundUsers() {
        mFoundUsersList.setValue(new ArrayList<User>());
    }
}

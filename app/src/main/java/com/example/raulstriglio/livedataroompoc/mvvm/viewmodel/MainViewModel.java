package com.example.raulstriglio.livedataroompoc.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.mvvm.view.MainView;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainViewModel extends BaseViewModel {

    @Inject
    UserRepository mUserRepository;

    @Inject
    public MainViewModel(Application application) {
        super(application);
    }

    public void addUser(User user){
        mUserRepository.addUser(user);
    }

    public LiveData<List<User>> getUsers() {
        return mUserRepository.getUsersList();
    }

    public void requestUsersToServer() {
        mUserRepository.requestUsersToServer();
    }
}

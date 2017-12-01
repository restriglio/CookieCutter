package com.example.raulstriglio.livedataroompoc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;
import com.example.raulstriglio.livedataroompoc.view.MainView;

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

    public void addUser(String name, String lastName){
        mUserRepository.addUser(name, lastName);
    }

    @Override
    public void initializeData() {

    }

    public void findUserByText(String text){
        mUserRepository.searchUser(text);
    }

    public LiveData<List<User>> getUsers() {
        return mUserRepository.getmUsers();
    }

    public LiveData<List<User>> getFoundUsers(){
        return mUserRepository.getFoundUsers();
    }
}

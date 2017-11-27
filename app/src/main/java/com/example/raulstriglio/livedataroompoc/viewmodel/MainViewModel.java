package com.example.raulstriglio.livedataroompoc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.AppDatabase;
import com.example.raulstriglio.livedataroompoc.db.DatabaseInitializer;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainViewModel extends BaseViewModel {

    @Inject
    UserRepository userRepository;

    @Inject
    public MainViewModel(Application application) {
        super(application);
        initializeData();
    }

    public void addUser(String name, String lastName){
        userRepository.addUser(name, lastName);
    }

    @Override
    public void initializeData() {

    }

    public LiveData<List<User>> getUsers() {
        return userRepository.getUsers();
    }
}

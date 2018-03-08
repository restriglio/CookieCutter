package com.example.globant.sampleapp.users.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.globant.sampleapp.db.entities.User;
import com.example.globant.sampleapp.users.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 03/11/17.
 */

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(Application application, UserRepository useCaseRepository) {
        super(application);
        this.useCaseRepository = useCaseRepository;
    }

    public LiveData<List<User>> getUsers() {
        return useCaseRepository.getDataList();
    }

    public void fetchUsersFromServer() {
        useCaseRepository.requestDataToServer();
    }
}

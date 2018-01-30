package com.example.raulstriglio.sampleapp.users.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.sampleapp.db.entities.User;
import com.example.raulstriglio.sampleapp.users.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class FindUserViewModel extends BaseViewModel<User, UserRepository> {

    @Inject
    public FindUserViewModel(Application application, UserRepository useCaseRepository) {
        super(application);
        this.useCaseRepository = useCaseRepository;
    }

    public LiveData<List<User>> findUserByText(String text){
        useCaseRepository.searchUser(text);
        return getFoundUsers();
    }

    public LiveData<List<User>> getFoundUsers(){
        return useCaseRepository.getFoundUsersList();
    }

    public void clearFoundUsers(){
        useCaseRepository.deleteFoundUsers();
    }

}

package com.example.raulstriglio.livedataroompoc.users.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 09/01/18.
 */

public class FindUserViewModel extends BaseViewModel {

    @Inject
    UserRepository mUserRepository;

    @Inject
    public FindUserViewModel(Application application) {
        super(application);
    }

    public LiveData<List<User>> findUserByText(String text){
        mUserRepository.searchUser(text);
        return getFoundUsers();
    }

    public LiveData<List<User>> getFoundUsers(){
        return mUserRepository.getFoundUsersList();
    }

    public void clearFoundUsers(){
        mUserRepository.deleteFoundUsers();
    }

}

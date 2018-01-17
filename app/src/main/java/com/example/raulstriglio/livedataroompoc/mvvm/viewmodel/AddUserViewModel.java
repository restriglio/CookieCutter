package com.example.raulstriglio.livedataroompoc.mvvm.viewmodel;

import android.app.Application;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddUserViewModel extends BaseViewModel {

    @Inject
    UserRepository mUserRepository;

    public AddUserViewModel(Application application) {
        super(application);
    }

}

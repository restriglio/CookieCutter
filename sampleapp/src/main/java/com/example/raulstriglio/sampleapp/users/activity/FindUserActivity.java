package com.example.raulstriglio.sampleapp.users.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.sampleapp.R;
import com.example.raulstriglio.sampleapp.users.view.FindUserView;
import com.example.raulstriglio.sampleapp.users.viewmodel.FindUserViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


/**
 * Created by raul.striglio on 01/12/17.
 */

public class FindUserActivity extends BaseActivity {

    private FindUserView findUserView;

    @Inject
    FindUserViewModel findUserViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.find_user_activity);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        findUserView = new FindUserView(this, findUserViewModel);
    }

    @Override
    public void onStop() {
        super.onStop();
        findUserView.removeObserver();
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }
}

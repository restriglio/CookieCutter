package com.example.raulstriglio.livedataroompoc.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.mvvm.view.FindUserView;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.FindUserViewModel;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.FindUserViewModelFactory;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;


/**
 * Created by raul.striglio on 01/12/17.
 */

public class FindUserActivity extends BaseActivity {

    private FindUserView findUserView;
    private FindUserViewModel findUserViewModel;

    @Inject
    @Named("FindUserViewModelFactory")
    ViewModelProvider.Factory mViewModelFactory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_user_activity);

        AndroidInjection.inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();

        findUserViewModel = ViewModelProviders.of(this, mViewModelFactory).get(FindUserViewModel.class);
        findUserView = new FindUserView(this, findUserViewModel);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}

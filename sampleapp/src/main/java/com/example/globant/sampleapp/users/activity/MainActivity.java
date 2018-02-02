package com.example.globant.sampleapp.users.activity;


import android.os.Bundle;

import com.example.modelviewviewmodel.activity.BaseActivity;
import com.example.globant.sampleapp.R;
import com.example.globant.sampleapp.users.view.MainView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    @Inject
    MainView mainView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

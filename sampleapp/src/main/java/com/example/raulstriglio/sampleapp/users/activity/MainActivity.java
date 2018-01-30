package com.example.raulstriglio.sampleapp.users.activity;


import android.os.Bundle;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.sampleapp.R;
import com.example.raulstriglio.sampleapp.users.view.MainView;

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

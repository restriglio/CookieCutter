package com.example.raulstriglio.livedataroompoc.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.viewmodel.MainViewModel;
import com.example.raulstriglio.livedataroompoc.view.MainView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;
    public MainView mainView;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidInjection.inject(this);

        mainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        mainView = new MainView(this, mainViewModel);
    }
}

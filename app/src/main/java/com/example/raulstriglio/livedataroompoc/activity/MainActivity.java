package com.example.raulstriglio.livedataroompoc.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.MainViewModel;
import com.example.raulstriglio.livedataroompoc.mvvm.view.MainView;
import com.example.raulstriglio.livedataroompoc.utils.BusProvider;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;
    private MainView mainView;
    private Fragment mCurrentFragment;

    @Inject
    @Named("MainViewModelFactory")
    ViewModelProvider.Factory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidInjection.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        mainView = new MainView(this, mainViewModel);
        BusProvider.register(mainViewModel);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(mainViewModel);
    }

    public MainView getMainView() {
        return mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public Fragment getmCurrentFragment() {
        return mCurrentFragment;
    }
}

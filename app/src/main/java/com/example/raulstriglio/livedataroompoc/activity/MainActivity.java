package com.example.raulstriglio.livedataroompoc.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.modelview.MainViewModel;
import com.example.raulstriglio.livedataroompoc.view.MainView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;

    @Inject
    private MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        AndroidInjection.inject(this);
        //mainView = new MainView(this, mainViewModel);
    }
}

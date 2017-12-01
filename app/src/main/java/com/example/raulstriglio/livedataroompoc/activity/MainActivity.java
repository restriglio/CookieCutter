package com.example.raulstriglio.livedataroompoc.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.db.entities.User;
import com.example.raulstriglio.livedataroompoc.viewmodel.MainViewModel;
import com.example.raulstriglio.livedataroompoc.view.MainView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;
    private MainView mainView;

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


    public void goToFragmentWithStack(int fragmentContainer, Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentContainer, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    public void showFoundUsersInFragment(List<User> users){
        Toast.makeText(this, users.size(), Toast.LENGTH_SHORT).show();
    }

    public MainView getMainView() {
        return mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }
}

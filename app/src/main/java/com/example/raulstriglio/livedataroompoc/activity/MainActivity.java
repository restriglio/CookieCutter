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
import com.example.raulstriglio.livedataroompoc.fragments.FindUserFragment;
import com.example.raulstriglio.livedataroompoc.viewmodel.MainViewModel;
import com.example.raulstriglio.livedataroompoc.view.MainView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;
    private MainView mainView;
    private Fragment mCurrentFragment;

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

        mCurrentFragment = fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentContainer, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    public void showFoundUsersInFragment(List<User> users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.name);
            sb.append(", ");
            sb.append(user.lastName);
            sb.append(", ");
            sb.append(user.getAddress().toString());
            sb.append("\n");
        }

        ((FindUserFragment) mCurrentFragment).showFoundUsers(sb.toString());
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if ((getSupportFragmentManager().getBackStackEntryCount() <= 0) && (mCurrentFragment != null)) {
            mainView.onViewBackPressed();
            mCurrentFragment = null;
        }
    }
}

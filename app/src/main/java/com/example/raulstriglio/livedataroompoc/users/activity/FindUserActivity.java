package com.example.raulstriglio.livedataroompoc.users.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.users.view.FindUserView;
import com.example.raulstriglio.livedataroompoc.users.viewmodel.FindUserViewModel;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_user_activity);

        AndroidInjection.inject(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        findUserView = new FindUserView(this, findUserViewModel);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}

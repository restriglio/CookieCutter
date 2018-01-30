package com.example.raulstriglio.livedataroompoc.posts.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.Constants;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.view.AddPostView;
import com.example.raulstriglio.livedataroompoc.utils.BusProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostActivity extends BaseActivity {

    @Inject
    AddPostView addPostView;

    String mUserId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.add_post_activity);
        mUserId = getIntent().getExtras().getString(Constants.USER_ID);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(addPostView.getViewModel());
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.unregister(addPostView.getViewModel());
    }

    public String getUserId() {
        return mUserId;
    }

}

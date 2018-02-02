package com.example.globant.sampleapp.posts.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activity.BaseActivity;
import com.example.globant.sampleapp.global.Constants;
import com.example.globant.sampleapp.R;
import com.example.globant.sampleapp.posts.mvvm.view.PostsView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsActivity extends BaseActivity {

    @Inject
    PostsView postsView;

    private String mUserId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.posts_activity);
        mUserId = getIntent().getExtras().getString(Constants.USER_ID);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectThis() {
        AndroidInjection.inject(this);
    }

    public String getUserId() {
        return mUserId;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

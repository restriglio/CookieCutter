package com.example.raulstriglio.livedataroompoc.posts.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.Constants;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.view.PostsView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsActivity extends BaseActivity {

    @Inject
    PostsView postsView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_activity);

        AndroidInjection.inject(this);

        postsView.setUserId(getIntent().getExtras().getString(Constants.USER_ID));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

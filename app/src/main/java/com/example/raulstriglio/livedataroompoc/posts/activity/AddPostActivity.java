package com.example.raulstriglio.livedataroompoc.posts.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.modelviewviewmodel.activities.BaseActivity;
import com.example.raulstriglio.livedataroompoc.R;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.view.AddPostView;

import javax.inject.Inject;
import dagger.android.AndroidInjection;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostActivity extends BaseActivity {

    @Inject
    AddPostView addPostView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post_activity);
        AndroidInjection.inject(this);
    }
}

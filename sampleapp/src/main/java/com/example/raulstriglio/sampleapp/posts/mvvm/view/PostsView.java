package com.example.raulstriglio.sampleapp.posts.mvvm.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.raulstriglio.sampleapp.R;
import com.example.raulstriglio.sampleapp.posts.activity.PostsActivity;
import com.example.raulstriglio.sampleapp.db.entities.Post;
import com.example.raulstriglio.sampleapp.posts.mvvm.viewmodel.PostsViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsView extends BaseView<PostsActivity, PostsViewModel> {

    private List<Post> mPosts;
    private String userId;

    @BindView(R.id.rv_posts)
    RecyclerView mRvPosts;

    @Inject
    public PostsView(PostsActivity postsActivity, PostsViewModel postsViewModel ) {
        super(postsActivity, postsViewModel);
        ButterKnife.bind(this, postsActivity);
    }

    @Override
    protected void subscribeUiToLiveData() {

        userId = mBaseActivity.get().getUserId();
        mBaseViewModel.getPosts().observe(mBaseActivity.get(), new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts == null || posts.size() <= 0) {
                    //Fetch data from API or Server
                    mBaseViewModel.fetchPostsByUserId(userId);
                } else {
                    //Data fetched from DataBase
                    mPosts = mBaseViewModel.getLocalPostsByUserId(userId).getValue();
                    if(mPosts.size() <= 0 ){
                        mBaseViewModel.fetchPostsByUserId(userId);
                    } else {
                        showDataInUi();
                    }
                }
            }
        });
    }


    @Override
    protected void showDataInUi() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity.get());
        PostsAdapter postsAdapter = new PostsAdapter(mPosts);
        mRvPosts.setAdapter(postsAdapter);
        mRvPosts.setLayoutManager(linearLayoutManager);
        postsAdapter.notifyDataSetChanged();

    }

}

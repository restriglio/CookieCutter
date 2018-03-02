package com.example.globant.sampleapp.posts.mvvm.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.modelviewviewmodel.view.BaseView;
import com.example.globant.sampleapp.R;
import com.example.globant.sampleapp.posts.activity.PostsActivity;
import com.example.globant.sampleapp.db.entities.Post;
import com.example.globant.sampleapp.posts.mvvm.viewmodel.PostsViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsView extends BaseView<PostsActivity, PostsViewModel> {

    private List<Post> postsLists;
    private String userId;

    @BindView(R.id.postsList)
    RecyclerView postsList;

    @Inject
    public PostsView(PostsActivity postsActivity, PostsViewModel postsViewModel ) {
        super(postsActivity, postsViewModel);
        ButterKnife.bind(this, postsActivity);
    }

    @Override
    protected void subscribeUiToLiveData() {

        userId = baseActivity.get().getUserId();
        baseViewModel.getPosts().observe(baseActivity.get(), new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                if (posts == null || posts.size() <= 0) {
                    //Fetch data from API or Server
                    baseViewModel.fetchPostsByUserId(userId);
                } else {
                    //Data fetched from DataBase
                    postsLists = baseViewModel.getLocalPostsByUserId(userId).getValue();
                    if(postsLists.size() <= 0 ){
                        baseViewModel.fetchPostsByUserId(userId);
                    } else {
                        showDataInUi();
                    }
                }
            }
        });
    }


    @Override
    protected void showDataInUi() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity.get());
        PostsAdapter postsAdapter = new PostsAdapter(postsLists);
        postsList.setAdapter(postsAdapter);
        postsList.setLayoutManager(linearLayoutManager);
        postsAdapter.notifyDataSetChanged();

    }

}

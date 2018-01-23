package com.example.raulstriglio.livedataroompoc.posts.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.entities.Post;
import com.example.raulstriglio.livedataroompoc.repositories.PostRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsViewModel extends BaseViewModel {

    @Inject
    PostRepository postRepository;

    @Inject
    public PostsViewModel(Application application) {
        super(application);
    }

    public LiveData<List<Post>> getPosts() {
        return postRepository.getDataList();
    }

    public void fetchPostsFromServer() {
        postRepository.requestDataToServer();
    }

    public void fetchPostsByUserId(String userId){
        postRepository.requestPostsToServerByUser(userId);
    }
}

package com.example.globant.sampleapp.posts.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.globant.sampleapp.db.entities.Post;
import com.example.globant.sampleapp.posts.repositories.PostRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 19/01/18.
 */

public class PostsViewModel extends BaseViewModel<Post, PostRepository> {


    @Inject
    public PostsViewModel(Application application, PostRepository useCaseRepository) {
        super(application);
        this.useCaseRepository = useCaseRepository;
    }

    public LiveData<List<Post>> getPosts() {
        return useCaseRepository.getDataList();
    }

    public LiveData<List<Post>> getLocalPostsByUserId(String userId) {
        useCaseRepository.setPostsDataListByUserId(userId);
        return useCaseRepository.getDataList();
    }

    public void fetchPostsByUserId(String userId){
        useCaseRepository.requestPostsToServerByUser(userId);
    }
}

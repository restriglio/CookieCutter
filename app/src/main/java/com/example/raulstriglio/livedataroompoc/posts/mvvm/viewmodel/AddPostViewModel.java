package com.example.raulstriglio.livedataroompoc.posts.mvvm.viewmodel;

import android.app.Application;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.db.entities.Post;
import com.example.raulstriglio.livedataroompoc.repositories.PostRepository;
import com.example.raulstriglio.livedataroompoc.repositories.UserRepository;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostViewModel extends BaseViewModel {

    @Inject
    PostRepository mPostRepository;

    @Inject
    public AddPostViewModel(Application application) {
        super(application);
    }

    public void addPostToDb(Post post){
        mPostRepository.addData(post);
    }

}

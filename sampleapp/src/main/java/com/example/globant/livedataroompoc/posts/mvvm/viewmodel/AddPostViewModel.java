package com.example.globant.livedataroompoc.posts.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.globant.livedataroompoc.global.Constants;
import com.example.globant.livedataroompoc.db.entities.Post;
import com.example.globant.livedataroompoc.posts.events.OnPostAddedSuccess;
import com.example.globant.livedataroompoc.posts.repositories.PostRepository;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostViewModel extends BaseViewModel<Post, PostRepository> {

    private Post mPost;
    private String mUserId;

    MutableLiveData<Post> addedPostLiveData = new MutableLiveData<>();

    @Inject
    public AddPostViewModel(Application application,PostRepository useCaseRepository) {
        super(application);
        this.useCaseRepository = useCaseRepository;
    }

    public void addPostToDb(Post post){
        post.setStatus(Constants.STATUS_SYNCING);
        post.setId( String.valueOf(useCaseRepository.getPostFromDbByUserId(mUserId).size() + 1));
        this.mPost = post;
        useCaseRepository.addData(post);
    }

    public LiveData<Post> getAddedPost(){
        if(mPost != null) {
            addedPostLiveData.setValue(useCaseRepository.loadPost(mPost));
            return addedPostLiveData;
        }
        return addedPostLiveData;
    }

    @Subscribe
    public void onPostAdded(OnPostAddedSuccess onPostAddedSuccess){

        if(onPostAddedSuccess.getPost().getStatus().equals(Constants.STATUS_ERROR)){
            useCaseRepository.updatePost(onPostAddedSuccess.getPost());
        } else if(onPostAddedSuccess.getPost().getStatus().equals(Constants.STATUS_SYNCED)){
            useCaseRepository.updatePost(onPostAddedSuccess.getPost());
        }
        getAddedPost();
    }

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }
}

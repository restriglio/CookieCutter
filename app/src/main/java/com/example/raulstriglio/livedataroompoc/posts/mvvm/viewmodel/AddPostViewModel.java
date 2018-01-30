package com.example.raulstriglio.livedataroompoc.posts.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.modelviewviewmodel.viewmodel.BaseViewModel;
import com.example.raulstriglio.livedataroompoc.Constants;
import com.example.raulstriglio.livedataroompoc.db.entities.Post;
import com.example.raulstriglio.livedataroompoc.posts.events.OnPostAddedSuccess;
import com.example.raulstriglio.livedataroompoc.repositories.PostRepository;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 17/01/18.
 */

public class AddPostViewModel extends BaseViewModel {

    @Inject
    PostRepository mPostRepository;
    private Post mPost;
    private String mUserId;

    MutableLiveData<Post> addedPostLiveData = new MutableLiveData<>();

    @Inject
    public AddPostViewModel(Application application) {
        super(application);
    }

    public void addPostToDb(Post post){
        post.setStatus(Constants.STATUS_SYNCING);
        post.setId( String.valueOf(mPostRepository.getPostFromDbByUserId(mUserId).size() + 1));
        this.mPost = post;
        mPostRepository.addData(post);
    }

    public LiveData<Post> getAddedPost(){
        if(mPost != null) {
            addedPostLiveData.setValue(mPostRepository.loadPost(mPost));
            return addedPostLiveData;
        }
        return addedPostLiveData;
    }

    @Subscribe
    public void onPostAdded(OnPostAddedSuccess onPostAddedSuccess){

        if(onPostAddedSuccess.getPost().getStatus().equals(Constants.STATUS_ERROR)){
            mPostRepository.updatePost(onPostAddedSuccess.getPost());
        } else if(onPostAddedSuccess.getPost().getStatus().equals(Constants.STATUS_SYNCED)){
            mPostRepository.updatePost(onPostAddedSuccess.getPost());
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

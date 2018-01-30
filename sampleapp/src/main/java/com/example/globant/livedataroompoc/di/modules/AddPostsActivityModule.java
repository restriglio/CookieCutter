package com.example.globant.livedataroompoc.di.modules;

import com.example.globant.livedataroompoc.posts.activity.AddPostActivity;
import com.example.globant.livedataroompoc.posts.mvvm.view.AddPostView;
import com.example.globant.livedataroompoc.posts.mvvm.viewmodel.AddPostViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 25/01/18.
 */

@Module
public class AddPostsActivityModule {

    @Provides
    AddPostView provideMainView(AddPostActivity addPostActivity, AddPostViewModel addPostViewModel){
        return new AddPostView(addPostActivity, addPostViewModel);
    }

}

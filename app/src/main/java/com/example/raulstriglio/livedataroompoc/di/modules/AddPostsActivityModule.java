package com.example.raulstriglio.livedataroompoc.di.modules;

import com.example.raulstriglio.livedataroompoc.posts.activity.AddPostActivity;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.view.AddPostView;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.viewmodel.AddPostViewModel;

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

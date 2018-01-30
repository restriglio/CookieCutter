package com.example.globant.sampleapp.di.modules;

import com.example.globant.sampleapp.posts.activity.PostsActivity;
import com.example.globant.sampleapp.posts.mvvm.view.PostsView;
import com.example.globant.sampleapp.posts.mvvm.viewmodel.PostsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 19/01/18.
 */

@Module
public class PostsActivityModule {

    @Provides
    PostsView providePostsView(PostsActivity postsActivity, PostsViewModel postsViewModel){
        return new PostsView(postsActivity, postsViewModel);
    }

}

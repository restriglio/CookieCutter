package com.example.raulstriglio.livedataroompoc.di.modules;

import com.example.raulstriglio.livedataroompoc.posts.activity.PostsActivity;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.view.PostsView;
import com.example.raulstriglio.livedataroompoc.posts.mvvm.viewmodel.PostsViewModel;

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

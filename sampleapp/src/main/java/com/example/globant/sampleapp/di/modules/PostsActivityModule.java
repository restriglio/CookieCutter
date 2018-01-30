package com.example.globant.sampleapp.di.modules;

import com.example.globant.sampleapp.posts.activity.PostsActivity;
import com.example.globant.sampleapp.posts.mvvm.view.PostsView;
import com.example.globant.sampleapp.posts.mvvm.viewmodel.PostsViewModel;
import com.example.globant.sampleapp.posts.repositories.PostRepository;
import com.example.modelviewviewmodel.repository.UseCaseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 19/01/18.
 */

@Module
public class PostsActivityModule {

    @Provides
    @Singleton
    UseCaseRepository providePostRepository(PostRepository postRepository){
        return postRepository;
    }

    @Provides
    PostsView providePostsView(PostsActivity postsActivity, PostsViewModel postsViewModel){
        return new PostsView(postsActivity, postsViewModel);
    }

}

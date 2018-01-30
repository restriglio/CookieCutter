package com.example.globant.livedataroompoc.di.modules;

import com.example.globant.livedataroompoc.posts.activity.AddPostActivity;
import com.example.globant.livedataroompoc.posts.activity.PostsActivity;
import com.example.globant.livedataroompoc.posts.mvvm.view.AddPostView;
import com.example.globant.livedataroompoc.posts.mvvm.view.PostsView;
import com.example.globant.livedataroompoc.posts.mvvm.viewmodel.AddPostViewModel;
import com.example.globant.livedataroompoc.posts.mvvm.viewmodel.PostsViewModel;
import com.example.globant.livedataroompoc.posts.repositories.PostRepository;
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

    @Provides
    AddPostView provideMainView(AddPostActivity addPostActivity, AddPostViewModel addPostViewModel){
        return new AddPostView(addPostActivity, addPostViewModel);
    }

}

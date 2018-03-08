package com.example.globant.sampleapp.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.globant.sampleapp.users.mvvm.viewmodel.FindUserViewModel;
import com.example.globant.sampleapp.users.mvvm.viewmodel.MainViewModel;
import com.example.globant.sampleapp.global.MainViewModelFactory;
import com.example.globant.sampleapp.posts.mvvm.viewmodel.PostsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by raul.striglio on 17/01/18.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    abstract ViewModel bindsPostsViewModel(PostsViewModel postsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FindUserViewModel.class)
    abstract ViewModel bindsFindUserViewModel(FindUserViewModel findUserViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindsMainViewModel(MainViewModel mainViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(MainViewModelFactory movieViewModelFactory);
}

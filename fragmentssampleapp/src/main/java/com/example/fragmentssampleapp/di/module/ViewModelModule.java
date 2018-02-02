package com.example.fragmentssampleapp.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.fragmentssampleapp.global.MainViewModelFactory;
import com.example.fragmentssampleapp.viewmodel.FragmentViewModel;
import com.example.fragmentssampleapp.viewmodel.MainViewModel;

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
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindsMainActivityModule(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FragmentViewModel.class)
    abstract ViewModel bindsPostsViewModel(FragmentViewModel fragmentViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(MainViewModelFactory movieViewModelFactory);
}

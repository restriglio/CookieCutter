package com.example.raulstriglio.livedataroompoc.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.AddUserViewModel;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.FindUserViewModel;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.MainViewModel;
import com.example.raulstriglio.livedataroompoc.mvvm.viewmodel.MainViewModelFactory;

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
    @ViewModelKey(AddUserViewModel.class)
    abstract ViewModel bindsAddUserViewModel(AddUserViewModel movieListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FindUserViewModel.class)
    abstract ViewModel bindsFindUserViewModel(FindUserViewModel movieDetailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindsMainViewModel(MainViewModel movieDetailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(MainViewModelFactory movieViewModelFactory);
}

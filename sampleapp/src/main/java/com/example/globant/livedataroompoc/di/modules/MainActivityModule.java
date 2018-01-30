package com.example.globant.livedataroompoc.di.modules;

import com.example.globant.livedataroompoc.users.activity.MainActivity;
import com.example.globant.livedataroompoc.users.view.MainView;
import com.example.globant.livedataroompoc.users.viewmodel.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public class MainActivityModule {

    @Provides
    MainView provideMainView(MainActivity mainActivity, MainViewModel mainViewModel){
        return new MainView(mainActivity, mainViewModel);
    }
}

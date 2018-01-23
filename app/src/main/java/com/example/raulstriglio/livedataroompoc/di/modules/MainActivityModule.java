package com.example.raulstriglio.livedataroompoc.di.modules;

import com.example.raulstriglio.livedataroompoc.users.activity.MainActivity;
import com.example.raulstriglio.livedataroompoc.users.view.MainView;
import com.example.raulstriglio.livedataroompoc.users.viewmodel.MainViewModel;

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

package com.example.globant.sampleapp.di.modules;

import com.example.globant.sampleapp.users.activity.MainActivity;
import com.example.globant.sampleapp.users.view.MainView;
import com.example.globant.sampleapp.users.viewmodel.MainViewModel;

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
